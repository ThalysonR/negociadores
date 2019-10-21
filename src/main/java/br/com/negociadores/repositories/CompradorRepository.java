package br.com.negociadores.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.negociadores.models.Comprador;

@RepositoryRestResource(collectionResourceRel = "compradores", path = "compradores")
public interface CompradorRepository extends PagingAndSortingRepository<Comprador, Integer> {
    
}