package Kütüphane;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        // Resmi yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("resim/kütüphane3.jpg")).getImage();
        } catch (Exception e) {
            System.err.println("Resim yüklenemedi: " + imagePath);
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Resmi çiz
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}