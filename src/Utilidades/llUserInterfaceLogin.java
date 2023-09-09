package Utilidades;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Framework.AppException;
import UploadFileSCV.VerficacionUpload;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;


public class llUserInterfaceLogin extends JFrame implements ActionListener{
    private JLabel usuarioLabel, contrasenaLabel, msjLabel, invLabel,  invLabel1, invLabel2;
    private JTextField usuarioTxtField;
    private JPasswordField contrasenaField;
    private JButton botonLogin;
    private ImageIcon icono;
VerficacionUpload verficacionUpload = new VerficacionUpload();
    public  llUserInterfaceLogin(String title, String pathIcon){
        try {
            setCustomizerForm(title, pathIcon);
        } catch (AppException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setSize (600 , 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout( new GridLayout(2,2));

        usuarioLabel = new JLabel("Usuario");
        contrasenaLabel = new JLabel("Contrasena");
        msjLabel = new JLabel("");
        usuarioTxtField = new JTextField();
        contrasenaField = new JPasswordField();
        botonLogin = new JButton("Iniciar Sesion");
        invLabel = new JLabel("");
        invLabel1 = new JLabel("");
        invLabel2 = new JLabel("");

        botonLogin.addActionListener(this);
        add(usuarioLabel);
        
        add(usuarioTxtField);
        add(invLabel);
        add(invLabel1);
        add(invLabel2);
        add(contrasenaLabel);
        add(contrasenaField);
        add(new JLabel());
        add(botonLogin);
        add(msjLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = usuarioTxtField.getText();
        String contrasena = new String(contrasenaField.getPassword());

        if ((usuario.equals("henry.ludena@epn.edu.ec") && contrasena.equals("1150141487")) || (usuario.equals("marco.lara01@epn.edu.ec") && contrasena.equals("1727547687")) || (usuario.equals("profe") && contrasena.equals("1234")) || (usuario.equals("Usuario_cualesquiera") && contrasena.equals("contrasena_cualesquiera"))) {
            msjLabel.setText("Inicio de sesión exitoso");
            // Aquí puedes redirigir al usuario a otra parte de tu aplicación.
            dispose();
            verficacionUpload.VerficacionExistenciaFile("ArchivosSCV\\datos.txt", usuario);
        } else {
            msjLabel.setText("Usuario o contrasena incorrectos");
        }
        contrasenaField.setText("");
    } 

    public void setCustomizerForm(String title, String pathIcon) throws AppException, SQLException{
        icono = new ImageIcon(pathIcon);                 
        setTitle(title);                            
        setVisible(true);
        setLayout(null);
        setLocation(100, 50);
        setResizable(true);
        setSize(1000, 800);
        setIconImage(icono.getImage()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

