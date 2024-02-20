package org.example;

import org.example.config.FactorConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        s1.setId(1);
        s1.setName("dinelka");
        s1.setAddress("galle");

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("ddvd");
        s2.setAddress("Pandura");

        Laptop l1=new Laptop();
        l1.setLid(1);
        l1.setModel("hp");

        Laptop l2=new Laptop();
        l2.setLid(2);
        l2.setModel("hp");

        List<Student> studentList=new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        List<Laptop> laptopList=new ArrayList<>();
        laptopList.add(l1);
        laptopList.add(l2);

        s1.setLaptops(laptopList);
        s2.setLaptops(laptopList);
        l1.setStudents(studentList);
        l1.setStudents(studentList);

        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(s1);
        session.save(s2);
        session.save(l1);
        session.save(l2);
        transaction.commit();
        session.close();


    }
}