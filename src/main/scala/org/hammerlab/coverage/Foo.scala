package org.hammerlab.coverage

case class Foo(n: Int, s: String) {
  val nn = n.toString + n
  def bar: Int = n * 2
  def ss = s + s
}
