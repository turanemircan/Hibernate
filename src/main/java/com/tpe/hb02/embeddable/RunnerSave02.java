package com.tpe.hb02.embeddable;

import com.tpe.hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Address address1 = new Address("Apple St.", "NewYork", "US", "543216");
        Address address2 = new Address("Orange St.", "London", "England", "773216");

        Student02 student01 = new Student02();
        student01.setId(1001);
        student01.setName("Emircan");
        student01.setGrade(99);
        student01.setAddress(address1);

        Student02 student02 = new Student02();
        student02.setId(1002);
        student02.setName("Ayşe");
        student02.setGrade(98);
        student02.setAddress(address2);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student02.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student02); // --> Hibernate 5.2 ile  DEPRECATE (kullanımdan kaldırıldı) oldu.
        session.persist(student01);
        session.persist(student02);

        tx.commit();
        session.close();
        sf.close();

    }
}
