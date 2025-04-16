package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageConnexion {
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
     element42.setBounds(307, 131, 165, 36);
     element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element42.setBackground(Color.decode("#ffe7bf"));
     element42.setForeground(Color.decode("#73664e"));
     element42.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element42, "Login", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element42);

     JPasswordField element44 = new JPasswordField("");
     element44.setBounds(307, 185, 165, 24);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element44.setBackground(Color.decode("#ffe7bf"));
     element44.setForeground(Color.decode("#73664e"));
     element44.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element44, "Mot de passe", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element44);

     JButton element45 = new JButton("Connexion");
     element45.setBounds(307, 243, 167, 44);
     element45.setBackground(Color.decode("#bca8e4"));
     element45.setForeground(Color.decode("#000"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element45);

     JLabel element46 = new JLabel("Pas de compte ? Créer un compte !");
     element46.setBounds(273, 296, 258, 21);
     element46.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element46.setForeground(Color.decode("#000"));
     panel.add(element46);

     JButton element47 = new JButton("Contactez nous");
     element47.setBounds(614, 337, 141, 35);
     element47.setBackground(Color.decode("#bca8e4"));
     element47.setForeground(Color.decode("#000"));
     element47.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element47.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element47.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element47, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element47);

     frame.add(panel);
     frame.setVisible(true);

  }
}