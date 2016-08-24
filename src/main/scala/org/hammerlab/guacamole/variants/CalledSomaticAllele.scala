package org.hammerlab.guacamole.variants

import org.bdgenomics.adam.util.PhredUtils

case class CalledSomaticAllele(somaticLogOdds: Double) {
  lazy val phredScaledSomaticLikelihood =
    PhredUtils.successProbabilityToPhred(somaticLogOdds)
}
