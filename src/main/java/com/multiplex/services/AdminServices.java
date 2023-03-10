package com.multiplex.services;

import com.multiplex.dto.HallDTO;
import com.multiplex.entities.Admin;
import com.multiplex.exception.HallNotFoundExcepiton;
import com.multiplex.exception.InvalidAdminException;
import com.multiplex.exception.UserNotFoundException;

public interface AdminServices {

	
	public String addAdmin(Admin admin);
	public String loginAdmin(String emailId,String password)throws UserNotFoundException;
	public Admin getAdminByEmailId(String aemailId)throws UserNotFoundException;
	public Admin updateAdmin(Admin adminDetails)throws UserNotFoundException;
	public Admin deleteAdmin(int adminId) throws UserNotFoundException;
	public Admin findByAdminName(String adminName) throws UserNotFoundException;
	public Integer addHall(HallDTO hall);
	public HallDTO gethallById(Integer hallId) throws HallNotFoundExcepiton;
	public void deleteHallById(Integer hallId) throws HallNotFoundExcepiton;
	public void updateHallBySeatsNo(Integer hallId, Integer saetsNo);
//	public boolean grantAdminRights(String emailid)  throws UserNotFoundException;
//	public Booking approveBooking(int bookingId)throws UserNotFoundException;
//	public Booking rejectBooking(int bookingId)throws UserNotFoundException;
//	public Booking disallowBooking(int bookingId)throws UserNotFoundException;
//	public Booking approveCancellation(int bookingId)throws UserNotFoundException;
	public Admin registerAdmin(Admin admin);
	String loginAdmin(Admin admin) throws InvalidAdminException;
}
