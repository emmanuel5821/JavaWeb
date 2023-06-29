package dominio;

public class Pago {
    private int ID_Pago;
    private String Nombre_Tarjeta;
    private String Numero_Tarjeta;
    private String Fecha_Expiracion;
    private int CVV;

    public Pago(int ID_Pago) {
        this.ID_Pago = ID_Pago;
    }

    public Pago(String Nombre_Tarjeta, String Numero_Tarjeta, String Fecha_Expiracion, int CVV) {
        this.Nombre_Tarjeta = Nombre_Tarjeta;
        this.Numero_Tarjeta = Numero_Tarjeta;
        this.Fecha_Expiracion = Fecha_Expiracion;
        this.CVV = CVV;
    }

    public Pago(int ID_Pago, String Nombre_Tarjeta, String Numero_Tarjeta, String Fecha_Expiracion, int CVV) {
        this.ID_Pago = ID_Pago;
        this.Nombre_Tarjeta = Nombre_Tarjeta;
        this.Numero_Tarjeta = Numero_Tarjeta;
        this.Fecha_Expiracion = Fecha_Expiracion;
        this.CVV = CVV;
    }

    public int getID_Pago() {
        return ID_Pago;
    }

    public void setID_Pago(int ID_Pago) {
        this.ID_Pago = ID_Pago;
    }

    public String getNombre_Tarjeta() {
        return Nombre_Tarjeta;
    }

    public void setNombre_Tarjeta(String Nombre_Tarjeta) {
        this.Nombre_Tarjeta = Nombre_Tarjeta;
    }

    public String getNumero_Tarjeta() {
        return Numero_Tarjeta;
    }

    public void setNumero_Tarjeta(String Numero_Tarjeta) {
        this.Numero_Tarjeta = Numero_Tarjeta;
    }

    public String getFecha_Expiracion() {
        return Fecha_Expiracion;
    }

    public void setFecha_Expiracion(String Fecha_Expiracion) {
        this.Fecha_Expiracion = Fecha_Expiracion;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
    
    
    
    
}
