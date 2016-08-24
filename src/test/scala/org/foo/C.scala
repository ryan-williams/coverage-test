package org.foo

import org.scalatest.{FunSuite, Matchers}

class C extends FunSuite with Matchers {
  test("simple") {
    (1 to 10).map(_ * 2) should be (2 to 20 by 2)
  }
}
