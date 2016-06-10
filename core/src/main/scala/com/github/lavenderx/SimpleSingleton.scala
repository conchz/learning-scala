package com.github.lavenderx

/**
 * Created by lavenderx on 2016-05-08.
 */
object SimpleSingleton {
  def main(args: Array[String]) {
    println(MarkerFactory getMarker "blue")
    println(MarkerFactory getMarker "blue")
    println(MarkerFactory getMarker "red")
    println(MarkerFactory getMarker "red")
    println(MarkerFactory getMarker "yellow")
  }
}

class Marker(val color: String) {
  println("Creating " + this)

  override def toString: String = "marker color" + color
}

object MarkerFactory {
  private val markers = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("grenn")
  )

  def getMarker(color: String) = if (markers.contains(color)) markers(color) else null
}
