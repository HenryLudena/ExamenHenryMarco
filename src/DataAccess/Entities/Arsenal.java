package DataAccess.Entities;

public class Arsenal {
    private String llArsenal;

    //Constructor
    public Arsenal(String llArsenal){
        this.llArsenal = llArsenal;
    }

    //Getter y Setter
    public String getLlArsenal() {
        return llArsenal;
    }

    public void setLlArsenal(String llArsenal) {
        this.llArsenal = llArsenal;
    }
}
