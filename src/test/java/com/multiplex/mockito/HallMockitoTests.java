package com.multiplex.mockito;
 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.multiplex.entities.Hall;
import com.multiplex.entities.Movie;
 
@RunWith(MockitoJUnitRunner.class)
public class HallMockitoTests {
 
    @Mock
    private Movie movieMock;
 
    @InjectMocks
    private Hall hall;
 
    @Before
    public void setUp() {
        hall = new Hall(1, movieMock, 100);
    }
 
    @Test
    public void testGetHallId() {
        assertEquals(Integer.valueOf(1), hall.getHallId());
    }
 
    @Test
    public void testSetHallId() {
        hall.setHallId(2);
        assertEquals(Integer.valueOf(2), hall.getHallId());
    }
 
    @Test
    public void testGetMovie() {
        assertEquals(movieMock, hall.getMovie());
    }
 
    @Test
    public void testSetMovie() {
        Movie newMovieMock = mock(Movie.class);
        hall.setMovie(newMovieMock);
        assertEquals(newMovieMock, hall.getMovie());
    }
 
    @Test
    public void testGetSeatsNo() {
        assertEquals(Integer.valueOf(100), hall.getSeatsNo());
    }
 
    @Test
    public void testSetSeatsNo() {
        hall.setSeatsNo(200);
        assertEquals(Integer.valueOf(200), hall.getSeatsNo());
    }
 
    @Test
    public void testToString() {
        String expected = "Hall [hallId=1, movie=" + movieMock + ", seatsNo=100]";
        assertEquals(expected, hall.toString());
    }
 
    @Test
    public void testHashCode() {
        Hall hall2 = new Hall(1, movieMock, 100);
        assertEquals(hall2.hashCode(), hall.hashCode());
    }
 
    @Test
    public void testEquals() {
        Hall hall2 = new Hall(1, movieMock, 100);
        assertEquals(hall2, hall);
    }
 
}
