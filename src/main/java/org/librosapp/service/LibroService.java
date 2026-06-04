package org.librosapp.service;
import org.librosapp.dao.impl.LibroDAOImpl;
import org.librosapp.model.Libro;
import java.util.List;

public class LibroService {
    private LibroDAOImpl libroDAOImpl;

    public LibroService() {
        this.libroDAOImpl = new LibroDAOImpl();
    }

    public void agregarLibro(Libro libro) {
        libroDAOImpl.insertar(libro);
    }

    public void modificarLibro(Libro libro) {
        libroDAOImpl.actualizar(libro);
    }

    public void eliminarLibro(int id) {
        libroDAOImpl.eliminar(id);
    }

    public Libro buscarPorId(int id) {
        return libroDAOImpl.buscarPorId(id);
    }

    public List<Libro> obtenerTodos() {
        return libroDAOImpl.obtenerTodos();
    }
}