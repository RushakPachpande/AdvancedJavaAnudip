
package com.anudip.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.anudip.hms.entity.Hotel;
import com.anudip.hms.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public Hotel getById(@PathVariable Long id) {
		return hotelService.getById(id);
	}

	@PostMapping("/add")
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}

	@PutExchange("/update/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel updatedHotel) {

		Hotel existingHotel = hotelService.getById(id);

		if (existingHotel != null) {
			existingHotel.setName(updatedHotel.getName());
			existingHotel.setHotelType(updatedHotel.getHotelType());
			existingHotel.setQuality(updatedHotel.getQuality());

			Hotel savedHotel = hotelService.saveHotel(existingHotel);

			return ResponseEntity.ok(savedHotel);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
		boolean isDeleted = hotelService.deleteHotel(id);

		return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

	}

}
