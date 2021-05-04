package com.today10sec.diary.service.impl;

import com.today10sec.diary.repository.DiaryRepository;
import com.today10sec.diary.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDiaryService implements DailyService {
    DiaryRepository diaryRepository;

    @Autowired
    public void setDiaryRepository(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }
}
