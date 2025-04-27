package mvc.vue;

import mvc.modele.Adresse;
import mvc.modele.Client;
import mvc.modele.Logement;
import dao.*;
import mvc.modele.Reservation;

import java.awt.*;
import java.util.Date;
import javax.swing.*;

public class WireFramePageReservation {
   public static void main(String[] args) {
      WireFramePageReservation wireframe = new WireFramePageReservation();
      String clientMail = "alfreddevulpian@mail.com";
      int idLogement = 1;
      wireframe.WF_Reservation(clientMail, "WF_Accueil", idLogement);
   }

   public void WF_Reservation(String clientMail, String pagePrecedente, int idLogement) {
      System.out.println("Lancement de la page réservation avec le compte: " + clientMail + " logement id: " + idLogement);

      //a partir du mail, on appelle la methode getClientbyMail de la classe daoClient. Cette methode renvoie un client.
      daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
      daoClient clientDAO = new daoClient(dao);
      Client client = clientDAO.getClientByMail(clientMail);
      System.out.println(client.getNom());

      daoLogement logementDAO = new daoLogement(dao);
      Logement logement = logementDAO.chercher(idLogement);

      daoAdresse adresesDAO = new daoAdresse(dao);
      Adresse adresse = adresesDAO.chercher(idLogement);

      JFrame frame = new JFrame("Projet JAVA - WireFrame Page de réservation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(783, 422);
      frame.setLayout(null);

// ===== Label Titre Site =====
      JLabel title = new JLabel("WhereBnB.com");
      title.setFont(new Font("SansSerif", Font.BOLD, 15));
      title.setForeground(Color.BLACK);
      title.setBounds(20, 10, 200, 30); // x, y, largeur, hauteur
      frame.add(title);

// ===== Bouton "Mon Compte" =====
      JButton button_my_account = new JButton("Votre compte");
      button_my_account.setBounds(640, 10, 120, 30);
      button_my_account.setBackground(Color.decode("#003c6b"));
      button_my_account.setForeground(Color.WHITE);
      button_my_account.setFocusPainted(false);
      button_my_account.addActionListener(e -> {
         System.out.println("Mon compte");
         WireFramePageMonCompte pageMonCompte = new WireFramePageMonCompte();
         pageMonCompte.WF_MonCompte(clientMail, "WF_Reservation");
         frame.dispose();
      });
      frame.add(button_my_account);

// ===== Titre Logement =====
      JLabel title_logement = new JLabel(logement.getNom());
      title_logement.setFont(new Font("SansSerif", Font.BOLD, 18));
      title_logement.setBounds(20, 60, 300, 30);
      frame.add(title_logement);

// ===== Adresse =====
      JLabel adresse_logement = new JLabel(adresse.getNumero() + " " + adresse.getRue() + " " + adresse.getVille());
      adresse_logement.setFont(new Font("SansSerif", Font.PLAIN, 14));
      adresse_logement.setBounds(20, 90, 400, 30);
      frame.add(adresse_logement);

// ===== Image Logement =====
      ImageIcon originalImage = new ImageIcon("src/mvc.vue/images/logement.jpeg");
      Image scaledImage = originalImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
      ImageIcon resizedImage = new ImageIcon(scaledImage);
      JLabel image = new JLabel(resizedImage);
      image.setBounds(20, 130, 200, 200);
      frame.add(image);

// ===== Prix =====
      JLabel label_prix = new JLabel(logement.getPrix() + " €/mois");
      label_prix.setFont(new Font("SansSerif", Font.BOLD, 16));
      label_prix.setBounds(240, 130, 150, 30);
      frame.add(label_prix);

// ===== Note =====
      JLabel note = new JLabel("Note : " + logement.getNote());
      note.setFont(new Font("SansSerif", Font.PLAIN, 14));
      note.setBounds(240, 160, 150, 30);
      frame.add(note);

// ===== Propriétaire =====
      String nomProprio = clientDAO.chercher(logement.getProprioId()).getNom();
      JLabel label_nom_proprio = new JLabel("Propriétaire : " + nomProprio);
      label_nom_proprio.setBounds(240, 200, 300, 30);
      frame.add(label_nom_proprio);

// ===== Description =====
      JTextArea description = new JTextArea(logement.getDescription());
      description.setLineWrap(true);
      description.setWrapStyleWord(true);
      description.setEditable(false);
      description.setBounds(240, 240, 500, 60);
      frame.add(description);

// ===== Bouton Réserver =====
      JButton button_reserver = new JButton("Réserver");
      button_reserver.setBounds(600, 320, 120, 30);
      button_reserver.setBackground(Color.decode("#800080"));
      button_reserver.setForeground(Color.WHITE);
      button_reserver.addActionListener(e -> {
         System.out.println("Réserver");
         daoReservation reservationDAO = new daoReservation(dao);
         Date dateDebut = new Date();
         Date dateFin = new Date();
         float prixTotal = 200.f;
         boolean statutPaiement = false;
         Date datePaiement = new Date();
         int nbAdultes = 2;
         int nbEnfants = 2;
         Reservation reservation = new Reservation(1, client.getClientId(), logement.getLogementId(), dateDebut, dateFin, prixTotal, statutPaiement, datePaiement, nbAdultes, nbEnfants);
         System.out.println(reservation.toString());
         reservationDAO.ajouter(reservation);
      });
      frame.add(button_reserver);

// ===== Bouton Réserver =====
      JButton button_retour = new JButton("Retour");
      button_retour.setBounds(20, 320, 120, 30);
      button_retour.setBackground(Color.decode("#800080"));
      button_retour.setForeground(Color.WHITE);
      button_retour.addActionListener(e -> {
         System.out.println("Page Principale");
         WireFramePagePrincipale pagePrincipale = new WireFramePagePrincipale();
         pagePrincipale.WF_Principale(clientMail, "WF_Reservation");
         frame.dispose();
      });
      frame.add(button_retour);

      // Affichage
      frame.setVisible(true);

   }
}
