package com.recon419a.verticality.structures

object MultiStoryPatioAtrium extends MultiStoryAtrium {
  override val atrium: Atrium = PatioAtrium

  override def apply(wingFlags: Seq[WingFlags]): Structure = {
    super.apply(patioFlags(wingFlags))
  }

  def patioFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    floorFlags(wingFlags).zip(ceilingFlags(wingFlags)).map({ case (fs, cs) => patioFlags(fs, cs) }).dropRight(1)
  }

  def patioFlags(floorFlags: WingFlags, ceilingFlags: WingFlags): WingFlags = {
    floorFlags.zip(ceilingFlags).map({ case (f, c) => f && !c })
  }

  def floorFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    Seq(WingFlags()) ++ wingFlags
  }

  def ceilingFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    wingFlags ++ Seq(WingFlags())
  }
}
