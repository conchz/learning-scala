package com.github.lavenderx.core.`implicit`

object Helpers {

  /*
   * 隐式类有以下限制条件:
   * 1. 只能在别的trait/object/class内部定义;
   * 2. 构造函数只能携带一个非隐式参数(虽然我们可以创建多个非隐式参数的隐式类, 但这些类无法用于隐式转换);
   * 3. 在同一作用域内, 不能有任何函数、成员或对象与隐式类同名(意味着隐式类不能是case class).
   */
  implicit class IntWithTimes(x: Int) {
    // 为Int类型扩展一个`times`函数
    // `times`函数接收一个函数`f`作为参数
    def times[A](f: => A): Unit = {
      // 在`times`内部定义`loop`函数体
      def loop(current: Int): Unit =
        if (current > 0) {
          // current大于0时执行函数f
          f
          // 递归调用`loop`
          loop(current - 1)
        }
      // 调用`times`的内部函数体`loop`
      loop(x)
    }
  }


  def main(args: Array[String]) {
    5 times {
      println("Hi, " + java.time.LocalDateTime.now())
    }
  }
}
