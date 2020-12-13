package org.example.lessonsPack.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String password;

    private boolean enable;

    public Client() {
    }

    public Client(String name, String password, boolean enable, List<Authorities> authorities) {
        this.name = name;
        this.password = password;
        this.enable = enable;
        this.authorities = authorities;
    }

    @ManyToMany
    @JoinTable(
            name = "client_authorities",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id")
    )
    private List<Authorities> authorities;

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
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return enable == client.enable &&
                Id.equals(client.Id) &&
                name.equals(client.name) &&
                password.equals(client.password) &&
                authorities.equals(client.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, password, enable, authorities);
    }

    @Override
    public String toString() {
        return "Client{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                ", authorities=" + authorities +
                '}';
    }
}
