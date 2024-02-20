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


        Student student= new Student();
        student.setId(10);
        student.setName("Dinelka");
        student.setAddress("galle");
       // student.setLaptops(laptopList);

        Laptop laptop1 = new Laptop();
        laptop1.setLid(122);
        laptop1.setModel("Dell");
        laptop1.setStudent(student);


        Laptop laptop2 = new Laptop();
        laptop2.setLid(23);
        laptop2.setModel("Hp");
        laptop2.setStudent(student);

        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(laptop1);
        laptopList.add(laptop2);




        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(laptop1);
        session.save(laptop2);

        transaction.commit();
        session.close();

    }
}