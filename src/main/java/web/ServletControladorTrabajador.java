package web;

import datos.TrabajadorDAO;
import dominio.Trabajador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

@WebServlet("/ServletControladorTrabajador")
public class ServletControladorTrabajador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarTrabajador(request, response);
                    break;
                case "eliminar":
                    this.eliminarTrabajador(request, response);
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
                    this.insertarTrabajador(request, response);
                    break;
                case "modificar":
                    this.modificarTrabajador(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void editarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idAdministrador
        int idTrabajador = Integer.parseInt(request.getParameter("ID_Administrador"));
        Trabajador trabajador = new TrabajadorDAO().encontrar(new Trabajador(idTrabajador));
        request.setAttribute("trabajador", trabajador);
        String jspEditar = "/WEB-INF/paginas/cliente/editarAdministrador.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarAdministrador
        int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
     

        //Creamos el objeto de administrador (modelo)
        Trabajador trabajador = new Trabajador(idTrabajador);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new TrabajadorDAO().eliminar(trabajador);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void insertarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarAdministrador
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoP");
        String apellidoMaterno = request.getParameter("apellidoM");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String telefono = request.getParameter("telefono");
        String descripcion = request.getParameter("descripcion");
        
        //Creamos el objeto de trabajador (modelo)
        Trabajador trabajador = new Trabajador(nombre, apellidoPaterno, apellidoMaterno, edad, telefono, descripcion);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new TrabajadorDAO().insertar(trabajador);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void modificarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoP");
        String apellidoMaterno = request.getParameter("apellidoM");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String telefono = request.getParameter("telefono");
        String descripcion = request.getParameter("descripcion");
        
        //Creamos el objeto de trabajador (modelo)
        Trabajador trabajador = new Trabajador(idTrabajador, nombre, apellidoPaterno, apellidoMaterno, edad, telefono, descripcion);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new TrabajadorDAO().actualizar(trabajador);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Trabajador> trabajadores = new TrabajadorDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("trabajadores", trabajadores);
        response.sendRedirect("administradores.jsp");
    }
    
    
}
