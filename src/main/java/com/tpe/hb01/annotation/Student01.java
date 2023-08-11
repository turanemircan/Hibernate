package com.tpe.hb01.annotation;

import javax.persistence.*;

@Entity // Bu classtan oluşturduğumuz objeleri kalıcı hale getirmek için
// DB de bir tablo oluşturulur --> Student01
@Table(name = "t_student01") // tabloya custom bir isim vermemizi sağlar:opsiyonel
//HQL: Student01
//SQL: t_student01
public class Student01 {

    @Id // entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    @Column(name = "std_id") // Id annotation’ında isim değiştirme
    private int id;

    @Column(name = "std_name", length = 100, nullable = false, unique = true) // opsiyonel
    private String name;

    private int grade;

    @Transient // Bu fielda karşılık age isminde bir sütun oluşturmaz
    private int age; // age için sütun oluşturulsun istemiyorsak

    // BLOB = Binary Large Object. PostgreSQL de büyük boyuta dataları kaydetmek için kullanırız.
    // CLOB = Character Large Object. PostgreSQL de büyük boyuta textleri tutmak için kullanırız.

//    @Lob // Büyük boyutlu datalar(Large object) için sütun oluşmasını sağlar.
    // Bir resmi,videoyu, büyük boyuttaki textleri byte arrayde tutarız.
//    private byte[] image;

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
