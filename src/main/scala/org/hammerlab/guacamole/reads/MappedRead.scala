package org.hammerlab.guacamole.reads

import htsjdk.samtools.Cigar
import org.bdgenomics.adam.util.PhredUtils
import org.hammerlab.guacamole.readsets.{SampleId, SampleName}
import org.hammerlab.guacamole.reference.{ContigName, Locus, ReferenceRegion}

import scala.collection.JavaConversions

/**
 * A mapped read. See the [[Read]] trait for some of the field descriptions.
 *
 * @param contigName the contig name (e.g. "chr12") that this read was mapped to.
 * @param alignmentQuality the mapping quality, phred scaled.
 * @param start the (0-based) reference locus that the first base in this read aligns to.
 * @param cigar parsed samtools CIGAR object.
 */
case class MappedRead(
    name: String,
    sequence: IndexedSeq[Byte],
    baseQualities: IndexedSeq[Byte],
    isDuplicate: Boolean,
    sampleId: SampleId,
    sampleName: SampleName,
    contigName: ContigName,
    alignmentQuality: Int,
    start: Locus,
    cigar: Cigar,
    failedVendorQualityChecks: Boolean,
    isPositiveStrand: Boolean,
    isPaired: Boolean)
  extends Read

    with ReferenceRegion {

  assert(baseQualities.length == sequence.length,
    "Base qualities have length %d but sequence has length %d".format(baseQualities.length, sequence.length))

  override val isMapped = true
  override def asMappedRead = Some(this)

  lazy val alignmentLikelihood = PhredUtils.phredToSuccessProbability(alignmentQuality)

  /** Individual components of the CIGAR string (e.g. "10M"), parsed, and as a Scala buffer. */
  val cigarElements = JavaConversions.asScalaBuffer(cigar.getCigarElements)

  /**
   * The end of the alignment, exclusive. This is the first reference locus AFTER the locus corresponding to the last
   * base in this read.
   */
  val end: Long = start + cigar.getPaddedReferenceLength
}
