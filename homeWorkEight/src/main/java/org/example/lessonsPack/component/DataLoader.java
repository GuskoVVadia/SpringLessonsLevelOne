package org.example.lessonsPack.component;

import org.example.lessonsPack.dao.AuthoritiesDao;
import org.example.lessonsPack.dao.ClientDao;
import org.example.lessonsPack.dao.ProductDao;
import org.example.lessonsPack.domain.Role;
import org.example.lessonsPack.domain.Client;
import org.example.lessonsPack.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    private final ClientDao clientDao;
    private final AuthoritiesDao authoritiesDao;
    private final ProductDao productDao;

    public DataLoader(ClientDao clientDao, AuthoritiesDao authoritiesDao, ProductDao productDao) {
        this.clientDao = clientDao;
        this.authoritiesDao = authoritiesDao;
        this.productDao = productDao;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData(){
        System.out.println("init products");
        productDao.saveAndFlush(new Product("Milk", 15.5));
        productDao.saveAndFlush(new Product("Bread", 20.0));
        productDao.saveAndFlush(new Product("Butter", 33.7));
        productDao.saveAndFlush(new Product("Water", 5.0));

        System.out.println("init user/roles");

        Role userRole = new Role();
        userRole.setName("user");

        Role adminRole = new Role();
        adminRole.setName("admin");

        Role managerRole = new Role();
        managerRole.setName("manager");

        Client user1 = new Client();
        user1.setName("user");
        user1.setPassword("123");
        user1 = clientDao.save(user1);
        user1.setRoles(Arrays.asList(userRole));

        Client user2 = new Client();
        user2.setName("manager");
        user2.setPassword("123");
        user2 = clientDao.save(user2);
        user2.setRoles(Arrays.asList(userRole, managerRole));

        Client admin = new Client();
        admin.setName("admin");
        admin.setPassword("123");
        admin = clientDao.save(admin);
        admin.setRoles(Arrays.asList(userRole, managerRole, adminRole));

//        userRole.setClients(Arrays.asList(user1, user2, admin));
//        adminRole.setClients(Arrays.asList(admin));

        userRole = authoritiesDao.save(userRole);
        adminRole = authoritiesDao.save(adminRole);
        managerRole = authoritiesDao.save(managerRole);

        clientDao.save(user1);
        clientDao.save(user2);
        clientDao.save(admin);

        authoritiesDao.save(userRole);
        authoritiesDao.save(adminRole);
        authoritiesDao.save(managerRole);

        System.out.println("end init method");
    }
}
