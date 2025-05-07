package sc.content

import mindustry.type.Item
import kotlin.Number

object item{
  lateinit var as:Item
fun load(){
  as=Item("as"){
    apply{
cost =1.2
    }
  }
}
}
