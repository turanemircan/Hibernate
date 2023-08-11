package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        // configure() --> hibernate.cfg.xml (default değer bu olduğu için yazmadık farklı bir isim verseydik yazmak zorundaydık )
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student01.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // DB den data çekmek için 3 tane yol var

        // 1.Yol: get metodu
        Student01 student1 = session.get(Student01.class, 1001); // select * from t_student01 where std_id=1001
        Student01 student2 = session.get(Student01.class, 1002); // select * from t_student01 where std_id=1001
        Student01 student3 = session.get(Student01.class, 1003); // select * from t_student01 where std_id=1001

        System.out.println("-------------------Get Metodu----------------------");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        // 2.Yol:SQL
        System.out.println("-------------------SQL Query----------------------");


        String sql = "SELECT * FROM t_student01";
        List<Object[]> resultList = session.createSQLQuery(sql).getResultList();
        for (Object[] objects : resultList) {
            System.out.println(Arrays.toString(objects));
        }

        // 3.Yol:HQL:Hibernate Query Language:Java bileşenleri ile sorgu yazılır.
        System.out.println("-------------------HQL Query----------------------");

        // HQL kullanırken databasedeki tablo ismi ve sütun ismi yerine javadaki class ismini ve fieldların isimini kullanıyoruz.
        String hql = "FROM Student01";
        List<Student01> studentList = session.createQuery(hql, Student01.class).getResultList();
        for (Student01 student : studentList) {
            System.out.println(student);
        }

        // SQL ile getirince array olarak, HQL ile yazınca object format olarak getiriyor

        // İsmi Benna olan kaydı yazdıralım.
        //SQL
        String sql2 = "SELECT * FROM t_student01 WHERE std_name='Can'";
        Object[] studentBenna = (Object[]) session.createSQLQuery(sql2).uniqueResult(); // Object tipini ref olarak kabul eder.
        System.out.println(Arrays.toString(studentBenna));

        //HQL
        String hql2 = "FROM Student01 WHERE name='Can'";
        Student01 student01 = session.createQuery(hql2, Student01.class).uniqueResult();
        System.out.println(student01);

        // session da SQL için createSQLquery kullanıyoruz; HQL için createQuery kullanıyoruz

        // HQL sorgusunda ALIAS(SQL de Takma isim için kulanırdık) kullanalım, ismi 'Ali' olan kaydın sadece id ve name ini yazdıralım.

        String hql3="SELECT s.id, s.name FROM Student01 s WHERE s.name='Ali'";

        Object[] studentAli= (Object[]) session.createQuery(hql3).uniqueResult(); // Geriye [id, name] gelecek sadece:
        System.out.println(Arrays.toString(studentAli));

        tx.commit();
        session.close();
        sf.close();

    }
}