package org.librosapp.dao.impl;

import org.librosapp.model.Libro;

import java.util.List;

public interface LibroDAO {
    void insertar(Libro libro);
    void actualizar(Libro libro);
    void eliminar(int id);
    Libro buscarPorId(int id);
    List<Libro> obtenerTodos();
}
