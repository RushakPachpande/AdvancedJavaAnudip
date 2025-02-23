
package com.anudip.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.hms.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {

}
