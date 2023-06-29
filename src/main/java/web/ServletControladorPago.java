package web;

import datos.PagoDAO;
import dominio.Pago;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

@WebServlet("/ServletControladorPago")
public class ServletControladorPago extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPago(request, response);
                    break;
                case "eliminar":
                    this.eliminarPago(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarPago(request, response);
                    break;
                case "modificar":
                    this.modificarPago(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void editarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idPago
        int idPago = Integer.parseInt(request.getParameter("ID_Pago"));
        Pago pago = new PagoDAO().encontrar(new Pago(idPago));
        request.setAttribute("pago", pago);
        String jspEditar = "/WEB-INF/paginas/cliente/editarAdministrador.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarAdministrador
        int idPago = Integer.parseInt(request.getParameter("idPago"));
     

        //Creamos el objeto de administrador (modelo)
        Pago pago = new Pago(idPago);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new PagoDAO().eliminar(pago);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void insertarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarAdministrador
        String nombre = request.getParameter("nombreTarjeta");
        String numero = request.getParameter("numeroTarjeta");
        String fecha = request.getParameter("fechaExpiracion");
        int cvv = Integer.parseInt(request.getParameter("cvv"));
        
        //Creamos el objeto de cliente (modelo)
        Pago pago = new Pago(nombre, numero, fecha, cvv);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new PagoDAO().insertar(pago);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
     
      private void modificarPago(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        String nombre = request.getParameter("nombreTarjeta");
        String numero = request.getParameter("numeroTarjeta");
        String fecha = request.getParameter("fechaExpiracion");
        int cvv = Integer.parseInt(request.getParameter("cvv"));
        
        //Creamos el objeto de cliente (modelo)
        Pago pago = new Pago(idPago, nombre, numero, fecha, cvv);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new PagoDAO().actualizar(pago);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Pago> pagos = new PagoDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pago", pagos);
        response.sendRedirect("pagos.jsp");
    }
    
    
    
}
