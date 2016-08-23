package org.hammerlab.coverage

import org.scalatest.{FunSuite, Matchers}

class FooTest extends FunSuite with Matchers {
  test("foo") {
    val foo = Foo(2, "abc")
    foo.bar should be(4)
    foo.ss should be("abcabc")
  }
}
