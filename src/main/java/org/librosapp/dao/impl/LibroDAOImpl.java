package org.librosapp.dao.impl;

import org.librosapp.database.ConexionSQLite;
import org.librosapp.model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public void insertar(Libro libro) {

        String sql = """
                INSERT INTO libros(titulo, fecha_publicacion, paginas)
                VALUES(?, ?, ?)
                """;

        try (
                Connection conn = ConexionSQLite.conectar();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2,
                    libro.getFechaPublicacion().toString());
            stmt.setInt(3, libro.getPaginas());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Libro libro) {

        String sql = """
                UPDATE libros
                SET titulo = ?,
                    fecha_publicacion = ?,
                    paginas = ?
                WHERE id = ?
                """;

        try (
                Connection conn = ConexionSQLite.conectar();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2,
                    libro.getFechaPublicacion().toString());
            stmt.setInt(3, libro.getPaginas());
            stmt.setInt(4, libro.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = """
                DELETE FROM libros
                WHERE id = ?
                """;

        try (
                Connection conn = ConexionSQLite.conectar();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Libro buscarPorId(int id) {

        String sql = """
                SELECT * FROM libros
                WHERE id = ?
                """;

        try (
                Connection conn = ConexionSQLite.conectar();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        LocalDate.parse(
                                rs.getString("fecha_publicacion")
                        ),
                        rs.getInt("paginas")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Libro> obtenerTodos() {

        List<Libro> lista = new ArrayList<>();

        String sql = """
                SELECT * FROM libros
                """;

        try (
                Connection conn = ConexionSQLite.conectar();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        LocalDate.parse(
                                rs.getString("fecha_publicacion")
                        ),
                        rs.getInt("paginas")
                );

                lista.add(libro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}

