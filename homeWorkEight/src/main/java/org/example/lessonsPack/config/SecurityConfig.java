package org.example.lessonsPack.config;

import org.example.lessonsPack.domain.Role;
import org.example.lessonsPack.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ClientServiceImp clientService;

    @Autowired
    public void setClientServiceImp(ClientServiceImp clientServiceImp) {
        this.clientService = clientServiceImp;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(clientService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/products/list").hasAuthority("ROLE_USER")
                .antMatchers("/products/new").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .antMatchers("/products/form-edit-product").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .antMatchers("/products/finder-product-by-title").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .antMatchers("/user/users-list").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                    .formLogin()
//                    .loginPage("/login")
                    .loginProcessingUrl("/auth")
                    .permitAll()
                .and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                .and()
                    .csrf().disable();
    }
}
