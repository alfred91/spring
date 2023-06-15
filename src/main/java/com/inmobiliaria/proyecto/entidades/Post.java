package com.inmobiliaria.proyecto.entidades;


import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private String autor;
    private boolean esImportante;
    private LocalDateTime createdAt;
    /**
     * Constructor vacio
     */
	public Post() {
		
	}
	/**
	 * Constructor parametrizado
	 * @param titulo
	 * @param contenido
	 * @param autor
	 * @param esImportante
	 * @param createdAt
	 */
	public Post(String titulo, String contenido, String autor, boolean esImportante, LocalDateTime createdAt) {

		this.titulo = titulo;
		this.contenido = contenido;
		this.autor = autor;
		this.esImportante = esImportante;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isEsImportante() {
		return esImportante;
	}

	public void setEsImportante(boolean esImportante) {
		this.esImportante = esImportante;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", autor=" + autor
				+ ", esImportante=" + esImportante + ", createdAt=" + createdAt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
}
