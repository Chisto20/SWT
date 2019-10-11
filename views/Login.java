package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import config.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmAccesoADatos;
	private JTextField txusu;
	private JTextField txpass;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAccesoADatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoADatos = new JFrame();
		frmAccesoADatos.getContentPane().setBackground(Color.YELLOW);
		frmAccesoADatos.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombre.setBounds(71, 97, 100, 29);
		frmAccesoADatos.getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblContrasea.setBounds(71, 137, 135, 29);
		frmAccesoADatos.getContentPane().add(lblContrasea);
		
		txusu = new JTextField();
		txusu.setBounds(214, 97, 169, 29);
		frmAccesoADatos.getContentPane().add(txusu);
		txusu.setColumns(10);
		
		txpass = new JTextField();
		txpass.setColumns(10);
		txpass.setBounds(214, 137, 169, 29);
		frmAccesoADatos.getContentPane().add(txpass);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceder();
			}
		});
		btnAcceder.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnAcceder.setBounds(147, 192, 135, 29);
		frmAccesoADatos.getContentPane().add(btnAcceder);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setBackground(Color.LIGHT_GRAY);
		lblLogin.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblLogin.setBounds(164, 11, 100, 42);
		frmAccesoADatos.getContentPane().add(lblLogin);
		frmAccesoADatos.setBackground(Color.WHITE);
		frmAccesoADatos.setTitle("Acceso a Datos");
		frmAccesoADatos.setBounds(100, 100, 450, 300);
		frmAccesoADatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void acceder() {
		Connection conn = new Conexion().conectar();
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
			ps.setString(1, txusu.getText());
			ps.setString(2, txpass.getText());
			
			ResultSet rs = ps.executeQuery();//ejecutar select
			//System.out.println(rs.next());
			
			if(rs.next()) {
				Principal p = new Principal();
				p.frame.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error en el Login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//cierra acceder
}//cierra clase
