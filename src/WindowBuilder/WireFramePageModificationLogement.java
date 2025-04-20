package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageModificationLogement {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page modification logement");
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

     JLabel element5 = new JLabel("Modification de logements");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#000"));
     panel.add(element5);

     JButton element13 = new JButton("Retour");
     element13.setBounds(25, 342, 106, 30);
     element13.setBackground(Color.decode("#bca8e4"));
     element13.setForeground(Color.decode("#000"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element13);

     JButton element25 = new JButton("Contactez nous");
     element25.setBounds(-212, -123, 149, 35);
     element25.setBackground(Color.decode("#bca8e4"));
     element25.setForeground(Color.decode("#000"));
     element25.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element25.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element25.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element25, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element25);

     JLabel element31 = new JLabel("PHOTO");
     element31.setBounds(130, 174, 120, 95);
     element31.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 32));
     element31.setForeground(Color.decode("#000"));
     panel.add(element31);

     JLabel element32 = new JLabel("Titre");
     element32.setBounds(298, 162, 106, 18);
     element32.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element32.setForeground(Color.decode("#000"));
     panel.add(element32);

     JLabel element33 = new JLabel("Adresse");
     element33.setBounds(318, 204, 106, 18);
     element33.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element33.setForeground(Color.decode("#000"));
     panel.add(element33);

     JLabel element34 = new JLabel("Description");
     element34.setBounds(319, 230, 106, 18);
     element34.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element34.setForeground(Color.decode("#000"));
     panel.add(element34);

     JLabel element35 = new JLabel("🎀🎀🎀");
     element35.setBounds(519, 167, 106, 18);
     element35.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element35.setForeground(Color.decode("#000"));
     panel.add(element35);

     JLabel element36 = new JLabel("Prix : x€");
     element36.setBounds(518, 200, 106, 18);
     element36.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element36.setForeground(Color.decode("#000"));
     panel.add(element36);

     JButton element37 = new JButton("🖊 Modifier");
     element37.setBounds(645, 171, 106, 30);
     element37.setBackground(Color.decode("#bca8e4"));
     element37.setForeground(Color.decode("#000"));
     element37.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element37.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element37.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element37, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element37);

     JButton element38 = new JButton("🗑 Supprimer");
     element38.setBounds(645, 215, 106, 30);
     element38.setBackground(Color.decode("#bca8e4"));
     element38.setForeground(Color.decode("#000"));
     element38.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element38.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element38.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element38, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element38);

     JLabel element39 = new JLabel("PHOTO");
     element39.setBounds(128, 283, 145, 100);
     element39.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 32));
     element39.setForeground(Color.decode("#000"));
     panel.add(element39);

     JLabel element40 = new JLabel("Titre");
     element40.setBounds(301, 279, 106, 18);
     element40.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element40.setForeground(Color.decode("#000"));
     panel.add(element40);

     JLabel element41 = new JLabel("Adresse");
     element41.setBounds(317, 311, 106, 18);
     element41.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element41.setForeground(Color.decode("#000"));
     panel.add(element41);

     JLabel element42 = new JLabel("Description");
     element42.setBounds(317, 338, 106, 18);
     element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element42.setForeground(Color.decode("#000"));
     panel.add(element42);

     JLabel element43 = new JLabel("🎀🎀🎀🎀");
     element43.setBounds(496, 277, 106, 18);
     element43.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element43.setForeground(Color.decode("#000"));
     panel.add(element43);

     JLabel element44 = new JLabel("Prix : x€");
     element44.setBounds(517, 303, 106, 18);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element44.setForeground(Color.decode("#000"));
     panel.add(element44);

     JButton element45 = new JButton("🖊 Modifier");
     element45.setBounds(644, 272, 106, 30);
     element45.setBackground(Color.decode("#bca8e4"));
     element45.setForeground(Color.decode("#000"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element45);

     JButton element46 = new JButton("🗑 Supprimer");
     element46.setBounds(643, 319, 106, 30);
     element46.setBackground(Color.decode("#bca8e4"));
     element46.setForeground(Color.decode("#000"));
     element46.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element46.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element46.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element46, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element46);

     JButton element47 = new JButton("Ajouter logement");
     element47.setBounds(614, 337, 147, 31);
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