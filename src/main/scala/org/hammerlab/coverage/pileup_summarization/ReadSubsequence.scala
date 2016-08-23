package org.hammerlab.coverage.pileup_summarization

case class ReadSubsequence(startReadPosition: Int,
                      endReadPosition: Int) {

//  assume(endLocus > startLocus)
//
//  /** Number of reference bases spanned */
//  def referenceLength: Int = (endLocus - startLocus).toInt
//
//  /** The sequenced bases as a string */
//  def sequence(): String = Bases.basesToString(read.sequence.slice(startReadPosition, endReadPosition))
//
//  /** true if the sequence contains only A,C,G,T (e.g. no N's) */
//  def sequenceIsAllStandardBases(): Boolean =
//    Bases.allStandardBases(read.sequence.slice(startReadPosition, endReadPosition))
//
//  /** The base qualities corresponding to the sequenced bases. */
//  def baseQualities(): Seq[Int] = if (startReadPosition == endReadPosition) {
//    // Technically no sequenced bases at this location (deletion). Use quality of previous base.
//    Seq(read.baseQualities(startReadPosition).toInt)
//  } else {
//    read.baseQualities.slice(startReadPosition, endReadPosition).map(_.toInt)
//  }
//
//  /** Average base quality of the sequenced bases. */
//  def meanBaseQuality(): Double = {
//    val qualities = baseQualities
//    assert(qualities.nonEmpty)
//    val result = qualities.sum.toDouble / qualities.length
//    assert(result >= 0, "Invalid base qualities: %s".format(qualities.map(_.toString).mkString(" ")))
//    result
//  }
//
//  /** The reference sequence at this locus. */
//  def refSequence(contigReferenceSequence: ContigSequence): String = {
//    Bases.basesToString(contigReferenceSequence.slice(startLocus.toInt, endLocus.toInt))
//  }
}
object ReadSubsequence {
//  def ofFixedReferenceLength(element: PileupElement, length: Int): Option[ReadSubsequence] = {
//    assume(length > 0)
//
//    if (element.allele.isVariant || element.locus >= element.read.end - 1) {
//      None
//    } else {
//      val firstElement = element.advanceToLocus(element.locus + 1)
//      var currentElement = firstElement
//      var refOffset = 1
//      while (currentElement.locus < currentElement.read.end - 1 && refOffset < length) {
//        currentElement = currentElement.advanceToLocus(currentElement.locus + 1)
//        refOffset += 1
//      }
//      if (currentElement.locus >= currentElement.read.end - 1) {
//        None
//      } else {
//        val result = ReadSubsequence(
//          element.read,
//          firstElement.locus,
//          currentElement.locus + 1,
//          firstElement.readPosition,
//          currentElement.advanceToLocus(currentElement.locus + 1).readPosition)
//        Some(result)
//      }
//    }
//  }

//  def ofNextAltAllele(element: PileupElement): Option[ReadSubsequence] = {
//    val contigSequence = element.contigSequence
//
//    def isVariantOrFollowedByDeletion(e: PileupElement): Boolean = {
//      e.allele.isVariant || (
//        e.isFinalCigarBase && e.nextCigarElement.exists(
//          cigar => !cigar.getOperator.consumesReadBases && cigar.getOperator.consumesReferenceBases))
//    }
//
//    if (isVariantOrFollowedByDeletion(element) || element.locus >= element.read.end - 1) {
//      None
//    } else {
//      val firstElement = element.advanceToLocus(element.locus + 1)
//      var currentElement = firstElement
//      while (currentElement.locus < currentElement.read.end - 1 && isVariantOrFollowedByDeletion(currentElement)) {
//        currentElement = currentElement.advanceToLocus(currentElement.locus + 1)
//      }
//      if (currentElement.locus == firstElement.locus || currentElement.locus == currentElement.read.end) {
//        // We either have no variant here, or we hit the end of the read.
//        None
//      } else {
//        val result = ReadSubsequence(
//          element.read,
//          firstElement.locus,
//          currentElement.locus,
//          firstElement.readPosition,
//          currentElement.readPosition)
//        Some(result)
//      }
//    }
//  }

//  def nextAlts(elements: Seq[PileupElement]): Seq[ReadSubsequence] = {
//    val startLocus = elements.headOption.map(_.locus)
//    assume(elements.forall(_.locus == startLocus.get))
//    elements.flatMap(element => ofNextAltAllele(element))
//  }
}
