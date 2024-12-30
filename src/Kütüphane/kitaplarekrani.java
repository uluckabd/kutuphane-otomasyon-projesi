package Kütüphane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class kitaplarekrani extends JFrame {
	
	private JTable kitapTablosu;
	

	public kitaplarekrani() {
        setTitle("Kitap Listesi");
        setBounds(250, 100, 1024, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("kitap adı");
        model.addColumn("Kitap yazarı");
        model.addColumn("basım yılı");
        model.addColumn("stok sayısı");
        model.addColumn("sayfa sayısı");
        model.addColumn("yayınevi");
        

        kitapTablosu = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(kitapTablosu);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        kitaplariGetir(model);
    }

    private void kitaplariGetir(DefaultTableModel model) {
        try (Connection conn = baglanti3.getConnection()) {
            String query = "SELECT * FROM kitap";
            Statement stmt = conn.createStatement();
            ResultSet myRs = stmt.executeQuery(query);

            while (myRs.next()) {
                model.addRow(new Object[]{
                        
                		myRs.getString("kitap_adi"),
                		myRs.getString("kitap_yazarı"),
                		myRs.getString("basım_yılı"),
                		myRs.getInt("stok_sayısı"),
                		myRs.getInt("sayfa_sayısı"),
                		myRs.getString("yayınevi")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Kitaplar yüklenirken bir hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                kitaplarekrani frame = new kitaplarekrani();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}

