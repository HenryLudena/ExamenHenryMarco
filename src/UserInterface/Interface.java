package UserInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Interface {
    public void main() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Horarios Guerra");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JTable table = new JTable();
            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Cargar datos CSV en la tabla
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
}
