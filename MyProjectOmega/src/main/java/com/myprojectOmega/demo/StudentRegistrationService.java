package com.myprojectOmega.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojectOmega.demo.entity.CustomerInfo;
import com.myprojectOmega.demo.entity.StudentRegistrationRepo;

@Service("studentRegistrationService")
public class StudentRegistrationService {

	@Autowired
	StudentRegistrationRepo studentRegistrationRepo;

	public List<StudentInfo> getStudentInfo() {

		List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentId(1234l);
		studentInfo.setStudentName("abc");
		studentInfo.setEmail("abc@gmail.com");

		StudentInfo studentInfo1 = new StudentInfo();
		studentInfo1.setStudentId(567l);
		studentInfo1.setStudentName("klm");
		studentInfo1.setEmail("klm@gmail.com");

		StudentInfo studentInfo2 = new StudentInfo();
		studentInfo2.setStudentId(893l);
		studentInfo2.setStudentName("xyz");
		studentInfo2.setEmail("xyz@gmail.com");

		studentInfoList.add(studentInfo);
		studentInfoList.add(studentInfo1);
		studentInfoList.add(studentInfo2);

		return studentInfoList;

	}

	public StudentInfo getStudentById(Long studentId) {

		List<StudentInfo> studentList = getStudentInfo();

		StudentInfo studentInfo = null;

		for (StudentInfo studentInfoObj : studentList) {
			if (studentInfoObj.getStudentId().equals(studentId)) {
				studentInfo = studentInfoObj;
				return studentInfo;
			}

		}

		return studentInfo;

	}

	public StudentInfo createStudent(StudentInfo studentInfo) {

		return studentInfo;

	}

	public CustomerInfo createCustomer(CustomerInfo customerInfo) {

		System.out.println("Customer Name : " + customerInfo.getCustomerName());
		studentRegistrationRepo.save(customerInfo);
		return customerInfo;

	}

	public CustomerInfo updateCustomer(CustomerInfo customerInfo, Long customerId) {

		System.out.println("Customer Name : " + customerInfo.getCustomerName());

		customerInfo.setCustomerId(customerId);
		studentRegistrationRepo.save(customerInfo);
		return customerInfo;

	}

	public boolean deleteCustomer(Long customerId) {

//	System.out.println("Customer Name : " +customerInfo.getCustomerName());

//	customerInfo.setCustomerId(customerId);
		studentRegistrationRepo.deleteById(customerId);
		return Boolean.TRUE;

	}

}
