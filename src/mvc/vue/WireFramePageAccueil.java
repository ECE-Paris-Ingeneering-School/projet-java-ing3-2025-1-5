
package mvc.vue;

import mvc.controleur.LogementControl;
import mvc.vue.helper_classes.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Page d'accueil de l'application WhereBnB
 *
 * Cette classe crée une interface graphique pour la page d'accueil de l'application, elle est un point de retour régulier
 */
public class WireFramePageAccueil {
   public static void main(String[] args) {

      //Lancement d'une instance par defaut
      WireFramePageAccueil wireFrame = new WireFramePageAccueil();
      String client_mail = "felixcadene@mail.com";
      wireFrame.WF_Accueil(client_mail);    
   }

   public void WF_Accueil(String mail) {
      System.out.println(mail);

      JFrame frame = new JFrame("Page d'accueil");
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

      ImageIcon emojiIcon = scaleIcon("src/assets/icons/hug.png", 20, 20);
      JButton element5 = new JButton("Mon compte", emojiIcon);
      element5.setBounds(600, 6, 150, 40);
      element5.setBackground(Color.decode("#003c6b"));
      element5.setForeground(Color.decode("#ffffff"));
      element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element5.setFocusPainted(false);
      element5.setBorder(BorderFactory.createLineBorder(Color.decode("#003c6b"), 1, true));
      element5.setHorizontalTextPosition(SwingConstants.RIGHT);
      OnClickEventHelper.setOnClickColor(element5, Color.decode("#003c6b"), Color.decode("#003c6b"));
      //On click, call the method afficher_moncompte de la classe WireFramePageMonCompte
      element5.addActionListener(e -> {
         WireFramePageMonCompte pageMonCompte = new WireFramePageMonCompte();
         pageMonCompte.WF_MonCompte(mail, "WF_Accueil");
         frame.dispose();
      });
      Navig_Bar.add(element5);

      JLabel element6 = new JLabel("Trouvez votre prochain s\u00e9jour");
      element6.setBounds(190, 105, 600, 44);
      element6.setFont(new Font("SansSerif", Font.BOLD, 30));
      element6.setForeground(Color.decode("#ffffff"));
      panel.add(element6);

      // Label avec une image d'emoji de maison.png a gauche de element6
      JLabel element7 = new JLabel(scaleIcon("src/assets/icons/house.png", 40, 40));
      element7.setBounds(140, 105, 40, 40);
      element6.setFont(new Font("SansSerif", Font.BOLD, 30));
      element7.setForeground(Color.decode("#ffffff"));
      panel.add(element7);

      JTextField element_localisation = new JTextField();
      //Blindage
      element_localisation.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
             char c = e.getKeyChar();
             if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isISOControl(c)) {
                 e.consume();
             }
         }
      });
      JTextField element_arrivee = new JTextField();
      JTextField element_depart = new JTextField();
      JTextField element_personnes = new JTextField();
      //Blindage
      element_personnes.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
             char c = e.getKeyChar();
             if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                 e.consume();
             }
         }
      });
      element_personnes.setText("1");
      panel.add(merge_icon_Text("O\u00f9 allez-vous ?", "src/assets/icons/localisation.png", element_localisation, 59, 195, 137, 24));
      panel.add(merge_icon_Text("Date d'arriv\u00e9e", "src/assets/icons/arrivee.png", element_arrivee, 216, 195, 124, 24));
      panel.add(merge_icon_Text("Date de d\u00e9part", "src/assets/icons/depart.png", element_depart, 346, 195, 124, 24));
      //panel.add(merge_Icon_text_Date("📅 Date d'arrivée", "src/assets/icons/arrivee.png", 216, 195, 124, 24));
      //panel.add(merge_Icon_text_Date("📅 Date de départ", "src/assets/icons/depart.png", 346, 195, 124, 24));

      panel.add(merge_icon_Text("Personnes", "src/assets/icons/person.png", element_personnes, 483, 195, 119, 24));

      JLabel element8 = new JLabel("Format: jj/mm/aaaa");
      element8.setBounds(216, 220, 124, 24);
      element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 10));
      element8.setForeground(Color.decode("#ffffff"));
      panel.add(element8);

      JLabel element9 = new JLabel("Format: jj/mm/aaaa");
      element9.setBounds(346, 220, 124, 24);
      element9.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 10));
      element9.setForeground(Color.decode("#ffffff"));
      panel.add(element9);
      

      JButton element11 = new JButton("Rechercher");
      element11.setBounds(629, 192, 106, 29);
      element11.setBackground(Color.decode("#003c6b"));
      element11.setForeground(Color.decode("#ffffff"));
      element11.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element11.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
      element11.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(element11, Color.decode("#003c6b"), Color.decode("#003c6b"));
      element11.addActionListener(e -> {
          String localisation = element_localisation.getText().trim();
          String arrivee = element_arrivee.getText().trim();
          String depart = element_depart.getText().trim();
          int nbPersonnes = Integer.parseInt(element_personnes.getText().trim());

          // Valider les données avant de les transmettre
          LogementControl rechercheControl = new LogementControl();
          if (!rechercheControl.validerRecherche(localisation, String.valueOf(nbPersonnes), arrivee, depart, frame)) {
              return;
          }

          SwingUtilities.invokeLater(() -> {
              WireFramePagePrincipale pagePrincipale = new WireFramePagePrincipale();
              pagePrincipale.WF_Principale(mail, "WF_Accueil");
              pagePrincipale.preRemplirEtChercher(localisation, arrivee, depart, nbPersonnes);
          });

          // Fermer la page actuelle
          frame.dispose();
      });

      panel.add(element11);


      JButton element16 = new JButton("Contactez nous");
      element16.setBounds(614, 337, 141, 35);
      element16.setBackground(Color.decode("#003c6b"));
      element16.setForeground(Color.decode("#ffffff"));
      element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element16.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
      element16.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(element16, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      //On click, call the method afficher_moncompte de la classe WireFramePageMonCompte
      element16.addActionListener(e -> {
         WireFramePageAide pageAide = new WireFramePageAide();
         pageAide.WF_Aide(mail, "WF_Accueil");
         //frame.dispose();
      });
      panel.add(element16);


      frame.add(panel);
      frame.setVisible(true);
   }

   private static JPanel merge_icon_Text(String txt_defaut, String iconPath, JTextField textField, int x, int y, int width, int height) {
      JPanel merger = new JPanel();
      merger.setLayout(new BorderLayout(5, 0));
      merger.setBounds(x, y, width, height);
      merger.setBackground(Color.decode("#203647"));
      merger.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
  
      JLabel iconLabel = new JLabel(scaleIcon(iconPath, 18, 18));
      iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
      merger.add(iconLabel, BorderLayout.WEST);
  
      // Use the textField passed in
      textField.setText(txt_defaut);
      textField.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      textField.setBackground(Color.decode("#203647"));
      textField.setForeground(Color.decode("#ffffff"));
      textField.setBorder(null);
      textField.setOpaque(true);
      textField.setCaretColor(Color.WHITE);
  
      OnFocusEventHelper.setOnFocusText(textField, txt_defaut, Color.WHITE, Color.decode("#73664e"));
  
      merger.add(textField, BorderLayout.CENTER);
      return merger;
  }
  


   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}