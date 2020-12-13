package org.example.lessonsPack.services;

import org.example.lessonsPack.domain.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ClientService{
    Client getById(Long id);
    Client auth(String name, String password);
    List<Client> getAll();
}
