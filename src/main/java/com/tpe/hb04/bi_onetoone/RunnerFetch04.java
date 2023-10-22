package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student04 student = session.get(Student04.class, 1001);
        System.out.println(student.getDiary());
        //studentdan diarye ulaşabiliyoruz...

        tx.commit();
        session.close();
        sf.close();
    }
}