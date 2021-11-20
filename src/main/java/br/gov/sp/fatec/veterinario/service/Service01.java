package br.gov.sp.fatec.veterinario.service;
import java.util.List;
import br.gov.sp.fatec.veterinario.entity.Animal;


public interface Service01 {

    public Animal novoAnimal(
        String nomeAnimal,  
        String especie, 
        String cor, 
        String nomeDono, 
        String waDono, 
        Long tel);
    public List <Animal> buscarTodosAnimais();
    
}
