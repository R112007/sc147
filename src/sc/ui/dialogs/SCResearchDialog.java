package sc.ui.dialogs;

import arc.Core;
import arc.Events;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.input.KeyCode;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Rect;
import arc.scene.Action;
import arc.scene.Element;
import arc.scene.Group;
import arc.scene.actions.Actions;
import arc.scene.actions.RelativeTemporalAction;
import arc.scene.event.ElementGestureListener;
import arc.scene.event.InputEvent;
import arc.scene.event.InputListener;
import arc.scene.event.Touchable;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.ImageButton;
import arc.scene.ui.Label;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Scl;
import arc.scene.ui.layout.Table;
import arc.struct.ObjectMap;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import arc.util.I18NBundle;
import arc.util.Nullable;
import arc.util.Scaling;
import arc.util.Structs;
import java.util.Arrays;
import mindustry.Vars;
import mindustry.content.TechTree;
import mindustry.core.UI;
import mindustry.game.EventType;
import mindustry.game.Objectives;
import mindustry.gen.Icon;
import mindustry.gen.Sounds;
import mindustry.gen.Tex;
import mindustry.graphics.Pal;
import mindustry.input.Binding;
import mindustry.type.Item;
import mindustry.type.ItemSeq;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.ui.Fonts;
import mindustry.ui.ItemsDisplay;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.layout.BranchTreeLayout;
import mindustry.ui.layout.TreeLayout;
import mindustry.ui.layout.BranchTreeLayout.TreeLocation;

@SuppressWarnings("all")
public class SCResearchDialog extends BaseDialog {
   public static boolean debugShowRequirements = false;
   public final float nodeSize = Scl.scl(60.0F);
   public ObjectSet nodes = new ObjectSet();
   public TechTreeNode root;
   public TechTree.TechNode lastNode;
   public Rect bounds;
   public ItemsDisplay itemDisplay;
   public View view;
   public ItemSeq items;
   private boolean showTechSelect;

