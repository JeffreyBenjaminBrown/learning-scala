import org.saddle.io._

val data = ( CsvParser .
  parse( List(0,1,2,3) ) // List is optional.
    // Says which columns to parse,
    // including index column if applicable.
    // (It applies if withRowIndex() is used.)
  (CsvFile("../data/test.csv")) .
  withRowIndex(0) .
  withColIndex(0)
)

val noIndex = ( CsvParser .
  parse( List(0,1,2) )
  (CsvFile("../data/no-index.csv")) .
  withColIndex(0)
)


// mapValues maps across the cells of the Series
// (or Frame) it is called from.
val b2 : org.saddle.Series[String,Int] = ( data
  . col("b") // at this point it's still a Frame
  . colAt(0) // this makes it a Series
  . mapValues( CsvParser.parseInt ) ) // convert to int

val c2 : org.saddle.Series[String,String] =
  data.col("c").colAt(0).mapValues(_+" wut")


// concat collects rows; rconcat collects columns
val data2 : org.saddle.Frame[String, String, Any] =
  data . rconcat(
    org.saddle.Frame(
      "new" -> // must give it a String name
      b2 . asInstanceOf[
        org.saddle.Series[String,Any] ] ) )

// Determine the type of a cell
( data . colAt(0) .
  raw(0) . // at(0) returns it in a Saddle "Scalar" wrapper,
           // where the underlying type is invisible.
           // instead, raw(0) gives you the underlying type.
  getClass )


//
// Cast a column of `Any` values to something more specific:
//

val u = org.saddle.Series(0,1,2)
val v = org.saddle.Series("a","b","c")
val fr = org.saddle.Frame(
  u . asInstanceOf[ org.saddle.Series[Int,Any] ],
  v . asInstanceOf[ org.saddle.Series[Int,Any] ] )

def intCol[A,B] (
    // Unsafe -- could be called where it makes no sense
    f : org.saddle.Frame[A,B,Any],
    i : B )
    : org.saddle.Series[A,Int] = {
  f . col(i) . colAt(0) .
    asInstanceOf[ org.saddle.Series[A,Int] ] }

intCol(fr,0).mapValues(_+1) // works
intCol(fr,1)
  // "Succeeds" even though it makes no sense.
  // I wish it threw an error.

