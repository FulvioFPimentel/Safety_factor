package diospringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigDio {

	
    @Bean
    public InMemoryUserDetailsManager userDetailsServiceDio() throws Exception {
        
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}user123")
                .roles("USERS")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("USERS", "MANAGERS")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    
}
