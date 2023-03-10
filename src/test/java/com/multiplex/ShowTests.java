package com.multiplex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.multiplex.entities.Hall;
import com.multiplex.entities.Show;

public class ShowTests {
    
    private Show show;
    private Hall hall;
    
    @Before
    public void setUp() throws Exception {
        hall = new Hall();
        hall.setHallId(1);     
        show = new Show();
        show.setShowId(1);
        show.setHall(hall);
    }
    
    @Test
    public void testShow() {
        assertNotNull(show);
    }
    
    @Test
    public void testGetShowId() {
        assertEquals(Integer.valueOf(1), show.getShowId());
    }
    
    @Test
    public void testSetShowId() {
        show.setShowId(2);
        assertEquals(Integer.valueOf(2), show.getShowId());
    }
    
    @Test
    public void testGetHall() {
        assertEquals(hall, show.getHall());
    }
    
    @Test
    public void testSetHall() {
        Hall newHall = new Hall();
        newHall.setHallId(2);
        show.setHall(newHall);
        assertNotEquals(hall, show.getHall());
        assertEquals(newHall, show.getHall());
    }
    
   
    
    
}
