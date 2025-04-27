package mvc.vue;

import javax.swing.*;
import java.awt.*;

import mvc.controleur.Retour;
import mvc.vue.helper_classes.*;

public class WireFramePageModificationLogement {
  public static void main(String[] args) {

     //Lancement d'une instance par defaut
     WireFramePageModificationLogement wireFrame = new WireFramePageModificationLogement();
     String client_mail = "leondalle@mail.com";
     wireFrame.WF_ModificationLogement(client_mail, "WF_ModificationLogement");
  }

   public void WF_ModificationLogement(String client_mail, String page_precedente) {

     JFrame frame = new JFrame("Page modification logement");
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
     JLabel element3 = new JLabel(scaleIcon("src/assets/icons/fr.png", 20, 20));
     element3.setBounds(500, 15, 20, 20);
     element3.setForeground(Color.decode("#000"));
     Navig_Bar.add(element3);


     JButton element4 = WireFramePagePrincipale.emojiIconPlacer(scaleIcon("src/assets/icons/hug.png", 20, 20));
     Navig_Bar.add(element4);

     JLabel element5 = new JLabel("Modification de logements");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#000"));
     panel.add(element5);


     //Ajouter bouton de retour en appelant le fichier return.java dans controlleur
     ImageIcon retourIcon = scaleIcon("src/assets/icons/return.png", 20, 20);
     JButton retourBtn = new JButton(retourIcon);
     retourBtn.setBounds(10, 335, 40, 40);
     retourBtn.setBackground(Color.decode("#bca8e4"));
     retourBtn.setForeground(Color.decode("#000"));
     retourBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     retourBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     //On appele la methode de retour de la classe controlleur en mettant le nom de la page precedente en parametre - methode: retour(String page_precedente)
     //appel de retour()
     Retour retour = new Retour();
     retourBtn.addActionListener(e -> {
       System.out.println("Retour à la page précédente : " + page_precedente);
       frame.dispose();
       retour.retour(client_mail, page_precedente);
     });
     frame.add(retourBtn);

     JButton element7 = new JButton("Ajoutez un logement");
     element7.setBounds(614, 337, 141, 35);
     element7.setBackground(Color.decode("#bca8e4"));
     element7.setForeground(Color.decode("#000"));
     element7.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element7.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element7.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element7, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element7);


     JLabel element31 = new JLabel(scaleIcon("src/assets/icons/office.png", 80, 80));
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

     //Label avec une image d'emoji de ribbon.png
     for (int i = 0; i < 3; i++) {
        JLabel element35 = new JLabel(scaleIcon("src/assets/icons/ribbon.png", 20, 20));
        element35.setBounds(519 + (i * 25), 167, 20, 20); // Positionne chaque image avec un décalage horizontal
        panel.add(element35);
     }

     JLabel element36 = new JLabel("Prix : x€");
     element36.setBounds(518, 200, 106, 18);
     element36.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element36.setForeground(Color.decode("#000"));
     panel.add(element36);

     ImageIcon emojiIcon2 = scaleIcon("src/assets/icons/pencil2.png", 20, 20);
     JButton element37 = new JButton("Modifier", emojiIcon2);
     element37.setBounds(645, 171, 106, 30);
     element37.setBackground(Color.decode("#bca8e4"));
     element37.setForeground(Color.decode("#000"));
     element37.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element37.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element37.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element37, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element37);

     ImageIcon emojiIcon3 = scaleIcon("src/assets/icons/wastebasket.png", 20, 20);
     JButton element38 = new JButton("Supprimer", emojiIcon3);
     element38.setBounds(645, 215, 106, 30);
     element38.setBackground(Color.decode("#bca8e4"));
     element38.setForeground(Color.decode("#000"));
     element38.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element38.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element38.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element38, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element38);

     JLabel element39 = new JLabel(scaleIcon("src/assets/icons/japanese_castle.png", 80, 80));
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

     //Label avec une image d'emoji de ribbon.png
     for (int i = 0; i < 4; i++) { // Affiche l'image 5 fois
        JLabel element9 = new JLabel(scaleIcon("src/assets/icons/ribbon.png", 20, 20));
        element9.setBounds(496 + (i * 25), 277, 20, 20); // Positionne chaque image avec un décalage horizontal
        panel.add(element9);
     }


     JLabel element44 = new JLabel("Prix : x€");
     element44.setBounds(517, 303, 106, 18);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element44.setForeground(Color.decode("#000"));
     panel.add(element44);

     ImageIcon emojiIcon4 = scaleIcon("src/assets/icons/pencil2.png", 20, 20);
     JButton element45 = new JButton("Modifier", emojiIcon4);
     element45.setBounds(644, 272, 106, 30);
     element45.setBackground(Color.decode("#bca8e4"));
     element45.setForeground(Color.decode("#000"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element45);

     ImageIcon emojiIcon5 = scaleIcon("src/assets/icons/wastebasket.png", 20, 20);
     JButton element46 = new JButton("Supprimer", emojiIcon5);
     element46.setBounds(643, 319, 106, 30);
     element46.setBackground(Color.decode("#bca8e4"));
     element46.setForeground(Color.decode("#000"));
     element46.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element46.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element46.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element46, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element46);

     frame.add(panel);
     frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}