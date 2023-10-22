package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Diary;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student01 = new Student04();
        student01.setId(1001);
        student01.setName("Emircan");
        student01.setGrade(98);

        Student04 student02 = new Student04();
        student02.setId(1002);
        student02.setName("Ahmet");
        student02.setGrade(97);

        Student04 student03 = new Student04();
        student03.setId(1003);
        student03.setName("Damla");
        student03.setGrade(95);
        //student03.setDiary();

        Diary04 diary01 = new Diary04();
        diary01.setId(11);
        diary01.setName("A Diary");
        diary01.setStudent(student01);

        Diary04 diary02 = new Diary04();
        diary02.setId(22);
        diary02.setName("B Diary");
        diary02.setStudent(student02);

        Diary04 diary03 = new Diary04();
        diary03.setId(33);
        diary03.setName("C Diary");

        // bi_directionalda: kesinlikle ilişki sahibi tarafında diğer obje set edilmeli
        // yani Diary tarafında Eğer sadece diğer taraftan set edersek FK null değer döndürür.

        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student01);
        session.persist(student02);
        session.persist(student03);

        session.persist(diary01);
        session.persist(diary02);
        session.persist(diary03);

        tx.commit();
        session.close();
        sf.close();
    }
}
