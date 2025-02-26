
package com.anudip.sms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anudip.sms.entity.Student;
import com.anudip.sms.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController1 {

	private StudentService studentService;

	public StudentController1(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler to remove popup success message as blank
	@PostMapping("/resetSuccessMessage")
	public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
		session.removeAttribute("successMessage");
		return ResponseEntity.ok().build();
	}

	// what should get and what should not will be done here.

	// handler method to handle list of students and return mode and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	// get the add student page
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object from student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";

	}

	// saving student
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student, HttpSession session) {
		studentService.addStudent(student);
		session.setAttribute("successMessage", "Successfully Added");
		return "redirect:/students";
	}

	// get the update or edit page
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getById(id));
		return "edit_student";
	}

	// update data into existing table
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model,
			HttpSession session) {

		// get student from database by id
		Student existingStudent = studentService.getById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setAddress(student.getAddress());

		// save update student object
		studentService.updateStudentById(existingStudent);
		session.setAttribute("successMessage", "Successfully Updated");
		return "redirect:/students";

	}

	// handler method to delete student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id, HttpSession session) {
		studentService.deleteById(id);
		session.setAttribute("successMessage", "Successfully Deleted");
		return "redirect:/students";
	}

}
