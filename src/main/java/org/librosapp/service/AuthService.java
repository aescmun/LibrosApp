package org.librosapp.service;

import org.librosapp.dao.UsuarioDAO;
import org.librosapp.dao.impl.UsuarioDAOImpl;

public class AuthService {

    private UsuarioDAO usuarioDAO;

    public AuthService() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public boolean autenticar(String username, String password) {
        return usuarioDAO.login(username, password) != null;
    }
}