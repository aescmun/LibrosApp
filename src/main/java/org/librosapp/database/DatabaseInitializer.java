package org.librosapp.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void init() {
        String sqlUsuarios = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL,
                password TEXT NOT NULL
            )
        """;

        String sqlLibros = """
            CREATE TABLE IF NOT EXISTS libros (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                fechaPublicacion TEXT,
                paginas INTEGER
            )
        """;

        String sqlInsertarAdmin = """
            INSERT OR IGNORE INTO usuarios (id, username, password)
            VALUES (1, 'admin', '1234')
        """;

        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlUsuarios);
            stmt.execute(sqlLibros);
            stmt.execute(sqlInsertarAdmin);

            System.out.println("Base de datos inicializada correctamente.");

        } catch (Exception e) {
            System.out.println("Error al inicializar la BD: " + e.getMessage());
        }
    }
}