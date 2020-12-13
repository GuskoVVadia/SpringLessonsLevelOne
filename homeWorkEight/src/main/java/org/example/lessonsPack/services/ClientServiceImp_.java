/*
Подготовленный вариант.
 */
package org.example.lessonsPack.services;

import org.example.lessonsPack.dao.ClientDao;
import org.example.lessonsPack.domain.Client;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Objects;

public class ClientServiceImp_ implements ClientService, UserDetailsService {

    private final ClientDao clientDao;

    public ClientServiceImp_(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client getById(Long id) {
        return this.clientDao.findById(id).orElse(null);
    }

    @Override
    public Client auth(String name, String password) {
        if(name == null || name.isEmpty()){
            System.out.println("You are not authenticated");
            return null;
        }
        Client client = clientDao.findFirstByName(name);
        if (!client.isEnable()) {
            System.out.println("Account is disabled");
            return null;
        }

        if(client == null){
            System.out.println("You are not authenticated");
            return null;
        }
        if(!Objects.equals(password, client.getPassword())){
            System.out.println("You are not authenticated");
            return null;
        }
        System.out.println("You are authenticated");
        return client;
    }

    @Override
    public List<Client> getAll() {
        return this.clientDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return (UserDetails) this.clientDao.findFirstByName(name);
    }
}
