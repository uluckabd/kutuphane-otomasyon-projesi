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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class kitap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitap frame = new kitap();
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
	public kitap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1024, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LÜTFEN KİTAP BİLGİLERİNİ GİRİNİZ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(212, 0, 530, 126);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("KİTAP ADI");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(259, 108, 132, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("KİTAP YAZARI");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(269, 157, 132, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BASIM YILI");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(269, 210, 132, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("STOK SAYISI");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(283, 249, 118, 39);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SAYFA SAYISI");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(283, 298, 132, 39);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("YAYINEVİ");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(283, 347, 132, 28);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(422, 118, 132, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(422, 162, 132, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(422, 215, 132, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(422, 259, 132, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(425, 308, 132, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(422, 347, 132, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("KİTABI AL");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    String kitapAdi = textField.getText();
			        String kitapYazar = textField_1.getText();
			        String basimYili = textField_2.getText();
			        String stokSayisi = textField_3.getText(); // Bu alan kontrol için alınabilir ama güncellemede kullanılmaz
			        String sayfaSayisi = textField_4.getText();
			        String yayinevi = textField_5.getText();

			        try {
			            // MySQL bağlantısı
			            Connection con = baglanti3.getConnection();

			            // Kitap kontrolü
			            String selectQuery = "SELECT * FROM kitap WHERE kitap_adı = ? AND kitap_yazarı = ? AND basım_yılı = ? AND stok_sayısı > 0 AND sayfa_sayısı = ? AND yayınevi = ?";
			            PreparedStatement selectPst = con.prepareStatement(selectQuery);
			            selectPst.setString(1, kitapAdi);
			            selectPst.setString(2, kitapYazar);
			            selectPst.setString(3, basimYili);
			            selectPst.setString(4, sayfaSayisi);
			            selectPst.setString(5, yayinevi);

			            ResultSet rs = selectPst.executeQuery();
			            if (rs.next()) {
			                // Stok güncelleme
			                String updateQuery = "UPDATE kitap SET stok_sayısı = stok_sayısı - 1 WHERE kitap_adı = ? AND kitap_yazarı = ? AND basım_yılı = ? AND yayınevi = ?";
			                PreparedStatement updatePst = con.prepareStatement(updateQuery);
			                updatePst.setString(1, kitapAdi);
			                updatePst.setString(2, kitapYazar);
			                updatePst.setString(3, basimYili);
			                updatePst.setString(4, yayinevi);
			                updatePst.executeUpdate();

			                JOptionPane.showMessageDialog(null, "Kitap alındı! Stok güncellendi.");
			            } else {
			                JOptionPane.showMessageDialog(null, "Kitap bulunamadı veya stok yetersiz.");
			            }
			            con.close();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Bir hata oluştu: " + ex.getMessage());
			        }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(425, 402, 129, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BİTTİ");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uyemenu uyemenu =new uyemenu();
                uyemenu.setVisible(true);
                dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(422, 467, 132, 46);
		contentPane.add(btnNewButton_1);
		
    	JLabel lblNewLabel_arkaplan = new JLabel(new ImageIcon(getClass().getResource("kütüphane6.png")));
		lblNewLabel_arkaplan.setBounds(0,0, 1024, 550);
		contentPane.add(lblNewLabel_arkaplan);
	}

}
