case class Coordinate(x: Int, y: Int, z: Int) {
  def +(c: Coordinate): Coordinate = {
    Coordinate(this.x + c.x, this.y + c.y, this.z + c.z)
  }

  def -(c: Coordinate): Coordinate = {
    Coordinate(this.x - c.x, this.y - c.y, this.z - c.z)
  }

  val coordinates = List(x, y, z)
}