package com.multiplex.mockito;
 
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.multiplex.entities.Booking;
import com.multiplex.entities.Hall;
import com.multiplex.entities.Show;
import com.multiplex.entities.User;
 
@RunWith(MockitoJUnitRunner.class)
public class BookingMockitoTests {
 
    @Mock
    private User user;
 
    @Mock
    private Show show;
 
    @Mock
    private Hall hall;
 
    @InjectMocks
    private Booking booking;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testGetBookingId() {
        booking.setBookingId(1);
        assertEquals(Integer.valueOf(1), booking.getBookingId());
    }
 
    @Test
    public void testGetUser() {
        booking.setUser(user);
        assertEquals(user, booking.getUser());
    }
 
    @Test
    public void testGetShow() {
        booking.setShow(show);
        assertEquals(show, booking.getShow());
    }
 
    @Test
    public void testGetHall() {
        booking.setHall(hall);
        assertEquals(hall, booking.getHall());
    }
 
    @Test
    public void testGetDate() {
        LocalDate date = LocalDate.of(2023, 3, 9);
        booking.setDate(date);
        assertEquals(date, booking.getDate());
    }
 
    @Test
    public void testGetTime() {
        LocalTime time = LocalTime.of(10, 0);
        booking.setTime(time);
        assertEquals(time, booking.getTime());
    }
 
    @Test
    public void testToString() {
        booking.setBookingId(1);
        booking.setUser(user);
        booking.setShow(show);
        booking.setHall(hall);
        LocalDate date = LocalDate.of(2023, 3, 9);
        booking.setDate(date);
        LocalTime time = LocalTime.of(10, 0);
        booking.setTime(time);
 
        String expected = "Booking [bookingId=1, user=" + user + ", show=" + show + ", hall=" + hall
                + ", date=" + date + ", time=" + time + "]";
 
        assertEquals(expected, booking.toString());
    }
}
