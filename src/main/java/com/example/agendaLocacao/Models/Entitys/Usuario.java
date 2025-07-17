package com.example.agendaLocacao.Models.Entitys;

import com.example.agendaLocacao.Models.Enum.Nivel;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data // Gera automaticamente getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera o construtor sem argumentos (necessário para JPA)
 // Gera o construtor com todos os argumentos
@Table(name = "unidade")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    @Column(name = "criado_em")
    private Timestamp criado_em;
    @Column(name = "modificado_em")
    private Timestamp modificado_em;

    public Usuario(String nome, String login, String senha, Nivel nivel) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }

    @PrePersist
    protected void onCreate() {
        this.criado_em = new Timestamp(System.currentTimeMillis());
    }
    @PreUpdate void onUpdate() {
        this.modificado_em = new Timestamp(System.currentTimeMillis());
    }
}