   public SCResearchDialog() {
      super("");
      this.root = new TechTreeNode((TechTree.TechNode) TechTree.roots.first(), (TechTreeNode) null);
      this.lastNode = this.root.node;
      this.bounds = new Rect();
      this.titleTable.remove();
      this.titleTable.clear();
      this.titleTable.top();
      this.titleTable.button((b) -> {
         b.imageDraw(() -> this.root.node.icon()).padRight(8.0F).size(32.0F);
         b.add().growX();
         b.label(() -> this.root.node.localizedName()).color(Pal.accent);
         b.add().growX();
         b.add().size(32.0F);
      }, () -> (new BaseDialog("@techtree.select") {
         {
            this.cont.pane((t) -> t.table(Tex.button, (in) -> {
               in.defaults().width(300.0F).height(60.0F);

               for (TechTree.TechNode node : TechTree.roots) {
                  if (!node.requiresUnlock || node.content.unlocked()
                        || node == SCResearchDialog.this.getPrefRoot()) {
                     in.button(node.localizedName(), node.icon(), Styles.flatTogglet, 32.0F, () -> {
                        if (node != SCResearchDialog.this.lastNode) {
                           SCResearchDialog.this.rebuildTree(node);
                           this.hide();
                        }
                     }).marginLeft(12.0F).checked(node == SCResearchDialog.this.lastNode).row();
                  }
               }

            }));
            this.addCloseButton();
         }
      }).show()).visible(() -> this.showTechSelect = TechTree.roots
            .count((node) -> !node.requiresUnlock || node.content.unlocked()) > 1).minWidth(300.0F);
      this.margin(0.0F).marginBottom(8.0F);
      this.cont.stack(new Element[] { this.titleTable, this.view = new View(), this.itemDisplay = new ItemsDisplay() })
            .grow();
      this.titleTable.toFront();
      this.shouldPause = true;
      Runnable checkMargin = () -> {
         if (Core.graphics.isPortrait() && this.showTechSelect) {
            this.itemDisplay.marginTop(60.0F);
         } else {
            this.itemDisplay.marginTop(0.0F);
         }

      };
      this.onResize(checkMargin);
      this.shown(() -> {
         checkMargin.run();
         Planet currPlanet = Vars.ui.planet.isShown() ? Vars.ui.planet.state.planet
               : (Vars.state.isCampaign() ? Vars.state.rules.sector.planet : null);
         if (currPlanet != null && currPlanet.techTree != null) {
            this.switchTree(currPlanet.techTree);
         }

         this.items = new ItemSeq() {
            ObjectMap<Sector, ItemSeq> cache = new ObjectMap<>();
            {
               for (Planet planet : Vars.content.planets()) {
                  for (Sector sector : planet.sectors) {
                     if (sector.hasBase()) {
                        ItemSeq cached = sector.items();
                        cache.put(sector, cached);
                        cached.each((item, amount) -> {
                           int[] var10000 = this.values;
                           short var10001 = item.id;
                           var10000[var10001] += Math.max(amount, 0);
                           this.total += Math.max(amount, 0);
                        });
                     }
                  }
               }

            }

            @Override
            public void add(Item item, int amount) {
               if (amount < 0) {
                  amount = -amount;
                  double percentage = (double) amount / get(item);
                  int[] counter = { amount };
                  cache.each((sector, seq) -> {
                     if (counter[0] == 0)
                        return;
                     int toRemove = Math.min((int) Math.ceil(percentage * seq.get(item)), counter[0]);
                     sector.removeItem(item, toRemove);
                     seq.remove(item, toRemove);
                     counter[0] -= toRemove;
                  });
                  amount = -amount;
               }
               super.add(item, amount);
            }
         };
         this.checkNodes(this.root);
         this.treeLayout();
         this.view.hoverNode = null;
         this.view.infoTable.remove();
         this.view.infoTable.clear();
      });
      this.addCloseButton();
      this.keyDown((key) -> {
         if (key == Binding.planetMap.value.key) {
            Core.app.post(this::hide);
         }

      });
      this.buttons.button("@database", Icon.book, () -> {
         this.hide();
         Vars.ui.database.show();
      }).size(210.0F, 64.0F).name("database");
      this.addListener(new InputListener() {
         public boolean scrolled(InputEvent event, float x, float y, float amountX, float amountY) {
            SCResearchDialog.this.view.setScale(Mathf.clamp(
                  SCResearchDialog.this.view.scaleX - amountY / 10.0F * SCResearchDialog.this.view.scaleX,
                  0.05F, 5.0F));
            SCResearchDialog.this.view.setOrigin(1);
            SCResearchDialog.this.view.setTransform(true);
            return true;
         }

         public boolean mouseMoved(InputEvent event, float x, float y) {
            SCResearchDialog.this.view.requestScroll();
            return super.mouseMoved(event, x, y);
         }
      });
      this.touchable = Touchable.enabled;
      this.addCaptureListener(new ElementGestureListener() {
         public void zoom(InputEvent event, float initialDistance, float distance) {
            if (SCResearchDialog.this.view.lastZoom < 0.0F) {
               SCResearchDialog.this.view.lastZoom = SCResearchDialog.this.view.scaleX;
            }

            SCResearchDialog.this.view.setScale(
                  Mathf.clamp(distance / initialDistance * SCResearchDialog.this.view.lastZoom, 0.05F, 5.0F));
            SCResearchDialog.this.view.setOrigin(1);
            SCResearchDialog.this.view.setTransform(true);
         }

         public void touchUp(InputEvent event, float x, float y, int pointer, KeyCode button) {
            SCResearchDialog.this.view.lastZoom = SCResearchDialog.this.view.scaleX;
         }

         public void pan(InputEvent event, float x, float y, float deltaX, float deltaY) {
            View var10000 = SCResearchDialog.this.view;
            var10000.panX += deltaX / SCResearchDialog.this.view.scaleX;
            var10000 = SCResearchDialog.this.view;
            var10000.panY += deltaY / SCResearchDialog.this.view.scaleY;
            SCResearchDialog.this.view.moved = true;
            SCResearchDialog.this.view.clamp();
         }
      });
   }

