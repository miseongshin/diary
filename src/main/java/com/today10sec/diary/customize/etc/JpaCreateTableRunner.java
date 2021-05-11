package com.today10sec.diary.customize.etc;

import com.today10sec.diary.customize.model.Customer;
import com.today10sec.diary.customize.model.Daily;
import com.today10sec.diary.customize.model.Diary;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class JpaCreateTableRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args){

        Session session = entityManager.unwrap(Session.class);

        Customer customer =Customer.builder()
                .email("test@test.com")
                .auth("A")
                .password("11111").build();
        List<Diary> diaryList = new ArrayList<>();
        Diary diary = new Diary("타이틀");
        diaryList.add(diary);

        session.save(customer);
        session.save(diary);
        Daily daily = new Daily();
        session.save(daily);

    }
}
