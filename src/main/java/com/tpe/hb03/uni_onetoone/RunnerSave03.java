package com.tpe.hb03.uni_onetoone;

import com.tpe.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student01 = new Student03(1001, "Emircan", 100);
        Student03 student02 = new Student03(1002, "Ali", 95);
        Student03 student03 = new Student03(1003, "Ayşe", 98);

        Diary diary01 = new Diary();
        diary01.setId(11);
        diary01.setName("Emircan's dairy.");
        diary01.setStudent(student01);

        Diary diary02 = new Diary();
        diary02.setId(12);
        diary02.setName("Ali's dairy.");
        diary02.setStudent(student02);

        Diary diary03 = new Diary();
        diary03.setId(13);
        diary03.setName("X's dairy.");
        // diary02.setStudent(student01); Olursa 1 e 1 olmaz buna ya biz dikkat edecez ya da
        // Diary classında @JoinColumn (unique = true) kullanmamız lazım.

        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Oluşturulan objeleri tablolara kaydetmek için persist methodunu kullandık.

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
