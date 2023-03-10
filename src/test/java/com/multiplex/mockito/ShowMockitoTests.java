package com.multiplex.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
 
import java.time.LocalTime;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.multiplex.entities.Hall;
import com.multiplex.entities.Show;
 
@RunWith(MockitoJUnitRunner.class)
public class ShowMockitoTests {

    @Mock
    private Hall hall;

    @InjectMocks
    private Show show;

    private Integer showId = 1;
    private LocalTime showTime = LocalTime.of(14, 30);

    @Before
    public void setup() {
        show.setShowId(showId);
        show.setHall(hall);
        show.setShowTime(showTime);
    }

    @Test
    public void testGetShowId() {
        assertEquals(showId, show.getShowId());
    }

    @Test
    public void testGetHall() {
        assertEquals(hall, show.getHall());
    }

    @Test
    public void testGetShowTime() {
        assertEquals(showTime, show.getShowTime());
    }

    @Test
    public void testToString() {
        String expected = "Show [showId=" + showId + ", hall=" + hall + ", showTime=" + showTime + "]";
        assertEquals(expected, show.toString());
    }
}
