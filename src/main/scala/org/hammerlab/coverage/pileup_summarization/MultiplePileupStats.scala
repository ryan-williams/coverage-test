package org.hammerlab.coverage.pileup_summarization

class InputCollection

/**
 * Collection of per-sample PileupStats instances plus pooled normal and tumor DNA PileupStats.
 *
 * Used as a convenient way to pass several PileupStats instances around.
 *
 */
case class MultiplePileupStats(inputs: InputCollection, singleSampleStats: Vector[PileupStats]) {
  val referenceSequence = singleSampleStats.head.referenceSequence
  val normalDNAPooled = PileupStats(Vector(), Vector())
  val tumorlDNAPooled = PileupStats(Vector(), Vector())
}
