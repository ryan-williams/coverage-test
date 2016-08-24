package org.hammerlab.guacamole.reference

trait Interval extends Ordered[Interval] {
  def start: Long

  def end: Long

  def contains(locus: Long): Boolean = start <= locus && locus < end

  /** Comparisons between ranges. Order is DESCENDING (i.e. reversed) from by start. */
  override def compare(other: Interval): Int = {
    val diff = start - other.start
    if (diff < 0) -1
    else if (diff == 0) 0
    else 1
  }
}

private case class IntervalImpl(start: Long, end: Long)
