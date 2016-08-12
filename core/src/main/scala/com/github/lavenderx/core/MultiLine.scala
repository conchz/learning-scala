package com.github.lavenderx.core

object MultiLine {

  def main(args: Array[String]) {
    val str =
      """In his famous inaugural speech, Jhon F. Kennedy said
        |"And so, my fellow Americans: ask not what your country can do
        |for you-ask what you can do for your country." He then proceeded
        |to speak to the citizens of the World...
      """.stripMargin
    println(str)
  }
}
