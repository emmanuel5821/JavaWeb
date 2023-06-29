package web;

import datos.AdministradorDAO;
import dominio.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

@WebServlet("/ServletControladorAdministrador")
public class ServletControladorAdministrador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarAdministrador(request, response);
                    break;
                case "eliminar":
                    this.eliminarAdministrador(request, response);
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
                    this.insertarAdministrador(request, response);
                    break;
                case "modificar":
                    this.modificarAdministrador(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void editarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idAdministrador
        int idAdministrador = Integer.parseInt(request.getParameter("ID_Administrador"));
        Administrador administrador = new AdministradorDAO().encontrar(new Administrador(idAdministrador));
        request.setAttribute("administrador", administrador);
        String jspEditar = "/WEB-INF/paginas/Administrador/editarAdministrador.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarAdministrador
        int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
     

        //Creamos el objeto de administrador (modelo)
        Administrador administrador = new Administrador(idAdministrador);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new AdministradorDAO().eliminar(administrador);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void insertarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarAdministrador
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoP");
        String apellidoMaterno = request.getParameter("apellidoM");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //Creamos el objeto de cliente (modelo)
        Administrador administrador = new Administrador(nombre, apellidoPaterno, apellidoMaterno, edad, usuario, password);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new AdministradorDAO().insertar(administrador);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
     
      private void modificarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoP");
        String apellidoMaterno = request.getParameter("apellidoM");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //Creamos el objeto de cliente (modelo)
        Administrador administrador = new Administrador(idAdministrador,nombre, apellidoPaterno, apellidoMaterno, edad, usuario, password);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new AdministradorDAO().actualizar(administrador);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
      
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Administrador> administradores = new AdministradorDAO().listar();
        System.out.println("administradores = " + administradores);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("administradores", administradores);
        sesion.setAttribute("totalAdministradores", administradores.size());
        //request.getRequestDispatcher("administradores.jsp").forward(request, response);
        response.sendRedirect("administradores.jsp");
    }
    
    
}
