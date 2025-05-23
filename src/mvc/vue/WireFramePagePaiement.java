package mvc.vue;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

import mvc.controleur.PaiementControleur;
import mvc.modele.Reservation;
import mvc.vue.helper_classes.*;


/**
 * Classe WireFramePagePaiement
 *
 * Représente la page de paiement de l'application.
 * Permet à l'utilisateur de saisir ses informations de paiement et de finaliser sa réservation.
 */
public class WireFramePagePaiement {

   public static void main(String[] args) {
      //Lancement d'une instance par defaut
      WireFramePagePaiement wireFrame = new WireFramePagePaiement();
      String client_mail = "felixcadene@mail.com";
      Date date = new Date(System.currentTimeMillis());
      Date date2 = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000);

      Reservation reservation = new Reservation(0, 1, 1, date, date2, 2, false, date, 3, 1);
      wireFrame.WF_Paiement(client_mail, reservation);
   }

   public void WF_Paiement(String client_mail, Reservation reservation) {



     JFrame frame = new JFrame("Page paiement");
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
           pageMonCompte.WF_MonCompte(client_mail, "WF_Paiement");
           frame.dispose();
       });
       Navig_Bar.add(element5);

     JButton element13 = new JButton("Retour");
     element13.setBounds(25, 342, 106, 30);
     element13.setBackground(Color.decode("#003c6b"));
     element13.setForeground(Color.decode("#ffffff"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#7c6f97"), Color.decode("#003c6b"));
    element13.addActionListener(e -> {
        WireFramePageReservation pageReservation = new WireFramePageReservation();
        //"WF_Accueil", idLogement, LocalDate.now(), LocalDate.now().plusDays(7));"WF_Accueil", idLogement, LocalDate.now(), LocalDate.now().plusDays(7));

        //transformer les dates de reservation en LocalDate
        Date dateDebut = (Date) reservation.getDateDebut();
        Date dateFin = (Date) reservation.getDateFin();
        LocalDate dateDebutLocalDate = dateDebut.toLocalDate();
        LocalDate dateFinLocalDate = dateFin.toLocalDate();

        pageReservation.WF_Reservation(client_mail,"WF_Accueil", reservation.getResaId(), dateDebutLocalDate, dateFinLocalDate);
        frame.dispose();
    });
     panel.add(element13);

     JLabel element48 = new JLabel("Paiement");
     element48.setBounds(68, 71, 176, 36);
     element48.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 27));
     element48.setForeground(Color.decode("#ffffff"));
     panel.add(element48);

     JLabel element49 = new JLabel("Arrivée :");
     element49.setBounds(89, 112, 106, 18);
     element49.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element49.setForeground(Color.decode("#ffffff"));
     panel.add(element49);

     String dateDebut = reservation.getDateDebut().toString();
     JLabel element51 = new JLabel(dateDebut);
     element51.setBounds(106, 138, 106, 18);
     element51.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element51.setForeground(Color.decode("#ffffff"));
     panel.add(element51);

     JLabel element52 = new JLabel("Départ :");
     element52.setBounds(89, 160, 106, 18);
     element52.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element52.setForeground(Color.decode("#ffffff"));
     panel.add(element52);

     String dateFin = reservation.getDateFin().toString();
     JLabel element53 = new JLabel(dateFin);
     element53.setBounds(105, 179, 126, 21);
     element53.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element53.setForeground(Color.decode("#ffffff"));
     panel.add(element53);

     JLabel element54 = new JLabel("Durée du séjour :");
     element54.setBounds(89, 204, 120, 19);
     element54.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element54.setForeground(Color.decode("#ffffff"));
     panel.add(element54);

     JLabel element55 = new JLabel("Total de personnes :");
     element55.setBounds(89, 224, 147, 21);
     element55.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element55.setForeground(Color.decode("#ffffff"));
     panel.add(element55);

     JLabel element56 = new JLabel("Total de chambres :");
     element56.setBounds(89, 245, 133, 20);
     element56.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element56.setForeground(Color.decode("#ffffff"));
     panel.add(element56);

     JLabel element57 = new JLabel("Prix total :");
     element57.setBounds(89, 280, 106, 18);
     element57.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element57.setForeground(Color.decode("#ffffff"));
     panel.add(element57);

      JLabel element58 = new JLabel(reservation.getPrixTotal() + " €");
     element58.setBounds(192, 285, 63, 25);
     element58.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element58.setForeground(Color.decode("#ffffff"));
     panel.add(element58);

     String dureeSejour = reservation.getDateFin().toString() + " - " + reservation.getDateDebut().toString();
     Float dureeSejourFloat = (float) (reservation.getDateFin().getTime() - reservation.getDateDebut().getTime()) / (1000 * 60 * 60 * 24);
     JLabel element59 = new JLabel("" + dureeSejourFloat + " jours");
     element59.setBounds(210, 205, 60, 18);
     element59.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element59.setForeground(Color.decode("#ffffff"));
     panel.add(element59);

     Float totalPersonnes = (float) (reservation.getNbAdultes() + reservation.getNbEnfants());
     JLabel element60 = new JLabel("" + totalPersonnes + " personnes");
     element60.setBounds(234, 224, 106, 18);
     element60.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element60.setForeground(Color.decode("#ffffff"));
     panel.add(element60);

     Float totalChambres = (float) reservation.getNbAdultes() / 2 + (reservation.getNbEnfants() / 2) + 1;
     //si totalChambres est un nombre decimal, on l'arrondi a l'entier superieur
     if (totalChambres % 1 != 0) {
         totalChambres = (float) Math.ceil(totalChambres);
     }
     JLabel element61 = new JLabel("" + totalChambres + " chambres");
     element61.setBounds(230, 246, 106, 18);
     element61.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element61.setForeground(Color.decode("#ffffff"));
     panel.add(element61);

     JLabel element62 = new JLabel("Client :");
     element62.setBounds(382, 86, 106, 18);
     element62.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element62.setForeground(Color.decode("#ffffff"));
     panel.add(element62);

     JTextField element63 = new JTextField("");
     element63.setBounds(416, 108, 162, 24);
     element63.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element63.setBackground(Color.decode("#203647"));
     element63.setForeground(Color.decode("#ffffff"));
     element63.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element63, "ex : Sophie Marceau", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element63);

     JLabel element64 = new JLabel("Détails du paiement :");
     element64.setBounds(382, 146, 169, 18);
     element64.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element64.setForeground(Color.decode("#ffffff"));
     panel.add(element64);

     JLabel element65 = new JLabel("Notez que si vous annulez la réservation, le  rembousement");
     element65.setBounds(416, 176, 335, 24);
     element65.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element65.setForeground(Color.decode("#ffffff"));
     panel.add(element65);

     JLabel element66 = new JLabel("dépendra de la politique d'annulation dans vos conditions ");
     element66.setBounds(416, 190, 327, 24);
     element66.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element66.setForeground(Color.decode("#ffffff"));
     panel.add(element66);

     JLabel element67 = new JLabel("de réservations.");
     element67.setBounds(416, 206, 334, 19);
     element67.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 12));
     element67.setForeground(Color.decode("#ffffff"));
     panel.add(element67);

     JLabel element68 = new JLabel("Nom sur la carte :");
     element68.setBounds(382, 237, 171, 18);
     element68.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element68.setForeground(Color.decode("#ffffff"));
     panel.add(element68);

     JTextField element69 = new JTextField("");
     element69.setBounds(519, 235, 162, 24);
     element69.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element69.setBackground(Color.decode("#203647"));
     element69.setForeground(Color.decode("#ffffff"));
     element69.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element69, "remplir", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element69);

     JLabel element70 = new JLabel("Numéro de carte :");
     element70.setBounds(382, 270, 149, 20);
     element70.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element70.setForeground(Color.decode("#ffffff"));
     panel.add(element70);

     JLabel element71 = new JLabel("CVV :");
     element71.setBounds(382, 314, 106, 18);
     element71.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element71.setForeground(Color.decode("#ffffff"));
     panel.add(element71);

     JLabel element72 = new JLabel("Date d'expiration :");
     element72.setBounds(382, 294, 137, 17);
     element72.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element72.setForeground(Color.decode("#ffffff"));
     panel.add(element72);

     JTextField element73 = new JTextField("");
     element73.setBounds(519, 266, 162, 24);
     element73.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element73.setBackground(Color.decode("#203647"));
     element73.setForeground(Color.decode("#ffffff"));
     element73.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element73, "remplir", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element73);

     JTextField element74 = new JTextField("");
     element74.setBounds(519, 291, 162, 24);
     element74.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element74.setBackground(Color.decode("#203647"));
     element74.setForeground(Color.decode("#ffffff"));
     element74.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element74, "remplir", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element74);

     JTextField element75 = new JTextField("");
     element75.setBounds(518, 316, 162, 24);
     element75.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element75.setBackground(Color.decode("#203647"));
     element75.setForeground(Color.decode("#ffffff"));
     element75.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element75, "remplir", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element75);

     JButton element76 = new JButton("Payer");
     element76.setBounds(408, 345, 106, 30);
     element76.setBackground(Color.decode("#003c6b"));
     element76.setForeground(Color.decode("#ffffff"));
     element76.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element76.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element76.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element76, Color.decode("#7c6f97"), Color.decode("#003c6b"));
     panel.add(element76);

     element76.addActionListener(e -> {
         // Vérification des champs de saisie
         String defaultText1 = "ex : Sophie Marceau";
         String defaultText2 = "remplir";
         if (element63.getText().trim().isEmpty() || element63.getText().trim().equals(defaultText1) ||
                 element69.getText().trim().isEmpty() || element69.getText().trim().equals(defaultText2) ||
                 element73.getText().trim().isEmpty() || element73.getText().trim().equals(defaultText2) ||
                 element74.getText().trim().isEmpty() || element74.getText().trim().equals(defaultText2) ||
                 element75.getText().trim().isEmpty() || element75.getText().trim().equals(defaultText2)) {
           JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs de paiement.", "Erreur", JOptionPane.ERROR_MESSAGE);
           return;
         }

         // Effacer uniquement le contenu du panneau principal
         panel.removeAll();
         panel.revalidate();
         panel.repaint();

         // Ajouter un label pour l'animation de chargement
         JLabel loadingLabel = new JLabel("Chargement.");
         loadingLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
         loadingLabel.setForeground(Color.decode("#ffffff"));
         loadingLabel.setBounds(350, 200, 300, 30);
         panel.add(loadingLabel);
         panel.revalidate();
         panel.repaint();

         // Animation de chargement
         Timer animationTimer = new Timer(500, null);
         animationTimer.addActionListener(event -> {
             String text = loadingLabel.getText();
             if (text.equals("Chargement.")) {
                 loadingLabel.setText("Chargement..");
             } else if (text.equals("Chargement..")) {
                 loadingLabel.setText("Chargement...");
             } else {
                 loadingLabel.setText("Chargement.");
             }
         });
         animationTimer.start();

         // Délai de 5 secondes avant d'appeler le contrôleur
         Timer actionTimer = new Timer(5000, event -> {
             animationTimer.stop();
             panel.removeAll();
             panel.revalidate();
             panel.repaint();
             Navig_Bar.removeAll();

             // Appel du contrôleur de paiement
             PaiementControleur paiementControleur = new PaiementControleur();
             paiementControleur.effectuerPaiement(reservation);

             // Affichage d'une alerte de confirmation
             JOptionPane.showMessageDialog(frame, "Le paiement a été effectué.", "Succès", JOptionPane.INFORMATION_MESSAGE);
             frame.dispose();
         });
         actionTimer.setRepeats(false);
         actionTimer.start();
     });

     JButton element77 = new JButton("Contactez nous");
     element77.setBounds(640, 348, 120, 29);
     element77.setBackground(Color.decode("#003c6b"));
     element77.setForeground(Color.decode("#ffffff"));
     element77.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element77.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element77.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element77, Color.decode("#7c6f97"), Color.decode("#003c6b"));
     panel.add(element77);
     element77.addActionListener(e -> {
        // Afficher la page d'aide
        WireFramePageAide pageAide = new WireFramePageAide();
        pageAide.WF_Aide("", "WF_Paiement");
        frame.dispose();
     });

     frame.add(panel);
     frame.setVisible(true);
  }
   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}