package mvc.vue;

import javax.swing.*;
import java.awt.*;

import mvc.controleur.CommentaireControleur;
import mvc.controleur.Retour;
import mvc.controleur.ClientControl; // Ensure this is the correct package for ClientControl
import mvc.vue.helper_classes.*;

public class WireFramePageCommentaire {

   public static void main(String[] args) {
      //Lancement d'une instance par defaut
      WireFramePageCommentaire wireFrame = new WireFramePageCommentaire();
      String client_mail = "felixcadene@mail.com";
      wireFrame.WF_Commentaire(1, 1, "felixcaden");
   }

   public static void WF_Commentaire(int clientId, int logId, String client_mail) {

     JFrame frame = new JFrame("Page commentaire");
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
       JButton element4 = new JButton("Mon compte", emojiIcon);
       element4.setBounds(600, 6, 150, 40);
       element4.setBackground(Color.decode("#003c6b"));
       element4.setForeground(Color.decode("#ffffff"));
       element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
       element4.setFocusPainted(false);
       element4.setBorder(BorderFactory.createLineBorder(Color.decode("#003c6b"), 1, true));
       element4.setHorizontalTextPosition(SwingConstants.RIGHT);
       OnClickEventHelper.setOnClickColor(element4, Color.decode("#003c6b"), Color.decode("#003c6b"));
       //On click, call the method afficher_moncompte de la classe WireFramePageMonCompte
       element4.addActionListener(e -> {
           WireFramePageMonCompte pageMonCompte = new WireFramePageMonCompte();

           pageMonCompte.WF_MonCompte(client_mail, "WF_Accueil");
           frame.dispose();
       });
       Navig_Bar.add(element4);

     JLabel element5 = new JLabel("Ajout de commentaire");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#ffffff"));
     panel.add(element5);

     JLabel element8 = new JLabel("Etoiles :");
     element8.setBounds(170, 148, 222, 25);
     element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element8.setForeground(Color.decode("#ffffff"));
     panel.add(element8);

    //Label avec une image d'emoji de ribbon.png
    for (int i = 0; i < 5; i++) { // Affiche l'image 5 fois
    JLabel element9 = new JLabel(scaleIcon("src/assets/icons/ribbon.png", 20, 20));
    element9.setBounds(250 + (i * 30), 148, 20, 20); // Positionne chaque image avec un décalage horizontal
    panel.add(element9);
    }

    // Tableau pour stocker les emojis
    JLabel[] emojiLabels = new JLabel[5];
    int[] selectedValue = {0}; // Stocke la valeur sélectionnée

    for (int i = 0; i < 5; i++) {
     JLabel element9 = new JLabel(scaleIcon("src/assets/icons/ribbon.png", 20, 20));
     element9.setBounds(250 + (i * 30), 148, 20, 20); // Positionne chaque image avec un décalage horizontal
     element9.setBorder(BorderFactory.createEmptyBorder()); // Pas de bordure par défaut
     int value = i + 1; // Valeur associée à cet emoji

         // Ajout d'un MouseListener pour gérer les clics
         element9.addMouseListener(new java.awt.event.MouseAdapter() {
             @Override
             public void mouseClicked(java.awt.event.MouseEvent e) {
                 // Supprime le contour des autres emojis
                 for (JLabel emoji : emojiLabels) {
                     if (emoji != null) {
                         emoji.setBorder(BorderFactory.createEmptyBorder());
                     }
                 }
                 // Ajoute un contour à l'emoji cliqué
                 element9.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff"), 2));
                 selectedValue[0] = value; // Met à jour la valeur sélectionnée
             }
         });

     emojiLabels[i] = element9; // Ajoute l'emoji au tableau
     panel.add(element9);
    }

     JButton element13 = new JButton("Publier");
     element13.setBounds(329, 338, 106, 30);
     element13.setBackground(Color.decode("#003c6b"));
     element13.setForeground(Color.decode("#ffffff"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#003c6b"), Color.decode("#003c6b"));
     panel.add(element13);

     JTextArea element24 = new JTextArea("");
     element24.setBounds(170, 190, 434, 106);
     element24.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element24.setBackground(Color.decode("#203647"));
     element24.setForeground(Color.decode("#ffffff"));
     element24.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element24, "Commentaire :", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element24);

    // ActionListener pour le bouton "Publier"
    element13.addActionListener(e -> {
    if (selectedValue[0] == 0) {
       JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une note avant de publier.");
    } else {
       String commentaire = element24.getText().trim();
       if (commentaire.isEmpty()) {
          JOptionPane.showMessageDialog(frame, "Veuillez entrer un commentaire avant de publier.");
       } else {
           // Appel au contrôleur avec les IDs
          CommentaireControleur commentaireControleur = new CommentaireControleur();
          commentaireControleur.ajouterCommentaire(clientId, logId, selectedValue[0], commentaire);

          JOptionPane.showMessageDialog(frame, "Note attribuée : " + selectedValue[0] + "/5\nCommentaire publié !");
          frame.dispose(); // Ferme la fenêtre après publication
       }
    }
    });

     JButton element25 = new JButton("Contactez nous");
     element25.setBounds(-212, -123, 149, 35);
     element25.setBackground(Color.decode("#003c6b"));
     element25.setForeground(Color.decode("#ffffff"));
     element25.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element25.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element25.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element25, Color.decode("#003c6b"), Color.decode("#003c6b"));
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

    //##################### BOUTON RETOUR ######################
    //Ajouter bouton de retour en appelant le fichier return.java dans controlleur
    ImageIcon retourIcon = scaleIcon("src/assets/icons/return.png", 20, 20);
    JButton retourBtn = new JButton(retourIcon);
    retourBtn.setBounds(10, 350, 40, 30);
    retourBtn.setBackground(Color.decode("#bca8e4"));
    retourBtn.setForeground(Color.decode("#000"));
    retourBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    retourBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    Retour retour = new Retour();
    retourBtn.addActionListener(e -> {
        frame.dispose();
    });
    frame.add(retourBtn);

    frame.add(panel);
    frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}