   @Nullable
   public TechTree.TechNode getPrefRoot() {
      Planet currPlanet = Vars.ui.planet.isShown() ? Vars.ui.planet.state.planet
            : (Vars.state.isCampaign() ? Vars.state.rules.sector.planet : null);
      return currPlanet == null ? null : currPlanet.techTree;
   }

   public void switchTree(TechTree.TechNode node) {
      if (this.lastNode != node && node != null) {
         this.nodes.clear();
         this.root = new TechTreeNode(node, (TechTreeNode) null);
         this.lastNode = node;
         this.view.rebuildAll();
      }
   }

   public void rebuildTree(TechTree.TechNode node) {
      this.switchTree(node);
      this.view.panX = 0.0F;
      this.view.panY = -200.0F;
      this.view.setScale(1.0F);
      this.view.hoverNode = null;
      this.view.infoTable.remove();
      this.view.infoTable.clear();
      this.checkNodes(this.root);
      this.treeLayout();
   }

   void treeLayout() {
      final float spacing = 20.0F;
      LayoutNode node = new LayoutNode(this.root, (LayoutNode) null);
      LayoutNode[] children = (LayoutNode[]) node.children;
      LayoutNode[] leftHalf = (LayoutNode[]) Arrays.copyOfRange((LayoutNode[]) node.children, 0,
            Mathf.ceil((float) ((LayoutNode[]) node.children).length / 2.0F));
      LayoutNode[] rightHalf = (LayoutNode[]) Arrays.copyOfRange((LayoutNode[]) node.children,
            Mathf.ceil((float) ((LayoutNode[]) node.children).length / 2.0F), ((LayoutNode[]) node.children).length);
      node.children = leftHalf;
      (new BranchTreeLayout() {
         {
            this.gapBetweenLevels = this.gapBetweenNodes = spacing;
            this.rootLocation = TreeLocation.top;
         }
      }).layout(node);
      float lastY = node.y;
      if (rightHalf.length > 0) {
         node.children = rightHalf;
         (new BranchTreeLayout() {
            {
               this.gapBetweenLevels = this.gapBetweenNodes = spacing;
               this.rootLocation = TreeLocation.bottom;
            }
         }).layout(node);
         this.shift(leftHalf, node.y - lastY);
      }

      node.children = children;
      float minx = 0.0F;
      float miny = 0.0F;
      float maxx = 0.0F;
      float maxy = 0.0F;
      this.copyInfo(node);
      ObjectSet.ObjectSetIterator var11 = this.nodes.iterator();

      while (var11.hasNext()) {
         TechTreeNode n = (TechTreeNode) var11.next();
         if (n.visible) {
            minx = Math.min(n.x - n.width / 2.0F, minx);
            maxx = Math.max(n.x + n.width / 2.0F, maxx);
            miny = Math.min(n.y - n.height / 2.0F, miny);
            maxy = Math.max(n.y + n.height / 2.0F, maxy);
         }
      }

      this.bounds = new Rect(minx, miny, maxx - minx, maxy - miny);
      Rect var10000 = this.bounds;
      var10000.y += this.nodeSize * 1.5F;
   }

   void shift(LayoutNode[] children, float amount) {
      for (LayoutNode node : children) {
         node.y += amount;
         if (node.children != null && ((LayoutNode[]) node.children).length > 0) {
            this.shift((LayoutNode[]) node.children, amount);
         }
      }

   }

   void copyInfo(LayoutNode node) {
      node.node.x = node.x;
      node.node.y = node.y;
      if (node.children != null) {
         for (LayoutNode child : (LayoutNode[]) node.children) {
            this.copyInfo(child);
         }
      }

   }

