package org.hammerlab.guacamole.variants

import org.hammerlab.guacamole.util.Bases.BasesOrdering

case class Allele(refBases: Seq[Byte], altBases: Seq[Byte]) extends Ordered[Allele] {
  val isVariant = refBases != altBases

  override def compare(that: Allele): Int = {
    BasesOrdering.compare(refBases, that.refBases) match {
      case 0 => BasesOrdering.compare(altBases, that.altBases)
      case x => x
    }
  }
}
