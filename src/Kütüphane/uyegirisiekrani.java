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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class uyegirisiekrani extends JFrame {

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
					uyegirisiekrani frame = new uyegirisiekrani();
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
	public uyegirisiekrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1024, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ÜYE GİRİŞ EKRANI");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(376, 31, 288, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADINIZI GİRİNİZ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(188, 82, 99, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SOYADINIZI GİRİNİZ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(172, 118, 125, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ŞİFRENİZİ GİRİNİZ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(172, 154, 136, 26);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(317, 86, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 122, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 158, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("GİRİŞ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
		                String ad = textField.getText();
		                String soyad = textField_1.getText();
		                String sifre = textField_2.getText();

		                try {
		                    // MySQL bağlantısı
		                    Connection con = baglanti.getConnection();
		                    String query = "SELECT * FROM üyeler WHERE üye_adı = ? AND üye_soyadı = ? AND üye_numarası = ?";
		                    PreparedStatement pst = con.prepareStatement(query);
		                    pst.setString(1, ad);
		                    pst.setString(2, soyad);
		                    pst.setString(3, sifre);

		                    ResultSet rs = pst.executeQuery();
		                    if (rs.next()) {
		                        JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
		                        uyemenu uyemenu = new uyemenu();
		                        uyemenu.setVisible(true);
		                        dispose(); // Bu pencereyi kapat
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Giriş Başarısız!");
		                    }
		                    con.close();
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "Bir hata oluştu: " + ex.getMessage());
		                }
		
	               
			}
		});
		btnNewButton.setBounds(619, 87, 96, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("GERİ DÖN");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anamenu anamenu = new anamenu(); 
                anamenu.setVisible(true);       
                dispose(); 
				
			}
		});
		btnNewButton_2.setBounds(619, 146, 96, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_arkaplan = new JLabel(new ImageIcon(getClass().getResource("kütüphane4.jpg")));
		lblNewLabel_arkaplan.setBounds(0,0, 1024, 550);
		contentPane.add(lblNewLabel_arkaplan);
	}
}

	
		
		
		
		
		
		
		
		
		
		
		