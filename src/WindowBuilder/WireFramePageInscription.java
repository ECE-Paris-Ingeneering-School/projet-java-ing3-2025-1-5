package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageInscription {
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

     JTextField element42 = new JTextField("");
     element42.setBounds(305, 110, 165, 36);
     element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element42.setBackground(Color.decode("#ffe7bf"));
     element42.setForeground(Color.decode("#73664e"));
     element42.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element42, "Nom", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element42);

     JPasswordField element44 = new JPasswordField("");
     element44.setBounds(306, 155, 165, 24);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element44.setBackground(Color.decode("#ffe7bf"));
     element44.setForeground(Color.decode("#73664e"));
     element44.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element44, "Prénom", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element44);

     JButton element45 = new JButton("Inscription");
     element45.setBounds(307, 258, 167, 44);
     element45.setBackground(Color.decode("#bca8e4"));
     element45.setForeground(Color.decode("#000"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element45);

     JTextField element48 = new JTextField("");
     element48.setBounds(306, 201, 165, 24);
     element48.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element48.setBackground(Color.decode("#ffe7bf"));
     element48.setForeground(Color.decode("#73664e"));
     element48.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element48, "Mail", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element48);

     JButton element49 = new JButton("Contactez nous");
     element49.setBounds(614, 337, 141, 35);
     element49.setBackground(Color.decode("#bca8e4"));
     element49.setForeground(Color.decode("#000"));
     element49.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element49.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element49.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element49, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element49);

     frame.add(panel);
     frame.setVisible(true);

  }
}