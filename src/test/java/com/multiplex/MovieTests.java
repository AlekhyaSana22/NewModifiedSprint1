package com.multiplex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.multiplex.entities.Movie;

public class MovieTests {
	
	private Movie movie;
	
	@Before
	public void setUp() {
		movie = new Movie(1, "The Matrix", LocalDate.of(1999, 3, 31), LocalTime.of(2, 16));
	}
	
	@Test
	public void testGettersAndSetters() {
		assertEquals(1, movie.getMovieId().intValue());
		assertEquals("The Matrix", movie.getMovieName());
		assertEquals(LocalDate.of(1999, 3, 31), movie.getDate());
		assertEquals(LocalTime.of(2, 16), movie.getDuration());
		
		movie.setMovieId(2);
		assertEquals(2, movie.getMovieId().intValue());
		
		movie.setMovieName("The Matrix Reloaded");
		assertEquals("The Matrix Reloaded", movie.getMovieName());
		
		movie.setDate(LocalDate.of(2003, 5, 15));
		assertEquals(LocalDate.of(2003, 5, 15), movie.getDate());
		
		movie.setDuration(LocalTime.of(2, 18));
		assertEquals(LocalTime.of(2, 18), movie.getDuration());
	}
	
	@Test
	public void testEqualsAndHashCode() {
		Movie sameMovie = new Movie(1, "The Matrix", LocalDate.of(1999, 3, 31), LocalTime.of(2, 16));
		Movie differentMovie = new Movie(2, "The Matrix Reloaded", LocalDate.of(2003, 5, 15), LocalTime.of(2, 18));
		
		assertTrue(movie.equals(sameMovie));
		assertFalse(movie.equals(differentMovie));
		
		assertEquals(movie.hashCode(), sameMovie.hashCode());
		assertFalse(movie.hashCode() == differentMovie.hashCode());
	}
	
	@Test
	public void testToString() {
		assertEquals("Movie [movieId=1, movieName=The Matrix, date=1999-03-31, duration=02:16]", movie.toString());
	}
	
}
















//public class MovieTests {
//
//    private Movie movie;
//
//    @Before
//    public void setUp() {
//        movie = new Movie();
//        movie.setMovieId(1);
//        movie.setMovieName("Test Movie");
//        movie.setDate(LocalDate.now());
//        movie.setDuration(LocalTime.of(10, 30));
////        movie.setBookings(new ArrayList<>());
////        movie.setShows(new ArrayList<>());
////        movie.setHalls(new ArrayList<>());
//    }
//
//    @Test
//    public void testGetMovieId() {
//        assertEquals(Integer.valueOf(1), movie.getMovieId());
//    }
//
//    @Test
//    public void testGetMovieName() {
//        assertEquals("Test Movie", movie.getMovieName());
//    }
//
//    @Test
//    public void testGetDate() {
//        assertEquals(LocalDate.now(), movie.getDate());
//    }
//
//    @Test
//    public void testGetTime() {
//        assertEquals(LocalTime.of(10, 30), movie.getDuration());
//    }
//
////    @Test
////    public void testGetBookings() {
////        assertTrue(movie.getBookings().isEmpty());
////    }
////
////    @Test
////    public void testGetShows() {
////        assertTrue(movie.getShows().isEmpty());
////    }
////
////    @Test
////    public void testGetHalls() {
////        assertTrue(movie.getHalls().isEmpty());
////    }
//
//    @Test
//    public void testEquals() {
//        Movie movie2 = new Movie();
//        movie2.setMovieId(1);
//        movie2.setMovieName("Test Movie");
//        movie2.setDate(LocalDate.now());
//        movie2.setDuration(LocalTime.of(10, 30));
//        movie2.setBookings(new ArrayList<>());
//        movie2.setShows(new ArrayList<>());
//        movie2.setHalls(new ArrayList<>());
//        assertTrue(movie.equals(movie2));
//    }
//    @Test
//	public void testMovieConstructor() {
//		Integer movieId = 1;
//		String movieName = "Lion King";
//		LocalDate date = LocalDate.now();
//		LocalTime time = LocalTime.now();
//		List<Booking> bookings = null;
//		List<Show> shows = null;
//		List<Hall> halls = null;
//
//		movie = new Movie(movieId, movieName, date, time, bookings, shows, halls);
//
//		assertEquals(movieId, movie.getMovieId());
//		assertEquals(movieName, movie.getMovieName());
//		assertEquals(date, movie.getDate());
//		assertEquals(time, movie.getDuration());
//		assertEquals(bookings, movie.getBookings());
//	}
//    @Test
//	public void testToString() {
//		assertNotNull(movie.toString());
//	}
//    @Test
//	public void testHashCodeAndEquals() {
//		Integer movieId1 = 1;
//		String movieName1 = "Lion King";
//		LocalDate date1 = LocalDate.now();
//		LocalTime time1 = LocalTime.now();
//		List<Booking> bookings1 = null;
//		List<Show> shows1 = null;
//		List<Hall> halls1 = null;
//
//		Integer movieId2 = 2;
//		String movieName2 = "Life of Pie";
//		LocalDate date2 = LocalDate.now().plusDays(1);
//		LocalTime time2 = LocalTime.now().plusHours(1);
//		List<Booking> bookings2 = null;
//		List<Show> shows2 = null;
//		List<Hall> halls2 = null;
//
//		Movie movie1 = new Movie(movieId1, movieName1, date1, time1, bookings1, shows1, halls1);
//		Movie movie2 = new Movie(movieId1, movieName1, date1, time1, bookings1, shows1, halls1);
//		Movie movie3 = new Movie(movieId2, movieName2, date2, time2, bookings2, shows2, halls2);
//
//		assertTrue(movie1.equals(movie2));
//		assertFalse(movie1.equals(movie3));
//
//		assertEquals(movie1.hashCode(), movie2.hashCode());
//		assertFalse(movie1.hashCode() == movie3.hashCode());
//	}
//
//}
