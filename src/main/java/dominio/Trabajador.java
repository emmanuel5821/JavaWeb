package dominio;

public class Trabajador {
    private int ID_Trabajador;
    private String Nombre_Trabajador;
    private String ApellidoPaterno_Trabajador;
    private String ApellidoMaterno_Trabajador;
    private int Edad_Trabajador;
    private String Telefono_Trabajador;
    private String Descripcion_Trabajador;

    public Trabajador(int ID_Trabajador) {
        this.ID_Trabajador = ID_Trabajador;
    }

    public Trabajador(String Nombre_Trabajador, String ApellidoPaterno_Trabajador, String ApellidoMaterno_Trabajador, int Edad_Trabajador, String Telefono_Trabajador, String Descripcion_Trabajador) {
        this.Nombre_Trabajador = Nombre_Trabajador;
        this.ApellidoPaterno_Trabajador = ApellidoPaterno_Trabajador;
        this.ApellidoMaterno_Trabajador = ApellidoMaterno_Trabajador;
        this.Edad_Trabajador = Edad_Trabajador;
        this.Telefono_Trabajador = Telefono_Trabajador;
        this.Descripcion_Trabajador = Descripcion_Trabajador;
    }

    public Trabajador(int ID_Trabajador, String Nombre_Trabajador, String ApellidoPaterno_Trabajador, String ApellidoMaterno_Trabajador, int Edad_Trabajador, String Telefono_Trabajador, String Descripcion_Trabajador) {
        this.ID_Trabajador = ID_Trabajador;
        this.Nombre_Trabajador = Nombre_Trabajador;
        this.ApellidoPaterno_Trabajador = ApellidoPaterno_Trabajador;
        this.ApellidoMaterno_Trabajador = ApellidoMaterno_Trabajador;
        this.Edad_Trabajador = Edad_Trabajador;
        this.Telefono_Trabajador = Telefono_Trabajador;
        this.Descripcion_Trabajador = Descripcion_Trabajador;
    }

    public int getID_Trabajador() {
        return ID_Trabajador;
    }

    public void setID_Trabajador(int ID_Trabajador) {
        this.ID_Trabajador = ID_Trabajador;
    }

    public String getNombre_Trabajador() {
        return Nombre_Trabajador;
    }

    public void setNombre_Trabajador(String Nombre_Trabajador) {
        this.Nombre_Trabajador = Nombre_Trabajador;
    }

    public String getApellidoPaterno_Trabajador() {
        return ApellidoPaterno_Trabajador;
    }

    public void setApellidoPaterno_Trabajador(String ApellidoPaterno_Trabajador) {
        this.ApellidoPaterno_Trabajador = ApellidoPaterno_Trabajador;
    }

    public String getApellidoMaterno_Trabajador() {
        return ApellidoMaterno_Trabajador;
    }

    public void setApellidoMaterno_Trabajador(String ApellidoMaterno_Trabajador) {
        this.ApellidoMaterno_Trabajador = ApellidoMaterno_Trabajador;
    }

    public int getEdad_Trabajador() {
        return Edad_Trabajador;
    }

    public void setEdad_Trabajador(int Edad_Trabajador) {
        this.Edad_Trabajador = Edad_Trabajador;
    }

    public String getTelefono_Trabajador() {
        return Telefono_Trabajador;
    }

    public void setTelefono_Trabajador(String Telefono_Trabajador) {
        this.Telefono_Trabajador = Telefono_Trabajador;
    }

    public String getDescripcion_Trabajador() {
        return Descripcion_Trabajador;
    }

    public void setDescripcion_Trabajador(String Descripcion_Trabajador) {
        this.Descripcion_Trabajador = Descripcion_Trabajador;
    }
    
    
    
}
