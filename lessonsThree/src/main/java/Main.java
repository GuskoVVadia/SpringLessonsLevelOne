import HomeWork.Customer;
import HomeWork.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration().configure("hibernate.xml").buildSessionFactory();
        EntityManager manager = factory.createEntityManager();

        Product milk = new Product("milk");
        createEntity(manager, milk);
        Product bread = new Product("bread");
        createEntity(manager, bread);
        Product ham = new Product("ham");
        createEntity(manager, ham);

        Customer happyMilkMan = new Customer("Igor");
        createEntity(manager, happyMilkMan);

        Customer userTwo = new Customer("Alex");
        createEntity(manager, userTwo);

        happyMilkMan = readEntity(manager, happyMilkMan.getId(), Customer.class);
        List<Product> purchaseHappyMilk = new ArrayList<>();
        Product product = readEntity(manager, 1, Product.class);
        purchaseHappyMilk.add(product);
        happyMilkMan.setProducts(purchaseHappyMilk);
        saveEntity(manager, happyMilkMan);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(happyMilkMan);
        product.setCustomers(customerList);
        saveEntity(manager, product);







    }
    private  static <T> void createEntity(EntityManager em, T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    private static <T> T readEntity(EntityManager em, long id, Class<T> tClazz){
        em.getTransaction().begin();
        T object = em.find(tClazz, id);
        em.getTransaction().commit();
        return object;
    }

    private static <T> T saveEntity(EntityManager em, T entity){
        em.getTransaction().begin();
        T savedEntity = em.merge(entity);
        em.getTransaction().commit();
        return savedEntity;
    }

    private static <T> void deleteEntity(EntityManager em, T entity){
        em.getTransaction().begin();
        em.detach(entity);
        em.getTransaction().commit();
    }


}
