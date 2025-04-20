package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageReduction {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page de réduction");
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

     JLabel element5 = new JLabel("Ajout d'une réduction");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#000"));
     panel.add(element5);

     JLabel element8 = new JLabel("Réduction actuelle : ");
     element8.setBounds(170, 148, 167, 26);
     element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element8.setForeground(Color.decode("#000"));
     panel.add(element8);

     JButton element13 = new JButton("Retour");
     element13.setBounds(29, 340, 106, 30);
     element13.setBackground(Color.decode("#bca8e4"));
     element13.setForeground(Color.decode("#000"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element13);

     JLabel element14 = new JLabel("xzy");
     element14.setBounds(359, 150, 107, 25);
     element14.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element14.setForeground(Color.decode("#000"));
     panel.add(element14);

     JLabel element15 = new JLabel("Sélectionner un type de réduction  puis complétez les éléments");
     element15.setBounds(225, 185, 441, 19);
     element15.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element15.setForeground(Color.decode("#000"));
     panel.add(element15);

     JLabel element16 = new JLabel("de configuration de celle-ci.");
     element16.setBounds(225, 207, 369, 19);
     element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element16.setForeground(Color.decode("#000"));
     panel.add(element16);

     JLabel element17 = new JLabel("Type de réduction :");
     element17.setBounds(172, 238, 197, 26);
     element17.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element17.setForeground(Color.decode("#000"));
     panel.add(element17);

     JLabel element20 = new JLabel("🔲 Fixe en €");
     element20.setBounds(224, 275, 106, 18);
     element20.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element20.setForeground(Color.decode("#000"));
     panel.add(element20);

     JLabel element21 = new JLabel("🔲 Pourcentage %");
     element21.setBounds(222, 297, 166, 22);
     element21.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element21.setForeground(Color.decode("#000"));
     panel.add(element21);

     JLabel element22 = new JLabel("Montant ou Pourcentage de réduction :");
     element22.setBounds(167, 332, 313, 24);
     element22.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element22.setForeground(Color.decode("#000"));
     panel.add(element22);

     JTextField element23 = new JTextField("");
     element23.setBounds(480, 329, 106, 24);
     element23.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element23.setBackground(Color.decode("#ffe7bf"));
     element23.setForeground(Color.decode("#73664e"));
     element23.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element23, "remplir", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element23);

     frame.add(panel);
     frame.setVisible(true);

  }
}