package br.gov.sp.fatec.veterinario.service;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.gov.sp.fatec.veterinario.entity.Animal;
import br.gov.sp.fatec.veterinario.entity.Dono;
import br.gov.sp.fatec.veterinario.repository.AnimalRepository;
import br.gov.sp.fatec.veterinario.repository.DonoRepository;

@Service
public class Service01Impl implements Service01 {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    DonoRepository donoRepository;

    @Transactional
    public Animal novoAnimal(
        String nomeAnimal,  
        String especie, 
        String cor, 
        String nomeDono, 
        String waDono, 
        Long tel) {

        Dono dono = donoRepository.findByWa(waDono);
        if(dono == null) {
            dono = new Dono ();
            dono.setNome(nomeDono);
            dono.setWa(waDono);            
            dono.setTelefone(tel);
            donoRepository.save(dono);
        }
        Animal animal = new Animal();
        animal.setNome(nomeAnimal);
        animal.setEspecie(especie);
        animal.setCor(cor);
        animal.setDonos(new HashSet<Dono>());
        animal.getDonos().add(dono);
        animalRepository.save(animal);  

        return animal;

    }

    public List <Animal> buscarTodosAnimais() {
        return animalRepository.findAll();
    }  
    
}
