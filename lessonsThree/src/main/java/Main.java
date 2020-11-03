package HomeWork;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration().configure("hibernate.xml").buildSessionFactory();
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(new Object());


    }
}
