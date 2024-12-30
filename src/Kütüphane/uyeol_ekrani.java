package Kütüphane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class uyeol_ekrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uyeol_ekrani frame = new uyeol_ekrani();
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
	public uyeol_ekrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1024, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(173, 216, 230)); // Açık mavi
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YENİ ÜYE KAYIT EKRANI");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(290, 31, 354, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LÜTFEN ADINIZI GİRİNİZ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(190, 147, 189, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LÜTFEN SOYADINIZI GİRİNİZ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 245, 238));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(198, 211, 189, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LÜTFEN ŞİFRENİZİ GİRİNİZ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(198, 279, 181, 33);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(420, 155, 131, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(420, 219, 131, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(425, 287, 126, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ÜYE OL");
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ad = textField.getText();
                String soyad = textField_1.getText();
                String sifre = textField_2.getText();
			

                if (ad.isEmpty() || soyad.isEmpty() || sifre.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    uyeEkle(ad, soyad, sifre);
                }
			}
		});
		btnNewButton.setBounds(425, 363, 126, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("BİTİR");
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anamenu anaMenu = new anamenu();
                anaMenu.setVisible(true);
                dispose();
				
				
			}
		});
		btnNewButton_2.setBounds(425, 443, 126, 39);
		contentPane.add(btnNewButton_2);
		
		
    	JLabel lblNewLabel_arkaplan = new JLabel(new ImageIcon(getClass().getResource("kütüphane6.png")));
		lblNewLabel_arkaplan.setBounds(0,0, 1024, 550);
		contentPane.add(lblNewLabel_arkaplan);
	}
		
		
		
		private void uyeEkle(String ad, String soyad, String sifre) {
	        try {
	            // Veritabanı bağlantısı
	            Connection conn = baglanti.getConnection();

	            // Veritabanına ekleme sorgusu
	            String query = "INSERT INTO üyeler (üye_adı, üye_soyadı, üye_numarası) VALUES (?, ?, ?)";
	            PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, ad);
	            pstmt.setString(2, soyad);
	            pstmt.setString(3, sifre);

	            int result = pstmt.executeUpdate();
	            if (result > 0) {
	                JOptionPane.showMessageDialog(contentPane, "Üye başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(contentPane, "Üye eklenemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
	            }

	            // Kaynakları kapat
	            pstmt.close();
	            conn.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(contentPane, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
	      
	
	}
	        

			

}
}
