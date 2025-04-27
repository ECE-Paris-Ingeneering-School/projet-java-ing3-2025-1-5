package mvc.vue;

import mvc.modele.Adresse;
import mvc.modele.Client;
import mvc.modele.Logement;
import dao.*;
import mvc.modele.Reservation;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.*;

public class WireFramePageReservation {

   public static void main(String[] args) {
      WireFramePageReservation wireframe = new WireFramePageReservation();
      String clientMail = "alfreddevulpian@mail.com";
      int idLogement = 1;
      wireframe.WF_Reservation(clientMail, "WF_Accueil", idLogement, LocalDate.now(), LocalDate.now().plusDays(7));
   }

   public void WF_Reservation(String clientMail, String pagePrecedente, int idLogement, LocalDate dateArrivee, LocalDate dateDepart) {
      System.out.println("Lancement de la page réservation avec le compte: " + clientMail + " logement id: " + idLogement);

      daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
      daoClient clientDAO = new daoClient(dao);
      Client client = clientDAO.getClientByMail(clientMail);

      daoLogement logementDAO = new daoLogement(dao);
      Logement logement = logementDAO.chercher(idLogement);

      daoAdresse adresesDAO = new daoAdresse(dao);
      Adresse adresse = adresesDAO.chercher(idLogement);

      JFrame frame = new JFrame("Page de réservation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 500);
      frame.setLayout(null);
      frame.getContentPane().setBackground(Color.decode("#091f30")); // fond général

// ===== Label Titre Site =====
      JLabel title = new JLabel("WhereBnB.com");
      title.setFont(new Font("SansSerif", Font.BOLD, 20));
      title.setForeground(Color.WHITE);
      title.setBounds(20, 10, 200, 30);
      frame.add(title);

// ===== Bouton "Mon Compte" =====
      JButton button_my_account = new JButton("Votre compte");
      button_my_account.setBounds(640, 10, 120, 30);
      button_my_account.setBackground(Color.decode("#003c6b"));
      button_my_account.setForeground(Color.WHITE);
      button_my_account.setFocusPainted(false);
      button_my_account.addActionListener(e -> {
         WireFramePageMonCompte pageMonCompte = new WireFramePageMonCompte();
         pageMonCompte.WF_MonCompte(clientMail, "WF_Reservation");
         frame.dispose();
      });
      frame.add(button_my_account);

// ===== Titre Logement =====
      JLabel title_logement = new JLabel(logement.getNom());
      title_logement.setFont(new Font("SansSerif", Font.BOLD, 18));
      title_logement.setForeground(Color.WHITE);
      title_logement.setBounds(20, 60, 300, 30);
      frame.add(title_logement);

// ===== Adresse =====
      JLabel adresse_logement = new JLabel(adresse.getNumero() + " " + adresse.getRue() + " " + adresse.getVille());
      adresse_logement.setFont(new Font("SansSerif", Font.PLAIN, 14));
      adresse_logement.setForeground(Color.WHITE);
      adresse_logement.setBounds(20, 90, 400, 30);
      frame.add(adresse_logement);

// ===== Images du Logement (Grille) =====
      int nb_images = 6;
      int images_par_ligne = 3;
      int x_depart = 20;
      int y_depart = 130;
      int decalage_x = 100;
      int decalage_y = 100;
      int largeur_image = 80;
      int hauteur_image = 80;

      ImageIcon icone_secours = charger_image("src/assets/images/logement" + idLogement + "_image1");
      if (icone_secours == null) {
         System.out.println("Image de secours manquante !");
      }

      for (int i = 1; i <= nb_images; i++) {
         ImageIcon icone_originale = charger_image("src/assets/images/logement" + idLogement + "_image" + i);

         if (icone_originale == null) {
            System.out.println("Image logement " + i + " non trouvée -> utilisation de l'image de secours");
            icone_originale = icone_secours;
         }
         if (icone_originale == null) continue;

         Image image_redimensionnee = icone_originale.getImage().getScaledInstance(largeur_image, hauteur_image, Image.SCALE_SMOOTH);
         ImageIcon icone_redimensionnee = new ImageIcon(image_redimensionnee);

         JLabel label_image = new JLabel(icone_redimensionnee);
         int x = x_depart + ((i - 1) % images_par_ligne) * decalage_x;
         int y = y_depart + ((i - 1) / images_par_ligne) * decalage_y;
         label_image.setBounds(x, y, largeur_image, hauteur_image);

         frame.add(label_image);
      }

// ===== Prix =====
      JLabel label_prix = new JLabel(logement.getPrix() + " €/mois");
      label_prix.setFont(new Font("SansSerif", Font.BOLD, 16));
      label_prix.setForeground(Color.WHITE);
      label_prix.setBounds(320, 130, 150, 30);
      frame.add(label_prix);

// ===== Note =====
      JLabel note = new JLabel("Note : " + logement.getNote());
      note.setFont(new Font("SansSerif", Font.PLAIN, 14));
      note.setForeground(Color.WHITE);
      note.setBounds(320, 160, 150, 30);
      frame.add(note);

// ===== Propriétaire =====
      String nomProprio = clientDAO.chercher(logement.getProprioId()).getNom();
      JLabel label_nom_proprio = new JLabel("Propriétaire : " + nomProprio);
      label_nom_proprio.setFont(new Font("SansSerif", Font.PLAIN, 14));
      label_nom_proprio.setForeground(Color.WHITE);
      label_nom_proprio.setBounds(320, 200, 300, 30);
      frame.add(label_nom_proprio);

// ===== Description =====
      JTextArea description = new JTextArea(logement.getDescription());
      description.setLineWrap(true);
      description.setWrapStyleWord(true);
      description.setEditable(false);
      description.setBounds(320, 240, 440, 60);
      description.setBackground(Color.decode("#203647")); // Fond description
      description.setForeground(Color.WHITE);
      description.setFont(new Font("SansSerif", Font.PLAIN, 13));
      frame.add(description);

// ===== Bouton Réserver =====
      JButton button_reserver = new JButton("Réserver");
      button_reserver.setBounds(640, 400, 120, 30);
      button_reserver.setBackground(Color.decode("#003c6b"));
      button_reserver.setForeground(Color.WHITE);
      button_reserver.addActionListener(e -> {
         daoReservation reservationDAO = new daoReservation(dao);
         Date dateDebut = Date.valueOf(dateArrivee);
         Date dateFin = Date.valueOf(dateDepart);
         boolean statutPaiement = false;
         LocalDate localDatePaiement = LocalDate.now();
         Date datePaiement = Date.valueOf(localDatePaiement);
         int nbAdultes = 2;
         int nbEnfants = 2;
         long duree = (dateFin.getTime() - dateDebut.getTime()) / (24 * 60 * 60 * 1000);
         float prixTotal = nbAdultes * duree * logement.getPrix();

         Reservation reservation = new Reservation(1, client.getClientId(), logement.getLogementId(), dateDebut, dateFin, prixTotal, statutPaiement, datePaiement, nbAdultes, nbEnfants);

         WireFramePagePaiement pagePaiement = new WireFramePagePaiement();
         pagePaiement.WF_Paiement(clientMail, reservation);
         frame.dispose();
      });
      frame.add(button_reserver);

// ===== Bouton Retour =====
      JButton button_retour = new JButton("Retour");
      button_retour.setBounds(10, 400, 120, 30);
      button_retour.setBackground(Color.decode("#003c6b"));
      button_retour.setForeground(Color.WHITE);
      button_retour.addActionListener(e -> {
         WireFramePagePrincipale pagePrincipale = new WireFramePagePrincipale();
         pagePrincipale.WF_Principale(clientMail, "WF_Reservation");
         frame.dispose();
      });
      frame.add(button_retour);

      frame.setVisible(true);
   }

   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }

   private ImageIcon charger_image(String base_path) {
      String[] extensions = {".png", ".jpg", ".jpeg"};
      for (String ext : extensions) {
         String chemin = base_path + ext;
         ImageIcon icone = new ImageIcon(chemin);
         if (icone.getIconWidth() != -1) {
            return icone;
         }
      }
      return null;
   }
}
