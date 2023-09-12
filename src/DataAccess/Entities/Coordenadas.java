package DataAccess.Entities;

public class Coordenadas {
    private String LlCoordenadas;
    //Constructor
    public Coordenadas(String LlCoordenadas){
        this.LlCoordenadas = LlCoordenadas;
    }
    //Getter y Setter
    public String getLlCoordenadas() {
        return LlCoordenadas;
    }
    public void setLlCoordenadas(String llCoordenadas) {
        LlCoordenadas = llCoordenadas;
    }
}
