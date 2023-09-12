package UserInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.List;

public class Interface {
    public void llMain() {
        SwingUtilities.invokeLater(() -> {
            JFrame llFrame = new JFrame("Horarios Guerra");
            llFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            llFrame.setLayout(new BorderLayout());

            // Tabla: Datos SCV     
            JTable llTable = new JTable();
            DefaultTableModel llModel = new DefaultTableModel();
            llTable.setModel(llModel);

            //Scroll en la tabla en caso de ingreso de muchos datos
            JScrollPane scrollPane = new JScrollPane(llTable);
            llFrame.add(scrollPane, BorderLayout.CENTER);
            
            // Datos desde SQLite 
            List<String> sqliteData = llGetDataFromSQLite("jdbc:sqlite:database\\dataBaseUcraine.db", "LL_USUARIO");

            // Agregar fila de datos de SQLite al inicio de la tabla CSV
            if (sqliteData != null) {
                addRowToCSVTable(llModel, sqliteData);
            }

            // Cargar datos TXT en la tabla
            llLoadCSVData(llModel, "ArchivosSCV\\LudenaLara.txt");

            llFrame.setSize(2000, 600);
            llFrame.setVisible(true);
        });
    }

    private void llLoadCSVData(DefaultTableModel model, String filePath) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Leer la primera línea como encabezados
            if ((line = reader.readLine()) != null) {
                String[] headers = line.split(";");
                model.setColumnIdentifiers(headers);
            }
    
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                
                // Reemplazar los valores en la última columna
                if (data.length > 0) {
                    String dataTemporal = data[data.length - 1];
                    String dataTemporal2 = dataTemporal.substring(1, dataTemporal.length());
                    data[data.length - 1] = reemplazarLetras(dataTemporal2);
                }
                
                model.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> llGetDataFromSQLite(String jdbcURL, String tableName) {
        List<String> data = new ArrayList<>();

        try {
            Connection llConnection = DriverManager.getConnection(jdbcURL);
            Statement llStatement = llConnection.createStatement();

            // Consulta SQL para seleccionar una fila de la tabla SQLite
            String query = " SELECT l.Nombre "
                          +" FROM LL_USUARIO l"
                          +" WHERE Estado = 'A';";

            ResultSet llResultSet = llStatement.executeQuery(query);

            // Obtener datos de la fila y agregarlos a la lista
            while (llResultSet.next()) {
                String Nombre = llResultSet.getString("Nombre"); 
                data.add(Nombre);
            }

            llResultSet.close();
            llStatement.close();
            llConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private static void addRowToCSVTable(DefaultTableModel model, List<String> rowData) {
        if (rowData != null && !rowData.isEmpty()) {
            Object[] row = rowData.toArray();
            model.addRow(row);
        }
    }

    public String reemplazarLetras(String entrada) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < entrada.length(); i++) {
            char letra = entrada.charAt(i);
            switch (letra) {
                case 'a':
                    resultado.append("Avion");
                    break;
                case 'b':
                    resultado.append("Barco");
                    break;
                case 'c':
                    resultado.append("Convoy");
                    break;
                case 'd':
                    resultado.append("Dron");
                break;
                case 't':
                    resultado.append("Tanque");
                break;
                default:
                    resultado.append(letra);
            }

            if (i < entrada.length() - 1) {
                resultado.append(", ");
            }
        }

        return resultado.toString();
    }
}
