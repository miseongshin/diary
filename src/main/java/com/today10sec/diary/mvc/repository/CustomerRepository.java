
package com.today10sec.diary.mvc.repository;

import com.today10sec.diary.customize.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

