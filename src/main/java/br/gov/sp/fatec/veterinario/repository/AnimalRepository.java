package br.gov.sp.fatec.veterinario.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.veterinario.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    public List <Animal> findByNome (String Nome);

    public List <Animal> findByNomeContainsOrEspecieContains (String nome, String especie);

    public List <Animal> findByDonosNome(String nome);

    public List <Animal> findByConsultasProcedimento(String procedimento);
    
}
