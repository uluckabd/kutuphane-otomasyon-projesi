package Kütüphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class baglanti {
	static  String url = "jdbc:mysql://localhost:3306/kütüphane?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
    static  String user = "root";
    static  String password = "abdulu1458.";
     
 	public static Connection getConnection() {
 		try {
 			return DriverManager.getConnection(url, user, password);
 		}catch(Exception e) {
 			e.printStackTrace();
 			throw new RuntimeException("veritabanı baglantısı basarısız");
 		}
 	}

    public static void main(String[] args) {
        try {
            // JDBC sürücüsünü yükle
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // Bağlantı bilgileri
            

            // Veritabanına bağlan
            Connection myConn = DriverManager.getConnection(url, user, password);
            System.out.println("Bağlantı başarılı!");

            // Sorgu çalıştır
            Statement myStat = myConn.createStatement();
            ResultSet myRs = myStat.executeQuery("SELECT * FROM üyeler");

            // Sonuçları yazdır
            while (myRs.next()) {
                System.out.println(myRs.getString("üye_adı") + " - " +
                                   myRs.getString("üye_soyadı") + " - " +
                                   myRs.getString("üye_numarası") + " - ");
                                   
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
