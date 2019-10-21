package br.com.negociadores.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import br.com.negociadores.security.JwtTokenFilterConfigurer;
import br.com.negociadores.security.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public static final String[] AUTH_WHITELIST = {
        "/",
        "/h2-console/**/**",
        "/browser/**",
        "/profile/**",
        "/compradores/**"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
        .antMatchers(HttpMethod.GET ,AUTH_WHITELIST).authenticated()
        .antMatchers(HttpMethod.POST ,AUTH_WHITELIST).permitAll()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .anyRequest().authenticated();

        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }
}