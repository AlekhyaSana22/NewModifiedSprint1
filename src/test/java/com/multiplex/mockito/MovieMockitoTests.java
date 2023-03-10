package com.multiplex.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import com.multiplex.entities.Movie;
 
public class MovieMockitoTests {
 
   private Movie movie;
 
   @Before
   public void setUp() {
       movie = mock(Movie.class);
       when(movie.getMovieId()).thenReturn(1);
      when(movie.getMovieName()).thenReturn("The Matrix");
      when(movie.getDate()).thenReturn(LocalDate.of(1999, 3, 31));
      when(movie.getDuration()).thenReturn(LocalTime.of(2, 16));
   }
 
   @Test
   public void testGetMovieId() {
       assertEquals(1, movie.getMovieId().intValue());
   }
 
   @Test
   public void testGetMovieName() {
       assertEquals("The Matrix", movie.getMovieName());
   }
 
   @Test
   public void testGetDate() {
       assertEquals(LocalDate.of(1999, 3, 31), movie.getDate());
   }
 
   @Test
   public void testGetDuration() {
       assertEquals(LocalTime.of(2, 16), movie.getDuration());
   }
 
}

