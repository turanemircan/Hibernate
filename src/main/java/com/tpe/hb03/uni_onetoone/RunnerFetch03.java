package com.tpe.hb03.uni_onetoone;

import com.tpe.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    // İlişkili bir şekilde oluşturduğumuz objeleri getirelim.
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // id:1002 olan studentı görelim
        Student03 student = session.get(Student03.class, 1002);
        System.out.println(student);
        // student.getDiary();?????


        System.out.println("----------------------------------------");

        // id:12 olan diaryi görelim
        Diary diary = session.get(Diary.class, 12);
        System.out.println(diary);

        // id:11 olan diaryinin sahibi olan studentı görelim
        Diary diary2 = session.get(Diary.class, 11);
        System.out.println("id:11 olan diarynin sahibi: " + diary2.getStudent());

        // Diary'den Student'a ulaşabiliyoruz.
        // Student'dan Diary'e ulaşamıyoruz.
        // SQL ile ulaşılır ama kodlar ile ulaşamayız.

        tx.commit();
        session.close();
        sf.close();
    }
}
