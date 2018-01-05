package com.recon419a.verticality.structures

object MultiStoryPatioAtrium extends MultiStoryAtrium {
  override val atrium: Atrium = PatioAtrium

  override def apply(wingFlags: Seq[WingFlags]): Structure = {
    super.apply(patioFlags(wingFlags))
  }

  def patioFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    val ffs = floorFlags(wingFlags)
    val cfs = ceilingFlags(wingFlags)
    wingFlags.indices.map(i => patioFlags(ffs(i + 1), cfs(i + 1), wingFlags(i)))
  }

  def patioFlags(floorFlags: WingFlags, ceilingFlags: WingFlags, wingFlags: WingFlags): WingFlags = {
    (floorFlags, ceilingFlags, wingFlags).zipped.map({ case (f, c, w) => f && !c && !w })
  }

  def floorFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    Seq.fill(2)(WingFlags()) ++ wingFlags
  }

  def ceilingFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    wingFlags ++ Seq.fill(2)(WingFlags())
  }
}
