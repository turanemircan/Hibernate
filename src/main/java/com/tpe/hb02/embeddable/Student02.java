package com.tpe.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id//entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name", length = 100, nullable = false, unique = true)//opsiyonel
    private String name;

    private int grade;

    // street
    // city
    // zipcode
    //  country
    // Daha okunur kod için bu fieldlar için ayrı class oluşturalım.
    // Bir class ta çok fazla field barındırmak yerine aynı amaçla kullanılan fieldları ayrı bir class ta topladık.
    // Class adı Address olarak oluşturduk ve class içindeki fieldlara
    // ve get-setlere ulaşabilmek için bulundğumuz classta Address veri tipli field oluşturduk.

    @Embedded // gömülü, opsiyonel yazmasakta olurdu okunurluğu artırmak için kullandık
    private Address address;
    // street, city, zipcode, country sütun oluşacak

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade + '\'' +
                ", adress=" + getAddress() +
                '}';
    }
}