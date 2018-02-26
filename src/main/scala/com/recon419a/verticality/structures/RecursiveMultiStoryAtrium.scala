package com.recon419a.verticality.structures

object RecursiveMultiStoryAtrium extends Atrium {
  override val wingStructure: Structure = MultiStoryClosedAtrium(4)
  override val centerStructure: Structure = MultiStoryClosedAtrium(4)
}
