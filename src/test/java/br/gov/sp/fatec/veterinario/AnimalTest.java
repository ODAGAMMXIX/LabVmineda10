/*package br.gov.sp.fatec.veterinario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.veterinario.entity.Animal;
import br.gov.sp.fatec.veterinario.entity.Consulta;
import br.gov.sp.fatec.veterinario.entity.Dono;
import br.gov.sp.fatec.veterinario.repository.AnimalRepository;
import br.gov.sp.fatec.veterinario.repository.ConsultaRepository;
import br.gov.sp.fatec.veterinario.repository.DonoRepository;
import br.gov.sp.fatec.veterinario.service.Service01;

@SpringBootTest
@Transactional
@Rollback
public class AnimalTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private DonoRepository donoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private Service01 Service;

    @Test
    void novoAnimalTest(){
        long tel = 999999999;
        Service.novoAnimal("Bidu",
                            "cachorro", 
                            "Azul", 
                            "Monica",
                            "1399999999", 
                            tel);
        assertNotNull(animalRepository.findByNome("Bidu"));
    }

    @Test
    void findBynomeTest(){
        Animal animal = new Animal();
        animal.setNome("Bidu");
        animal.setEspecie("Cachorro");
        animal.setCor("Azul");
        animalRepository.save(animal);
        List <Animal> animal2 = animalRepository.findByNome("Bidu");
        assertNotNull(animal2);
        
    }

    @Test
    void findByNomeContainsOrEspecieContains(){
        Animal animal = new Animal();
        animal.setNome("teste");
        animal.setEspecie("teste");
        animal.setCor("Caramelo");
        animalRepository.save(animal);        
        assertFalse(animalRepository.findByNomeContainsOrEspecieContains("teste","teste").isEmpty());        
    }

    @Test
    void findByDonosNome(){
        Dono dono = new Dono ();
        dono.setNome("teste");
        dono.setWa("1399999999");
        long tel = 999999999;
        dono.setTelefone(tel);
        donoRepository.save(dono);

        Animal animal = new Animal();
        animal.setNome("teste");
        animal.setEspecie("teste");
        animal.setCor("Verde");
        animal.setDonos(new HashSet<Dono>());
        animal.getDonos().add(dono);
        animalRepository.save(animal);        
        assertFalse(animalRepository.findByDonosNome("teste").isEmpty());       
    }   

    @Test
    void findByConsultasProcedimento(){
        Animal animal = new Animal();
        animal.setNome("tampico");
        animal.setEspecie("srd");
        animal.setCor("Vermelho");
        animalRepository.save(animal);

        Consulta consulta = new Consulta();
        consulta.setData(new Date(1220227200L * 1000));
        consulta.setProcedimento("castração");
        consulta.setPaciente(animal);
        consultaRepository.save(consulta);
        
        assertFalse(animalRepository.findByConsultasProcedimento("castração").isEmpty());        
    }
    

}
*/