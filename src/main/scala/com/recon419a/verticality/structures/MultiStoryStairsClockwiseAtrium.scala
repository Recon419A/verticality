package com.recon419a.verticality.structures

object MultiStoryStairsClockwiseAtrium extends MultiStoryAtrium {
  override val atrium: Atrium = StairsClockwiseAtrium

  override def apply(wingFlags: Seq[WingFlags]): Structure = {
    super.apply(stairFlags(wingFlags))
  }

  def stairFlags(wingFlags: Seq[WingFlags]): Seq[WingFlags] = {
    wingFlags.zip(wingFlags.drop(1) ++ Seq(WingFlags())).map({ case (wf, floorUp) => stairFlags(wf, floorUp) })
  }

  def stairFlags(wingFlags: WingFlags, floorUp: WingFlags): WingFlags = {
    WingFlags(
      wingFlags.north && floorUp.east,
      wingFlags.east && floorUp.south,
      wingFlags.south && floorUp.west,
      wingFlags.west && floorUp.north)
  }
}
