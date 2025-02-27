
package com.anudip.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.sms.entity.Student;
import com.anudip.sms.service.StudentService;

// @RestController
// @RequestMapping("/students")
public class StudentController1 {

	@Autowired
	private StudentService studentService;

	/* Postman Methods */

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/id/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getById(id);
	}

	@PostMapping("/add")
	public boolean createEntry(@RequestBody Student student) {
		studentService.addStudent(student);
		return true;
	}

	//
	@PutMapping("id/{id}")
	public Student updateStudentById(@PathVariable long id, @RequestBody Student updatedStudent) {
		Student existingStudent = studentService.getById(id);

		if (existingStudent != null) {
			existingStudent.setFirstName(updatedStudent.getFirstName());
			existingStudent.setLastName(updatedStudent.getLastName());
			existingStudent.setRollNo(updatedStudent.getRollNo());
			existingStudent.setAddress(updatedStudent.getAddress());
			Student savedStudent = studentService.addStudent(existingStudent);
			return savedStudent;
		}

		return null;
	}

	@DeleteMapping("id/{id}")
	public void deleteStudentById(@PathVariable Long id) {
		studentService.deleteById(id);
	}

}
