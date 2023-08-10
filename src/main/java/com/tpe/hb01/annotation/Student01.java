package com.tpe.hb01.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Bu classtan oluşturduğumuz objeleri kalıcı hale getirmek için
       // DB de bir tablo oluşturulur --> Student01
@Table(name = "t_student01") // tabloya custom bir isim vermemizi sağlar:opsiyonel
public class Student01 {

    @Id // entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name",length = 100,nullable = false,unique = true) // opsiyonel
    private String name;

    private int grade;

    private int age;

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
