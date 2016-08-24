package org.hammerlab.guacamole.reads

import org.hammerlab.guacamole.readsets.SampleName

/**
 * The fields in the Read trait are common to any read, whether mapped (aligned) or not.
 */
trait Read extends HasSampleId {

  /* The template name. A read, its mate, and any alternate alignments have the same name. */
  def name: String

  /** The nucleotide sequence. */
  def sequence: IndexedSeq[Byte]

  /** The base qualities, phred scaled.  These are numbers, and are NOT character encoded. */
  def baseQualities: IndexedSeq[Byte]

  /** Is this read a duplicate of another? */
  def isDuplicate: Boolean

  /** Is this read mapped? */
  def isMapped: Boolean

  def asMappedRead: Option[MappedRead]

  /** The sample (e.g. "tumor" or "patient3636") name. */
  def sampleName: SampleName

  /** Whether the read failed predefined vendor checks for quality */
  def failedVendorQualityChecks: Boolean

  /** Whether read is from a paired-end library */
  def isPaired: Boolean
}
