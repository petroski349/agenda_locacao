package com.example.agendaLocacao.Models.Entitys;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Gera automaticamente getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera o construtor sem argumentos (necessário para JPA)
// Gera o construtor com todos os argumentos
@Table(name = "unidade")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "telefone")
    private String telefone;

    public Unidade(String nome, String telefone, String cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
    }
}
