package br.gov.sp.fatec.veterinario.entity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.veterinario.controller.View;


@Entity
@Table(name = "ani_animal")

public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ani_id")
    @JsonView(View.AnimalCompl.class)
    private Long id;

    @Column(name="ani_nome")
    @JsonView(View.AnimalSimpl.class)
    private String nome;

    @Column(name="ani_especie")
    @JsonView(View.AnimalSimpl.class)
    private String especie;
    
    @Column(name="ani_cor")
    @JsonView(View.AnimalCompl.class)
    private String cor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ado_animal_dono",
        joinColumns = {@JoinColumn(name = "ani_id") },
        inverseJoinColumns = {@JoinColumn(name = "don_id") })
        @JsonView(View.AnimalSimpl.class)
    private Set<Dono> donos;   
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
    private Set<Consulta> consultas;    
    
      
    public Long getId() {
        return id;
    }

   public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCor() {
        return cor;
    }

   public void setCor(String cor) {
        this.cor = cor;
    }

    public Set<Dono> getDonos() {
        return donos;
    }

    public void setDonos(Set<Dono> donos) {
        this.donos = donos;
    }

        
}
