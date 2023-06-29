package datos;

import dominio.Renta;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentaDAO {
     private static final String SQL_SELECT = "SELECT ID_Renta, ID_Cliente, ID_Trabajador, Costo, Horas, Fecha, Direccion"
            + " FROM renta";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_Renta, ID_Cliente, ID_Trabajador, Costo, Horas, Fecha, Direccion"
            + " FROM renta WHERE ID_Renta = ?";

    private static final String SQL_INSERT = "INSERT INTO renta(ID_Cliente, ID_Trabajador, Costo, Horas, Fecha, Direccion)"
            + " VALUES(?, ?, ?, ?, ?, ?";

    private static final String SQL_UPDATE = "UPDATE renta "
            + " SET ID_Cliente = ?, ID_Trabajador = ?, Costo = ?, Horas = ?, Fecha = ?, Direccion = ?";

    private static final String SQL_DELETE = "DELETE FROM renta WHERE ID_Renta = ?";
    
    public List<Renta> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Renta renta = null;
        List<Renta> rentas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idRenta = rs.getInt("ID_Renta");
                int idCliente = rs.getInt("ID_Cliente");
                int idTrabajador = rs.getInt("ID_Trabajador");
                double costo = rs.getDouble("Costo");
                int horas = rs.getInt("Horas");
                String fecha = rs.getString("Fecha");
                String direccion = rs.getString("Direccion");

                renta = new Renta(idRenta, idCliente, idTrabajador, costo, horas, fecha, direccion);
                rentas.add(renta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rentas;
    }

    public Renta encontrar(Renta renta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, renta.getID_Renta());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto
            
            int idCliente = rs.getInt("ID_Cliente");
            int idTrabajador = rs.getInt("ID_Trabajador");
            double costo = rs.getDouble("Costo");
            int horas = rs.getInt("Horas");
            String fecha = rs.getString("Fecha");
            String direccion = rs.getString("Direccion");

            renta.setID_Cliente(idCliente);
            renta.setID_Trabajador(idTrabajador);
            renta.setCosto(costo);
            renta.setHoras(horas);
            renta.setFecha(fecha);
            renta.setDireccion(direccion);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return renta;
    }

    public int insertar(Renta renta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, renta.getID_Cliente());
            stmt.setInt(2, renta.getID_Trabajador());
            stmt.setDouble(3, renta.getCosto());
            stmt.setString(4, renta.getFecha());
            stmt.setString(5, renta.getDireccion());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int actualizar(Renta renta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, renta.getID_Cliente());
            stmt.setInt(2, renta.getID_Trabajador());
            stmt.setDouble(3, renta.getCosto());
            stmt.setString(4, renta.getFecha());
            stmt.setString(5, renta.getDireccion());
            stmt.setInt(6, renta.getID_Renta());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int eliminar(Renta renta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, renta.getID_Renta());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(RentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }
}
