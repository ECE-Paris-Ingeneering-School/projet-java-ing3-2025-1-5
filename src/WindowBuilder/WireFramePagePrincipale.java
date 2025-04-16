package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePagePrincipale {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page principale");
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

     JLabel element17 = new JLabel("🛌 Où allez-vous ?");
     element17.setBounds(57, 60, 147, 18);
     element17.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element17.setForeground(Color.decode("#000"));
     panel.add(element17);

     JLabel element18 = new JLabel("📅 Date d'arrivée");
     element18.setBounds(219, 61, 131, 18);
     element18.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element18.setForeground(Color.decode("#000"));
     panel.add(element18);

     JLabel element19 = new JLabel("| Date de départ");
     element19.setBounds(350, 63, 138, 17);
     element19.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element19.setForeground(Color.decode("#000"));
     panel.add(element19);

     JLabel element20 = new JLabel("🧑🧒 Personnes");
     element20.setBounds(483, 63, 120, 20);
     element20.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element20.setForeground(Color.decode("#000"));
     panel.add(element20);

     JLabel element21 = new JLabel("📍Google Maps");
     element21.setBounds(54, 108, 141, 107);
     element21.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 26));
     element21.setForeground(Color.decode("#000"));
     panel.add(element21);

     JLabel element22 = new JLabel("Les filtres");
     element22.setBounds(62, 213, 119, 20);
     element22.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element22.setForeground(Color.decode("#000"));
     panel.add(element22);

     JLabel element23 = new JLabel("Lieu : X  établissements trouvés");
     element23.setBounds(221, 105, 296, 20);
     element23.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element23.setForeground(Color.decode("#000"));
     panel.add(element23);

     JLabel element24 = new JLabel(".PNG");
     element24.setBounds(218, 160, 140, 158);
     element24.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 50));
     element24.setForeground(Color.decode("#000"));
     panel.add(element24);

     JLabel element26 = new JLabel("Nom de l'établissement");
     element26.setBounds(387, 172, 192, 23);
     element26.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element26.setForeground(Color.decode("#000"));
     panel.add(element26);

     JLabel element27 = new JLabel("🎀🎀🎀🎀🎀");
     element27.setBounds(638, 170, 106, 18);
     element27.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element27.setForeground(Color.decode("#000"));
     panel.add(element27);

     JLabel element28 = new JLabel("Adresse");
     element28.setBounds(401, 195, 63, 18);
     element28.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element28.setForeground(Color.decode("#000"));
     panel.add(element28);

     JLabel element29 = new JLabel("Indiquer sur la carte");
     element29.setBounds(471, 197, 161, 18);
     element29.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 10));
     element29.setForeground(Color.decode("#000"));
     panel.add(element29);

     JLabel element30 = new JLabel("dist du centre");
     element30.setBounds(587, 197, 89, 14);
     element30.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
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

     JLabel element37 = new JLabel("Les filtres");
     element37.setBounds(59, 232, 106, 18);
     element37.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element37.setForeground(Color.decode("#000"));
     panel.add(element37);

     JLabel element38 = new JLabel("Les filtres");
     element38.setBounds(61, 251, 106, 18);
     element38.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element38.setForeground(Color.decode("#000"));
     panel.add(element38);

     JLabel element39 = new JLabel("Les filtres");
     element39.setBounds(61, 269, 106, 18);
     element39.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element39.setForeground(Color.decode("#000"));
     panel.add(element39);

     JLabel element40 = new JLabel("Les filtres");
     element40.setBounds(61, 287, 106, 18);
     element40.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element40.setForeground(Color.decode("#000"));
     panel.add(element40);

     JLabel element41 = new JLabel("Les filtres");
     element41.setBounds(65, 305, 106, 18);
     element41.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element41.setForeground(Color.decode("#000"));
     panel.add(element41);

     frame.add(panel);
     frame.setVisible(true);

  }
}