   void checkNodes(TechTreeNode node) {
      boolean locked = this.locked(node.node);
      if (!locked && (node.parent == null || ((TechTreeNode) node.parent).visible)) {
         node.visible = true;
      }

      node.selectable = this.selectable(node.node);

      for (TechTreeNode l : (TechTreeNode[]) node.children) {
         l.visible = !locked && ((TechTreeNode) l.parent).visible;
         this.checkNodes(l);
      }

      this.itemDisplay.rebuild(this.items);
   }

   boolean selectable(TechTree.TechNode node) {
      return node.content.unlocked() || !node.objectives.contains((i) -> !i.complete());
   }

   boolean locked(TechTree.TechNode node) {
      return node.content.locked();
   }

   class LayoutNode extends TreeLayout.TreeNode {
      final TechTreeNode node;

      LayoutNode(TechTreeNode node, LayoutNode parent) {
         this.node = node;
         this.parent = parent;
         this.width = this.height = SCResearchDialog.this.nodeSize;
         if (node.children != null) {
            this.children = (TreeLayout.TreeNode[]) Seq.with((TechTreeNode[]) node.children)
                  .map((t) -> SCResearchDialog.this.new LayoutNode(t, this)).toArray(LayoutNode.class);
         }

      }
   }

   public class TechTreeNode extends TreeLayout.TreeNode {
      public final TechTree.TechNode node;
      public boolean visible = true;
      public boolean selectable = true;

      public TechTreeNode(TechTree.TechNode node, TechTreeNode parent) {
         this.node = node;
         this.parent = parent;
         this.width = this.height = SCResearchDialog.this.nodeSize;
         SCResearchDialog.this.nodes.add(this);
         if (node.children != null) {
            this.children = new TechTreeNode[node.children.size];

            for (int i = 0; i < ((TechTreeNode[]) this.children).length; ++i) {
               ((TechTreeNode[]) this.children)[i] = SCResearchDialog.this.new TechTreeNode(
                     (TechTree.TechNode) node.children.get(i), this);
            }
         }

      }
   }

   public class View extends Group {
      public float panX = 0.0F;
      public float panY = -200.0F;
      public float lastZoom = -1.0F;
      public boolean moved = false;
      public ImageButton hoverNode;
      public Table infoTable = new Table();

      public View() {
         this.rebuildAll();
      }

      public void rebuildAll() {
         this.clear();
         this.hoverNode = null;
         this.infoTable.clear();
         this.infoTable.touchable = Touchable.enabled;
         ObjectSet.ObjectSetIterator var1 = SCResearchDialog.this.nodes.iterator();

         while (var1.hasNext()) {
            TechTreeNode node = (TechTreeNode) var1.next();
            ImageButton button = new ImageButton(node.node.content.uiIcon, Styles.nodei);
            button.visible(() -> true);
            button.clicked(() -> {
               if (!this.moved) {
                  if (Vars.mobile) {
                     this.hoverNode = button;
                     this.rebuild();
                     float right = this.infoTable.getRight();
                     if (right > (float) Core.graphics.getWidth()) {
                        final float moveBy = right - (float) Core.graphics.getWidth();
                        this.addAction(new RelativeTemporalAction() {
                           {
                              this.setDuration(0.1F);
                              this.setInterpolation(Interp.fade);
                           }

                           protected void updateRelative(float percentDelta) {
                              View var10000 = View.this;
                              var10000.panX -= moveBy * percentDelta;
                           }
                        });
                     }
                  } else if (this.canSpend(node.node) && SCResearchDialog.this.locked(node.node)) {
                     this.spend(node.node);
                  }

               }
            });
            button.hovered(() -> {
               if (!Vars.mobile && this.hoverNode != button) {
                  this.hoverNode = button;
                  this.rebuild();
               }

            });
            button.exited(() -> {
               if (!Vars.mobile && this.hoverNode == button && !this.infoTable.hasMouse()
                     && !this.hoverNode.hasMouse()) {
                  this.hoverNode = null;
                  this.rebuild();
               }

            });
            button.touchable(() -> Touchable.enabled);
            button.userObject = node.node;
            button.setSize(SCResearchDialog.this.nodeSize);
            button.update(() -> {
               float offset = (float) (Core.graphics.getHeight() % 2) / 2.0F;
               button.setPosition(node.x + this.panX + this.width / 2.0F,
                     node.y + this.panY + this.height / 2.0F + offset, 1);
               button.getStyle().up = !SCResearchDialog.this.locked(node.node) ? Tex.buttonOver
                     : (SCResearchDialog.this.selectable(node.node) && this.canSpend(node.node) ? Tex.button
                           : Tex.buttonRed);
               ((TextureRegionDrawable) button.getStyle().imageUp).setRegion(node.node.content.uiIcon);
               button.getImage().setColor(Color.white);
               button.getImage().setScaling(Scaling.bounded);
            });
            this.addChild(button);
         }

         if (Vars.mobile) {
            this.tapped(() -> {
               Element e = Core.scene.hit((float) Core.input.mouseX(), (float) Core.input.mouseY(), true);
               if (e == this) {
                  this.hoverNode = null;
                  this.rebuild();
               }

            });
         }

         this.setOrigin(1);
         this.setTransform(true);
         this.released(() -> this.moved = false);
      }

