package com.myprojectOmega.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegistrationRepo extends JpaRepository<CustomerInfo, Long> {

}
