package WindowBuilder;

import javax.swing.*;
import java.awt.*;

import WindowBuilder.helper_classes.*;

public class WireFramePagePaiement {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page paiement");
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

     JButton element4 = WireFramePagePrincipale.emojiIconPlacer(scaleIcon("src/ressources/emojis/hug.png", 20, 20));
     Navig_Bar.add(element4);

     JButton element13 = new JButton("Retour");
     element13.setBounds(25, 342, 106, 30);
     element13.setBackground(Color.decode("#bca8e4"));
     element13.setForeground(Color.decode("#000"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element13);

     JLabel element48 = new JLabel("Paiement");
     element48.setBounds(68, 71, 176, 36);
     element48.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 27));
     element48.setForeground(Color.decode("#000"));
     panel.add(element48);

     JLabel element49 = new JLabel("Arrivée :");
     element49.setBounds(89, 142, 106, 18);
     element49.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element49.setForeground(Color.decode("#000"));
     panel.add(element49);

     JLabel element51 = new JLabel("[Date d'arrivée]");
     element51.setBounds(106, 168, 106, 18);
     element51.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element51.setForeground(Color.decode("#000"));
     panel.add(element51);

     JLabel element52 = new JLabel("Départ :");
     element52.setBounds(89, 190, 106, 18);
     element52.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element52.setForeground(Color.decode("#000"));
     panel.add(element52);

     JLabel element53 = new JLabel("[Date de départ]");
     element53.setBounds(105, 209, 126, 21);
     element53.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element53.setForeground(Color.decode("#000"));
     panel.add(element53);

     JLabel element54 = new JLabel("Durée du séjour :");
     element54.setBounds(89, 234, 120, 19);
     element54.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element54.setForeground(Color.decode("#000"));
     panel.add(element54);

     JLabel element55 = new JLabel("Total de personnes :");
     element55.setBounds(89, 254, 147, 21);
     element55.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element55.setForeground(Color.decode("#000"));
     panel.add(element55);

     JLabel element56 = new JLabel("Total de chambres :");
     element56.setBounds(89, 275, 133, 20);
     element56.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element56.setForeground(Color.decode("#000"));
     panel.add(element56);

     JLabel element57 = new JLabel("Prix total :");
     element57.setBounds(89, 310, 106, 18);
     element57.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element57.setForeground(Color.decode("#000"));
     panel.add(element57);

     JLabel element58 = new JLabel("XXX €");
     element58.setBounds(192, 315, 63, 25);
     element58.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element58.setForeground(Color.decode("#000"));
     panel.add(element58);

     JLabel element59 = new JLabel("xxx");
     element59.setBounds(222, 235, 43, 18);
     element59.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element59.setForeground(Color.decode("#000"));
     panel.add(element59);

     JLabel element60 = new JLabel("xxx");
     element60.setBounds(234, 254, 106, 18);
     element60.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element60.setForeground(Color.decode("#000"));
     panel.add(element60);

     JLabel element61 = new JLabel("xxx");
     element61.setBounds(230, 276, 106, 18);
     element61.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element61.setForeground(Color.decode("#000"));
     panel.add(element61);

     JLabel element62 = new JLabel("Client :");
     element62.setBounds(382, 86, 106, 18);
     element62.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element62.setForeground(Color.decode("#000"));
     panel.add(element62);

     JTextField element63 = new JTextField("");
     element63.setBounds(416, 108, 162, 24);
     element63.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element63.setBackground(Color.decode("#ffe7bf"));
     element63.setForeground(Color.decode("#73664e"));
     element63.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element63, "ex : Sophie Marceau", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element63);

     JLabel element64 = new JLabel("Détails du paiement :");
     element64.setBounds(382, 146, 169, 18);
     element64.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element64.setForeground(Color.decode("#000"));
     panel.add(element64);

     JLabel element65 = new JLabel("Notez que si vous annulez la réservation, le  rembousement");
     element65.setBounds(416, 176, 335, 24);
     element65.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element65.setForeground(Color.decode("#000"));
     panel.add(element65);

     JLabel element66 = new JLabel("dépendra de la politique d'annulation dans vos conditions ");
     element66.setBounds(416, 190, 327, 24);
     element66.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element66.setForeground(Color.decode("#000"));
     panel.add(element66);

     JLabel element67 = new JLabel("de réservations.");
     element67.setBounds(416, 206, 334, 19);
     element67.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element67.setForeground(Color.decode("#000"));
     panel.add(element67);

     JLabel element68 = new JLabel("Nom sur la carte :");
     element68.setBounds(382, 237, 171, 18);
     element68.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element68.setForeground(Color.decode("#000"));
     panel.add(element68);

     JTextField element69 = new JTextField("");
     element69.setBounds(519, 235, 162, 24);
     element69.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element69.setBackground(Color.decode("#ffe7bf"));
     element69.setForeground(Color.decode("#73664e"));
     element69.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element69, "remplir", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element69);

     JLabel element70 = new JLabel("Numéro de carte :");
     element70.setBounds(382, 270, 149, 20);
     element70.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element70.setForeground(Color.decode("#000"));
     panel.add(element70);

     JLabel element71 = new JLabel("CVV :");
     element71.setBounds(382, 314, 106, 18);
     element71.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element71.setForeground(Color.decode("#000"));
     panel.add(element71);

     JLabel element72 = new JLabel("Date d'expiration :");
     element72.setBounds(382, 294, 137, 17);
     element72.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element72.setForeground(Color.decode("#000"));
     panel.add(element72);

     JTextField element73 = new JTextField("");
     element73.setBounds(519, 266, 162, 24);
     element73.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element73.setBackground(Color.decode("#ffe7bf"));
     element73.setForeground(Color.decode("#73664e"));
     element73.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element73, "remplir", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element73);

     JTextField element74 = new JTextField("");
     element74.setBounds(519, 291, 162, 24);
     element74.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element74.setBackground(Color.decode("#ffe7bf"));
     element74.setForeground(Color.decode("#73664e"));
     element74.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element74, "remplir", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element74);

     JTextField element75 = new JTextField("");
     element75.setBounds(518, 316, 162, 24);
     element75.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element75.setBackground(Color.decode("#ffe7bf"));
     element75.setForeground(Color.decode("#73664e"));
     element75.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element75, "remplir", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element75);

     JButton element76 = new JButton("Payer");
     element76.setBounds(408, 345, 106, 30);
     element76.setBackground(Color.decode("#bca8e4"));
     element76.setForeground(Color.decode("#000"));
     element76.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element76.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element76.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element76, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element76);

     JButton element77 = new JButton("Contactez nous");
     element77.setBounds(640, 348, 120, 29);
     element77.setBackground(Color.decode("#bca8e4"));
     element77.setForeground(Color.decode("#000"));
     element77.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element77.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element77.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element77, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element77);

     frame.add(panel);
     frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}