object HigherOrderFunDemo01 {
  def main(args: Array[String]): Unit = {
    val res = hfun(fun1, fun2, 3.5)
    println("res = " + res)
  }

  /**
    * 高阶函数
    * @param f1
    * @param f2
    * @param n
    * @return 将n进行以下处理返回：(n+n).toInt
    */
  def hfun(f1: Double => Double, f2: Double => Int, n: Double) = {
    f2(f1(n))
  }


  /** 普通函数fun1
    * @param x 输入Double类型的值
    * @return x + x
    */
  def fun1(x: Double): Double = {
    x + x
  }

  /** 普通函数fun2
    * @param x 输入Double类型的值
    * @return 返回对应的Int
    */
  def fun2(x: Double): Int = {
    x.toInt
  }
}
