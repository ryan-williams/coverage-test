package org.hammerlab.coverage

case class Foo(n: Int, s: String) {
  def bar: Int = n * 2
  def ss = s + s
}
