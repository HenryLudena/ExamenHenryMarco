package UploadFileSCV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Utilidades.Utilidades;


public class VerficacionUpload {
    static Scanner sc = new Scanner(System.in);
    ConexionSQL llConexionSQL = new ConexionSQL();
    Utilidades utilidades = new Utilidades();
    public void llVerficacionExistenciaFile(String llRutaArchivo, String llUsuario){
        
        utilidades.llLimpiarTerminal();
        // Crear un objeto File con la ruta del archivo CSV
        File llArchivo = new File(llRutaArchivo);

        // Verificar si el archivo existe
        if (llArchivo.exists()) {
            // Obtener el nombre del archivo
            String llNombreArchivo = llArchivo.getName();

            // Imprimir el nombre del archivo
            System.out.println(" \u001B[32mEl nombre del archivo CSV es: " + llNombreArchivo + "\n ¿Desea subirlo a la base de datos? Ingrese SI en caso afirmativo caso contrario otro digito \u001B[0m");
            String llEleccionUsuario = sc.nextLine();
            if(llEleccionUsuario.toLowerCase().equals("si"))
                llConexionSQL.DatabaseInsert(llRutaArchivo, llUsuario);
        } else {
            //Si el archivo no existe se indica al usuario 
            System.err.println("El archivo no existe en la ruta proporcionada.");
        }
    }


    /**
     * Se evita volver a subir archivos que ya están en la base de datos
     */
    public void llIngresoArchivo(String rutaArchivo, String Usuario) {
        Scanner scanner = new Scanner(System.in);
        Set<String> llNombresSet = new HashSet<>();

        // Cargar nombres desde el archivo (si existe)
        cargarNombresDesdeArchivo(llNombresSet);
            System.out.println("Ingrese un nombre");
            String llNombre = scanner.nextLine();            

            // Agregar el nombre al conjunto, en caso de que se pueda añadir caso contrario enseñar que no se puede.
            if (llNombresSet.add(llNombre)) {
                System.out.println("Nombre agregado con éxito.");
                llConexionSQL.DatabaseInsert(rutaArchivo, Usuario);
            } else {
                System.out.println("El nombre ya existe en la lista.");
            }
        
        // Guardar los nombres en el archivo
        llGuardarNombresEnArchivo(llNombresSet);

        // Imprimir la lista de nombres únicos
        // System.out.println("Nombres únicos ingresados:");
        // for (String nombres : nombresSet) {
        //     System.out.println(nombres);
        // }
    }
    /**
     * Cargar los nombres del archivo .txt para verficar si ya existen en la lista
     * @param nombresSet
     */
    private static void cargarNombresDesdeArchivo(Set<String> nombresSet) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\UploadFileSCV\\nombres.txt"))) {
            String llLinea;
            while ((llLinea = br.readLine()) != null) {
                nombresSet.add(llLinea);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de nombres: " + e.getMessage());
        }
    }

    /**
     * Guardar el nombre en la lista en caso de que no exista
     * @param nombresSet
     */
    private static void llGuardarNombresEnArchivo(Set<String> nombresSet) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\UploadFileSCV\\nombres.txt"))) {
            for (String nombre : nombresSet) {
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de nombres: " + e.getMessage());
        }
    }

    // Utilidades utilidades = new Utilidades();

    // public void llImpresionInicial(String rutaArchivo, String Usuario){
    //     System.out.println(utilidades.hlCEDULA + "\n" + utilidades.hlCORREO + "\n" + utilidades.hlNOMBRE);
    //     int HLnumeroIntentos = 3, HLnumeroMenu;
    //     boolean HLbandera = true;
    //     String HLusuario;
    //     String HLclave;
    //     do {
    //     System.out.println("--------------------");
    //     System.out.print("+ Usuario: ");
    //     HLusuario = sc.nextLine();
    //     System.out.print("+ Clave: ");
    //     HLclave = sc.nextLine();
    //     System.out.println("--------------------");
    //         HLbandera = utilidades.llIngresoUsuario(HLusuario, HLclave,HLbandera);
    //         if(HLbandera==true){
    //         HLnumeroIntentos--;
    //         System.out.println("* Numero de intentos: "+HLnumeroIntentos);
    //         }
    //         if(HLnumeroIntentos==0){
    //         System.out.println("Lo sentimos tu usuario y clave son incorrectos..!");
    //         System.out.println("Gracias");
    //         System.exit(0);
    //         }
    //     } while ((HLbandera==true)&&(HLnumeroIntentos>=1));
    //     utilidades.llLimpiarTerminal();
    //     System.out.println("Bienvenido "+HLusuario.toUpperCase());
    //     llVerficacionExistenciaFile(rutaArchivo, Usuario);
    // }
}
