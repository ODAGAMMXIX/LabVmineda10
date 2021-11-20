package br.gov.sp.fatec.veterinario.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.veterinario.entity.Usuario;

//IT SERVICES FRONTEND/API ETC.

public interface SegurancaService extends UserDetailsService{

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}
