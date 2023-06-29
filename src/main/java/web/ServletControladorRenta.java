package web;



import datos.RentaDAO;
import dominio.Renta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

@WebServlet("/ServletControladorRenta")
public class ServletControladorRenta extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarRenta(request, response);
                    break;
                case "eliminar":
                    this.eliminarRenta(request, response);
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
                    this.insertarRenta(request, response);
                    break;
                case "modificar":
                    this.modificarRenta(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void editarRenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idPago
        int idRenta = Integer.parseInt(request.getParameter("ID_Renta"));
        Renta renta = new RentaDAO().encontrar(new Renta(idRenta));
        request.setAttribute("pago", renta);
        String jspEditar = "/WEB-INF/paginas/cliente/editarAdministrador.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarRenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarAdministrador
        int idRenta = Integer.parseInt(request.getParameter("idRenta"));
     

        //Creamos el objeto de administrador (modelo)
        Renta renta = new Renta(idRenta);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new RentaDAO().eliminar(renta);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void insertarRenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarRenta
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
        double costo = Double.parseDouble(request.getParameter("costo"));
        int horas = Integer.parseInt(request.getParameter("horas"));
        String fecha = request.getParameter("fecha");
        String direccion = request.getParameter("direccion");
        //Creamos el objeto de renta (modelo)
        Renta renta = new Renta(idCliente, idTrabajador, costo, horas, fecha, direccion);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new RentaDAO().insertar(renta);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void modificarRenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idRenta = Integer.parseInt(request.getParameter("idRenta"));
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
        double costo = Double.parseDouble(request.getParameter("costo"));
        int horas = Integer.parseInt(request.getParameter("horas"));
        String fecha = request.getParameter("fecha");
        String direccion = request.getParameter("direccion");
        
         //Creamos el objeto de renta (modelo)
        Renta renta = new Renta(idRenta, idCliente, idTrabajador, costo, horas, fecha, direccion);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new RentaDAO().insertar(renta);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Renta> pagos = new RentaDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rentas", pagos);
        response.sendRedirect("rentas.jsp");
    }
    
    
    
}
