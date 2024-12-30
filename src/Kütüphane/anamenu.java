package Kütüphane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class anamenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anamenu frame = new anamenu();
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
	public anamenu() {
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1024, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 204)); // Açık mavi

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AİBÜ FUAT SEZGİN KÜTÜPHANESİNE HOŞGELDİNİZ");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(175, 26, 577, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("YÖNETİCİ GİRİŞİ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(new ImageIcon("src/ikon2.png")); // İkon dosyasının yolu
		iconLabel.setBounds(150, 120, 50, 50); // Pencere içinde konum ve boyut ayarlama
		contentPane.add(iconLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				yonetici_ekrani yonetici_ekrani=new yonetici_ekrani();
				yonetici_ekrani.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(108, 199, 139, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÜYE GİRİŞİ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(248, 248, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uyegirisiekrani uyegirisiekrani = new uyegirisiekrani(); 
		        uyegirisiekrani.setVisible(true);
			}
		});
		
		JLabel iconLabel1 = new JLabel();
		iconLabel1.setIcon(new ImageIcon("src/ikon1.png")); // İkon dosyasının yolu
		iconLabel1.setBounds(440, 120, 50, 50); // Pencere içinde konum ve boyut ayarlama
		contentPane.add(iconLabel1);
		
		btnNewButton_1.setBounds(396, 199, 135, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ÜYE OL");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(248, 248, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uyeol_ekrani uyeol = new uyeol_ekrani();
				uyeol.setVisible(true);
				
			}
		});
		
		JLabel iconLabel2 = new JLabel();
		iconLabel2.setIcon(new ImageIcon("src/ikon3.png")); // İkon dosyasının yolu
		iconLabel2.setBounds(740, 120, 50, 50);
		// Pencere içinde konum ve boyut ayarlama
		contentPane.add(iconLabel2);
		btnNewButton_2.setBounds(692, 199, 139, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("KİTAPLAR");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 255, 224));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kitaplarekrani kitaplarEkrani = new kitaplarekrani();
	            kitaplarEkrani.setVisible(true);
				
			}
		});
		JLabel iconLabel4 = new JLabel();
		iconLabel4.setIcon(new ImageIcon("src/ikon4.png")); // İkon dosyasının yolu
		iconLabel4.setBounds(290, 300, 50, 50);
		contentPane.add(iconLabel4);
		
		
		btnNewButton_3.setBounds(247, 368, 139, 32);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 10, 10);
		contentPane.add(panel);
		
		JButton btnNewButton_4 = new JButton("ÇIKIŞ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "çıkış yapmak istiyor musunuz", "çıkış butonu", JOptionPane.INFORMATION_MESSAGE);
			        
			        // 1 saniye (1000 ms) sonra uygulamayı kapat
			        javax.swing.Timer timer = new javax.swing.Timer(200, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent evt) {
			                System.exit(0); // Uygulamayı kapat
			            }
			        });
			        timer.setRepeats(false); //  Timer sadece bir kez çalışacak
			        timer.start();
				
				
			}
		});
		JLabel iconLabel5 = new JLabel();
		iconLabel5.setIcon(new ImageIcon("src/ikon5.png")); // İkon dosyasının yolu
		iconLabel5.setBounds(590, 300, 50, 50);
		contentPane.add(iconLabel5);
		
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setBackground(new Color(255, 228, 225));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setBounds(547, 368, 135, 32);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon(getClass().getResource("kütüphane3.jpg")));
		lblNewLabel_5.setBounds(0,0, 1024, 550);
		contentPane.add(lblNewLabel_5);
		
		JButton button = new JButton("New button");
		button.setBounds(115, 374, 85, 21);
		contentPane.add(button);
	}

}
