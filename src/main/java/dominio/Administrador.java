package dominio;

public class Administrador {
    private int ID_Administrador;
    private String Nombre_Administrador;
    private String ApellidoPaterno_Administrador;
    private String ApellidoMaterno_Administrador;
    private int Edad_Administrador;
    private String Usuario_Administrador;
    private String Contraseña_Administrador;

    public Administrador(int ID_Administrador) {
        this.ID_Administrador = ID_Administrador;
    }

    public Administrador(String Nombre_Administrador, String ApellidoPaterno_Administrador, String ApellidoMaterno_Administrador, int Edad_Administrador, String Usuario_Administrador, String Contraseña_Administrador) {
        this.Nombre_Administrador = Nombre_Administrador;
        this.ApellidoPaterno_Administrador = ApellidoPaterno_Administrador;
        this.ApellidoMaterno_Administrador = ApellidoMaterno_Administrador;
        this.Edad_Administrador = Edad_Administrador;
        this.Usuario_Administrador = Usuario_Administrador;
        this.Contraseña_Administrador = Contraseña_Administrador;
    }

    public Administrador(int ID_Administrador, String Nombre_Administrador, String ApellidoPaterno_Administrador, String ApellidoMaterno_Administrador, int Edad_Administrador, String Usuario_Administrador, String Contraseña_Administrador) {
        this.ID_Administrador = ID_Administrador;
        this.Nombre_Administrador = Nombre_Administrador;
        this.ApellidoPaterno_Administrador = ApellidoPaterno_Administrador;
        this.ApellidoMaterno_Administrador = ApellidoMaterno_Administrador;
        this.Edad_Administrador = Edad_Administrador;
        this.Usuario_Administrador = Usuario_Administrador;
        this.Contraseña_Administrador = Contraseña_Administrador;
    }

    public Administrador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getID_Administrador() {
        return ID_Administrador;
    }

    public void setID_Administrador(int ID_Administrador) {
        this.ID_Administrador = ID_Administrador;
    }

    public String getNombre_Administrador() {
        return Nombre_Administrador;
    }

    public void setNombre_Administrador(String Nombre_Administrador) {
        this.Nombre_Administrador = Nombre_Administrador;
    }

    public String getApellidoPaterno_Administrador() {
        return ApellidoPaterno_Administrador;
    }

    public void setApellidoPaterno_Administrador(String ApellidoPaterno_Administrador) {
        this.ApellidoPaterno_Administrador = ApellidoPaterno_Administrador;
    }

    public String getApellidoMaterno_Administrador() {
        return ApellidoMaterno_Administrador;
    }

    public void setApellidoMaterno_Administrador(String ApellidoMaterno_Administrador) {
        this.ApellidoMaterno_Administrador = ApellidoMaterno_Administrador;
    }

    public int getEdad_Administrador() {
        return Edad_Administrador;
    }

    public void setEdad_Administrador(int Edad_Administrador) {
        this.Edad_Administrador = Edad_Administrador;
    }

    public String getUsuario_Administrador() {
        return Usuario_Administrador;
    }

    public void setUsuario_Administrador(String Usuario_Administrador) {
        this.Usuario_Administrador = Usuario_Administrador;
    }

    public String getContraseña_Administrador() {
        return Contraseña_Administrador;
    }

    public void setContraseña_Administrador(String Contraseña_Administrador) {
        this.Contraseña_Administrador = Contraseña_Administrador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Administrador{");
        sb.append("ID_Administrador=").append(ID_Administrador);
        sb.append(",Nombre_Administrador=").append(Nombre_Administrador);
        sb.append(", ApellidoPaterno_Administrador=").append(ApellidoPaterno_Administrador);
        sb.append(", ApellidoMaterno_Administrador=").append(ApellidoMaterno_Administrador);
        sb.append(", Edad_Administrador=").append(Edad_Administrador);
        sb.append(", Usuario_Administrador=").append(Usuario_Administrador);
        sb.append(", Contraseña_Administrador=").append(Contraseña_Administrador);
        sb.append('}');
        return sb.toString();
        
    }
    
    
}
