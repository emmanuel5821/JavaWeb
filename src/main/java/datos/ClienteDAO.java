package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    private static final String SQL_SELECT = "SELECT ID_Cliente, Nombre_Cliente, ApellidoPaterno_Cliente, ApellidoMaterno_Cliente, Edad_Cliente, Usuario_Cliente, Contraseña_Cliente "
            + " FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_Cliente, Nombre_Cliente, ApellidoPaterno_Cliente, ApellidoMaterno_Cliente, Edad_Cliente, Usuario_Cliente, Contraseña_Cliente "
            + " FROM cliente WHERE ID_Administrador = ?";

    private static final String SQL_INSERT = "INSERT INTO cliente(Nombre_Cliente, ApellidoPaterno_Cliente, ApellidoMaterno_Cliente, Edad_Cliente, Usuario_Cliente, Contraseña_Cliente) "
            + " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente "
            + " SET ID_Cliente = ?, Nombre_Cliente = ?, ApellidoPaterno_Cliente = ?, ApellidoMaterno_Cliente = ?, Edad_Cliente = ?, Usuario_Cliente = ?, Contraseña_Cliente = ?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE ID_Cliente = ?";
    
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("ID_Cliente");
                String nombre = rs.getString("Nombre_Cliente");
                String apellidoPaterno = rs.getString("ApellidoPaterno_Cliente");
                String apellidoMaterno = rs.getString("ApellidoPaterno_Cliente");
                int edad = rs.getInt("Edad_Cliente");
                String usuario = rs.getString("Usuario_Cliente");
                String contraseña = rs.getString("Contraseña_Cliente");

                cliente = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, edad, usuario, contraseña);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getID_Cliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("Nombre_Cliente");
                String apellidoPaterno = rs.getString("ApellidoPaterno_Cliente");
                String apellidoMaterno = rs.getString("ApellidoPaterno_Cliente");
                int edad = rs.getInt("Edad_Cliente");
                String usuario = rs.getString("Usuario_Cliente");
                String contraseña = rs.getString("Contraseña_Cliente");

            cliente.setNombre_Cliente(nombre);
            cliente.setApellidoPaterno_Cliente(apellidoPaterno);
            cliente.setApellidoMaterno_Cliente(apellidoMaterno);
            cliente.setEdad_Cliente(edad);
            cliente.setUsuario_Cliente(usuario);
            cliente.setContraseña_Cliente(contraseña);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre_Cliente());
            stmt.setString(2, cliente.getApellidoPaterno_Cliente());
            stmt.setString(3, cliente.getApellidoMaterno_Cliente());
            stmt.setInt(4, cliente.getEdad_Cliente());
            stmt.setString(5, cliente.getUsuario_Cliente());
            stmt.setString(6, cliente.getContraseña_Cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre_Cliente());
            stmt.setString(2, cliente.getApellidoPaterno_Cliente());
            stmt.setString(3, cliente.getApellidoMaterno_Cliente());
            stmt.setInt(4, cliente.getEdad_Cliente());
            stmt.setString(5, cliente.getUsuario_Cliente());
            stmt.setString(6, cliente.getContraseña_Cliente());
            stmt.setInt(7, cliente.getID_Cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getID_Cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }
}
