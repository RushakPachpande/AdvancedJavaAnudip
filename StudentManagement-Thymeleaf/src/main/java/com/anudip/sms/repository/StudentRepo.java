
package com.anudip.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.sms.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
