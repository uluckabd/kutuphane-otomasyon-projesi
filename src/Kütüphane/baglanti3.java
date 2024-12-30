package Kütüphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class baglanti3 {
	
	
	       static  String url = "jdbc:mysql://localhost:3306/kütüphane?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
           static String user = "root";
           static String password = "abdulu1458.";
            
        	public static Connection getConnection() {
        		try {
        			return DriverManager.getConnection(url, user, password);
        		}catch(Exception e) {
        			e.printStackTrace();
        			throw new RuntimeException("veritabanı baglantısı basarısız");
        		}
        	}

    public static void main(String[] args) {
        try (Connection myConn = getConnection()){
            System.out.println("Bağlantı başarılı!");

            // Sorgu çalıştır
            String query="SELECT * from kitap";
            Statement myStat = myConn.createStatement();
            ResultSet myRs = myStat.executeQuery("SELECT * FROM kitap");

            // Sonuçları yazdır
            while (myRs.next()) {
                System.out.println(myRs.getString("kitap_adı") + " - " +
                                   myRs.getString("kitap_yazarı") + " - " +
                                   myRs.getString("basım_yılı") + " - "+
                                   myRs.getString("stok_sayısı") +" - "+
                                   myRs.getString("sayfa_sayısı")+ " - "+
                                   myRs.getString("yayınevi")+" - ");
                                   
            }

            // Kaynakları kapat
            myRs.close();
            myStat.close();
            myConn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
