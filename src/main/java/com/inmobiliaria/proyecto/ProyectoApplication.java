package com.inmobiliaria.proyecto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inmobiliaria.proyecto.entidades.*;
import com.inmobiliaria.proyecto.repositorios.*;
/**
 * 
 * @author Apache
 * Clase Aplicacion
 */
@SpringBootApplication
@EnableJpaRepositories("com.inmobiliaria.proyecto.repositorios")
@EntityScan("com.inmobiliaria.proyecto.entidades")
public class ProyectoApplication {

    private final PostRepositorio postRepositorio;
    private final ComentarioRepositorio comentarioRepositorio;

    public ProyectoApplication(PostRepositorio postRepositorio, ComentarioRepositorio comentarioRepositorio) {
        this.postRepositorio = postRepositorio;
        this.comentarioRepositorio = comentarioRepositorio;
    }
/**
 * Clase main
 * @param args
 */
    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }
/**
 * Command Line Runner con los metodos
 * 
 */
    @Bean
    public CommandLineRunner run() {
        return args -> {
        	
        	/**
        	 * Crear cinco entradas o posts
        	 */            
            for (int i = 1; i <= 5; i++) {
            	
                Post post = new Post();
                post.setTitulo("Título del Post " + i);
                post.setContenido("Contenido del Post " + i);
                post.setAutor("Autor del Post " + i);
                post.setEsImportante(i % 2 == 0);
                post.setCreatedAt(LocalDateTime.now());
                /**
                 * Guardar el post
                 */
                postRepositorio.save(post);

                /**
                 * Crear tres comentarios para cada post
                 */
                for (int j = 1; j <= 3; j++) {
                	
                    Comentario comentario = new Comentario();
                    comentario.setContenido("Comentario " + j + " del Post " + i);
                    comentario.setPost(post);
                    /**
                     * Guardar el comentario
                     */
                    comentarioRepositorio.save(comentario);
                }
            }
		
		         /**
		          *  Mostrar todos los posts
		          */
		            System.out.println("Todos los posts:");
		            List<Post> posts = postRepositorio.findAll();
		            for (Post post : posts) {
		                System.out.println(post);
		                List<Comentario> comentarios = comentarioRepositorio.findByPost(post);
		                System.out.println("Comentarios:");
		                for (Comentario comentario : comentarios) {
		                    System.out.println(comentario);
		                }
		                System.out.println();
		            }
        };
    }
}