      void clamp() {
         float pad = SCResearchDialog.this.nodeSize;
         float ox = this.width / 2.0F;
         float oy = this.height / 2.0F;
         float rx = SCResearchDialog.this.bounds.x + this.panX + ox;
         float ry = this.panY + oy + SCResearchDialog.this.bounds.y;
         float rw = SCResearchDialog.this.bounds.width;
         float rh = SCResearchDialog.this.bounds.height;
         rx = Mathf.clamp(rx, -rw + pad, (float) Core.graphics.getWidth() - pad);
         ry = Mathf.clamp(ry, -rh + pad, (float) Core.graphics.getHeight() - pad);
         this.panX = rx - SCResearchDialog.this.bounds.x - ox;
         this.panY = ry - SCResearchDialog.this.bounds.y - oy;
      }

      boolean canSpend(TechTree.TechNode node) {
         if (!SCResearchDialog.this.selectable(node)) {
            return false;
         } else if (node.parent.content.locked()) {
            return false;
         } else if (node.requirements.length == 0) {
            return true;
         } else {
            for (int i = 0; i < node.requirements.length; ++i) {
               if (node.finishedRequirements[i].amount < node.requirements[i].amount
                     && SCResearchDialog.this.items.has(node.requirements[i].item)) {
                  return true;
               }
            }

            return node.content.locked();
         }
      }

      void spend(TechTree.TechNode node) {
         boolean complete = true;
         boolean[] shine = new boolean[node.requirements.length];
         boolean[] usedShine = new boolean[Vars.content.items().size];

         for (int i = 0; i < node.requirements.length; ++i) {
            ItemStack req = node.requirements[i];
            ItemStack completed = node.finishedRequirements[i];
            int used = Math.max(Math.min(req.amount - completed.amount, SCResearchDialog.this.items.get(req.item)),
                  0);
            SCResearchDialog.this.items.remove(req.item, used);
            completed.amount += used;
            if (used > 0) {
               shine[i] = true;
               usedShine[req.item.id] = true;
            }

            if (completed.amount < req.amount) {
               complete = false;
            }
         }

         if (complete) {
            this.unlock(node);
         }

         node.save();
         Core.scene.act();
         this.rebuild(shine);
         SCResearchDialog.this.itemDisplay.rebuild(SCResearchDialog.this.items, usedShine);
      }

      void unlock(TechTree.TechNode node) {
         node.content.unlock();

         for (TechTree.TechNode parent = node.parent; parent != null; parent = parent.parent) {
            parent.content.unlock();
         }

         SCResearchDialog.this.checkNodes(SCResearchDialog.this.root);
         this.hoverNode = null;
         SCResearchDialog.this.treeLayout();
         this.rebuild();
         Core.scene.act();
         Sounds.unlock.play();
         Events.fire(new EventType.ResearchEvent(node.content));
      }

