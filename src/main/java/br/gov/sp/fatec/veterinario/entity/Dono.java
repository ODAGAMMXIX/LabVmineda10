package br.gov.sp.fatec.veterinario.entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.veterinario.controller.View;

@Entity
@Table(name = "don_dono")

public class Dono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="don_id")
    @JsonView(View.AnimalCompl.class)
    private Long id;

    @Column(name="don_nome")
    private String nome;
    @JsonView(View.AnimalSimpl.class)

    @Column(name="don_telefone")
    private Long telefone;/*unique key*/

    @Column(name="don_whatsapp")
    private String wa;

    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "donos")
    private Set<Animal> animais;        

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

    public String getWa() {
        return wa;
    }

    public void setWa(String wa) {
        this.wa = wa;
    }

    public Set<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(Set<Animal> animais) {
        this.animais = animais;
    }    


    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

          
}
