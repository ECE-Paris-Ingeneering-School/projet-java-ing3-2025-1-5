package MVC.vue;

import javax.swing.*;
import java.awt.*;

import MVC.vue.helper_classes.*;

public class WireFramePageCommentaire {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page commentaire");
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
     JLabel element3 = new JLabel(scaleIcon("src/ressources/icons/fr.png", 20, 20));
     element3.setBounds(500, 15, 20, 20);
     element3.setForeground(Color.decode("#000"));
     Navig_Bar.add(element3);

     JButton element4 = WireFramePagePrincipale.emojiIconPlacer(scaleIcon("src/ressources/icons/hug.png", 20, 20));
     Navig_Bar.add(element4);

     JLabel element5 = new JLabel("Ajout de commentaire");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#000"));
     panel.add(element5);

     JLabel element8 = new JLabel("Etoiles :");
     element8.setBounds(170, 148, 222, 25);
     element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element8.setForeground(Color.decode("#000"));
     panel.add(element8);

     //Label avec une image d'emoji de ribbon.png
     for (int i = 0; i < 5; i++) { // Affiche l'image 5 fois
        JLabel element9 = new JLabel(scaleIcon("src/ressources/icons/ribbon.png", 20, 20));
        element9.setBounds(250 + (i * 30), 148, 20, 20); // Positionne chaque image avec un décalage horizontal
        panel.add(element9);
     }

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
     element26.setBounds(614, 337, 141, 35);
     element26.setBackground(Color.decode("#bca8e4"));
     element26.setForeground(Color.decode("#000"));
     element26.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element26.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element26.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element26, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     element26.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Contactez nous"));
     panel.add(element26);

     frame.add(panel);
     frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}