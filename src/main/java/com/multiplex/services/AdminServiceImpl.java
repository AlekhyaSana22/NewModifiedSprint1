package com.multiplex.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.HallDTO;
import com.multiplex.entities.Admin;
import com.multiplex.entities.Hall;
import com.multiplex.exception.HallNotFoundExcepiton;
import com.multiplex.exception.InvalidAdminException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.AdminRepository;
import com.multiplex.repository.BookingRepository;
import com.multiplex.repository.HallRepository;
import com.multiplex.repository.UserRepository;

@Service("AdminService")
public class AdminServiceImpl implements AdminServices {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	BookingRepository bookingdetailsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private HallRepository hallRepository;
	
	
	@Override
	public String addAdmin(Admin admin) {
		adminRepository.saveAndFlush(admin);
		return "Admin added successfully";
	}	
	
	@Override
	public String loginAdmin(String emailId, String password) throws InvalidAdminException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new InvalidAdminException("Admin details not found!");
		}
		return "Loggedin successfully";
	}

	@Override
	public Admin getAdminByEmailId(String aemailId) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getEmailId().equals(aemailId) ) {
					bean =  i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return bean;
	}

	@Override
	public Admin updateAdmin(Admin adminDetails) throws UserNotFoundException {
		Admin  bean = null;
		try {
			bean = adminRepository.findById(adminDetails.getAdminId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		adminRepository.saveAndFlush(adminDetails);
		return bean;
	}

	@Override
	public Admin deleteAdmin(int adminId) throws UserNotFoundException {
		Admin  bean = null;
		try {
			bean = adminRepository.findById((long) adminId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		adminRepository.deleteById((long) adminId);
		return bean;
	}

	@Override
	public Admin findByAdminName(String adminName) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getUserName().equals(adminName) ) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return bean;
	}

	@Override
	public Integer addHall(HallDTO hall) {
		Hall hallEntity=new Hall();
		hallEntity.setHallId(hall.getHallId());
//		hallEntity.listMovies(hall.getMovie());
		hallEntity.setSeatsNo(hall.getSeatsNo());
		Hall hallEntity2=hallRepository.save(hallEntity);
		
		return hallEntity2.getHallId();
	}
	@Override
	public HallDTO gethallById(Integer hallId) throws HallNotFoundExcepiton{
		Optional<Hall> optional=hallRepository.findById(hallId);
		Hall hall=optional.orElseThrow(HallNotFoundExcepiton::new);
		HallDTO hall2=new HallDTO();
		hall2.setHallId(hall.getHallId());
		hall2.setMovie(hall.getMovie());
		hall2.setSeatsNo(hall.getSeatsNo());
		return hall2;

	}
	@Override
	public void deleteHallById(Integer hallId) throws HallNotFoundExcepiton{
		Optional<Hall> optional=hallRepository.findById(hallId);
		Hall hall=optional.orElseThrow(HallNotFoundExcepiton::new);
		HallDTO hall2=new HallDTO(); 
		hall2.setHallId(hall.getHallId());
		hall2.setMovie(hall.getMovie());
		hall2.setSeatsNo(hall.getSeatsNo());
		hallRepository.deleteById(hallId);
		
	}

	@Override
	public void updateHallBySeatsNo(Integer hallId, Integer seatsNo)throws HallNotFoundExcepiton {
		if(hallRepository.existsById(hallId)) {
			Hall hall=hallRepository.findById(hallId).get();
			hall.setSeatsNo(seatsNo);
			hallRepository.save(hall);
		}
		else {
			throw new HallNotFoundExcepiton();
		}
		}
	
	    @Override
	    public Admin registerAdmin(Admin admin) {
	        return adminRepository.save(admin);
	    }

	    @Override
	    public String loginAdmin(Admin admin) throws InvalidAdminException{
	        Admin existingAdmin = adminRepository.findByUserName(admin.getUserName());
	        if (existingAdmin == null || !existingAdmin.getPassword().equals(admin.getPassword())) {
	            throw new InvalidAdminException("Invalid credentials");
	        }
	        return "Welcome, " + existingAdmin.getUserName() + "!";
	    }
}