      void rebuild() {
         this.rebuild((boolean[]) null);
      }

      void rebuild(@Nullable boolean[] shine) {
         ImageButton button = this.hoverNode;
         this.infoTable.remove();
         this.infoTable.clear();
         this.infoTable.update((Runnable) null);
         if (button != null) {
            TechTree.TechNode node = (TechTree.TechNode) button.userObject;
            this.infoTable.exited(() -> {
               if (this.hoverNode == button && !this.infoTable.hasMouse() && !this.hoverNode.hasMouse()) {
                  this.hoverNode = null;
                  this.rebuild();
               }

            });
            this.infoTable.update(
                  () -> this.infoTable.setPosition(button.x + button.getWidth(), button.y + button.getHeight(), 10));
            this.infoTable.left();
            this.infoTable.background(Tex.button).margin(8.0F);
            boolean selectable = SCResearchDialog.this.selectable(node);
            this.infoTable.table((b) -> {
               b.margin(0.0F).left().defaults().left();
               if (node.content.description != null || node.content.stats.toMap().size > 0) {
                  b.button(Icon.info, Styles.flati, () -> Vars.ui.content.show(node.content)).growY().width(50.0F);
               }

               b.add().grow();
               b.table((desc) -> {
                  desc.left().defaults().left();
                  desc.add(node.content.localizedName);
                  desc.row();
                  if (!SCResearchDialog.this.locked(node) && !SCResearchDialog.debugShowRequirements) {
                     desc.add("@completed");
                  } else {
                     desc.table((t) -> {
                        t.left();
                        if (selectable) {
                           if (Structs.contains(node.finishedRequirements, (s) -> s.amount > 0)) {
                              float sum = 0.0F;
                              float used = 0.0F;
                              boolean shiny = false;

                              for (int i = 0; i < node.requirements.length; ++i) {
                                 sum += node.requirements[i].item.cost * (float) node.requirements[i].amount;
                                 used += node.finishedRequirements[i].item.cost
                                       * (float) node.finishedRequirements[i].amount;
                                 if (shine != null) {
                                    shiny |= shine[i];
                                 }
                              }

                              Label label = (Label) t.add(Core.bundle.format("research.progress",
                                    new Object[] { Math.min((int) (used / sum * 100.0F), 99) })).left().get();
                              if (shiny) {
                                 label.setColor(Pal.accent);
                                 label.actions(new Action[] { Actions.color(Color.lightGray, 0.75F, Interp.fade) });
                              } else {
                                 label.setColor(Color.lightGray);
                              }

                              t.row();
                           }

                           for (int i = 0; i < node.requirements.length; ++i) {
                              ItemStack req = node.requirements[i];
                              ItemStack completed = node.finishedRequirements[i];
                              if (req.amount > completed.amount || SCResearchDialog.debugShowRequirements) {
                                 boolean shiny = shine != null && shine[i];
                                 t.table((list) -> {
                                    int reqAmount = SCResearchDialog.debugShowRequirements ? req.amount
                                          : req.amount - completed.amount;
                                    list.left();
                                    list.image(req.item.uiIcon).size(24.0F).padRight(3.0F);
                                    list.add(req.item.localizedName).color(Color.lightGray);
                                    Label label = (Label) list.label(() -> {
                                       String var10000 = UI.formatAmount(
                                             (long) Math.min(SCResearchDialog.this.items.get(req.item), reqAmount));
                                       return " " + var10000 + " / " + UI.formatAmount((long) reqAmount);
                                    }).get();
                                    Color targetColor = SCResearchDialog.this.items.has(req.item) ? Color.lightGray
                                          : Color.scarlet;
                                    if (shiny) {
                                       label.setColor(Pal.accent);
                                       label.actions(new Action[] { Actions.color(targetColor, 0.75F, Interp.fade) });
                                    } else {
                                       label.setColor(targetColor);
                                    }

                                 }).fillX().left();
                                 t.row();
                              }
                           }
                        } else if (node.objectives.size > 0) {
                           t.table((r) -> {
                              r.add("@complete").colspan(2).left();
                              r.row();

                              for (Objectives.Objective o : node.objectives) {
                                 if (!o.complete()) {
                                    String var10001 = this.显示(o);
                                    r.add("> " + var10001).color(Color.lightGray).left();
                                    r.image(o.complete() ? Icon.ok : Icon.cancel,
                                          o.complete() ? Color.lightGray : Color.scarlet).padLeft(3.0F);
                                    r.row();
                                 }
                              }

                           });
                           t.row();
                        }

                     });
                  }

               }).pad(9.0F);
               if (Vars.mobile && SCResearchDialog.this.locked(node)) {
                  b.row();
                  b.button("@research", Icon.ok, new TextButton.TextButtonStyle() {
                     {
                        this.disabled = Tex.button;
                        this.font = Fonts.def;
                        this.fontColor = Color.white;
                        this.disabledFontColor = Color.gray;
                        this.up = Tex.buttonOver;
                        this.over = Tex.buttonDown;
                     }
                  }, () -> this.spend(node)).disabled((i) -> !this.canSpend(node)).growX().height(44.0F).colspan(3);
               }

            });
            this.infoTable.row();
            if (node.content.description != null && node.content.inlineDescription) {
               this.infoTable.table((t) -> t.margin(3.0F).left().labelWrap(node.content.displayDescription())
                     .color(Color.lightGray).growX()).fillX();
            }

            this.addChild(this.infoTable);
            this.infoTable.pack();
            this.infoTable.act(Core.graphics.getDeltaTime());
         }
      }

