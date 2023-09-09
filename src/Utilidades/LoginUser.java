package Utilidades;

import java.util.Scanner;

import UploadFileSCV.VerficacionUpload;

public class LoginUser {
    static  Scanner sc = new Scanner(System.in);
    Utilidades utilidades = new Utilidades();
    VerficacionUpload verficacionUpload = new VerficacionUpload();

        public void impresionInicial(){
        System.out.println(utilidades.hlCEDULA + "\n" + utilidades.hlCORREO + "\n" + utilidades.hlNOMBRE);
        int HLnumeroIntentos = 3, HLnumeroMenu;
        boolean HLbandera = true;
        String HLusuario;
        String HLclave;
        do {
        System.out.println("--------------------");
        System.out.print("+ Usuario: ");
        HLusuario = sc.nextLine();
        System.out.print("+ Clave: ");
        HLclave = sc.nextLine();
        System.out.println("--------------------");
            HLbandera = utilidades.hlIngresoUsuario(HLusuario, HLclave,HLbandera);
            if(HLbandera==true){
            HLnumeroIntentos--;
            System.out.println("* Numero de intentos: "+HLnumeroIntentos);
            }
            if(HLnumeroIntentos==0){
            System.out.println("Lo sentimos tu usuario y clave son incorrectos..!");
            System.out.println("Gracias");
            System.exit(0);
            }
        } while ((HLbandera==true)&&(HLnumeroIntentos>=1));
        utilidades.HLlimpiarTerminal();
        System.out.println("Bienvenido "+HLusuario.toUpperCase());
        HLbandera = true;
        do {
        utilidades.HLlimpiarTerminal();
        HLnumeroMenu=utilidades.HLmenu(HLusuario);
        
        switch (HLnumeroMenu) {
            //El usuario elige cual de los 3 archivos desea, si son mas es recomendable sacar lista de txt
            case 1:
            System.out.println("Elija cual archivo desea escoger:" 
                                +"\n HIDALGO CRUZ PABLO ESTEBAN"
                                +"\n CHUNCHO JIMENEZ ANGEL DAVID"
                                +"\n ALEMAN OSORIO CARLOS ALEJANDRO");
            boolean bandera = true;
            int eleccionUsuario = 0;
            do{
                try {
                    eleccionUsuario = Integer.parseInt(sc.nextLine());
                    if((eleccionUsuario>3)&&(eleccionUsuario<=0))
                    throw new Exception("Ingrese un número del 1 al 3");
                    bandera = false;
                } catch (Exception e) {
                    System.out.println("Ingrese un número del 1 al 3");
                }
            
            }while(bandera);
            switch (eleccionUsuario) {
                case 1:
                
                    verficacionUpload.VerficacionExistenciaFile("ArchivosSCV\\202111083-HIDALGO CRUZ PABLO ESTEBAN.csv");
                    break;
                case 2:
                
                verficacionUpload.VerficacionExistenciaFile("ArchivosSCV\\202110105-CHUNCHO JIMENEZ ANGEL DAVID.csv");
                    break;
                case 3:
                
                verficacionUpload.VerficacionExistenciaFile("ArchivosSCV\\202120757-ALEMAN OSORIO CARLOS ALEJANDRO.csv");
            }
                break;
            default:
            System.out.println("Hasta pronto " + HLusuario);
            System.exit(0);
            break;
        }
        
        System.out.println("Escriba SI en caso de querer acabar acabar el programa caso contrario escriba otro digito");
        String hlDecision = sc.nextLine();
        if ((hlDecision.toUpperCase().equals("SI"))) {
            HLbandera=false;
        }
        } while (HLbandera==true);
    }
}

