import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import UploadFileSCV.ConexionSQL;
import UploadFileSCV.VerficacionUpload;
import UserInterface.Interface;
import Utilidades.llUserInterfaceLogin;

public class App {
    public static void main(String[] args) throws Exception {
    // ConexionSQL conexionSQL = new ConexionSQL();
    // String filePath = "ArchivosSCV\\202111083-HIDALGO CRUZ PABLO ESTEBAN.csv";
    // conexionSQL.DatabaseInsert(filePath);
    // VerficacionUpload VerficacionUpload = new VerficacionUpload();
    // VerficacionUpload.impresionInicial("InterfazLogin", "src\\Utilidades\\ImagenIcono\\1693487.png");;
    // LoginUser loginUser = new LoginUser();
    // loginUser.impresionInicial();
    // Interface Interface = new Interface();
    // Interface.main();
    llUserInterfaceLogin llUserInterfaceLogin = new llUserInterfaceLogin("InterfazLogin", "src\\Utilidades\\ImagenIcono\\1693487.png");
    
    
}
}