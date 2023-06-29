package dominio;

public class Cliente {
    private int ID_Cliente;
    private String Nombre_Cliente;
    private String ApellidoPaterno_Cliente;
    private String ApellidoMaterno_Cliente;
    private int Edad_Cliente;
    private String Usuario_Cliente;
    private String Contraseña_Cliente;

    public Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public Cliente(String Nombre_Cliente, String ApellidoPaterno_Cliente, String ApellidoMaterno_Cliente, int Edad_Cliente, String Usuario_Cliente, String Contraseña_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
        this.ApellidoPaterno_Cliente = ApellidoPaterno_Cliente;
        this.ApellidoMaterno_Cliente = ApellidoMaterno_Cliente;
        this.Edad_Cliente = Edad_Cliente;
        this.Usuario_Cliente = Usuario_Cliente;
        this.Contraseña_Cliente = Contraseña_Cliente;
    }

    public Cliente(int ID_Cliente, String Nombre_Cliente, String ApellidoPaterno_Cliente, String ApellidoMaterno_Cliente, int Edad_Cliente, String Usuario_Cliente, String Contraseña_Cliente) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre_Cliente = Nombre_Cliente;
        this.ApellidoPaterno_Cliente = ApellidoPaterno_Cliente;
        this.ApellidoMaterno_Cliente = ApellidoMaterno_Cliente;
        this.Edad_Cliente = Edad_Cliente;
        this.Usuario_Cliente = Usuario_Cliente;
        this.Contraseña_Cliente = Contraseña_Cliente;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getApellidoPaterno_Cliente() {
        return ApellidoPaterno_Cliente;
    }

    public void setApellidoPaterno_Cliente(String ApellidoPaterno_Cliente) {
        this.ApellidoPaterno_Cliente = ApellidoPaterno_Cliente;
    }

    public String getApellidoMaterno_Cliente() {
        return ApellidoMaterno_Cliente;
    }

    public void setApellidoMaterno_Cliente(String ApellidoMaterno_Cliente) {
        this.ApellidoMaterno_Cliente = ApellidoMaterno_Cliente;
    }

    public int getEdad_Cliente() {
        return Edad_Cliente;
    }

    public void setEdad_Cliente(int Edad_Cliente) {
        this.Edad_Cliente = Edad_Cliente;
    }

    public String getUsuario_Cliente() {
        return Usuario_Cliente;
    }

    public void setUsuario_Cliente(String Usuario_Cliente) {
        this.Usuario_Cliente = Usuario_Cliente;
    }

    public String getContraseña_Cliente() {
        return Contraseña_Cliente;
    }

    public void setContraseña_Cliente(String Contraseña_Cliente) {
        this.Contraseña_Cliente = Contraseña_Cliente;
    }
    
    
}
