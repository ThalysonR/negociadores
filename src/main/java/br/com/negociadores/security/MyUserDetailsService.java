package br.com.negociadores.security;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.negociadores.models.Pessoa;
import br.com.negociadores.repositories.PessoaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        log.info("Chegou");
        Pessoa pessoa = pessoaRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return new User(pessoa.getEmail(), pessoa.getSenha(), new HashSet<>());
    }
}