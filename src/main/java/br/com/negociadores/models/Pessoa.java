package br.com.negociadores.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;

@Data
@Entity
@RestResource
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
}