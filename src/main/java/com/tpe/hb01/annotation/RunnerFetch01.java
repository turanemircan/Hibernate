package com.tpe.hb01.annotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {
    public static void main(String[] args) {

        //configure()-->hibernate.cfg.xml
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Student01.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        tx.commit();
        session.close();
        sf.close();

    }
}