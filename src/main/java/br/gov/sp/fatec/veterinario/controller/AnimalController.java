package br.gov.sp.fatec.veterinario.controller;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.sp.fatec.veterinario.entity.Animal;
import br.gov.sp.fatec.veterinario.service.Service01;

@RestController
@CrossOrigin
@RequestMapping(value = "/animal")
public class AnimalController {

    @Autowired
    private Service01 Service01;

    @GetMapping //(value ="/todos")
    @JsonView(View.AnimalSimpl.class)
    public List<Animal> buscarTodosAnimais(){
        return Service01.buscarTodosAnimais();
    }

    @PostMapping
    @JsonView(View.AnimalCompl.class)
    public Animal novoAnimal(@RequestBody Animal animal) {
        long tel = 999999999;
        return Service01.novoAnimal(animal.getNome(), 
                                           animal.getEspecie(), 
                                           animal.getCor(), 
                                           "DONO_NOME", "DONO_WA", tel);
    }
    
}
