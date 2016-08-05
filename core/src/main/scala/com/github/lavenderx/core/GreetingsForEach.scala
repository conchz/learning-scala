package com.github.lavenderx.core

/**
 * Created by lavenderx on 2016-05-07.
 */
object GreetingsForEach {

  def main(args: Array[String]) {
    (1 until 6).foreach(i => print(i + ","))

    println("Scala Rocks!!!")
  }
}
