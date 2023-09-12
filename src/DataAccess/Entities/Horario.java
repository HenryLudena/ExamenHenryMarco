package DataAccess.Entities;

public class Horario {
    private String Lunes;
    private String Martes;
    private String Miercoles;
    private String Jueves;
    private String Viernes;

    //Constructor
    public Horario(String Lunes, String Martes, String Miercoles, String Jueves, String Viernes){
        this.Lunes = Lunes;
        this.Martes = Martes;
        this.Miercoles=Miercoles;
        this.Jueves = Jueves;
        this.Viernes = Viernes;
    }
    //Getter y Setters
    public String getLunes() {
        return Lunes;
    }

    public void setLunes(String Lunes) {
        this.Lunes = Lunes;
    }

    public String getMartes() {
        return Martes;
    }

    public void setMartes(String Martes) {
        this.Martes = Martes;
    }

    public String getMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(String Miercoles) {
        this.Miercoles = Miercoles;
    }

    public String getJueves() {
        return Jueves;
    }

    public void setJueves(String Jueves) {
        this.Jueves = Jueves;
    }

    public String getViernes() {
        return Viernes;
    }

    public void setViernes(String Viernes) {
        this.Viernes = Viernes;
    }
}
