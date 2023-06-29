package datos;

import dominio.Administrador;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDAO {
    private static final String SQL_SELECT = "SELECT ID_Administrador, Nombre_Administrador, ApellidoPaterno_Administrador, ApellidoMaterno_Administrador, Edad_Administrador, Usuario_Administrador, Contraseña_Administrador "
            + " FROM administrador";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_Administrador, Nombre_Administrador, ApellidoPaterno_Administrador, ApellidoMaterno_Administrador, Edad_Administrador, Usuario_Administrador, Contraseña_Administrador "
            + " FROM cliente WHERE ID_Administrador = ?";

    private static final String SQL_INSERT = "INSERT INTO administrador(Nombre_Administrador, ApellidoPaterno_Administrador, ApellidoMaterno_Administrador, Edad_Administrador, Usuario_Administrador, Contraseña_Administrador) "
            + " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE administrador "
            + " SET ID_Administrador = ?, Nombre_Administrador = ?, ApellidoPaterno_Administrador = ?, ApellidoMaterno_Administrador = ?, Edad_Administrador = ?, Usuario_Administrador = ?, Contraseña_Administrador = ?";

    private static final String SQL_DELETE = "DELETE FROM administrador WHERE ID_Adminitrador = ?";
    
    
    public List<Administrador> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Administrador administrador = null;
        List<Administrador> administradores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAdministrador = rs.getInt("ID_Administrador");
                String nombre = rs.getString("Nombre_Administrador");
                String apellidoPaterno = rs.getString("ApellidoPaterno_Administrador");
                String apellidoMaterno = rs.getString("ApellidoMaterno_Administrador");
                int edad = rs.getInt("Edad_Administrador");
                String usuario = rs.getString("Usuario_Administrador");
                String password = rs.getString("Contraseña_Administrador");

                administrador = new Administrador(idAdministrador, nombre, apellidoPaterno, apellidoMaterno, edad, usuario, password);
                administradores.add(administrador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return administradores;
    }

    public Administrador encontrar(Administrador administrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, administrador.getID_Administrador());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("Nombre_Administrador");
            String apellidoPaterno = rs.getString("ApellidoPaterno_Administrador");
            String apellidoMaterno = rs.getString("ApellidoMaterno_Administrador");
            int edad = rs.getInt("Edad_Administrador");
            String usuario = rs.getString("Usuario_Administrador");
            String password = rs.getString("Contraseña_Administrador");

            administrador.setNombre_Administrador(nombre);
            administrador.setApellidoPaterno_Administrador(apellidoPaterno);
            administrador.setApellidoMaterno_Administrador(apellidoMaterno);
            administrador.setEdad_Administrador(edad);
            administrador.setUsuario_Administrador(usuario);
            administrador.setContraseña_Administrador(password);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return administrador;
    }

    public int insertar(Administrador administrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, administrador.getNombre_Administrador());
            stmt.setString(2, administrador.getApellidoPaterno_Administrador());
            stmt.setString(3, administrador.getApellidoMaterno_Administrador());
            stmt.setInt(4, administrador.getEdad_Administrador());
            stmt.setString(5, administrador.getUsuario_Administrador());
            stmt.setString(6, administrador.getContraseña_Administrador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int actualizar(Administrador administrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, administrador.getNombre_Administrador());
            stmt.setString(2, administrador.getApellidoPaterno_Administrador());
            stmt.setString(3, administrador.getApellidoMaterno_Administrador());
            stmt.setInt(4, administrador.getEdad_Administrador());
            stmt.setString(5, administrador.getUsuario_Administrador());
            stmt.setString(6, administrador.getContraseña_Administrador());
            stmt.setInt(7, administrador.getID_Administrador());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int eliminar(Administrador administrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, administrador.getID_Administrador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }
}
