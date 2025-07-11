package com.myprojectOmega.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myprojectOmega.demo.entity.CustomerInfo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/myapp/studentController")
public class RegistrationController {

	@Autowired
	public StudentRegistrationService studentRegistrationService;

	// setter injunction
//	@Autowired
//	public void setStudentRegistrationService(StudentRegistrationService studentRegistrationService) {
//		this.studentRegistrationService = studentRegistrationService;
//
//	}
//
//	// constructor injunction
//	@Autowired
//	public RegistrationController(StudentRegistrationService studentRegistrationService) {
//		this.studentRegistrationService = studentRegistrationService;
//	}
//
//	public RegistrationController() {
//		this.studentRegistrationService = null;
//	}

	// field injunction
//	@Autowired
//	StudentRegistrationService studentRegistrationService;

	@GetMapping("/helloStudent")
	public String helloStudent() {

		System.out.println("My Student Get Method");

		return "Welcome Student Codebegun";
	}

	@GetMapping("/getStudents")
	public List<StudentInfo> getStudents() {

		List<StudentInfo> studentInfo = studentRegistrationService.getStudentInfo();
		return studentInfo;
	}

	// query parms -- @RequestParms
	// URI path variable - @PathVariable
	// @RequestBody

	@GetMapping("/getStudentById")
	public StudentInfo getStudentById(@RequestParam(name = "studentId") Long studentId,
			@RequestParam(name = "studentId1") Long studentId1) {

//		StudentRegistrationService srs = new StudentRegistrationService();
//		StudentInfo studentInfo = null;
		StudentInfo studentInfo = studentRegistrationService.getStudentById(studentId);
		return studentInfo;
	}

	@GetMapping("/getStudentByIdPath/{studentId}/{studentId1}")
	public StudentInfo getStudentById1(@PathVariable(name = "studentId") Long studentId,
			@PathVariable(name = "studentId1") Long studentId1) {

//		StudentRegistrationService srs = new StudentRegistrationService();
//		StudentInfo studentInfo = null;
		StudentInfo studentInfo = studentRegistrationService.getStudentById(studentId);
		return studentInfo;
	}

	@PostMapping("/createStudent")
	public StudentInfo createStudent(@RequestBody StudentInfo studentInfo) {

		System.out.println("SID: " + studentInfo.getStudentName());

		return studentInfo;
	}

	@PostMapping("/createCustomer")
	public CustomerInfo createCustomer(@Valid @RequestBody CustomerInfo customerInfo) {

		studentRegistrationService.createCustomer(customerInfo);

		return customerInfo;
	}

	@PutMapping("/updateCustomer/{customerId}")
	public CustomerInfo updateCustomer(@Valid @RequestBody CustomerInfo customerInfo,
			@PathVariable(name = "customerId") Long customerId) {

		studentRegistrationService.updateCustomer(customerInfo, customerId);

		return customerInfo;
	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public boolean deleteCustomer(@PathVariable(name = "customerId") Long customerId) {
		studentRegistrationService.deleteCustomer(customerId);
		return true;
	}

}
