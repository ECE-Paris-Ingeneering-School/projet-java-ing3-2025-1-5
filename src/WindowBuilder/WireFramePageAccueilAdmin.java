package WindowBuilder;

import WindowBuilder.helper_classes.*;
import java.awt.*;
import javax.swing.*;

public class WireFramePageAccueilAdmin {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page accueil admin");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#E9DAAF"));

     JPanel Navig_Bar = new JPanel();
     Navig_Bar.setLayout(null);
     Navig_Bar.setBounds(0, 0, 783, 50);
     Navig_Bar.setBackground(Color.decode("#017179"));
     frame.add(Navig_Bar);

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(29, 16, 130, 19);
     element1.setFont(new Font("SansSerif", Font.BOLD, 15));
     //set text color to white
     element1.setForeground(Color.decode("#ffffff"));
     Navig_Bar.add(element1);

     JLabel element2 = new JLabel("EUR");
     element2.setBounds(465, 16, 40, 19);
     element2.setFont(new Font("SansSerif", Font.BOLD, 15));
     element2.setForeground(Color.decode("#ffffff"));
     Navig_Bar.add(element2);

     //Label avec une image d'emoji de france.png
     JLabel element3 = new JLabel(scaleIcon("src/ressources/emojis/fr.png", 20, 20));
     element3.setBounds(500, 15, 20, 20);
     element3.setForeground(Color.decode("#000"));
     Navig_Bar.add(element3);

     ImageIcon emojiIcon = scaleIcon("src/ressources/emojis/hug.png", 20, 20);
     JButton element4 = new JButton("Votre compte", emojiIcon);
     element4.setBounds(600, 6, 150, 40);
     element4.setBackground(Color.decode("#bca8e4"));
     element4.setForeground(Color.decode("#000000"));
     element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element4.setFocusPainted(false);
     element4.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
     element4.setHorizontalTextPosition(SwingConstants.RIGHT);
     OnClickEventHelper.setOnClickColor(element4, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     Navig_Bar.add(element4);

     JLabel element78 = new JLabel("Accueil Admin");
     element78.setBounds(280, 83, 220, 33);
     element78.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element78.setForeground(Color.decode("#000"));
     panel.add(element78);

     JLabel element79 = new JLabel("STATISTIQUES");
     element79.setBounds(41, 144, 178, 30);
     element79.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element79.setForeground(Color.decode("#000"));
     panel.add(element79);

     JLabel element80 = new JLabel("Nombre de clients :");
     element80.setBounds(60, 185, 135, 18);
     element80.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element80.setForeground(Color.decode("#000"));
     panel.add(element80);

     JLabel element81 = new JLabel("Nombre de logements :");
     element81.setBounds(60, 213, 163, 18);
     element81.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element81.setForeground(Color.decode("#000"));
     panel.add(element81);

     JLabel element82 = new JLabel("Moyenne de durée de séjour :");
     element82.setBounds(60, 239, 206, 21);
     element82.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element82.setForeground(Color.decode("#000"));
     panel.add(element82);

     JLabel element83 = new JLabel("Pays d'origine des logements :");
     element83.setBounds(60, 263, 216, 23);
     element83.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element83.setForeground(Color.decode("#000"));
     panel.add(element83);

     JLabel element84 = new JLabel("xxx");
     element84.setBounds(204, 185, 106, 18);
     element84.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element84.setForeground(Color.decode("#000"));
     panel.add(element84);

     JLabel element85 = new JLabel("xxx");
     element85.setBounds(232, 213, 106, 18);
     element85.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element85.setForeground(Color.decode("#000"));
     panel.add(element85);

     JLabel element86 = new JLabel("xxx");
     element86.setBounds(264, 239, 106, 18);
     element86.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element86.setForeground(Color.decode("#000"));
     panel.add(element86);

     JLabel element87 = new JLabel(scaleIcon("src/ressources/emojis/statistiques.png", 150, 48));
     //l'image n'est qu'à titre temporaire. Elle devra être remplacée par un vrai graphe.
     element87.setBounds(103, 296, 150, 48);
     element87.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 27));
     element87.setForeground(Color.decode("#000"));
     panel.add(element87);

     JButton element88 = new JButton("Voir clients");
     element88.setBounds(372, 162, 155, 30);
     element88.setBackground(Color.decode("#bca8e4"));
     element88.setForeground(Color.decode("#000"));
     element88.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element88.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element88.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element88, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element88);

     JButton element89 = new JButton("Modifier logement(s)");
     element89.setBounds(372, 215, 155, 30);
     element89.setBackground(Color.decode("#bca8e4"));
     element89.setForeground(Color.decode("#000"));
     element89.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element89.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element89.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element89, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element89);

     JButton element90 = new JButton("Modifier réduction");
     element90.setBounds(372, 261, 155, 29);
     element90.setBackground(Color.decode("#bca8e4"));
     element90.setForeground(Color.decode("#000"));
     element90.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element90.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element90.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element90, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element90);

     JButton element91 = new JButton("Contactez nous");
     element91.setBounds(627, 340, 125, 30);
     element91.setBackground(Color.decode("#bca8e4"));
     element91.setForeground(Color.decode("#000"));
     element91.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element91.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element91.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element91, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element91);

     frame.add(panel);
     frame.setVisible(true);
  }


   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}