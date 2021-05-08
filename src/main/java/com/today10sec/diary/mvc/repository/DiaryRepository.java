package com.today10sec.diary.mvc.repository;

import com.today10sec.diary.customize.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {
}
