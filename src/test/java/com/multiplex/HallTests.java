package com.multiplex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.multiplex.entities.Booking;
import com.multiplex.entities.Hall;
import com.multiplex.entities.Movie;
import com.multiplex.entities.Show;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HallTests {

    @Test
    public void testGetHallId() {
        Hall hall = new Hall(1, new Movie(), 100);
        assertEquals(1, hall.getHallId().intValue());
    }

    @Test
    public void testGetMovie() {
        Movie movie = new Movie();
        Hall hall = new Hall(1, movie, 100);
        assertEquals(movie, hall.getMovie());
    }

    @Test
    public void testGetSeatsNo() {
        Hall hall = new Hall(1, new Movie(), 100);
        assertEquals(100, hall.getSeatsNo().intValue());
    }

    @Test
    public void testSetHallId() {
        Hall hall = new Hall();
        hall.setHallId(1);
        assertEquals(1, hall.getHallId().intValue());
    }

    @Test
    public void testSetMovie() {
        Movie movie = new Movie();
        Hall hall = new Hall();
        hall.setMovie(movie);
        assertEquals(movie, hall.getMovie());
    }

    @Test
    public void testSetSeatsNo() {
        Hall hall = new Hall();
        hall.setSeatsNo(100);
        assertEquals(100, hall.getSeatsNo().intValue());
    }

}










//public class HallTests {
//	
//	private Hall hall;
//	private List<Movie> movies;
//	private List<Booking> bookings;
//	private List<Show> shows;
//	private Integer seatsNo;
//	
////	@Before
////	public void setUp() {
////		movies = new ArrayList<>();
////		bookings = new ArrayList<>();
////		shows = new ArrayList<>();
////		seatsNo = 100;
////		
////		hall = new Hall(1, movies, bookings, shows, seatsNo);
////	}
//	
//	@Test
//	public void testGettersAndSetters() {
//		Integer newHallId = 2;
//		List<Movie> newMovies = new ArrayList<>();
//		List<Booking> newBookings = new ArrayList<>();
//		List<Show> newShows = new ArrayList<>();
//		Integer newSeatsNo = 200;
//		
//		hall.setHallId(newHallId);
//		assertEquals(newHallId, hall.getHallId());
//		
//		hall.setMovies(newMovies);
//		assertEquals(newMovies, hall.getMovies());
//		
//		hall.setBookings(newBookings);
//		assertEquals(newBookings, hall.getBookings());
//		
//		hall.setShows(newShows);
//		assertEquals(newShows, hall.getShows());
//		
//		hall.setSeatsNo(newSeatsNo);
//		assertEquals(newSeatsNo, hall.getSeatsNo());
//	}
//	
//	@Test
//	public void testEqualsAndHashCode() {
//		Hall hall1 = new Hall(1, movies, bookings, shows, seatsNo);
//		Hall hall2 = new Hall(1, movies, bookings, shows, seatsNo);
//		Hall hall3 = new Hall(2, movies, bookings, shows, seatsNo);
//		
//		assertEquals(hall, hall1);
//		assertEquals(hall.hashCode(), hall1.hashCode());
//		
//		assertEquals(hall1, hall2);
//		assertEquals(hall1.hashCode(), hall2.hashCode());
//		
//		assertNotEquals(hall1, hall3);
//		assertNotEquals(hall1.hashCode(), hall3.hashCode());
//	}
//	
//	@Test
//	public void testGetMovie() {
//		Movie movie = hall.getMovie();
//		assertNull(movie);
//	}
//	
//	@Test
//	public void testListMovies() {
//		Movie movie = new Movie();
//		hall.listMovies(movie);
//		assertEquals(0, hall.getMovie().size());
//	}
//	
//	@Test
//    public void testGetSeatsNo() {
//      assertEquals(Integer.valueOf(100), hall.getSeatsNo());
//  }
//	
//	@Test
//	public void testHall() {
//      assertNotNull(hall);
//  }
//
//  @Test
//  public void testGetHallId() {
//      assertEquals(Integer.valueOf(1), hall.getHallId());
//  }
//
//  @Test
//  public void testSetHallId() {
//      hall.setHallId(2);
//      assertEquals(Integer.valueOf(2), hall.getHallId());
//  }
//  @Test
//  public void testSetSeatsNo() {
//    hall.setSeatsNo(200);
//    assertEquals(Integer.valueOf(200), hall.getSeatsNo());
//}
//}
