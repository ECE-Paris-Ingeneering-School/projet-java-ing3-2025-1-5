package mvc.vue;

import javax.swing.*;
import java.awt.*;

import mvc.controleur.Retour;
import mvc.vue.helper_classes.*;


/**
 * Page de réduction
 *
 * Cette classe crée une interface graphique pour la page de réduction de l'application.
 */
public class WireFramePageReduction {
  public static void main(String[] args) {

     //Lancement d'une instance par defaut
     WireFramePageReduction wireFrame = new WireFramePageReduction();
     String client_mail = "leondalle@mail.com";
     wireFrame.WF_Reduction(client_mail, "WF_ModificationLogement");
  }

   public void WF_Reduction(String client_mail, String page_precedente) {

     JFrame frame = new JFrame("Page réduction");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#091f30"));

     JPanel Navig_Bar = new JPanel();
     Navig_Bar.setLayout(null);
     Navig_Bar.setBounds(0, 0, 783, 50);
     Navig_Bar.setBackground(Color.decode("#091f30"));
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
     element3.setForeground(Color.decode("#ffffff"));
     Navig_Bar.add(element3);

     JButton element4 = WireFramePagePrincipale.emojiIconPlacer(scaleIcon("src/assets/icons/hug.png", 20, 20));
     element4.addActionListener(e -> {
       frame.dispose();
       WireFramePageMonCompte compte = new WireFramePageMonCompte();
       compte.WF_MonCompte(client_mail, "WF_Reduction");
     });
     Navig_Bar.add(element4);

     JLabel element5 = new JLabel("Ajout d'une réduction");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#ffffff"));
     panel.add(element5);

     JLabel element8 = new JLabel("Réduction actuelle : ");
     element8.setBounds(170, 148, 167, 26);
     element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element8.setForeground(Color.decode("#ffffff"));
     panel.add(element8);

     //Ajouter bouton de retour en appelant le fichier return.java dans controlleur
     ImageIcon retourIcon = scaleIcon("src/assets/icons/return.png", 20, 20);
     JButton retourBtn = new JButton(retourIcon);
     retourBtn.setBounds(10, 335, 40, 40);
     retourBtn.setBackground(Color.decode("#003c6b"));
     retourBtn.setForeground(Color.decode("#ffffff"));
     retourBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     retourBtn.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     //On appele la methode de retour de la classe controlleur en mettant le nom de la page precedente en parametre - methode: retour(String page_precedente)
     //appel de retour()
     Retour retour = new Retour();
     retourBtn.addActionListener(e -> {
       System.out.println("Retour à la page précédente : " + page_precedente);
       frame.dispose();
       retour.retour(client_mail, page_precedente);
     });
     frame.add(retourBtn);

     JLabel element14 = new JLabel("xzy");
     element14.setBounds(359, 150, 107, 25);
     element14.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element14.setForeground(Color.decode("#ffffff"));
     panel.add(element14);

     JLabel element15 = new JLabel("Sélectionner un type de réduction  puis complétez les éléments");
     element15.setBounds(225, 185, 441, 19);
     element15.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element15.setForeground(Color.decode("#ffffff"));
     panel.add(element15);

     JLabel element16 = new JLabel("de configuration de celle-ci.");
     element16.setBounds(225, 207, 369, 19);
     element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element16.setForeground(Color.decode("#ffffff"));
     panel.add(element16);

     JLabel element17 = new JLabel("Type de réduction :");
     element17.setBounds(172, 238, 197, 26);
     element17.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element17.setForeground(Color.decode("#ffffff"));
     panel.add(element17);

     JLabel element20 = new JLabel("🔲 Fixe en €");
     element20.setBounds(224, 275, 106, 18);
     element20.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element20.setForeground(Color.decode("#ffffff"));
     panel.add(element20);

     JLabel element21 = new JLabel("🔲 Pourcentage %");
     element21.setBounds(222, 297, 166, 22);
     element21.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element21.setForeground(Color.decode("#ffffff"));
     panel.add(element21);

     JLabel element22 = new JLabel("Montant ou Pourcentage de réduction :");
     element22.setBounds(167, 332, 313, 24);
     element22.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element22.setForeground(Color.decode("#ffffff"));
     panel.add(element22);

     JTextField element23 = new JTextField("");
     element23.setBounds(480, 329, 106, 24);
     element23.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element23.setBackground(Color.decode("#203647"));
     element23.setForeground(Color.decode("#ffffff"));
     element23.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element23, "remplir", Color.decode("#ffffff"),   Color.decode("#73664e"));
     panel.add(element23);

     frame.add(panel);
     frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}