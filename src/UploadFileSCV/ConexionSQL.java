package UploadFileSCV;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import UserInterface.Interface;

public class ConexionSQL {
    Interface Interface = new Interface();
    public void DatabaseInsert(String filePath, String Usuario){
    String jdbcURL = "jdbc:sqlite:database\\databaseUcraine.db"; 
    String username = "Henry";
    String password = "";

    

    int batchSize = 20;

    Connection connection = null;
    System.out.println("(IMPARES)");
    try{
        connection = DriverManager.getConnection(jdbcURL, username, password);
        connection.setAutoCommit(false);

        String sqlTabla1 = "INSERT INTO LL_TIPO_ARSENAL (LlTipoArsenal) VALUES (?)";
        String sqlTabla2 = "INSERT INTO LL_COORDENADAS  (LlCoordenadas) VALUES (?)";
        String sqlTabla3 = "INSERT INTO LL_DIAS (Lunes, Martes, Miercoles, Jueves, Viernes) VALUES (?, ?, ?, ?, ?)";
        String sqlTabla4 = "INSERT INTO LL_USUARIO (Nombre) VALUES (?)";
//INSERT INTO LECTURA_ARCHIVO (Nro, Codigo, Materia, Paral, Aula, Creditos, Lunes, Martes, 
//Miercoles, Jueves, Viernes, Sabado, Carrera, Obs) VALUES 
//("1", "203o", "Software", "GR2", "E001", "3", "" , "", "", "HOL", "", "", "Programacion", "");

//Uno para cada tabla
PreparedStatement statement = connection.prepareStatement(sqlTabla1);
BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

String lineText = null;
int count = 0;
System.out.println("[+] Leyendo: \n" 
                    + "- ArsenalTipo... \n" 
                    + "- Coordenadas... \n"
                    + "- Arsenal... \n"
                    + "- Horarrios... \n");
System.out.println("[+] Guardando: \n" 
                    + "- ArsenalTipo... \n"
                    + "- Coordenadas... \n"
                    + "- Arsenal... \n"
                    + "- Horarrios...");

lineReader.readLine();
while((lineText=lineReader.readLine())!=null){
    // System.out.println(lineText);
    String[] data = lineText.split(";");
    
    String LlTipoArsenal = data[6];
    
    statement.setString(1, LlTipoArsenal);

    statement.addBatch();
    if(count%batchSize==0){
        statement.executeBatch();
    }
}
//lineReader.close();
statement.executeBatch();
connection.commit();
// connection.close();
//Mensaje en caso de que salga bien 
System.out.println("Data has been inserted succesfully");

//Segunda parte

statement = connection.prepareStatement(sqlTabla2);
lineReader = new BufferedReader(new FileReader(filePath));

lineText = null;
count = 0;

lineReader.readLine();
while((lineText=lineReader.readLine())!=null){
    String[] data = lineText.split(";");

    String LlCoordenadas = data[0];
    
    statement.setString(1, LlCoordenadas);

    statement.addBatch();
    if(count%batchSize==0){
        statement.executeBatch();
    }
}
// lineReader.close();
statement.executeBatch();
connection.commit();
// connection.close();

//Tercera parte

statement = connection.prepareStatement(sqlTabla3);
lineReader = new BufferedReader(new FileReader(filePath));

lineText = null;
count = 0;

lineReader.readLine();
while((lineText=lineReader.readLine())!=null){
    String[] data = lineText.split(";");

    String LlLunes = data[1];
    String LlMartes = data[2];
    String LlMiercoles = data[3];
    String LlJueves = data[4];
    String LlViernes = data[5];
    
    statement.setString(1, LlLunes);
    statement.setString(2, LlMartes);
    statement.setString(3, LlMiercoles);
    statement.setString(4, LlJueves);
    statement.setString(5, LlViernes);


    statement.addBatch();
    if(count%batchSize==0){
        statement.executeBatch();
    }
}
// lineReader.close();
statement.executeBatch();
connection.commit();
// connection.close();

// //Cuarta parte

statement = connection.prepareStatement(sqlTabla4);
lineReader = new BufferedReader(new FileReader(filePath));

lineText = null;
count = 0;

lineReader.readLine();
while((lineText=lineReader.readLine())!=null){

    String LlUsuario = Usuario;
    
    
    statement.setString(1, LlUsuario);


    statement.addBatch();
    if(count%batchSize==0){
        statement.executeBatch();
    }
}
lineReader.close();
statement.executeBatch();
connection.commit();
connection.close();
    }catch(Exception exception){
        exception.printStackTrace();
    }
//Hasta aca
Interface.main();
    }

    
    
}



