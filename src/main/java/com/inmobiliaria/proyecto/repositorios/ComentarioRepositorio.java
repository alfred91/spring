package com.inmobiliaria.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.proyecto.entidades.Comentario;
import com.inmobiliaria.proyecto.entidades.Post;

import java.util.List;
/**
 * 
 * @author Apache
 * Interfaz ComentarioRepositorio
 */
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPost(Post post);
}
