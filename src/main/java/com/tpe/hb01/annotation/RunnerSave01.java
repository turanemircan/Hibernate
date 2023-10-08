package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Emircan");
        student01.setGrade(99);
        student01.setAge(21);

        Student01 student02 = new Student01();
        student02.setId(1002);
        student02.setName("Ali");
        student02.setGrade(99);
        student02.setAge(30);

        Student01 student03 = new Student01();
        student03.setId(1003);
        student03.setName("Can");
        student03.setGrade(95);
        student03.setAge(30);

        // hibernate.cfg.xml dosyamızdaki bilgilere ve Student01 classındaki annotasyonalara göre konfigürasyon yapılır.
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        // addAnnotatedClass ile Entity classımızı Hibernate e gösteriyoruz.
        // Hibernate'in bir Configuration Class'ı var. Bu class içerisinde configure methodu kullanarak configuration dosyasının ismini belirtiyorum.
        // Bu dosyayı okuyup ayarları uygulayacak. addAnnotatedClass() methodu Student01.class classtaki anatasyonları okumasını sağlıyor.

        // SessionFactory = Database ile ilgili işlemlerimizi yönetmemizi sağlayan bir interface'tir.
        // Tüm uygulamada sadece bir tane sf kullanılır. fakat farklı işlemler için birden fazla session açılabilir.
        SessionFactory sf = configuration.buildSessionFactory(); //DB ile ilgili işlemlerin yönetimini sağlar. buildSessionFactory() Session Factory oluşturur.
        Session session = sf.openSession(); //DB de CRUD op. için ve sorguları çalıştırmak için metodlar içerir

        // Databasede yapmış olduğumuz en küçük işlem birimine transaction denir.
        // hibernate auto-commit:false yani her bir işlem otomatik aktif olmuyor. Bundan dolayı her bir değişiklik transaction sayesinde yaparız.
        Transaction tx = session.beginTransaction(); // DB de bir transaction başlatır

        // INSERT INTO ...
        //session.persist(student01);
        session.persist(student02);
        //session.persist(student03);
        // persist => Kalıcı hale getir


        tx.commit(); // işlem ve değişikliklerimizi kalıcı hale getirmek için transaction commit yaparız.
        session.close(); // db bağlanma işlemleri geçekleştirdikleri çin işlemcide ve memoryde kaynak ayrılır.
        sf.close(); // Kaynakları serbest bırakmak için close() işlemi yapılır.

    }
}
