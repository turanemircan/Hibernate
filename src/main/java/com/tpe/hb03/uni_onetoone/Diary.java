package com.tpe.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

    @Id
    private int id;

    private String name;

    @OneToOne // t_student(Student03 class'ındaki tablo) tablosundaki PK sütununu kullanarak
    // Diary tablosunda FK sütunu oluşturulur. Bu sütunun Default name: fieldname_id "student_id"
    @JoinColumn(name = "std_id", unique = true) // Oluşturduğumuz FK sütun ismini değiştirmemizi sağlar. // Opsiyonel
    private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
