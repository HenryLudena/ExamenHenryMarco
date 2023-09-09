import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import UploadFileSCV.ConexionSQL;
import UploadFileSCV.VerficacionUpload;
import Utilidades.LoginUser;
import Utilidades.llUserInterfaceLogin;

public class App {
    public static void main(String[] args) throws Exception {
    // ConexionSQL conexionSQL = new ConexionSQL();
    // String filePath = "ArchivosSCV\\202111083-HIDALGO CRUZ PABLO ESTEBAN.csv";
    // conexionSQL.DatabaseInsert(filePath);
    // VerficacionUpload VerficacionUpload = new VerficacionUpload();
    // VerficacionUpload.VerficacionExistenciaFile();
    // LoginUser loginUser = new LoginUser();
    // loginUser.impresionInicial();
    llUserInterfaceLogin llUserInterfaceLogin = new llUserInterfaceLogin("InterfazLogin", "src\\Utilidades\\ImagenIcono\\1693487.png");
    
}
}