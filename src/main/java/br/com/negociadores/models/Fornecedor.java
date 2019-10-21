package br.com.negociadores.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private Empresa empresa;
}