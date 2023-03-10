package com.multiplex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import com.multiplex.entities.User;

public class UserTests {
	
	@Test
	public void testGettersAndSetters() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("Alekhya");
		user.setPhoneNumber("7981018537");
		user.setEmailId("ale@gmail.com");
		user.setPassword("pass@123");
		
		assertEquals(1, user.getUserId().intValue());
		assertEquals("Alekhya", user.getUserName());
		assertEquals("7981018537", user.getPhoneNumber());
		assertEquals("ale@gmail.com", user.getEmailId());
		assertEquals("pass@123", user.getPassword());
	}
	
	@Test
	public void testEqualsAndHashCode() {
		User user1 = new User(1, null, "Alekhya", "7981018537", "ale@gmail.com", "pass@123");
		User user2 = new User(1, null, "Alekhya", "7981018537", "ale@gmail.com", "pass@123");
		User user3 = new User(2, null, "Anusha", "832826105", "anu@gmail.com", "anu@123");
		
		assertEquals(user1, user2);
		assertEquals(user1.hashCode(), user2.hashCode());
		
		assertEquals(false, user1.equals(user3));
		assertEquals(false, user1.hashCode() == user3.hashCode());
	}
	
	@Test
	public void testToString() {
		User user = new User(1, null, "Alekhya", "7981018537", "ale@gmail.com", "pass@123");
		
		assertNotNull(user.toString());
		assertEquals("User [userId=1, bookings=null, userName=Alekhya, phoneNumber=7981018537, emailId=ale@gmail.com, password=pass@123]", user.toString());
	}
	
	
}




















//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//    @Before
//    public void setUp() {
//        user1 = new User(1, "Alekhya", "7981018537", "ale123@gmail.com", "Ale@123");
//        user2 = new User(2, "Anusha", "8328261057", "anu234@gmail.com", "Anu@456");
//    }
//    
//    
//    
//    @Test
//    public void testGetPhoneNumber() {
//        assertEquals("7981018537", user1.getPhoneNumber());
//        assertEquals("8328261057", user2.getPhoneNumber());
//    }
//    
//    @Test
//    public void testGetEmailId() {
//        assertEquals("ale123@gmail.com", user1.getEmailId());
//        assertEquals("anu234@gmail.com", user2.getEmailId());
//    }
//    
//    @Test
//    public void testGetPassword() {
//        assertEquals("Ale@123", user1.getPassword());
//        assertEquals("Anu@456", user2.getPassword());
//    }
//    
//    @Test
//    public void testEquals() {
//        User user3 = new User(1, "Alekhya", "7981018537", "ale123@gmail.com", "Ale@123");
//        assertEquals(user1, user3);
//        assertNotEquals(user1, user2);
//    }
//    
//    @Test
//    public void testHashCode() {
//        User user3 = new User(1, "Alekhya", "7981018537", "ale123@gmail.com", "Ale@123");
//        assertEquals(user1.hashCode(), user3.hashCode());
//        assertNotEquals(user1.hashCode(), user2.hashCode());
//    }
//    
//    @Test
//    public void testToString() {
//        String expected1 = "User [userId=1, userName=Alekhya, phoneNumber=7981018537, emailId=ale123@gmail.com, password=Ale@123]";
//        String expected2 = "User [userId=2, userName=Anusha, phoneNumber=8328261057, emailId=anu234@gmail.com, password=Anu@456]";
//        assertEquals(expected1, user1.toString());
//        assertEquals(expected2, user2.toString());
//    }
//    
//}
//	
//
////	
