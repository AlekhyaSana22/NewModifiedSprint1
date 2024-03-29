package com.multiplex.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.HallDTO;
import com.multiplex.entities.Hall;
import com.multiplex.exception.HallNotFoundExcepiton;
import com.multiplex.repository.HallRepository;

@Service(value="hallservice")
public class HallServicesImpl implements HallServices{

	@Autowired
	private HallRepository hallRepository;
	@Override
	public List<HallDTO> getAllHalls() throws HallNotFoundExcepiton{
		Iterable<Hall> halls=hallRepository.findAll();
		List<HallDTO> halls2=new ArrayList<>();
		halls.forEach(hall -> {
			HallDTO halls1=new HallDTO();
			halls1.setHallId(hall.getHallId());
			halls1.setMovie(hall.getMovie());
			halls1.setSeatsNo(hall.getSeatsNo());
			halls2.add(halls1);
		});
		if(halls2.isEmpty()) {
			throw new HallNotFoundExcepiton();
		}
		return halls2;
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
	public void updateHallBySeatsNo(Integer hallId, Integer seatsNo) {
		    Hall hall = hallRepository.findById(hallId).orElseThrow(() -> new HallNotFoundExcepiton());
		    hall.setSeatsNo(seatsNo);
		    hallRepository.save(hall);
		}
}