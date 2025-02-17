package com.anudip.sms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.sms.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	private Map<Long, Student> studentEntry = new HashMap<>();

	// Constructor to initialize 5 default students
	public StudentController() {
		studentEntry.put(1L, new Student(1L, "Rushak Pachpande", 101));
		studentEntry.put(2L, new Student(2L, "Vikas Gawande", 102));
		studentEntry.put(3L, new Student(3L, "Avinash Bhalerao", 103));
		studentEntry.put(4L, new Student(4L, "Shreyash Gonge", 104));
		studentEntry.put(5L, new Student(5L, "Gaurav Bari", 105));
	}

	@GetMapping("/check")
	public String check() {
		return "Site is working";
	}

	@GetMapping
	public List<Student> getAll() {
		return new ArrayList<>(studentEntry.values());
	}

	@PostMapping
	public boolean createEntry(@RequestBody
	Student myEntry) {
		studentEntry.put(myEntry.getId(), myEntry);
		return true;
	}

	@GetMapping("/id/{id}")
	public Student getStudentById(@PathVariable
	long id) {
		return studentEntry.get(id);
	}

	@DeleteMapping("id/{id}")
	public Student deleteStudentById(@PathVariable
	long id) {
		return studentEntry.remove(id);
	}

	@PutMapping("id/{id}")
	public Student updateStudentById(@PathVariable
	long id, @RequestBody
	Student student) {
		return studentEntry.replace(id, student);
	}

}
