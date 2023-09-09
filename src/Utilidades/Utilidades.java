package Utilidades;
import java.util.Scanner;

public class Utilidades {
    public static final String hlCEDULA = "\t - CEDULA: 1150141487";
    public static final String hlCORREO = "\t - CORREO: henry.ludena@epn.edu.ec";
    public static final String hlNOMBRE = "\t - NOMBRE: henry francisco ludeña chicaiza";
    public static final String mlCEDULA = "\t - CEDULA: 1727547687";
    public static final String mlCORREO = "\t - CORREO: marco.lara01@epn.edu.ec";
    public static final String mlNOMBRE = "\t - NOMBRE: marco daniel lara vite";

    static  Scanner sc = new Scanner(System.in);
    public boolean hlIngresoUsuario(String HLusuario, String HLclave, boolean HLbandera){
        HLbandera=true;
        if(((HLusuario.equalsIgnoreCase("henry.ludena@epn.edu.ec"))||(HLusuario.equalsIgnoreCase("profe"))&&((HLclave.equalsIgnoreCase("1150141487"))||(HLclave.equalsIgnoreCase("1234"))))){
            return HLbandera = false;
        }else
        HLbandera = true;
        return HLbandera;
    }

    public static final void HLlimpiarTerminal(){
        try {
            String operatingSystem = System.getProperty("os.name");     
              
            if(operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public int HLmenu(String HLusuario){
        int HLnumeroIngreasdo = 0;
        boolean HLbandera = true;
        do {
        System.out.println("------------------------");
        System.out.println("Subida archivos");
        System.out.println("--------------------------");
        System.out.println("Usuario: "+HLusuario);
        System.out.println();
        System.out.println("1 Subir archivo a base de datos");
        System.out.println("0 SALIR");
        try {
            HLnumeroIngreasdo=Integer.parseInt(sc.nextLine());
            if(HLnumeroIngreasdo>=0&&HLnumeroIngreasdo<=4)
            HLbandera=false;
            else
            System.out.println("Ingrese un número del menú");
        } catch (Exception e) {
            System.out.println("Ingrese un número válido");
        }
        } while (HLbandera==true);
       
        return HLnumeroIngreasdo;
    }
}
