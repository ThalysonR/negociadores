package br.com.negociadores.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.negociadores.models.Comprador;
import br.com.negociadores.models.Fornecedor;
import br.com.negociadores.models.Pessoa;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RepositoryEventHandler(Fornecedor.class)
public class PessoaEventHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void criptografaSenha(Pessoa pessoa) {
        log.info(pessoa.toString());
        pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
    }

    @HandleBeforeCreate
    public void handleCompradorCreate(Comprador comprador) {
        criptografaSenha(comprador.getPessoa());
    }
}