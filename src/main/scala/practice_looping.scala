import scala.collection.immutable.Map

object practice_looping {

  def main(args: Array[String]) = {
    val x1=List("a1","a2","a3")
    val y1=List("b1","b2","b3")
    val m1 = Map("String1" -> x1, "lname" -> y1)
    for((k,v)<- m1)
      {
        val mylist=m1(k)
//        mylist.foreach(line=>print(line+","))
        print("\n")
      }

  }

}