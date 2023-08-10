package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Ummü Umare");
        student01.setGrade(98);
        student01.setAge(25);

        Student01 student2=new Student01();
        student2.setId(1002);
        student2.setName("Benna");
        student2.setGrade(99);
        student2.setAge(30);

        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("Hasan");
        student3.setGrade(95);
        student3.setAge(30);

        //hibernate.cfg.xml dosyamızdaki bilgilere ve Student01 classındaki annotasyonalara göre konfigürasyon yapılır.
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        //tüm uygulamada sadece bir tane sf kullanılır. fakat farklım işlemller için birden fazla session açılabilir.
        SessionFactory sf =configuration.buildSessionFactory();//DB ile ilgili işlemlerin yönetimini sağlar.
        Session session =sf.openSession();//DB de CRUD op. için ve sorguları çalıştırmak için metodlar içerir
        //hibernate auto-commit:false
        Transaction tx =session.beginTransaction();//DB de bir transaction başlatır

        //INSERT INTO ...
        session.persist(student01);
        session.persist(student2);
        session.persist(student3);

        // persist => Kalıcı hale getir
        tx.commit();
        session.close();
        sf.close();




    }
}
