package org.hammerlab.guacamole.reference

trait Interval {
  def start: Long

  def end: Long
}

private case class IntervalImpl(start: Long, end: Long)
