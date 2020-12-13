package org.example.lessonsPack.dao;

import org.example.lessonsPack.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
    Client findFirstByName(String name);
}
