
package com.anudip.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.sms.entity.Student;
import com.anudip.sms.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public Student getById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}

	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

//	public Student updateStudent(Long id, Student updateStudent) {
//		Student exists = studentRepo.findById(id).orElse(null);
//
//		if (exists != null) {
//			exists.setFirstName(updateStudent.getFirstName());
//			exists.setLastName(updateStudent.getLastName());
//			exists.setRollNo(updateStudent.getRollNo());
//			exists.setAddress(updateStudent.getAddress());
//			
//			Student savedStudent = stude
//		}
//
//	}

	public boolean deleteById(Long id) {

		if (studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			return true;
		}

		return false;
	}

}
