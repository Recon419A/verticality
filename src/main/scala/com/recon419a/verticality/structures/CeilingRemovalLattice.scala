package com.recon419a.verticality.structures

object CeilingRemovalLattice extends MultiStoryAtrium {
  override val atrium: Atrium = CeilingDeleterAtrium

  object CeilingDeleterAtrium extends Atrium {
    override val wingStructure: Structure = Structure()
    override val centerStructure: Structure = CeilingDeleter()
  }

}
