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
    private JLabel llUsuarioLabel, llContrasenaLabel, llMsjLabel, llInvLabel,  llInvLabel1, llInvLabel2;
    private JTextField llUsuarioTxtField;
    private JPasswordField llContrasenaField;
    private JButton llBotonLogin;
    private ImageIcon llIcono;
VerficacionUpload llVerficacionUpload = new VerficacionUpload();
Utilidades llUtilidades = new Utilidades();

//Constructor de la clase
    public  llUserInterfaceLogin(String llTitle, String llPathIcon){
        llUtilidades.llLimpiarTerminal();
        System.out.println(llUtilidades.hlCEDULA + "\n" + llUtilidades.hlCORREO + "\n" + llUtilidades.hlNOMBRE + "\n" + llUtilidades.mlCEDULA + "\n" + llUtilidades.mlCORREO + "\n" + llUtilidades.mlNOMBRE);
        try {
            setCustomizerForm(llTitle, llPathIcon);
        } catch (AppException | SQLException e) {
            e.printStackTrace();
        }
        setSize (600 , 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout( new GridLayout(2,2));
        
        llUsuarioLabel = new JLabel("Usuario");
        llContrasenaLabel = new JLabel("Contrasena");
        llMsjLabel = new JLabel("");
        llUsuarioTxtField = new JTextField();
        llContrasenaField = new JPasswordField();
        llBotonLogin = new JButton("Iniciar Sesion");
        llInvLabel = new JLabel("");
        llInvLabel1 = new JLabel("");
        llInvLabel2 = new JLabel("");

        llBotonLogin.addActionListener(this);
        add(llUsuarioLabel);
        
        add(llUsuarioTxtField);
        add(llInvLabel);
        add(llInvLabel1);
        add(llInvLabel2);
        add(llContrasenaLabel);
        add(llContrasenaField);
        add(new JLabel());
        add(llBotonLogin);
        add(llMsjLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String llUsuario = llUsuarioTxtField.getText();
        String llContrasena = new String(llContrasenaField.getPassword());

        if ((llUsuario.equals("henry.ludena@epn.edu.ec") && llContrasena.equals("1150141487")) || (llUsuario.equals("marco.lara01@epn.edu.ec") && llContrasena.equals("1727547687")) || (llUsuario.equals("profe") && llContrasena.equals("1234")) || (llUsuario.equals("Usuario_cualesquiera") && llContrasena.equals("contrasena_cualesquiera"))) {
            llMsjLabel.setText("Inicio de sesión exitoso");
            // Aquí puedes redirigir al usuario a otra parte de tu aplicación.
            dispose();
            llVerficacionUpload.llVerficacionExistenciaFile("ArchivosSCV\\LudenaLara.txt", llUsuario);
        } else {
            llMsjLabel.setText("Usuario o contrasena incorrectos");
        }
        llContrasenaField.setText("");
    } 

    public void setCustomizerForm(String title, String pathIcon) throws AppException, SQLException{
        llIcono = new ImageIcon(pathIcon);                 
        setTitle(title);                            
        setVisible(true);
        setLayout(null);
        setLocation(100, 50);
        setResizable(true);
        setSize(1000, 800);
        setIconImage(llIcono.getImage()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

