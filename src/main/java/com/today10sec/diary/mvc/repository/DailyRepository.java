
package com.today10sec.diary.mvc.repository;

import com.today10sec.diary.customize.model.Daily;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DailyRepository extends JpaRepository<Daily, Integer> {
}

