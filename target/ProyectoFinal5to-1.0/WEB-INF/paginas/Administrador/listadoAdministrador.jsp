<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido Paterno</th>
                                <th>Apellido Materno</th>
                                <th>Edad</th>
                                <th>Usuario</th>
                                <th>Contraseña</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes -->
                            <c:forEach var="administrador" items="${administradores}" varStatus="status" >
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${administrador.Nombre_Administrador}</td>
                                    <td>${administrador.ApellidoPaterno_Administrador}</td>
                                    <td>${administrador.apellidoMaterno}</td>
                                    <td><fmt:formatNumber value="${administrador.edad}"/></td>
                                    <td>${administrador.usuario}</td>
                                    <td>${administrador.password}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControladorAdministrador?accion=editar&idAdministrador=${administrador.idAdministrador}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

           
        </div>
    </div>
</section>

<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/Administrador/agregarAdministrador.jsp"/>
