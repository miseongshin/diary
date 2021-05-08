/*package com.today10sec.diary.customize.etc;

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

@Component
@Transactional
public class JpaCreateTableRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args){

        Session session = entityManager.unwrap(Session.class);

        Customer customer = new Customer();
        session.save(customer);
        Diary diary = new Diary();
        session.save(diary);
        Daily daily = new Daily();
        session.save(daily);

    }
}
*/