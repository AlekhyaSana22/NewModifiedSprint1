package com.multiplex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.multiplex.entities.Booking;
import com.multiplex.entities.Hall;
import com.multiplex.entities.Movie;
import com.multiplex.entities.Show;
import com.multiplex.entities.User;

public class BookingTests {

    private Booking booking;

    @Before
    public void setUp() {
        User user = new User(1, null, "John", "Doe", "johndoe@gmail.com", "password");
        Hall hall = new Hall();
        Movie movie = new Movie(1, "Movie A", LocalDate.now(), LocalTime.of(2, 30));
        Show show = new Show(1, hall, LocalTime.of(10, 0));
        booking = new Booking(1, user, show, hall, LocalDate.now(), LocalTime.of(12, 0));
    }

    @Test
    public void testGetBookingId() {
        assertNotNull(booking.getBookingId());
        assertEquals(Integer.valueOf(1), booking.getBookingId());
    }

    @Test
    public void testGetUser() {
        assertNotNull(booking.getUser());
        assertEquals("John", booking.getUser().getUserName());
    }

    @Test
    public void testGetShow() {
        assertNotNull(booking.getShow());
        assertEquals(LocalTime.of(10, 0), booking.getShow().getShowTime());
    }

    

    @Test
    public void testGetDate() {
        assertNotNull(booking.getDate());
        assertEquals(LocalDate.now(), booking.getDate());
    }

    @Test
    public void testGetTime() {
        assertNotNull(booking.getTime());
        assertEquals(LocalTime.of(12, 0), booking.getTime());
    }
}

//package com.multiplex;
//import static org.junit.Assert.*;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import org.junit.Test;
//
//import com.multiplex.entities.Booking;
//import com.multiplex.entities.Hall;
//import com.multiplex.entities.Movie;
//import com.multiplex.entities.Show;
//import com.multiplex.entities.User;
//
//public class BookingTests {
//
//    @Test
//    public void testEquals() {
//        // Create two identical bookings
//        User user = new User();
//        Movie movie = new Movie();
//        Show show = new Show();
//        Hall hall = new Hall();
//        LocalDate date = LocalDate.of(2023, 3, 7);
//        LocalTime time = LocalTime.of(12, 0);
//        Booking booking1 = new Booking(1, user, movie, show, hall, date, time);
//        Booking booking2 = new Booking(2, user, movie, show, hall, date, time);
//        
//        // Test that they are equal
//        assertTrue(booking1.equals(booking1));
//        assertTrue(booking2.equals(booking2));
//    }
//    
//    @Test
//    public void testNotEquals() {
//        // Create two bookings with different values
//        User user1 = new User();
//        User user2 = new User();
//        Movie movie = new Movie();
//        Show show = new Show();
//        Hall hall = new Hall();
//        LocalDate date1 = LocalDate.of(2023, 3, 7);
//        LocalDate date2 = LocalDate.of(2023, 3, 8);
//        LocalTime time = LocalTime.of(12, 0);
//        Booking booking1 = new Booking(1, user1, movie, show, hall, date1, time);
//        Booking booking2 = new Booking(2, user2, movie, show, hall, date2, time);
//        
//        // Test that they are not equal
//        assertFalse(booking1.equals(booking2));
//        assertFalse(booking2.equals(booking1));
//    }
//
//}	
