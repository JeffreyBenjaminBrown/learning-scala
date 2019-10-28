class NotMainTest
    extends org.scalatest.FunSuite {
  println("--- printed by NotMainTest ---" )
  test("NotMain.cube") {
    assert(NotMain.cube(3) === 27)
  }
}
