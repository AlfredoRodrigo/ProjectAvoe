package lpoo.projectAvoe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setBounds(new Rectangle(0, 0, 1000, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 51));
		panel.setBounds(0, 0, 984, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDrones = new JLabel("Drones");
		lblDrones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDrones.setBounds(836, 51, 138, 28);
		panel.add(lblDrones);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(menu.class.getResource("/lpoo/projectAvoe/icons/logo-12.png")));
		lblNewLabel.setBounds(10, 0, 282, 129);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(menu.class.getResource("/lpoo/projectAvoe/icons/icons8_Settings_25px.png")));
		lblNewLabel_1.setBounds(946, 0, 38, 29);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(746, 103, 238, 42);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(746, 145, 238, 42);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(746, 185, 238, 42);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(746, 351, 238, 42);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(746, 311, 238, 42);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(746, 269, 238, 42);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		panel_8.setBounds(746, 227, 238, 42);
		contentPane.add(panel_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.DARK_GRAY);
		panel_10.setBounds(746, 517, 238, 42);
		contentPane.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.DARK_GRAY);
		panel_11.setBounds(746, 475, 238, 42);
		contentPane.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.DARK_GRAY);
		panel_12.setBounds(746, 433, 238, 42);
		contentPane.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.DARK_GRAY);
		panel_13.setBounds(746, 391, 238, 42);
		contentPane.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.DARK_GRAY);
		panel_14.setBounds(746, 351, 238, 42);
		contentPane.add(panel_14);
	}
}
