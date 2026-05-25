package org.librosapp.dao;

import org.librosapp.model.Usuario;

public interface UsuarioDAO {
    Usuario login(String username, String password);
}