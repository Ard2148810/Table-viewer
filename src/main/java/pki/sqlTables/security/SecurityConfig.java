package pki.sqlTables.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Only authenticated client can access API
        http
                .authorizeRequests().antMatchers("/**").authenticated()
                .and()
                .oauth2Login();

    }

}