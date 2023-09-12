package DataAccess.Entities;

public class ArsenalTipo {
    private String llTipoArsenal;
    
    //Constructor
    public ArsenalTipo(String llTipoArsenal){
        this.llTipoArsenal = llTipoArsenal;
    }

    //Getters y Setters
    public String getLlTipoArsenal() {
        return llTipoArsenal;
    }
    public void setLlTipoArsenal(String llTipoArsenal) {
        this.llTipoArsenal = llTipoArsenal;
    }
}
