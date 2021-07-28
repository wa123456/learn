object AnonymousFunDemo02 {
  def main(args: Array[String]): Unit = {
    var sum = (a:Int,b:Int) =>{
      a + b;
    }

    println(sum(3,4))
    println(sum)
  }
}
