package org.librosapp.service;
import org.librosapp.dao.LibroDAO;
import org.librosapp.dao.impl.LibroDAOImpl;
import org.librosapp.model.Libro;
import java.util.List;

public class LibroService {
    private LibroDAO libroDAO;

    public LibroService() {
        this.libroDAO = new LibroDAOImpl();
    }

    public void agregarLibro(Libro libro) {
        libroDAO.insertar(libro);
    }

    public void modificarLibro(Libro libro) {
        libroDAO.actualizar(libro);
    }

    public void eliminarLibro(int id) {
        libroDAO.eliminar(id);
    }

    public Libro buscarPorId(int id) {
        return libroDAO.buscarPorId(id);
    }

    public List<Libro> obtenerTodos() {
        return libroDAO.obtenerTodos();
    }
}