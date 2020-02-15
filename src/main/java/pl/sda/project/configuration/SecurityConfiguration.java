package pl.sda.project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.sda.project.entity.Privilage;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/xyz").hasRole(Privilage.USER.name())
                .antMatchers("/abc").hasRole(Privilage.ADMIN.name())
                .and()
                .formLogin();
    }
}
