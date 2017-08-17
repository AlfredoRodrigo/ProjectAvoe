package lpoo.projectAvoe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Window.Type;
import java.awt.Label;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AvoeInterface extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	
	static Cadastrados cadastro = new Cadastrados();
    ListaDinamica.Lista encomendas = new ListaDinamica.Lista();

    Usuario logado = null;
    String login, senha = "";
    static AvoeInterface telaDeLogin;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		cadastro.administradorPadrao();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaDeLogin = new AvoeInterface();
					telaDeLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AvoeInterface() {
		setTitle("ProjectAvoe");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login = txtLogin.getText();
					for (Character x : passwordField.getPassword()) {
						senha += x.toString();
					}
					if (cadastro.autentica(login, senha) != null) {
		                logado = cadastro.autentica(login, senha);
		                senha = "";
		                //this.Dispose();
		                //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		                //FECHAR APOS AUTENTICACAO
		                Menu menu = new Menu();
		                menu.show();
		                telaDeLogin.setVisible(false);
		            } else {
		            	JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!");
		            	senha = "";
		            	txtLogin.setText("");
		            	passwordField.setText("");
		            }
				}
			}
			boolean flag2 = false;
			@Override
			public void keyTyped(KeyEvent e) {
				if(!flag2) {
					txtLogin.setText("");
					flag2 = true;
				}
			}
		});
		txtLogin.setText("Login");
		txtLogin.addMouseListener(new MouseAdapter() {
			boolean flag = false;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!flag) {
					txtLogin.setText("");
					flag = true;
				}
			}
		});
		txtLogin.setBackground(Color.WHITE);
		txtLogin.setToolTipText("Login");
		txtLogin.setBounds(21, 95, 161, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login = txtLogin.getText();
					for (Character x : passwordField.getPassword()) {
						senha += x.toString();
					}
					if (cadastro.autentica(login, senha) != null) {
		                logado = cadastro.autentica(login, senha);
		                senha = "";
		                
		                //FECHAR APOS AUTENTICACAO
		                Menu menu = new Menu();
		                menu.show();
		                telaDeLogin.setVisible(false);
		            } else {
		            	JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!");
		            	senha = "";
		            	txtLogin.setText("");
		            	passwordField.setText("");
		            }
				}
			}
		});
		passwordField.setBackground(Color.WHITE);
		passwordField.setToolTipText("Senha");
		passwordField.setBounds(21, 127, 161, 20);
		contentPane.add(passwordField);
		
		JLabel lblLogin = new JLabel("Project Avoe");
		lblLogin.setBounds(21, 70, 104, 14);
		contentPane.add(lblLogin);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login = txtLogin.getText();
				for (Character x : passwordField.getPassword()) {
					senha += x.toString();
				}
				if (cadastro.autentica(login, senha) != null) {
	                logado = cadastro.autentica(login, senha);
	                senha = "";
	                
	                //FECHAR APOS AUTENTICACAO
	                Menu menu = new Menu();
	                menu.show();
	                telaDeLogin.setVisible(false);
	            } else {
	            	JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!");
	            	senha = "";
	            	txtLogin.setText("");
	            	passwordField.setText("");
	            }
			}
		});
		btnEntrar.setBounds(21, 158, 161, 23);
		contentPane.add(btnEntrar);
		
	}
}
