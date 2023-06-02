package datos;

import domain.Planta;
import java.sql.*;
import java.util.*;

public class PlantaJDBC {

    private static final String SQL_SELECT = "SELECT id_planta, nombre_científico, nombre_común, región, precio, tamaño FROM plantas";
    private static final String SQL_INSERT = "INSERT INTO plantas(nombre_científico, nombre_común, región, precio, tamaño) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE plantas SET nombre_científico = ?, nombre_común = ?, región = ?, precio = ?, tamaño = ? WHERE id_planta = ? ";
    private static final String SQL_DELETE = "DELETE FROM plantas WHERE id_planta = ?";

    public List<Planta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Planta planta = null;
        List<Planta> plantas = new ArrayList<Planta>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_planta = rs.getInt("id_planta");
                String nombre_científico = rs.getString("nombre_científico");
                String nombre_común = rs.getString("nombre_común");
                String región = rs.getString("región");
                int precio = rs.getInt("precio");
                String tamaño = rs.getString("tamaño");

                planta = new Planta();

                planta.setId_planta(id_planta);
                planta.setNombre_científico(nombre_científico);
                planta.setNombre_común(nombre_común);
                planta.setRegión(región);
                planta.setPrecio(precio);
                planta.setTamaño(tamaño);

                plantas.add(planta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return plantas;
    }

    public int insert(Planta planta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, planta.getNombre_científico());
            stmt.setString(2, planta.getNombre_común());
            stmt.setString(3, planta.getRegión());
            stmt.setInt(4, planta.getPrecio());
            stmt.setString(5, planta.getTamaño());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            filas = stmt.executeUpdate();
            System.out.println("Registros afectados: " + filas);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return filas;
    }

    public int update(Planta planta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejcutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, planta.getNombre_científico());
            stmt.setString(2, planta.getNombre_común());
            stmt.setString(3, planta.getRegión());
            stmt.setInt(4, planta.getPrecio());
            stmt.setString(5, planta.getTamaño());
            stmt.setInt(6, planta.getId_planta());

            filas = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + filas);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return filas;
    }

    public int delete(Planta planta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, planta.getId_planta());
            filas = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + filas);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return filas;

    }

}
