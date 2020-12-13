package org.example.lessonsPack.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String role;

    @ManyToMany
    @JoinTable(
            name = "client_authorities",
            joinColumns = @JoinColumn(name = "authorities_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorities that = (Authorities) o;
        return Id.equals(that.Id) &&
                role.equals(that.role) &&
                clients.equals(that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, role, clients);
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "Id=" + Id +
                ", role='" + role + '\'' +
                ", clients=" + clients +
                '}';
    }
}
