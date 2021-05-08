package com.today10sec.diary.mvc.service.impl;

import com.today10sec.diary.mvc.repository.DiaryRepository;
import com.today10sec.diary.mvc.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDiaryService implements DiaryService {
    DiaryRepository diaryRepository;

    @Autowired
    public void setDiaryRepository(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }
}
