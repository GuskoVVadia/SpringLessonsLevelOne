package org.example.lessonsPack.dao;

import org.example.lessonsPack.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesDao extends JpaRepository<Role, Long> {
}
