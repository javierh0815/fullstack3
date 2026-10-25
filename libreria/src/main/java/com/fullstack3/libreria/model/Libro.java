package com.fullstack3.libreria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "titulo", length = 100)
    private String titulo;

    @Column (name = "autor", length = 100)
    private String autor;

    @Column (name = "anio_pub")
    private Integer anioPub;

    @Column (name = "genero", length = 100)
    private String genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnioPub() {
        return anioPub;
    }

    public void setAnioPub(Integer anioPub) {
        this.anioPub = anioPub;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Libro(Long id, String titulo, String autor, Integer anioPub, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPub = anioPub;
        this.genero = genero;
    }



    public Libro() {
        
    }


}
