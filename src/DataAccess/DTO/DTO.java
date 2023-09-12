package DataAccess.DTO;

import DataAccess.Entities.Arsenal;
import DataAccess.Entities.ArsenalTipo;
import DataAccess.Entities.Coordenadas;
import DataAccess.Entities.Horario;

public class DTO {
    private Arsenal arsenal;
    private ArsenalTipo arsenalTipo;
    private Coordenadas coordenadas;
    private Horario horario;

    //Constructor
    public DTO(Arsenal arsenal, ArsenalTipo arsenalTipo, Coordenadas coordenadas, Horario horario){
    this.arsenal = arsenal;
    this.arsenalTipo = arsenalTipo;
    this.coordenadas = coordenadas;
    this.horario = horario;
    }
    //Getter y Setter
    public Arsenal getArsenal() {
        return arsenal;
    }

    public void setArsenal(Arsenal arsenal) {
        this.arsenal = arsenal;
    }

    public ArsenalTipo getArsenalTipo() {
        return arsenalTipo;
    }

    public void setArsenalTipo(ArsenalTipo arsenalTipo) {
        this.arsenalTipo = arsenalTipo;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
