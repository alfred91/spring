package com.inmobiliaria.proyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.proyecto.entidades.Post;

public interface PostRepositorio extends JpaRepository<Post, Long> {
    List<Post> findByAutor(String autor);
}