      public String 显示(Objectives.Objective o) {
         if (o instanceof Objectives.Produce) {
            Objectives.Produce A = (Objectives.Produce) o;
            I18NBundle var4 = Core.bundle;
            Object[] var5 = new Object[1];
            String var6 = A.content.emoji();
            var5[0] = var6 + " " + A.content.localizedName;
            return var4.format("requirement.produce", var5);
         } else if (o instanceof Objectives.Research) {
            Objectives.Research A = (Objectives.Research) o;
            I18NBundle var10000 = Core.bundle;
            Object[] var10002 = new Object[1];
            String var10005 = A.content.emoji();
            var10002[0] = var10005 + " " + A.content.localizedName;
            return var10000.format("requirement.research", var10002);
         } else {
            return o.display();
         }
      }

      public void drawChildren() {
         this.clamp();
         float offsetX = this.panX + this.width / 2.0F;
         float offsetY = this.panY + this.height / 2.0F;
         Draw.sort(true);
         ObjectSet.ObjectSetIterator var3 = SCResearchDialog.this.nodes.iterator();

         while (var3.hasNext()) {
            TechTreeNode node = (TechTreeNode) var3.next();

            for (TechTreeNode child : (TechTreeNode[]) node.children) {
               boolean lock = SCResearchDialog.this.locked(node.node)
                     || SCResearchDialog.this.locked(child.node);
               Draw.z(lock ? 1.0F : 2.0F);
               Lines.stroke(Scl.scl(4.0F), lock ? Pal.gray : Pal.accent);
               Draw.alpha(this.parentAlpha);
               if (Mathf.equal(Math.abs(node.y - child.y), Math.abs(node.x - child.x), 1.0F)
                     && Mathf.dstm(node.x, node.y, child.x, child.y) <= node.width * 3.0F) {
                  Lines.line(node.x + offsetX, node.y + offsetY, child.x + offsetX, child.y + offsetY);
               } else {
                  Lines.line(node.x + offsetX, node.y + offsetY, child.x + offsetX, node.y + offsetY);
                  Lines.line(child.x + offsetX, node.y + offsetY, child.x + offsetX, child.y + offsetY);
               }
            }
         }

         Draw.sort(false);
         Draw.reset();
         super.drawChildren();
      }
   }
}
