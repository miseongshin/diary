package com.today10sec.diary.service.impl;

import com.today10sec.diary.repository.DailyRepository;
import com.today10sec.diary.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDailyService implements DailyService {
    DailyRepository dailyRepository;


    @Autowired
    public void setDailyRepository(DailyRepository dailyRepository) {
        this.dailyRepository = dailyRepository;
    }
}
