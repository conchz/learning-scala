package com.github.lavenderx

import com.github.lavenderx.core.Complex
import org.scalatest.{ FlatSpec, Matchers }

class ComplexSpec extends FlatSpec with Matchers {

  "(1+2i) + (2-3i)" should "3-1i" in {
    val c1 = new Complex(1, 2)
    val c2 = new Complex(2, -3)
    val sum = c1 + c2

    assert(sum.toString == "3-1i")
  }

  "(1+4i) + (2-3i) * (2-2i)" should "11+2i" in {
    val c1 = new Complex(1, 4)
    val c2 = new Complex(2, -3)
    val c3 = new Complex(2, 2)
    val sum = c1 + c2 * c3

    assert(sum.toString == "11+2i")
  }
}
