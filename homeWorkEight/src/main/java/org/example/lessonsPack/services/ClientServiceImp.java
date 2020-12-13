package org.example.lessonsPack.services;

import org.example.lessonsPack.dao.AuthoritiesDao;
import org.example.lessonsPack.dao.ClientDao;
import org.example.lessonsPack.domain.Authorities;
import org.example.lessonsPack.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImp implements UserDetailsService {

    private  ClientDao clientDao;
    private  AuthoritiesDao authoritiesDao;

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Autowired
    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

//    public ClientServiceImp(ClientDao clientDao, AuthoritiesDao authoritiesDao) {
//        this.clientDao = clientDao;
//        this.authoritiesDao = authoritiesDao;
//    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = this.clientDao.findFirstByName(s);
        if (client == null){
            throw new UsernameNotFoundException("invalid");
        }
        return new User(client.getName(), client.getPassword(), mapRolesToAuthorities(client.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Authorities> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
}
