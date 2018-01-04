package com.recon419a.verticality.structures

object MultiStoryClosedAtrium extends MultiStoryAtrium {
  override val atrium: Atrium = ClosedAtrium

  override def apply(wingFlags: Seq[Seq[Boolean]]): Structure = {
    super.apply(wingFlags) + CeilingRemovalLattice(wingFlags.size - 1) + MultiStoryPatioAtrium(wingFlags)
  }
}
