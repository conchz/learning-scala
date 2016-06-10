package com.github.lavenderx

/**
 * Created by lavenderx on 2016-05-07.
 */
class Complex(val real: Int, val imaginary: Int) {

  def +(operand: Complex): Complex = {
    new Complex(real + operand.real, imaginary + operand.imaginary)
  }

  def *(operand: Complex): Complex = {
    new Complex(
      real * operand.real - imaginary * operand.imaginary,
      real * operand.imaginary + imaginary * operand.real
    )
  }

  override def toString: String = real + (if (imaginary < 0) "" else "+") + imaginary + "i"
}
