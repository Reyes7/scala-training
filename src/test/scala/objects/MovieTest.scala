package objects

import org.scalatest.{FunSuite, Matchers}

class MovieTest extends FunSuite with Matchers{

  test("did Grand Hotel win oscar for the best movie in 1932 ?"){
    Movie.academyAwardBestMoviesForYear(1932).get.name should be("Grand Hotel")
  }
}
