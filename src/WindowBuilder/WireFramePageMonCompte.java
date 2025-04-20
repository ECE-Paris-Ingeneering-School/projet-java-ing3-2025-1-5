package WindowBuilder;

import javax.swing.*;
import java.awt.*;

import WindowBuilder.helper_classes.*;

public class WireFramePageMonCompte {
   public static void main(String[] args) {

      JFrame frame = new JFrame("Projet JAVA - WireFrame Page mon compte");
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
      JButton element5 = new JButton("Votre compte", emojiIcon);
      element5.setBounds(600, 6, 150, 40);
      element5.setBackground(Color.decode("#bca8e4"));
      element5.setForeground(Color.decode("#000000"));
      element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element5.setFocusPainted(false);
      element5.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
      element5.setHorizontalTextPosition(SwingConstants.RIGHT);
      OnClickEventHelper.setOnClickColor(element5, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      Navig_Bar.add(element5);

      ImageIcon emojiIcon2 = scaleIcon("src/ressources/emojis/blush.png", 20, 20);
      JLabel element6 = new JLabel("Bienvenue");
      element6.setIcon(emojiIcon2);
      element6.setBounds(63, 79, 199, 40);
      element6.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
      element6.setForeground(Color.decode("#000"));
      panel.add(element6);

      JLabel element7 = new JLabel("Mes informations personnelles ");
      element7.setBounds(63, 135, 310, 25);
      element7.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element7.setForeground(Color.decode("#000"));
      panel.add(element7);

      JLabel element8 = new JLabel("Suivi de voyages");
      element8.setBounds(427, 135, 226, 29);
      element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element8.setForeground(Color.decode("#000"));
      panel.add(element8);

      JLabel element9 = new JLabel("Votre nom :");
      element9.setBounds(81, 201, 105, 18);
      element9.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element9.setForeground(Color.decode("#000"));
      panel.add(element9);

      JLabel element10 = new JLabel("Votre e-mail :");
      element10.setBounds(81, 239, 105, 18);
      element10.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element10.setForeground(Color.decode("#000"));
      panel.add(element10);

      JLabel element11 = new JLabel("xxx");
      element11.setBounds(170, 201, 105, 18);
      element11.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element11.setForeground(Color.decode("#000"));
      panel.add(element11);

      JLabel element12 = new JLabel("xxx");
      element12.setBounds(178, 239, 105, 18);
      element12.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element12.setForeground(Color.decode("#000"));
      panel.add(element12);

      JLabel element13 = new JLabel("Votre numéro de téléphone :");
      element13.setBounds(81, 279, 197, 18);
      element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element13.setForeground(Color.decode("#000"));
      panel.add(element13);

      JLabel element14 = new JLabel("06 00 00 00 00");
      element14.setBounds(279, 279, 105, 18);
      element14.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element14.setForeground(Color.decode("#000"));
      panel.add(element14);

      JLabel element15 = new JLabel("Votre prochain voyage :");
      element15.setBounds(440, 204, 191, 20);
      element15.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element15.setForeground(Color.decode("#000"));
      panel.add(element15);

      JLabel element16 = new JLabel("Votre dernier commentaire : ");
      element16.setBounds(440, 279, 196, 21);
      element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element16.setForeground(Color.decode("#000"));
      panel.add(element16);

      JLabel element17 = new JLabel("Dates : [Début]/[Fin]");
      element17.setBounds(474, 229, 166, 18);
      element17.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
      element17.setForeground(Color.decode("#000"));
      panel.add(element17);

      JLabel element18 = new JLabel("Lieu : [Lieu]");
      element18.setBounds(474, 250, 105, 18);
      element18.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
      element18.setForeground(Color.decode("#000"));
      panel.add(element18);

      JLabel element19 = new JLabel("xxx");
      element19.setBounds(465, 304, 106, 18);
      element19.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element19.setForeground(Color.decode("#000"));
      panel.add(element19);

      frame.add(panel);
      frame.setVisible(true);
   }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}