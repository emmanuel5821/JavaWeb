package datos;

import dominio.Pago;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagoDAO {
    private static final String SQL_SELECT = "SELECT ID_Pago, Nombre_Tarjeta, Numero_Tarjeta, Fecha_Expiracion, CVV"
            + " FROM pago";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_Pago, Nombre_Tarjeta, Numero_Tarjeta, Fecha_Expiracion, CVV"
            + " FROM pago WHERE ID_Pago = ?";

    private static final String SQL_INSERT = "INSERT INTO pago(Nombre_Tarjeta, Numero_Tarjeta, Fecha_Expiracion, CVV) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE pago "
            + " SET Nombre_Tarjeta = ?, Numero_Tarjeta = ?, Fecha_Expiracion = ?, CVV = ?";

    private static final String SQL_DELETE = "DELETE FROM pago WHERE ID_Pago = ?";
    
    public List<Pago> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pago pago = null;
        List<Pago> pagos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPago = rs.getInt("ID_Pago");
                String nombre = rs.getString("Nombre_Tarjeta");
                String numero = rs.getString("Numero_Tarjeta");
                String fecha = rs.getString("Fecha_Expiracion");
                int cvv = rs.getInt("CVV");

                pago = new Pago(idPago, nombre, numero, fecha, cvv);
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pagos;
    }

    public Pago encontrar(Pago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, pago.getID_Pago());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("Nombre_Tarjeta");
            String numero = rs.getString("Numero_Tarjeta");
            String fecha = rs.getString("Fecha_Expiracion");
            int cvv = rs.getInt("CVV");
            
            pago.setNombre_Tarjeta(nombre);
            pago.setNumero_Tarjeta(numero);
            pago.setFecha_Expiracion(fecha);
            pago.setCVV(cvv);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pago;
    }

    public int insertar(Pago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pago.getNombre_Tarjeta());
            stmt.setString(2, pago.getNumero_Tarjeta());
            stmt.setString(3, pago.getFecha_Expiracion());
            stmt.setInt(4, pago.getCVV());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int actualizar(Pago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pago.getNombre_Tarjeta());
            stmt.setString(2, pago.getNumero_Tarjeta());
            stmt.setString(3, pago.getFecha_Expiracion());
            stmt.setInt(4, pago.getCVV());
            stmt.setInt(5, pago.getID_Pago());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }

    public int eliminar(Pago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pago.getID_Pago());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }
    
}
