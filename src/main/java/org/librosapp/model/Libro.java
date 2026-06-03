package org.librosapp.model;

import java.time.LocalDate;

public class Libro {
    private int id;
    private String titulo;
    private LocalDate fechaPublicacion;
    private int paginas;

    public Libro(String titulo, LocalDate fechaPublicacion, int paginas) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.paginas = paginas;
    }

    public Libro(int id, String titulo, LocalDate fechaPublicacion, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
