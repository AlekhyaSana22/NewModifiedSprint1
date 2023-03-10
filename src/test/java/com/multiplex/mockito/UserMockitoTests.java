package com.multiplex.mockito;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
 
import com.multiplex.entities.Booking;
import com.multiplex.entities.User;
 
@RunWith(MockitoJUnitRunner.class)
public class UserMockitoTests {
 
   @Mock
   private List<Booking> bookings;
 
   @InjectMocks
   private User user;
 
   @Test
   public void testGetUserId() {
       Integer userId = 1;
      user.setUserId(userId);
      assertEquals(userId, user.getUserId());
   }
 
   @Test
   public void testGetBookings() {
      user.setBookings(bookings);
      assertEquals(bookings, user.getBookings());
   }
 
   @Test
   public void testGetUserName() {
       String userName = "charlie";
      user.setUserName(userName);
      assertEquals(userName, user.getUserName());
   }
 
   @Test
   public void testGetPhoneNumber() {
       String phoneNumber = "1234567890";
      user.setPhoneNumber(phoneNumber);
       assertEquals(phoneNumber, user.getPhoneNumber());
   }
 
   @Test
   public void testGetEmailId() {
       String emailId = "charlie@example.com";
      user.setEmailId(emailId);
      assertEquals(emailId, user.getEmailId());
   }
 
   @Test
   public void testGetPassword() {
       String password = "password";
      user.setPassword(password);
      assertEquals(password, user.getPassword());
   }
 
   @Test
   public void testToString() {
       String expectedString = "User [userId=1, bookings=[], userName=charlie, phoneNumber=1234567890, emailId=charlie@example.com, password=password]";
      user.setUserId(1);
      user.setUserName("charlie");
      user.setPhoneNumber("1234567890");
      user.setEmailId("charlie@example.com");
      user.setPassword("password");
   }
 
   @Test
   public void testHashCode() {
       User otherUser = new User(null, bookings, "charlie", "1234567890", "charlie@example.com", "password");
   }
 
   @Test
   public void testEquals() {
       User otherUser = new User(null, bookings, "charlie", "1234567890", "charlie@example.com", "password");
   }
}
