package org.example.lessonsPack.dao;

import org.example.lessonsPack.domain.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesDao extends JpaRepository<Authorities, Long> {
}
