package WindowBuilder;

import javax.swing.*;
import java.awt.*;

import WindowBuilder.helper_classes.*;

public class WireFramePagePrincipale {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page principale");
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

     ImageIcon emojiIcon2 = scaleIcon("src/ressources/emojis/house.png", 20, 20);
     JLabel element17 = new JLabel("Où allez-vous ?");
     element17.setIcon(emojiIcon2);
     element17.setBounds(57, 63, 147, 18);
     element17.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element17.setForeground(Color.decode("#000"));
     panel.add(element17);

     ImageIcon emojiIcon3 = scaleIcon("src/ressources/emojis/depart.png", 20, 20);
     JLabel element18 = new JLabel("Date d'arrivée |");
     element18.setIcon(emojiIcon3);
     element18.setBounds(219, 63, 131, 18);
     element18.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element18.setForeground(Color.decode("#000"));
     panel.add(element18);

     ImageIcon emojiIcon4 = scaleIcon("src/ressources/emojis/arrivee.png", 20, 20);
     JLabel element19 = new JLabel("Date de départ");
     element19.setIcon(emojiIcon4);
     element19.setBounds(350, 63, 138, 17);
     element19.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element19.setForeground(Color.decode("#000"));
     panel.add(element19);

     ImageIcon emojiIcon5 = scaleIcon("src/ressources/emojis/person.png", 20, 20);
     JLabel element20 = new JLabel("Personnes");
     element20.setIcon(emojiIcon5);
     element20.setBounds(483, 63, 120, 20);
     element20.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element20.setForeground(Color.decode("#000"));
     panel.add(element20);

     ImageIcon emojiIcon6 = scaleIcon("src/ressources/emojis/localisation.png", 20, 20);
     JLabel element21 = new JLabel("Google Maps");
     element21.setIcon(emojiIcon6);
     element21.setBounds(50, 47, 141, 141);
     element21.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 19));
     element21.setForeground(Color.decode("#000"));
     panel.add(element21);

     JLabel element39 = new JLabel(scaleIcon("src/ressources/emojis/world_map.png", 80, 80));
     element39.setBounds(60, 120, 145, 100);
     element39.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 32));
     element39.setForeground(Color.decode("#000"));
     panel.add(element39);

     JLabel element23 = new JLabel("Lieu : X  établissements trouvés");
     element23.setBounds(221, 105, 296, 20);
     element23.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element23.setForeground(Color.decode("#000"));
     panel.add(element23);

     JLabel element24 = new JLabel(scaleIcon("src/ressources/emojis/japanese_castle.png",100, 100));
     element24.setBounds(218, 160, 140, 158);
     element24.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 50));
     element24.setForeground(Color.decode("#000"));
     panel.add(element24);

     JLabel element26 = new JLabel("Nom de l'établissement");
     element26.setBounds(387, 172, 192, 23);
     element26.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element26.setForeground(Color.decode("#000"));
     panel.add(element26);

     //Label avec une image d'emoji de ribbon.png
     for (int i = 0; i < 4; i++) {
        JLabel element27 = new JLabel(scaleIcon("src/ressources/emojis/ribbon.png", 20, 20));
        element27.setBounds(638 + (i * 25), 170, 20, 20);
        panel.add(element27);
     }

     JLabel element28 = new JLabel("Adresse");
     element28.setBounds(401, 197, 63, 18);
     element28.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element28.setForeground(Color.decode("#000"));
     panel.add(element28);

     JLabel element29 = new JLabel("Indiquer sur la carte");
     element29.setBounds(471, 197, 161, 18);
     element29.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element29.setForeground(Color.decode("#000"));
     panel.add(element29);

     JLabel element30 = new JLabel("dist du centre");
     element30.setBounds(587, 197, 89, 14);
     element30.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element30.setForeground(Color.decode("#000"));
     panel.add(element30);

     JLabel element31 = new JLabel("Type établissement");
     element31.setBounds(387, 240, 159, 18);
     element31.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element31.setForeground(Color.decode("#000"));
     panel.add(element31);

     JLabel element32 = new JLabel("Description de l'établissement");
     element32.setBounds(409, 266, 259, 20);
     element32.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 13));
     element32.setForeground(Color.decode("#000"));
     panel.add(element32);

     JLabel element33 = new JLabel("Nombre de nuits, personnes");
     element33.setBounds(609, 243, 180, 18);
     element33.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element33.setForeground(Color.decode("#000"));
     panel.add(element33);

     JLabel element34 = new JLabel("€ Prix");
     element34.setBounds(710, 265, 66, 32);
     element34.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element34.setForeground(Color.decode("#000"));
     panel.add(element34);

     JLabel element35 = new JLabel("Taxes et frais compris");
     element35.setBounds(643, 301, 137, 19);
     element35.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element35.setForeground(Color.decode("#000"));
     panel.add(element35);

     JButton element36 = new JButton("Voir les disponibilités >");
     element36.setBounds(583, 330, 179, 38);
     element36.setBackground(Color.decode("#bca8e4"));
     element36.setForeground(Color.decode("#000"));
     element36.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element36.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element36.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element36, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element36);

     JLabel element22 = new JLabel("Les filtres");
     element22.setBounds(62, 213, 119, 20);
     element22.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element22.setForeground(Color.decode("#000"));
     panel.add(element22);

     JLabel element37 = new JLabel("Les filtres");
     element37.setBounds(62, 232, 106, 18);
     element37.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element37.setForeground(Color.decode("#000"));
     panel.add(element37);

     JLabel element38 = new JLabel("Les filtres");
     element38.setBounds(62, 251, 106, 18);
     element38.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element38.setForeground(Color.decode("#000"));
     panel.add(element38);

     JLabel element50 = new JLabel("Les filtres");
     element50.setBounds(62, 269, 106, 18);
     element50.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element50.setForeground(Color.decode("#000"));
     panel.add(element50);

     JLabel element40 = new JLabel("Les filtres");
     element40.setBounds(62, 287, 106, 18);
     element40.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element40.setForeground(Color.decode("#000"));
     panel.add(element40);

     JLabel element41 = new JLabel("Les filtres");
     element41.setBounds(62, 305, 106, 18);
     element41.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element41.setForeground(Color.decode("#000"));
     panel.add(element41);

     frame.add(panel);
     frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}