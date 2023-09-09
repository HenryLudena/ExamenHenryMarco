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
    public void main() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Horarios Guerra");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Tabla: Datos SCV     
            JTable table = new JTable();
            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);

            //Scroll en la tabla en caso de ingreso de muchos datos
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);
            
            // Datos desde SQLite 
            List<String> sqliteData = getDataFromSQLite("jdbc:sqlite:database\\dataBaseUcraine.db", "LL_USUARIO");

            // Agregar fila de datos de SQLite al inicio de la tabla CSV
            if (sqliteData != null) {
                addRowToCSVTable(model, sqliteData);
            }

            // Cargar datos TXT en la tabla
            loadCSVData(model, "ArchivosSCV\\datos.txt");

            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }

    private static void loadCSVData(DefaultTableModel model, String filePath) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Leer la primera línea como encabezados
            if ((line = reader.readLine()) != null) {
                String[] headers = line.split(";");
                model.setColumnIdentifiers(headers);
            }

            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                model.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getDataFromSQLite(String jdbcURL, String tableName) {
        List<String> data = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            Statement statement = connection.createStatement();

            // Consulta SQL para seleccionar una fila de la tabla SQLite
            String query = " SELECT l.Nombre "
                          +" FROM LL_USUARIO l"
                          +" WHERE Estado = 'A';";

            ResultSet resultSet = statement.executeQuery(query);

            // Obtener datos de la fila y agregarlos a la lista
            while (resultSet.next()) {
                String Nombre = resultSet.getString("Nombre"); 
                data.add(Nombre);
            }

            resultSet.close();
            statement.close();
            connection.close();
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
}
