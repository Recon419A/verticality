package com.recon419a.verticality.structures

trait MultiStoryAtrium {
  val atrium: Atrium

  def apply(stories: Int): Structure = {
    atrium()
  }
}
