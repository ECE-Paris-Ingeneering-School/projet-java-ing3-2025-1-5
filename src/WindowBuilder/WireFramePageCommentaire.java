package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageCommentaire {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page commentaire");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#f4c064"));

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(18, 13, 199, 30);
     element1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element1.setForeground(Color.decode("#000"));
     panel.add(element1);

     JLabel element2 = new JLabel("EUR");
     element2.setBounds(393, 24, 36, 19);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element2.setForeground(Color.decode("#000"));
     panel.add(element2);

     JLabel element3 = new JLabel("🟦⬜🟥");
     element3.setBounds(453, 23, 106, 18);
     element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element3.setForeground(Color.decode("#000"));
     panel.add(element3);

     JButton element4 = new JButton("🤗 Votre compte");
     element4.setBounds(589, 11, 171, 38);
     element4.setBackground(Color.decode("#bca8e4"));
     element4.setForeground(Color.decode("#000"));
     element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element4.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element4.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element4, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element4);

     JLabel element5 = new JLabel("Ajout de commentaire");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#000"));
     panel.add(element5);

     JLabel element8 = new JLabel("Etoiles : 🎀 🎀 🎀 🎀 🎀");
     element8.setBounds(170, 148, 222, 25);
     element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element8.setForeground(Color.decode("#000"));
     panel.add(element8);

     JButton element13 = new JButton("Publier");
     element13.setBounds(329, 338, 106, 30);
     element13.setBackground(Color.decode("#bca8e4"));
     element13.setForeground(Color.decode("#000"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element13);

     JTextArea element24 = new JTextArea("");
     element24.setBounds(170, 190, 434, 106);
     element24.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element24.setBackground(Color.decode("#ffe7bf"));
     element24.setForeground(Color.decode("#73664e"));
     element24.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element24, "Commentaire :", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element24);

     JButton element25 = new JButton("Contactez nous");
     element25.setBounds(-212, -123, 149, 35);
     element25.setBackground(Color.decode("#bca8e4"));
     element25.setForeground(Color.decode("#000"));
     element25.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element25.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element25.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element25, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element25);

     JButton element26 = new JButton("Contactez nous");
     element26.setBounds(626, 337, 139, 31);
     element26.setBackground(Color.decode("#bca8e4"));
     element26.setForeground(Color.decode("#000"));
     element26.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element26.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element26.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element26, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element26);

     frame.add(panel);
     frame.setVisible(true);

  }
}