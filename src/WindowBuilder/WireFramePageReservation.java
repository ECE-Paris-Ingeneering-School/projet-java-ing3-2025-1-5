package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageReservation {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#f4c064"));

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(29, 12, 109, 19);
     element1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element1.setForeground(Color.decode("#000"));
     panel.add(element1);

     JLabel element2 = new JLabel("EUR");
     element2.setBounds(465, 18, 40, 19);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 13));
     element2.setForeground(Color.decode("#000"));
     panel.add(element2);

     JLabel element3 = new JLabel("🟦⬜🟥");
     element3.setBounds(508, 16, 68, 22);
     element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element3.setForeground(Color.decode("#000"));
     panel.add(element3);

     JLabel element4 = new JLabel("");
     element4.setBounds(518, 125, 106, 17);
     element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element4.setForeground(Color.decode("#000"));
     panel.add(element4);

     JButton element5 = new JButton("🤗 Votre compte");
     element5.setBounds(612, 12, 144, 34);
     element5.setBackground(Color.decode("#bca8e4"));
     element5.setForeground(Color.decode("#000"));
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element5.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element5.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element5, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element5);

     JLabel element49 = new JLabel("PHOTO");
     element49.setBounds(88, 61, 288, 108);
     element49.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 80));
     element49.setForeground(Color.decode("#000"));
     panel.add(element49);

     JLabel element50 = new JLabel("Description");
     element50.setBounds(95, 169, 106, 18);
     element50.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element50.setForeground(Color.decode("#000"));
     panel.add(element50);

     JLabel element51 = new JLabel("Photo 1");
     element51.setBounds(122, 222, 63, 25);
     element51.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element51.setForeground(Color.decode("#000"));
     panel.add(element51);

     JLabel element52 = new JLabel("Photo 2");
     element52.setBounds(228, 219, 61, 23);
     element52.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element52.setForeground(Color.decode("#000"));
     panel.add(element52);

     JLabel element53 = new JLabel("Photo 3");
     element53.setBounds(342, 223, 58, 18);
     element53.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element53.setForeground(Color.decode("#000"));
     panel.add(element53);

     JLabel element54 = new JLabel("Photo 4");
     element54.setBounds(118, 273, 106, 18);
     element54.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element54.setForeground(Color.decode("#000"));
     panel.add(element54);

     JLabel element55 = new JLabel("Photo 5");
     element55.setBounds(227, 271, 106, 18);
     element55.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element55.setForeground(Color.decode("#000"));
     panel.add(element55);

     JLabel element56 = new JLabel("Photo 6");
     element56.setBounds(341, 278, 106, 18);
     element56.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element56.setForeground(Color.decode("#000"));
     panel.add(element56);

     JLabel element57 = new JLabel("Photo 7");
     element57.setBounds(118, 330, 106, 18);
     element57.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element57.setForeground(Color.decode("#000"));
     panel.add(element57);

     JLabel element58 = new JLabel("Photo 8");
     element58.setBounds(227, 331, 106, 18);
     element58.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element58.setForeground(Color.decode("#000"));
     panel.add(element58);

     JLabel element59 = new JLabel("Photo 9");
     element59.setBounds(342, 325, 106, 18);
     element59.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element59.setForeground(Color.decode("#000"));
     panel.add(element59);

     JLabel element60 = new JLabel("Propriétaire");
     element60.setBounds(511, 90, 139, 28);
     element60.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element60.setForeground(Color.decode("#000"));
     panel.add(element60);

     JLabel element61 = new JLabel("Dates");
     element61.setBounds(512, 133, 106, 18);
     element61.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element61.setForeground(Color.decode("#000"));
     panel.add(element61);

     JButton element62 = new JButton("Réserver");
     element62.setBounds(630, 277, 116, 34);
     element62.setBackground(Color.decode("#bca8e4"));
     element62.setForeground(Color.decode("#000"));
     element62.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element62.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element62.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element62, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element62);

     JButton element63 = new JButton("Contactez nous ");
     element63.setBounds(609, 341, 136, 28);
     element63.setBackground(Color.decode("#bca8e4"));
     element63.setForeground(Color.decode("#000"));
     element63.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element63.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element63.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element63, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element63);

     JLabel element64 = new JLabel("📅");
     element64.setBounds(581, 120, 151, 144);
     element64.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 100));
     element64.setForeground(Color.decode("#000"));
     panel.add(element64);

     frame.add(panel);
     frame.setVisible(true);

  }
}