package org.example.config;

import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactorConfiguration {
    private static FactorConfiguration factorConfiguration;

    private SessionFactory sessionFactory;

    private FactorConfiguration(){
        Configuration configuration = new  Configuration().configure()
                .addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        sessionFactory=configuration.buildSessionFactory();
    }

    public static FactorConfiguration getInstance(){
        return  (factorConfiguration==null)?factorConfiguration=
                new FactorConfiguration():factorConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
