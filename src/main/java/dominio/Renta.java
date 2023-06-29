package dominio;

public class Renta {
    private int ID_Renta;
    private int ID_Cliente;
    private int ID_Trabajador;
    private double Costo;
    private int Horas;
    private String Fecha;
    private String Direccion;

    public Renta(int ID_Renta) {
        this.ID_Renta = ID_Renta;
    }

    public Renta(int ID_Cliente, int ID_Trabajador, double Costo, int Horas, String Fecha, String Direccion) {
        this.ID_Cliente = ID_Cliente;
        this.ID_Trabajador = ID_Trabajador;
        this.Costo = Costo;
        this.Horas = Horas;
        this.Fecha = Fecha;
        this.Direccion = Direccion;
    }

    public Renta(int ID_Renta, int ID_Cliente, int ID_Trabajador, double Costo, int Horas, String Fecha, String Direccion) {
        this.ID_Renta = ID_Renta;
        this.ID_Cliente = ID_Cliente;
        this.ID_Trabajador = ID_Trabajador;
        this.Costo = Costo;
        this.Horas = Horas;
        this.Fecha = Fecha;
        this.Direccion = Direccion;
    }

    public int getID_Renta() {
        return ID_Renta;
    }

    public void setID_Renta(int ID_Renta) {
        this.ID_Renta = ID_Renta;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Trabajador() {
        return ID_Trabajador;
    }

    public void setID_Trabajador(int ID_Trabajador) {
        this.ID_Trabajador = ID_Trabajador;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public int getHoras() {
        return Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
}
