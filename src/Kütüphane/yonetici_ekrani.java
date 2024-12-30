package Kütüphane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class yonetici_ekrani extends JFrame {

    public yonetici_ekrani() {
    	
    	
        setTitle("Yönetici Girişi");
        setBounds(250, 100, 1024, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Başlık etiketi
        JLabel lblTitle = new JLabel("YÖNETİCİ GİRİŞ EKRANI");
        lblTitle.setForeground(new Color(95, 158, 160));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(lblTitle, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        // Ad etiketi ve metin kutusu
        JLabel lblAd = new JLabel("YÖNETİCİ ADI");
        lblAd.setHorizontalAlignment(SwingConstants.CENTER);
        lblAd.setBounds(288, 96, 87, 26);
        panel.add(lblAd);

        JTextField txtAd = new JTextField();
        txtAd.setBounds(417, 99, 150, 22);
        panel.add(txtAd);

        // Soyad etiketi ve metin kutusu
        JLabel lblSoyad = new JLabel("YÖNETİCİ SOYADI");
        lblSoyad.setBounds(288, 177, 119, 25);
        panel.add(lblSoyad);

        JTextField txtSoyad = new JTextField();
        txtSoyad.setBounds(417, 177, 150, 25);
        panel.add(txtSoyad);

        // Şifre etiketi ve şifre alanı
        JLabel lblPassword = new JLabel("ŞİFRE");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(275, 253, 100, 25);
        panel.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(417, 253, 150, 25);
        panel.add(txtPassword);

        // Giriş yap butonu
        JButton btnLogin = new JButton("Giriş Yap");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(210, 105, 30));
        btnLogin.setBounds(436, 323, 100, 30);
        panel.add(btnLogin);

        // Geri Dön butonu
        JButton btnGeriDon = new JButton("Geri Dön");
        btnGeriDon.setBackground(new Color(255, 0, 0));
        btnGeriDon.setBounds(436, 382, 100, 30);
        panel.add(btnGeriDon);
        
		

        // Giriş butonu dinleyicisi
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin_adi = txtAd.getText();
                String admin_soyadi = txtSoyad.getText();
                String admin_no = new String(txtPassword.getPassword());
                if (yoneticiDogrula(admin_adi, admin_soyadi, admin_no)) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    yoneticimenu yoneticiMenu = new yoneticimenu(); 
                    yoneticiMenu.setVisible(true); 
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız! Bilgilerinizi kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Geri Dön butonu dinleyicisi
        btnGeriDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anamenu anaMenu = new anamenu();
                anaMenu.setVisible(true);
                dispose();
            }
        });
    }

    // Yönetici doğrulama
    private boolean yoneticiDogrula(String admin_adı, String admin_soyadı, String admin_no) {
    	
    	if (admin_adı.isEmpty() || admin_soyadı.isEmpty() || admin_no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tüm alanları doldurmanız gerekiyor!", "Hata", JOptionPane.WARNING_MESSAGE);
            return false;}
    	
        try (Connection conn = baglanti2.getConnection()) {
            String query = "SELECT * FROM admin WHERE admin_adı = ? AND admin_soyadı = ? AND admin_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, admin_adı);
            pstmt.setString(2, admin_soyadı);
            pstmt.setString(3, admin_no);

            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Eğer kayıt varsa true döner
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Veritabanı hatası!", "Hata", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                yonetici_ekrani frame = new yonetici_ekrani();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
   
    }
    
    
}