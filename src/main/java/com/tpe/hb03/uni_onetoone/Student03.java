package com.tpe.hb03.uni_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student03")
public class Student03 {

    @Id // entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name", length = 100, nullable = false, unique = true)//opsiyonel
    private String name;

    private int grade;

    // parametresiz constructor
    // parametresiz const kullanmamızın sebebi datalar tablodan fetch edildiğinde (objelerimizin datadan getirildiğinde)
    // hibernate parametresiz const kullanarak objeyi oluşturuyor.
    // Bundan dolayı parametreli cont kullanmak için parametresiz const oluşturmalıyız.
    public Student03() {
    }

    // parametreli constructor

    public Student03(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // getter-setter

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

    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}