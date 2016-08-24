package org.hammerlab.guacamole.reference

trait Interval extends Ordered[Interval] {
  /** Start position on the genome, inclusive. Must be non-negative. */
  def start: Locus

  /** The end position on the genome, *exclusive*. Must be non-negative. */
  def end: Locus

  def contains(locus: Locus): Boolean = start <= locus && locus < end

  /** Comparisons between ranges. Order is DESCENDING (i.e. reversed) from by start. */
  override def compare(other: Interval): Int = {
    val diff = start - other.start
    if (diff < 0) -1
    else if (diff == 0) 0
    else 1
  }
}

private case class IntervalImpl(start: Locus, end: Locus) extends Interval
