package Kütüphane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class yoneticimenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yoneticimenu frame = new yoneticimenu();
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
	public yoneticimenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1024, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204, 255, 255)); // Açık mavi

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YÖNETİCİ MENÜ");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(368, 36, 270, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("KİTAPLARI LİSTELE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kitaplarekrani kitaplarEkrani = new kitaplarekrani();
	            kitaplarEkrani.setVisible(true);
			}
		});
		btnNewButton.setBounds(207, 70, 169, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÜYELERİ LİSTELE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        try {
		            // Yeni bir JFrame açarak üyeleri listele
		            JFrame uyeListeFrame = new JFrame("Üyeleri Listele");
		            uyeListeFrame.setBounds(250, 100, 1024, 550);
		            uyeListeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            JPanel panel = new JPanel();
		            panel.setLayout(new BorderLayout());
		            uyeListeFrame.getContentPane().add(panel);

		            // Veritabanı bağlantısı
		            Connection conn = baglanti.getConnection();
		            String query = "SELECT * FROM üyeler"; // Üye tablosu sorgusu
		            PreparedStatement pstmt = conn.prepareStatement(query);
		            ResultSet rs = pstmt.executeQuery();

		            // JTable ve DefaultTableModel oluşturma
		            String[] columnNames = { "Ad", "Soyad", "şifre"};
		            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		            // Veritabanı sonuçlarını tabloya ekleme
		            while (rs.next()) {
		                
		                String ad = rs.getString("üye_adı");
		                String soyad = rs.getString("üye_soyadı");
		                String telefon = rs.getString("üye_numarası");
		               
		                model.addRow(new Object[]{ ad, soyad, telefon});
		            }

		            // JTable'i modele bağlama
		            JTable table = new JTable(model);
		            JScrollPane scrollPane = new JScrollPane(table);
		            panel.add(scrollPane, BorderLayout.CENTER);

		            // Yeni pencereyi görünür yap
		            uyeListeFrame.setVisible(true);

		            // Bağlantıyı kapat
		            rs.close();
		            pstmt.close();
		            conn.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Veritabanı hatası!", "Hata", JOptionPane.ERROR_MESSAGE);
		        }
				
				
				
			}
		});
		btnNewButton_1.setBounds(626, 70, 150, 31);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("KİTAP EKLE");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.setForeground(new Color(160, 82, 45));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame kitapEkleFrame = new JFrame("Kitap Ekle");
		        kitapEkleFrame.setBounds(250, 100, 1024, 550);
		        kitapEkleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        kitapEkleFrame.getContentPane().setLayout(null);

		        // Kitap Adı etiket ve metin alanı
		        JLabel kitapAdiLabel = new JLabel("Kitap Adı:");
		        kitapAdiLabel.setBounds(50, 50, 100, 25);
		        kitapEkleFrame.getContentPane().add(kitapAdiLabel);

		        JTextField kitapAdiField = new JTextField();
		        kitapAdiField.setBounds(150, 50, 200, 25);
		        kitapEkleFrame.getContentPane().add(kitapAdiField);

		        // Kitap Yazarı etiket ve metin alanı
		        JLabel kitapYazariLabel = new JLabel("Kitap Yazarı:");
		        kitapYazariLabel.setBounds(50, 100, 100, 25);
		        kitapEkleFrame.getContentPane().add(kitapYazariLabel);

		        JTextField kitapYazariField = new JTextField();
		        kitapYazariField.setBounds(150, 100, 200, 25);
		        kitapEkleFrame.getContentPane().add(kitapYazariField);

		        // Basım Yılı etiket ve metin alanı
		        JLabel basimYiliLabel = new JLabel("Basım Yılı:");
		        basimYiliLabel.setBounds(50, 150, 100, 25);
		        kitapEkleFrame.getContentPane().add(basimYiliLabel);

		        JTextField basimYiliField = new JTextField();
		        basimYiliField.setBounds(150, 150, 200, 25);
		        kitapEkleFrame.getContentPane().add(basimYiliField);

		        // Stok Sayısı etiket ve metin alanı
		        JLabel stokSayisiLabel = new JLabel("Stok Sayısı:");
		        stokSayisiLabel.setBounds(50, 200, 100, 25);
		        kitapEkleFrame.getContentPane().add(stokSayisiLabel);

		        JTextField stokSayisiField = new JTextField();
		        stokSayisiField.setBounds(150, 200, 200, 25);
		        kitapEkleFrame.getContentPane().add(stokSayisiField);

		        // Sayfa Sayısı etiket ve metin alanı
		        JLabel sayfaSayisiLabel = new JLabel("Sayfa Sayısı:");
		        sayfaSayisiLabel.setBounds(50, 250, 100, 25);
		        kitapEkleFrame.getContentPane().add(sayfaSayisiLabel);

		        JTextField sayfaSayisiField = new JTextField();
		        sayfaSayisiField.setBounds(150, 250, 200, 25);
		        kitapEkleFrame.getContentPane().add(sayfaSayisiField);

		        // Yayınevi etiket ve metin alanı
		        JLabel yayineviLabel = new JLabel("Yayınevi:");
		        yayineviLabel.setBounds(50, 300, 100, 25);
		        kitapEkleFrame.getContentPane().add(yayineviLabel);

		        JTextField yayineviField = new JTextField();
		        yayineviField.setBounds(150, 300, 200, 25);
		        kitapEkleFrame.getContentPane().add(yayineviField);

		        // Ekleme butonu
		        JButton ekleButton = new JButton("Ekle");
		        ekleButton.setBounds(150, 330, 100, 30);
		        kitapEkleFrame.getContentPane().add(ekleButton);
		        
		        JButton geriButton = new JButton("vazgeç");
		        geriButton.setBounds(250, 330, 100, 30);
		        kitapEkleFrame.getContentPane().add(geriButton);
		        
		        
		        
		        geriButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                kitapEkleFrame.dispose(); // Mevcut pencereyi kapat
		                // YoneticiMenu penceresini aç
		                yoneticimenu yoneticiMenu = new yoneticimenu();
		                yoneticiMenu.setVisible(true);
		            }
		        });
		        
		        

		        // Ekleme işlemi
		        ekleButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String kitapAdi = kitapAdiField.getText().trim();
		                String kitapYazari = kitapYazariField.getText().trim();
		                String basimYili = basimYiliField.getText().trim();
		                String stokSayisi = stokSayisiField.getText().trim();
		                String sayfaSayisi = sayfaSayisiField.getText().trim();
		                String yayinevi = yayineviField.getText().trim();

		                if (kitapAdi.isEmpty() || kitapYazari.isEmpty() || basimYili.isEmpty() || stokSayisi.isEmpty() || sayfaSayisi.isEmpty() || yayinevi.isEmpty()) {
		                    JOptionPane.showMessageDialog(kitapEkleFrame, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }

		                try {
		                    // Veritabanı bağlantısı
		                    Connection conn = baglanti3.getConnection();

		                    // Kitap ekleme için SQL sorgusu
		                    String query = "INSERT INTO kitap (kitap_adı, kitap_yazarı, basım_yılı, stok_sayısı, sayfa_sayısı, yayınevi) VALUES (?, ?, ?, ?, ?, ?)";
		                    PreparedStatement pstmt = conn.prepareStatement(query);

		                    // Parametreleri ayarla
		                    pstmt.setString(1, kitapAdi);
		                    pstmt.setString(2, kitapYazari);
		                    pstmt.setInt(3, Integer.parseInt(basimYili));
		                    pstmt.setInt(4, Integer.parseInt(stokSayisi));
		                    pstmt.setInt(5, Integer.parseInt(sayfaSayisi));
		                    pstmt.setString(6, yayinevi);

		                    // Sorguyu çalıştır
		                    int result = pstmt.executeUpdate();

		                    if (result > 0) {
		                        JOptionPane.showMessageDialog(kitapEkleFrame, "Kitap başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
		                        kitapAdiField.setText("");
		                        kitapYazariField.setText("");
		                        basimYiliField.setText("");
		                        stokSayisiField.setText("");
		                        sayfaSayisiField.setText("");
		                        yayineviField.setText("");
		                    } else {
		                        JOptionPane.showMessageDialog(kitapEkleFrame, "Kitap eklenemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
		                    }

		                    // Kaynakları kapat
		                    pstmt.close();
		                    conn.close();

		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(kitapEkleFrame, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        });

		        // Pencereyi görünür yap
		        kitapEkleFrame.setVisible(true);
		        
	     
			}
		});
		
		
		btnNewButton_2.setBounds(207, 131, 169, 31);
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_3 = new JButton("KİTAP SİL");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBackground(new Color(224, 255, 255));
		btnNewButton_3.setForeground(new Color(160, 82, 45));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        JFrame kitapSilFrame = new JFrame("Kitap Sil");
		        kitapSilFrame.setBounds(250, 100, 1024, 550);
		        kitapSilFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        kitapSilFrame.getContentPane().setLayout(null);

		        // Kitap Adı etiket ve metin alanı
		        JLabel kitapAdiLabel = new JLabel("Kitap Adı:");
		        kitapAdiLabel.setBounds(50, 50, 100, 25);
		        kitapSilFrame.getContentPane().add(kitapAdiLabel);

		        JTextField kitapAdiField = new JTextField();
		        kitapAdiField.setBounds(150, 50, 200, 25);
		        kitapSilFrame.getContentPane().add(kitapAdiField);

		        // Kitap Yazarı etiket ve metin alanı
		        JLabel kitapYazariLabel = new JLabel("Kitap Yazarı:");
		        kitapYazariLabel.setBounds(50, 100, 100, 25);
		        kitapSilFrame.getContentPane().add(kitapYazariLabel);

		        JTextField kitapYazariField = new JTextField();
		        kitapYazariField.setBounds(150, 100, 200, 25);
		        kitapSilFrame.getContentPane().add(kitapYazariField);

		        // Basım Yılı etiket ve metin alanı
		        JLabel basimYiliLabel = new JLabel("Basım Yılı:");
		        basimYiliLabel.setBounds(50, 150, 100, 25);
		        kitapSilFrame.getContentPane().add(basimYiliLabel);

		        JTextField basimYiliField = new JTextField();
		        basimYiliField.setBounds(150, 150, 200, 25);
		        kitapSilFrame.getContentPane().add(basimYiliField);

		        // Stok Sayısı etiket ve metin alanı
		        JLabel stokSayisiLabel = new JLabel("Stok Sayısı:");
		        stokSayisiLabel.setBounds(50, 200, 100, 25);
		        kitapSilFrame.getContentPane().add(stokSayisiLabel);

		        JTextField stokSayisiField = new JTextField();
		        stokSayisiField.setBounds(150, 200, 200, 25);
		        kitapSilFrame.getContentPane().add(stokSayisiField);

		        // Sayfa Sayısı etiket ve metin alanı
		        JLabel sayfaSayisiLabel = new JLabel("Sayfa Sayısı:");
		        sayfaSayisiLabel.setBounds(50, 250, 100, 25);
		        kitapSilFrame.getContentPane().add(sayfaSayisiLabel);

		        JTextField sayfaSayisiField = new JTextField();
		        sayfaSayisiField.setBounds(150, 250, 200, 25);
		        kitapSilFrame.getContentPane().add(sayfaSayisiField);

		        // Yayınevi etiket ve metin alanı
		        JLabel yayineviLabel = new JLabel("Yayınevi:");
		        yayineviLabel.setBounds(50, 300, 100, 25);
		        kitapSilFrame.getContentPane().add(yayineviLabel);

		        JTextField yayineviField = new JTextField();
		        yayineviField.setBounds(150, 300, 200, 25);
		        kitapSilFrame.getContentPane().add(yayineviField);

		        // Silme butonu
		        JButton silButton = new JButton("Sil");
		        silButton.setBounds(150, 330, 100, 30);
		        kitapSilFrame.getContentPane().add(silButton);
		        
		        JButton geriButton = new JButton("vazgeç");
		        geriButton.setBounds(250, 330, 100, 30);
		        kitapSilFrame.getContentPane().add(geriButton);
		        
		        geriButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                kitapSilFrame.dispose(); // Mevcut pencereyi kapat
		                // YoneticiMenu penceresini aç
		                yoneticimenu yoneticiMenu = new yoneticimenu();
		                yoneticiMenu.setVisible(true);
		            }
		        });

		        // Silme işlemi
		        silButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String kitapAdi = kitapAdiField.getText().trim();
		                String kitapYazari = kitapYazariField.getText().trim();
		                String basimYili = basimYiliField.getText().trim();
		                String stokSayisi = stokSayisiField.getText().trim();
		                String sayfaSayisi = sayfaSayisiField.getText().trim();
		                String yayinevi = yayineviField.getText().trim();

		                if (kitapAdi.isEmpty() || kitapYazari.isEmpty() || basimYili.isEmpty() || stokSayisi.isEmpty() || sayfaSayisi.isEmpty() || yayinevi.isEmpty()) {
		                    JOptionPane.showMessageDialog(kitapSilFrame, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }

		                try {
		                    // Veritabanı bağlantısı
		                    Connection conn = baglanti.getConnection();

		                    // Silme için SQL sorgusu
		                    String query = "DELETE FROM kitap WHERE kitap_adı = ? AND kitap_yazarı = ? AND basım_yılı = ? AND stok_sayısı = ? AND sayfa_sayısı = ? AND yayınevi = ?";
		                    PreparedStatement pstmt = conn.prepareStatement(query);

		                    // Parametreleri bağla
		                    pstmt.setString(1, kitapAdi);
		                    pstmt.setString(2, kitapYazari);
		                    pstmt.setInt(3, Integer.parseInt(basimYili));
		                    pstmt.setInt(4, Integer.parseInt(stokSayisi));
		                    pstmt.setInt(5, Integer.parseInt(sayfaSayisi));
		                    pstmt.setString(6, yayinevi);

		                    // Sorguyu çalıştır
		                    int result = pstmt.executeUpdate();

		                    if (result > 0) {
		                        JOptionPane.showMessageDialog(kitapSilFrame, "Kitap başarıyla silindi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
		                        kitapAdiField.setText("");
		                        kitapYazariField.setText("");
		                        basimYiliField.setText("");
		                        stokSayisiField.setText("");
		                        sayfaSayisiField.setText("");
		                        yayineviField.setText("");
		                    } else {
		                        JOptionPane.showMessageDialog(kitapSilFrame, "Belirtilen kitap bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
		                    }

		                    // Kaynakları kapat
		                    pstmt.close();
		                    conn.close();

		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(kitapSilFrame, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        });

		        // Pencereyi görünür yap
		        kitapSilFrame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(626, 131, 150, 31);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ÜYE EKLE");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setBackground(new Color(224, 255, 255));
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFrame uyeEkleFrame = new JFrame("Üye Ekle");
			        uyeEkleFrame.setBounds(250, 100, 1024, 550);
			        uyeEkleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        uyeEkleFrame.getContentPane().setLayout(null);
			        
			        

			        // Ad etiket ve metin alanı
			        JLabel adLabel = new JLabel("Ad:");
			        adLabel.setBounds(50, 50, 100, 25);
			        uyeEkleFrame.getContentPane().add(adLabel);

			        JTextField adField = new JTextField();
			        adField.setBounds(150, 50, 200, 25);
			        uyeEkleFrame.getContentPane().add(adField);

			        // Soyad etiket ve metin alanı
			        JLabel soyadLabel = new JLabel("Soyad:");
			        soyadLabel.setBounds(50, 100, 100, 25);
			        uyeEkleFrame.getContentPane().add(soyadLabel);

			        JTextField soyadField = new JTextField();
			        soyadField.setBounds(150, 100, 200, 25);
			        uyeEkleFrame.getContentPane().add(soyadField);

			        // Şifre etiket ve metin alanı
			        JLabel sifreLabel = new JLabel("Şifre:");
			        sifreLabel.setBounds(50, 150, 100, 25);
			        uyeEkleFrame.getContentPane().add(sifreLabel);

			        JTextField sifreField = new JTextField();
			        sifreField.setBounds(150, 150, 200, 25);
			        uyeEkleFrame.getContentPane().add(sifreField);

			        // Ekle butonu
			        JButton ekleButton = new JButton("Ekle");
			        ekleButton.setBounds(150, 200, 100, 30);
			        uyeEkleFrame.getContentPane().add(ekleButton);
			        
			        JButton geriButton = new JButton("Geri");
			        geriButton.setBounds(270, 200, 100, 30);
			        uyeEkleFrame.getContentPane().add(geriButton);
			        
			        geriButton.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                uyeEkleFrame.dispose(); // Mevcut pencereyi kapat
			                // YoneticiMenu penceresini aç
			                yoneticimenu yoneticiMenu = new yoneticimenu();
			                yoneticiMenu.setVisible(true);
			            }
			        });
			     

			        // Butonun işleyicisi
			        ekleButton.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                String uyeAdi = adField.getText().trim();
			                String uyeSoyadi = soyadField.getText().trim();
			                String uyeSifre = sifreField.getText().trim();

			                if (uyeAdi.isEmpty() || uyeSoyadi.isEmpty() || uyeSifre.isEmpty()) {
			                    JOptionPane.showMessageDialog(uyeEkleFrame, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
			                    return;
			                }

			                try {
			                    // Veritabanı bağlantısı
			                    Connection conn = baglanti.getConnection();

			                    // Ekleme işlemi için SQL sorgusu
			                    String query = "INSERT INTO üyeler (üye_adı, üye_soyadı, üye_numarası) VALUES (?, ?, ?)";
			                    PreparedStatement pstmt = conn.prepareStatement(query);

			                    // Parametreleri sorguya bağla
			                    pstmt.setString(1, uyeAdi);
			                    pstmt.setString(2, uyeSoyadi);
			                    pstmt.setString(3, uyeSifre);

			                    // Sorguyu çalıştır
			                    int result = pstmt.executeUpdate();

			                    if (result > 0) {
			                        JOptionPane.showMessageDialog(uyeEkleFrame, "Üye başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
			                        // Alanları temizle
			                        adField.setText("");
			                        soyadField.setText("");
			                        sifreField.setText("");
			                    } else {
			                        JOptionPane.showMessageDialog(uyeEkleFrame, "Üye eklenemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
			                    }

			                    // Kaynakları kapat
			                    pstmt.close();
			                    conn.close();

			                } catch (Exception ex) {
			                    ex.printStackTrace();
			                    JOptionPane.showMessageDialog(uyeEkleFrame, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        });

			        // Pencereyi görünür yap
			        uyeEkleFrame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(207, 191, 169, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ÜYE SİL");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.setBackground(new Color(224, 255, 255));
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFrame uyeSilFrame = new JFrame("Üye Sil");
		        uyeSilFrame.setBounds(250, 100, 1024, 550);
		        uyeSilFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        uyeSilFrame.getContentPane().setLayout(null);

		        // Ad etiket ve metin alanı
		        JLabel adLabel = new JLabel("Ad:");
		        adLabel.setBounds(50, 50, 100, 25);
		        uyeSilFrame.getContentPane().add(adLabel);

		        JTextField adField = new JTextField();
		        adField.setBounds(150, 50, 200, 25);
		        uyeSilFrame.getContentPane().add(adField);

		        // Soyad etiket ve metin alanı
		        JLabel soyadLabel = new JLabel("Soyad:");
		        soyadLabel.setBounds(50, 100, 100, 25);
		        uyeSilFrame.getContentPane().add(soyadLabel);

		        JTextField soyadField = new JTextField();
		        soyadField.setBounds(150, 100, 200, 25);
		        uyeSilFrame.getContentPane().add(soyadField);

		        // Şifre etiket ve metin alanı
		        JLabel sifreLabel = new JLabel("Şifre:");
		        sifreLabel.setBounds(50, 150, 100, 25);
		        uyeSilFrame.getContentPane().add(sifreLabel);

		        JTextField sifreField = new JTextField();
		        sifreField.setBounds(150, 150, 200, 25);
		        uyeSilFrame.getContentPane().add(sifreField);

		        // Silme butonu
		        JButton silButton = new JButton("Sil");
		        silButton.setBounds(150, 200, 100, 30);
		        uyeSilFrame.getContentPane().add(silButton);
		        
		        JButton geriButton = new JButton("Geri");
		        geriButton.setBounds(270, 200, 100, 30);
		        uyeSilFrame.getContentPane().add(geriButton);
		        
		        geriButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                uyeSilFrame.dispose(); // Mevcut pencereyi kapat
		                // YoneticiMenu penceresini aç
		                yoneticimenu yoneticiMenu = new yoneticimenu();
		                yoneticiMenu.setVisible(true);
		            }
		        });

		        // Butonun işleyicisi
		        silButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String uyeAdi = adField.getText().trim();
		                String uyeSoyadi = soyadField.getText().trim();
		                String uyeSifre = sifreField.getText().trim();

		                if (uyeAdi.isEmpty() || uyeSoyadi.isEmpty() || uyeSifre.isEmpty()) {
		                    JOptionPane.showMessageDialog(uyeSilFrame, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }

		                try {
		                    // Veritabanı bağlantısı
		                    Connection conn = baglanti.getConnection();

		                    // Silme işlemi için SQL sorgusu
		                    String query = "DELETE FROM üyeler WHERE üye_adı = ? AND üye_soyadı = ? AND üye_numarası = ?";
		                    PreparedStatement pstmt = conn.prepareStatement(query);

		                    // Parametreleri sorguya bağla
		                    pstmt.setString(1, uyeAdi);
		                    pstmt.setString(2, uyeSoyadi);
		                    pstmt.setString(3, uyeSifre);

		                    // Sorguyu çalıştır ve etkilenen satır sayısını kontrol et
		                    int result = pstmt.executeUpdate();

		                    if (result > 0) {
		                        JOptionPane.showMessageDialog(uyeSilFrame, "Üye başarıyla silindi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
		                        // Pencereyi kapat
		                        uyeSilFrame.dispose();
		                    } else {
		                        JOptionPane.showMessageDialog(uyeSilFrame, "Belirtilen üye bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
		                    }

		                    // Kaynakları kapat
		                    pstmt.close();
		                    conn.close();

		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(uyeSilFrame, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        });

		        // Pencereyi görünür yap
		        uyeSilFrame.setVisible(true);
		    }
		});
		btnNewButton_5.setBounds(626, 191, 150, 31);
		contentPane.add(btnNewButton_5);
	
		
		JButton çıkış = new JButton("ÇIKIŞ");
		çıkış.setFont(new Font("Tahoma", Font.BOLD, 10));
		çıkış.setBackground(new Color(224, 255, 255));
		çıkış.setForeground(new Color(0, 0, 0));
		çıkış.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        yoneticimenu yoneticimenu = new yoneticimenu();
				yoneticimenu.dispose(); // Mevcut pencereyi kapat
		        // Yeni ana menü penceresi oluştur ve görünür yap
		        anamenu anaMenu = new anamenu();
		        anaMenu.setVisible(true);
		    }
		});
		çıkış.setBounds(402, 465, 150, 38); // Butonun konumunu ve boyutunu belirler
		contentPane.add(çıkış);
		
		
		JLabel lblNewLabel_arkaplan = new JLabel(new ImageIcon(getClass().getResource("kütüphane4.jpg")));
		lblNewLabel_arkaplan.setBounds(0,0, 1024, 550);
		contentPane.add(lblNewLabel_arkaplan);
		
		
}
}




		
