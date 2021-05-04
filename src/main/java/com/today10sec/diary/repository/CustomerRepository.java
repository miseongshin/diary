
package com.today10sec.diary.repository;

import com.today10sec.diary.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

