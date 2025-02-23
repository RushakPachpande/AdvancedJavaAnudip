
package com.anudip.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.hms.entity.Hotel;
import com.anudip.hms.repository.HotelRepo;

@Service
public class HotelService {

	@Autowired
	private HotelRepo hotelRepo;

	// Getting all Hotels data
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	public Hotel getById(Long id) {
		return hotelRepo.findById(id).orElse(null);
	}

	// Saving a Hotel
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

//	 // Update a Hotel
//	 public Hotel updateHotel(Long id, Hotel hotel) {
//	 if(hotelRepo.existsById(id)) {
//	
//	 }
//	 }

	// Delete a Hotel
	public boolean deleteHotel(Long id) {

		if (hotelRepo.existsById(id)) {
			hotelRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}

	}

}
