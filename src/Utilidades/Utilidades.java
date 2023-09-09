package Utilidades;
import java.util.Scanner;

public class Utilidades {
    public static final String hlCEDULA = "\t \u001B[31m- CEDULA: 1150141487";
    public static final String hlCORREO = "\t - CORREO: henry.ludena@epn.edu.ec";
    public static final String hlNOMBRE = "\t - NOMBRE: henry francisco ludeña chicaiza \u001B[0m";
    public static final String mlCEDULA = "\t \u001B[36m- CEDULA: 1727547687";
    public static final String mlCORREO = "\t - CORREO: marco.lara01@epn.edu.ec";
    public static final String mlNOMBRE = "\t - NOMBRE: marco daniel lara vite \u001B[0m";

    static  Scanner sc = new Scanner(System.in);
    public boolean llIngresoUsuario(String llUsuario, String llClave, boolean llBandera){
        llBandera=true;
        if(((llUsuario.equalsIgnoreCase("henry.ludena@epn.edu.ec"))||(llUsuario.equalsIgnoreCase("profe"))&&((llClave.equalsIgnoreCase("1150141487"))||(llClave.equalsIgnoreCase("1234"))))){
            return llBandera = false;
        }else
        llBandera = true;
        return llBandera;
    }

    public final void llLimpiarTerminal(){
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

    // public int llMenu(String llUsuario){
    //     int llNumeroIngreasdo = 0;
    //     boolean llBandera = true;
    //     do {
    //     System.out.println("------------------------");
    //     System.out.println("Subida archivos");
    //     System.out.println("--------------------------");
    //     System.out.println("Usuario: "+llUsuario);
    //     System.out.println();
    //     System.out.println("1 Subir archivo a base de datos");
    //     System.out.println("0 SALIR");
    //     try {
    //         llNumeroIngreasdo=Integer.parseInt(sc.nextLine());
    //         if(llNumeroIngreasdo>=0&&llNumeroIngreasdo<=4)
    //         llBandera=false;
    //         else
    //         System.out.println("Ingrese un número del menú");
    //     } catch (Exception e) {
    //         System.out.println("Ingrese un número válido");
    //     }
    //     } while (llBandera==true);
       
    //     return llNumeroIngreasdo;
    // }
}
