package PDAO.Modelo;

public class Mesero {
    public String cedula;
    public String nombres;
    public String Asigmesa;
    public int user;

    public Mesero(String nIdentificacion, String nombres, String Asigmesa,int user) {
        this.cedula = nIdentificacion;
        this.nombres = nombres;
        this.Asigmesa = Asigmesa;
        this.user = user;
    }
    public Mesero(String nIdentificacion, String nombres, String Asigmesa) {
        this.cedula = nIdentificacion;
        this.nombres = nombres;
        this.Asigmesa = Asigmesa;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    public Mesero() {
    }

    public String getnIdentificacion() {
        return cedula;
    }

    public void setnIdentificacion(String nIdentificacion) {
        this.cedula = nIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getAsigmesa() {
        return Asigmesa;
    }

    public void setAsigmesa(String Asigmesa) {
        this.Asigmesa = Asigmesa;
    }
    
    
}
