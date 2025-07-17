package com.example.agendaLocacao.Models.Entitys;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "acesso")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Usuario unidadeId;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;
    @Column(name = "criado_em")
    private Timestamp criadoEm;
    @Column(name = "modificado_em")
    private Timestamp modificadoEm;
    @ManyToOne
    @JoinColumn(name = "criado_por")
    private Usuario criadoPor;
    @ManyToOne
    @JoinColumn(name = "modificado_por")
    private Usuario modificadoPor;

    public Acesso(Usuario unidadeId, Usuario usuarioId, Timestamp criadoEm, Timestamp modificadoEm, Usuario criadoPor, Usuario modificadoPor) {
        this.unidadeId = unidadeId;
        this.usuarioId = usuarioId;
        this.criadoEm = criadoEm;
        this.modificadoEm = modificadoEm;
        this.criadoPor = criadoPor;
        this.modificadoPor = modificadoPor;
    }

    @PrePersist
    protected void onCreate() {
        this.criadoEm = new Timestamp(System.currentTimeMillis());
    }
    @PreUpdate
    protected void onUpdate() {
        this.modificadoEm = new Timestamp(System.currentTimeMillis());
    }
}
