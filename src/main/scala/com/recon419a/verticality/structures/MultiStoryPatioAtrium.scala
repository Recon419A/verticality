package com.recon419a.verticality.structures

object MultiStoryPatioAtrium extends MultiStoryAtrium {
  override val atrium: Atrium = PatioAtrium

  override def apply(wingFlags: Seq[Seq[Boolean]]): Structure = {
    super.apply(patioFlags(wingFlags))
  }

  def patioFlags(wingFlags: Seq[Seq[Boolean]]): Seq[Seq[Boolean]] = {
    floorFlags(wingFlags).zip(ceilingFlags(wingFlags)).map({ case (fs, cs) => patioFlags(fs, cs) }).dropRight(1)
  }

  def patioFlags(floorFlags: Seq[Boolean], ceilingFlags: Seq[Boolean]): Seq[Boolean] = {
    floorFlags.zip(ceilingFlags).map({ case (f, c) => f && !c })
  }

  def floorFlags(wingFlags: Seq[Seq[Boolean]]): Seq[Seq[Boolean]] = {
    Seq(Seq.fill(wingFlags.head.size)(false)) ++ wingFlags
  }

  def ceilingFlags(wingFlags: Seq[Seq[Boolean]]): Seq[Seq[Boolean]] = {
    wingFlags ++ Seq(Seq.fill(wingFlags.head.size)(false))
  }
}
