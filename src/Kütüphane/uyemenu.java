package Kütüphane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class uyemenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uyemenu frame = new uyemenu();
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
	public uyemenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1024, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204, 229, 255)); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ÜYE MENÜ");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(348, 33, 271, 41);
		contentPane.add(lblNewLabel);
		

		
		JButton btnNewButton = new JButton("KİTAP AL");
		btnNewButton.setBackground(new Color(255, 245, 238));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kitap kitap=new kitap();
				kitap.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(423, 299, 129, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("KİTAP BIRAK");
		btnNewButton_1.setBackground(new Color(255, 245, 238));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kitap2 kitap=new kitap2();
				kitap.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(423, 211, 129, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MENÜYE DÖN");
		btnNewButton_2.setBackground(new Color(205, 92, 92));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uyegirisiekrani uyegirisiekrani=new uyegirisiekrani();
				uyegirisiekrani.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(431, 420, 121, 54);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("KİTAPLAR");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 245, 238));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kitaplarekrani kitaplarEkrani = new kitaplarekrani();
	            kitaplarEkrani.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(423, 117, 129, 49);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_arkaplan = new JLabel(new ImageIcon(getClass().getResource("kütüphane6.png")));
		lblNewLabel_arkaplan.setBounds(0,0, 1024, 550);
		contentPane.add(lblNewLabel_arkaplan);
	}
	

}
