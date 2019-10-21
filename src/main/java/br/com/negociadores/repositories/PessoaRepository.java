package br.com.negociadores.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.negociadores.models.Pessoa;

@RepositoryRestResource(exported = false)
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Integer> {
    public Optional<Pessoa> findByEmail(String email);
}