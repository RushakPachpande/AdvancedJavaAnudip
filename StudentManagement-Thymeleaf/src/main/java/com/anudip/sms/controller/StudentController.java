
package com.anudip.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anudip.sms.entity.Student;
import com.anudip.sms.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// Get the List of Students page
	@GetMapping
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	// Get the AddStudent page
	@GetMapping("/add")
	public String addStudentForm(Model model) {
		// create student object from student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_student";
	}

	// Saving the Student
	@PostMapping
	public String addStudent(@ModelAttribute /* ("student") */ Student student, HttpSession session) {
		studentService.addStudent(student);
		session.setAttribute("successMessage", "Student Added");
		return "redirect:/students";
	}

	// Get the Update page
	@GetMapping("/update/{id}")
	public String updateStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getById(id));
		return "update_student";
	}

	// Update existing student
	@PostMapping("/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute /* ("student") */ Student student, Model model,
			HttpSession session) {

		// Get by Id
		Student existingStudent = studentService.getById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setAddress(student.getAddress());

		// Save the updated student
		studentService.addStudent(existingStudent);
		session.setAttribute("successMessage", "Student Updated");
		return "redirect:/students";

	}

	// Delete student
	@GetMapping("/{id}")
	public String deleteStudent(@PathVariable Long id, HttpSession session) {
		studentService.deleteById(id);
		session.setAttribute("successMessage", "Student Deleted");
		return "redirect:/students";
	}

	// Handler to remove popup success message as blank
	@PostMapping("/resetSuccessMessage")
	public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
		session.removeAttribute("successMessage");
		return ResponseEntity.ok().build();
	}

}
