
package com.anudip.ems.controller;

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

import com.anudip.ems.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private Map<Long, Employee> employeeEntry = new HashMap<>();

	// Constructor to initialize 5 default students
	public EmployeeController() {
		employeeEntry.put(1L,
				new Employee(1L, "Rushak Pachpande", "rushak@email.com", "Software Engineer", "IT", 75000));
		employeeEntry.put(2L, 
				new Employee(2L, "Vikas Gawande", "vikas@email.com", "HR Manager", "HR", 68000));
		employeeEntry.put(3L,
				new Employee(3L, "Avinash Bhalerao", "avinash@email.com", "Marketing Specialist", "Marketing", 62000));
		employeeEntry.put(4L,
				new Employee(4L, "Shreyash Gonge", "shreyash@email.com", "Sales Executive", "Sales", 55000));
		employeeEntry.put(5L, 
				new Employee(5L, "Gaurav Bari", "gaurav@email.com", "Product Manager", "Product", 82000));
	}

	@GetMapping("/check")
	public String check() {
		return "Site is working";
	}

	@GetMapping
	public List<Employee> getAll() {
		return new ArrayList<>(employeeEntry.values());
	}

	@PostMapping
	public boolean createEntry(@RequestBody Employee myEntry) {
		employeeEntry.put(myEntry.getId(), myEntry);
		return true;
	}

	@GetMapping("/id/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return employeeEntry.get(id);
	}

	@DeleteMapping("id/{id}")
	public Employee deleteEmployeeById(@PathVariable long id) {
		return employeeEntry.remove(id);
	}

	@PutMapping("id/{id}")
	public Employee updateEmployeeById(@PathVariable long id, @RequestBody Employee employee) {
		return employeeEntry.replace(id, employee);
	}

}