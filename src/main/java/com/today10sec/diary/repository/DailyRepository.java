
package com.today10sec.diary.repository;

import com.today10sec.diary.model.Daily;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DailyRepository extends JpaRepository<Daily, Integer> {
}

