package org.hammerlab.guacamole.loci.set

import org.hammerlab.guacamole.reference.Interval
import org.scalatest.{FunSuite, Matchers}

case class TestInterval(start: Long, end: Long) extends Interval

class LociIteratorSuite extends FunSuite with Matchers {
  test("simple") {
    (1 to 10).map(_ * 2) should be (2 to 20 by 2)
  }
}
