
package com.anudip.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private Long id;

	private String name;

	private String email;

	private String role;

	private String dept;

	private double salary;

}
