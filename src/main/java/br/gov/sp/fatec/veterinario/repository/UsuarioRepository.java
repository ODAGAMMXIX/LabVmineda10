package br.gov.sp.fatec.veterinario.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.veterinario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Usuario findByNome (String Nome);

    public List <Usuario> findByNomeContainsOrWaContains (String Nome, String Wa);
    
}
