package com.github.lavenderx.core

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
