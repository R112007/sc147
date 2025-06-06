package sc.game;

import static sc.content.SCUnits.*;
import arc.func.Intc;
import arc.math.Mathf;
import arc.math.Rand;
import arc.struct.Seq;
import arc.util.Structs;
import mindustry.content.StatusEffects;
import mindustry.game.SpawnGroup;
import mindustry.type.UnitType;

//海军还没搞，所以只能两个布尔
public class SCWaves {
    public static Seq<SpawnGroup> generateLx(float difficulty) {
        // apply power curve to make starting sectors easier
        return generateLx(Mathf.pow(difficulty, 1.12f), new Rand());
    }

    public static Seq<SpawnGroup> generateLx(float difficulty, Rand rand) {
        return generateLx(difficulty, rand, false);
    }

    public static Seq<SpawnGroup> generateLx(float difficulty, Rand rand, boolean airOnly) {
        UnitType[][] species = {
                { chujia1, chujia2, chujia3, chujia4, chujia5 }
                // { liekong1, liekong2 }
        };

        if (airOnly) {
            species = Structs.filter(UnitType[].class, species, v -> v[0].flying);
        }

        UnitType[][] fspec = species;

        // required progression:
        // - extra periodic patterns

        Seq<SpawnGroup> out = new Seq<>();

        // max reasonable wave, after which everything gets boring
        int cap = 150;

        float shieldStart = 30, shieldsPerWave = 20 + difficulty * 30f;
        float[] scaling = { 1, 2f, 3f, 4f, 5f };

        Intc createProgression = start -> {
            // main sequence
            UnitType[] curSpecies = Structs.random(rand, fspec);
            int curTier = 0;

            for (int i = start; i < cap;) {
                int f = i;
                int next = rand.random(8, 16) + (int) Mathf.lerp(5f, 0f, difficulty) + curTier * 4;

                float shieldAmount = Math.max((i - shieldStart) * shieldsPerWave, 0);
                int space = start == 0 ? 1 : rand.random(1, 2);
                int ctier = curTier;

                // main progression
                out.add(new SpawnGroup(curSpecies[Math.min(curTier, curSpecies.length - 1)]) {
                    {
                        unitAmount = f == start ? 1 : 6 / (int) scaling[ctier];
                        begin = f;
                        end = f + next >= cap ? never : f + next;
                        max = 13;
                        unitScaling = (difficulty < 0.4f ? rand.random(5f, 10f) : rand.random(6f, 12f))
                                * scaling[ctier];
                        shields = shieldAmount;
                        shieldScaling = shieldsPerWave;
                        spacing = space;
                    }
                });

                // extra progression that tails out, blends in
                out.add(new SpawnGroup(curSpecies[Math.min(curTier, curSpecies.length - 1)]) {
                    {
                        unitAmount = 3 / (int) scaling[ctier];
                        begin = f + next - 1;
                        end = f + next + rand.random(6, 10);
                        max = 18;
                        unitScaling = rand.random(2f, 4f);
                        spacing = rand.random(2, 4);
                        shields = shieldAmount / 2f;
                        shieldScaling = shieldsPerWave;
                    }
                });

                i += next + 1;
                if (curTier < 3 || (rand.chance(0.05) && difficulty > 0.8)) {
                    curTier++;
                }

                // do not spawn bosses
                curTier = Math.min(curTier, 3);

                // small chance to switch species
                if (rand.chance(0.3)) {
                    curSpecies = Structs.random(rand, fspec);
                }
            }
        };

        createProgression.get(0);

        int step = 5 + rand.random(5);

        while (step <= cap) {
            createProgression.get(step);
            step += (int) (rand.random(15, 30) * Mathf.lerp(1f, 0.5f, difficulty));
        }

        int bossWave = (int) (rand.random(50, 70) * Mathf.lerp(1f, 0.5f, difficulty));
        int bossSpacing = (int) (rand.random(25, 40) * Mathf.lerp(1f, 0.5f, difficulty));

        int bossTier = difficulty < 0.6 ? 3 : 4;

        // main boss progression
        out.add(new SpawnGroup(Structs.random(rand, species)[bossTier]) {
            {
                unitAmount = 1;
                begin = bossWave;
                spacing = bossSpacing;
                end = never;
                max = 16;
                unitScaling = bossSpacing;
                shieldScaling = shieldsPerWave;
                effect = StatusEffects.boss;
            }
        });

        // alt boss progression
        out.add(new SpawnGroup(Structs.random(rand, species)[bossTier]) {
            {
                unitAmount = 1;
                begin = bossWave + rand.random(3, 5) * bossSpacing;
                spacing = bossSpacing;
                end = never;
                max = 16;
                unitScaling = bossSpacing;
                shieldScaling = shieldsPerWave;
                effect = StatusEffects.boss;
            }
        });

        int finalBossStart = 120 + rand.random(30);

        // final boss waves
        out.add(new SpawnGroup(Structs.random(rand, species)[bossTier]) {
            {
                unitAmount = 1;
                begin = finalBossStart;
                spacing = bossSpacing / 2;
                end = never;
                unitScaling = bossSpacing;
                shields = 500;
                shieldScaling = shieldsPerWave * 4;
                effect = StatusEffects.boss;
            }
        });

        // final boss waves (alt)
        out.add(new SpawnGroup(Structs.random(rand, species)[bossTier]) {
            {
                unitAmount = 1;
                begin = finalBossStart + 15;
                spacing = bossSpacing / 2;
                end = never;
                unitScaling = bossSpacing;
                shields = 500;
                shieldScaling = shieldsPerWave * 4;
                effect = StatusEffects.boss;
            }
        });

        // shift back waves on higher difficulty for a harder start
        int shift = Math.max((int) (difficulty * 14 - 5), 0);

        for (SpawnGroup group : out) {
            group.begin -= shift;
            group.end -= shift;
        }

        return out;
    }
}
