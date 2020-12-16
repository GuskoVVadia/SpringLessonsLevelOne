package org.example.lessonsPack.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Client> clients;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "ROLE_" + name.toUpperCase();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Id.equals(role.Id) &&
                name.equals(role.name) &&
                clients.equals(role.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, clients);
    }

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}
