package com.github.lavenderx

import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE

/**
  * 这个例子是关于Scala的类继承
  * Created by lavenderx on 2016-05-07.
  */
class Vehicle(val id: Int, val year: Int) {
  override def toString: String = ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE)
}

class Car(override val id: Int, override val year: Int, var fuelLevel: Int)
  extends Vehicle(id, year) {
  override def toString: String = ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE)
}

object Car {
  def main(args: Array[String]) {
    val car = new Car(1, 2016, 100)
    println(car)
  }
}