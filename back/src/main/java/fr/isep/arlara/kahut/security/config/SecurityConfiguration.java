
package fr.isep.arlara.kahut.security.config;

import fr.isep.arlara.kahut.model.database.AppUserRole;
import fr.isep.arlara.kahut.service.data.AppUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Getter
public class SecurityConfiguration {

    private final BCryptPasswordEncoder passwordEncoder;
    private final AppUserService appUserService;


    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and()
                .authorizeHttpRequests(authorize -> authorize
                        .mvcMatchers("/api/resources/**", "/api/registration/**","/api/page/**","/").permitAll()
                        .mvcMatchers("/api/user/**").hasRole("USER")
                        .mvcMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().denyAll()
                );

        return http.build();
    }



    @Bean public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }




}
