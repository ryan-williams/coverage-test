package org.hammerlab.guacamole.variants

case class CalledSomaticAllele(somaticLogOdds: Double) {
  lazy val phredScaledSomaticLikelihood = somaticLogOdds
}
