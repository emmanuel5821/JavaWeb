package datos;

import dominio.Trabajador;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabajadorDAO {
    private static final String SQL_SELECT = "SELECT ID_Trabajador, Nombre_Trabajador, ApellidoPaterno_Trabajador, ApellidoMaterno_Trabajador, Edad_Trabajador, Telefono_Trabajador, Descripcion_Trabajador"
            + " FROM trabajador";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_Trabajador, Nombre_Trabajador, ApellidoPaterno_Trabajador, ApellidoMaterno_Trabajador, Edad_Trabajador, Telefono_Trabajador, Descripcion_Trabajador"
            + " FROM Trabajador WHERE ID_Trabajador = ?";

    private static final String SQL_INSERT = "INSERT INTO trabajador(Nombre_Trabajador, ApellidoPaterno_Trabajador, ApellidoMaterno_Trabajador, Edad_Trabajador, Telefono_Trabajador, Descripcion_Trabajador) "
            + " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE trabajador "
            + " SET ID_Trabajador = ?, Nombre_Trabajador = ?, ApellidoPaterno_Trabajador = ?, ApellidoMaterno_Trabajador = ?, Edad_Trabajador = ?, Telefono_Trabajador = ?, Descripcion_Trabajador = ?";

    private static final String SQL_DELETE = "DELETE FROM trabajador WHERE ID_Trabajador = ?";
    
    public List<Trabajador> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Trabajador trabajador = null;
        List<Trabajador> trabajadores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTrabajador = rs.getInt("ID_Trabajador");
                String nombre = rs.getString("Nombre_Trabajador");
                String apellidoPaterno = rs.getString("ApellidoPaterno_Trabajador");
                String apellidoMaterno = rs.getString("ApellidoPaterno_Trabajador");
                int edad = rs.getInt("Edad_Trabajador");
                String telefono = rs.getString("Telefono_Trabajador");
                String descripcion = rs.getString("Descripcion_Trabajador");

                trabajador = new Trabajador(idTrabajador, nombre, apellidoPaterno, apellidoMaterno, edad, telefono, descripcion);
                trabajadores.add(trabajador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trabajadores;
    }

    public Trabajador encontrar(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, trabajador.getID_Trabajador());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("Nombre_Trabajador");
            String apellidoPaterno = rs.getString("ApellidoPaterno_Trabajador");
            String apellidoMaterno = rs.getString("ApellidoPaterno_Trabajador");
            int edad = rs.getInt("Edad_Trabajador");
            String telefono = rs.getString("Telefono_Trabajador");
            String descripcion = rs.getString("Descripcion_Trabajador");

            trabajador.setNombre_Trabajador(nombre);
            trabajador.setApellidoPaterno_Trabajador(apellidoPaterno);
            trabajador.setApellidoMaterno_Trabajador(apellidoMaterno);
            trabajador.setEdad_Trabajador(edad);
            trabajador.setTelefono_Trabajador(telefono);
            trabajador.setDescripcion_Trabajador(descripcion);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trabajador;
    }

    public int insertar(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, trabajador.getNombre_Trabajador());
            stmt.setString(2, trabajador.getApellidoPaterno_Trabajador());
            stmt.setString(3, trabajador.getApellidoMaterno_Trabajador());
            stmt.setInt(4, trabajador.getEdad_Trabajador());
            stmt.setString(5, trabajador.getTelefono_Trabajador());
            stmt.setString(6, trabajador.getDescripcion_Trabajador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int actualizar(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, trabajador.getNombre_Trabajador());
            stmt.setString(2, trabajador.getApellidoPaterno_Trabajador());
            stmt.setString(3, trabajador.getApellidoMaterno_Trabajador());
            stmt.setInt(4, trabajador.getEdad_Trabajador());
            stmt.setString(5, trabajador.getTelefono_Trabajador());
            stmt.setString(6, trabajador.getDescripcion_Trabajador());
            stmt.setInt(7, trabajador.getID_Trabajador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int eliminar(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, trabajador.getID_Trabajador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }
}
