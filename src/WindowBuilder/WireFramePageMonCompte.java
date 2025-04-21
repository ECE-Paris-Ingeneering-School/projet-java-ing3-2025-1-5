package WindowBuilder;

import MVC.controleur.*;
import MVC.modele.Client;
import WindowBuilder.helper_classes.*;
import dao.daoClient;
import dao.daoConnect;
import java.awt.*;
import javax.swing.*;



public class WireFramePageMonCompte {
   public static void main(String[] args) {

      //Lancement d'une instance par defaut
      WireFramePageMonCompte wireFrame = new WireFramePageMonCompte();
      String client_mail = "felixcadene@mail.com";
      wireFrame.WF_MonCompte(client_mail, "WF_Accueil");
   }


   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }


   public void WF_MonCompte(String client_mail, String page_precedente) {
      System.out.println("WireFramePageMonCompte.java : Lancement de la page Mon Compte avec le mail : " + client_mail);

      //a partir du mail, on appelle la methode getClientbyMail de la classe daoClient. Cette methode renvoie un client.
      daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
      daoClient clientDAO = new daoClient(dao);
      Client client = clientDAO.getClientByMail(client_mail);
      System.out.println(client.getNom());

      JFrame frame = new JFrame("Projet JAVA - WireFrame Page mon compte");
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

      ImageIcon emojiIcon = scaleIcon("src/ressources/emojis/anger.png", 20, 20);
      JButton element5 = new JButton("Se deconnecter", emojiIcon);
      element5.setBounds(600, 6, 150, 40);
      element5.setBackground(Color.decode("#bca8e4"));
      element5.setForeground(Color.decode("#000000"));
      element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element5.setFocusPainted(false);
      element5.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
      element5.setHorizontalTextPosition(SwingConstants.RIGHT);
      OnClickEventHelper.setOnClickColor(element5, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      //On click, call the method afficher_moncompte de la classe WireFramePageMonCompte
      element5.addActionListener(e -> {
         //Se deconnecter
         System.out.println("Se deconnecter");
         WireFramePageConnexion page_connexion = new WireFramePageConnexion();
         page_connexion.main(null);
         frame.dispose();
      });
      Navig_Bar.add(element5);

      ImageIcon emojiIcon_bienvenue = scaleIcon("src/ressources/emojis/blush.png", 20, 20);
      JLabel element6 = new JLabel("Bienvenue a votre espace");
      element6.setIcon(emojiIcon_bienvenue);
      element6.setBounds(63,65,450,40);
      element6.setFont(new Font("SansSerif", Font.BOLD, 25));
      element6.setForeground(Color.decode("#000"));
      panel.add(element6);

      /*
       * COLONNE 1: INFOROMATIONS PERSONNELLES
       *  --> Nom (modifiable)
       *  --> Mail (modifiable)
       *  --> Telephone (modifiable)
       */
      JLabel element7 = new JLabel("Mes informations personnelles : ");
      element7.setBounds(63,120,450,25);
      element7.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element7.setForeground(Color.decode("#000"));
      panel.add(element7);

      
      JLabel element8 = new JLabel(scaleIcon("src/ressources/emojis/person.png", 20, 20));
      element8.setText("Nom : ");
      element8.setBounds(81, 150, 105, 18);
      element7.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element8.setForeground(Color.decode("#000"));
      panel.add(element8);


      JLabel element9 = new JLabel(client.getNom());
      element9.setBounds(170, 152, 143, 18);
      element9.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
      element9.setForeground(Color.decode("#000"));
      panel.add(element9);

      ImageIcon pencilIcon = new ImageIcon("src/ressources/emojis/pencil2.png"); // Chemin vers l'icône
      pencilIcon = scaleIcon("src/ressources/emojis/pencil2.png", 20, 20); // Redimensionner l'icône
      JButton editNameBtn = new JButton(pencilIcon);
      editNameBtn.setBounds(300, 150, 20, 20);
      editNameBtn.setBackground(Color.decode("#bca8e4"));
      editNameBtn.setForeground(Color.decode("#000"));
      editNameBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      editNameBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      editNameBtn.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(editNameBtn, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      editNameBtn.addActionListener(e -> {
         JTextField newNameField = new JTextField(client.getNom()); // Pré-remplir avec le nom actuel
         int result = JOptionPane.showConfirmDialog(
                  frame,
                  new Object[]{"Entrez votre nouveau nom:", newNameField},
                  "Modifier le nom",
                  JOptionPane.OK_CANCEL_OPTION
         );

         if (result == JOptionPane.OK_OPTION) {
            String newName = newNameField.getText().trim();
            if (!newName.equals("")) {
                  element9.setText(newName);
                  client.setNom(newName);
                  clientDAO.modifier(client);
            }
         }
      });
      panel.add(editNameBtn);

      //Numero de telephone dont icone est telephone_receiver.png
      JLabel element10 = new JLabel(scaleIcon("src/ressources/emojis/telephone_receiver.png", 20, 20));
      element10.setText("Tel : ");
      element10.setBounds(81, 180, 105, 18);
      element10.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element10.setForeground(Color.decode("#000"));
      panel.add(element10);

      JLabel element11 = new JLabel(client.getNumTelephone());
      element11.setBounds(170, 182, 143, 18);
      element11.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
      element11.setForeground(Color.decode("#000"));
      panel.add(element11);
      JButton editPhoneBtn = new JButton(pencilIcon);
      editPhoneBtn.setBounds(300, 180, 20, 20);
      editPhoneBtn.setBackground(Color.decode("#bca8e4"));
      editPhoneBtn.setForeground(Color.decode("#000"));
      editPhoneBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      editPhoneBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      editPhoneBtn.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(editPhoneBtn, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      editPhoneBtn.addActionListener(e -> {
         JTextField newPhoneField = new JTextField(client.getNumTelephone()); // Pré-remplir avec le numéro actuel
         int result = JOptionPane.showConfirmDialog(
                  frame,
                  new Object[]{"Entrez votre nouveau numéro de téléphone:", newPhoneField},
                  "Modifier le numéro de téléphone",
                  JOptionPane.OK_CANCEL_OPTION
         );

         if (result == JOptionPane.OK_OPTION) {
            String newPhone = newPhoneField.getText().trim();
            if (newPhone.length() != 10) {
               JOptionPane.showMessageDialog(frame, "Le numéro de téléphone doit contenir 10 chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!newPhone.matches("\\d+")) {
               JOptionPane.showMessageDialog(frame, "Le numéro de téléphone ne doit contenir que des chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!newPhone.equals("")) {
                  element11.setText(newPhone);
                  client.setNumTelephone(newPhone);
                  clientDAO.modifier(client);
            }
         }
      });
      panel.add(editPhoneBtn);

      //Email dont l'icone est email.png
      JLabel element12 = new JLabel(scaleIcon("src/ressources/emojis/email.png", 20, 20));
      element12.setText("Email : ");
      element12.setBounds(81, 210, 120, 18);
      element12.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element12.setForeground(Color.decode("#000"));
      panel.add(element12);

      JLabel element13 = new JLabel(client.getEmail());
      element13.setBounds(180, 212, 143, 18);
      element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
      element13.setForeground(Color.decode("#000"));
      panel.add(element13);

      JLabel element18 = new JLabel(scaleIcon("src/ressources/emojis/lock.png", 20, 20));
      element18.setText("Mot de Passe : ");
      element18.setBounds(81, 240, 180, 18);
      element18.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element18.setForeground(Color.decode("#000"));
      panel.add(element18);

      JLabel element19 = new JLabel("**********");
      element19.setBounds(250, 242, 143, 18);
      element19.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
      element19.setForeground(Color.decode("#000"));
      panel.add(element19);

      //Ajout d'un bouton avec l'oeil eye.png qui permet de voir le mot de passe via un popup
      ImageIcon eyeIcon = scaleIcon("src/ressources/emojis/eye.png", 20, 20);
      JButton eyeBtn = new JButton(eyeIcon);
      eyeBtn.setBounds(300, 240, 20, 20);
      eyeBtn.setBackground(Color.decode("#bca8e4"));
      eyeBtn.setForeground(Color.decode("#000"));
      eyeBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      eyeBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      eyeBtn.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(eyeBtn, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      eyeBtn.addActionListener(e -> {
         JOptionPane.showMessageDialog(frame, "Mot de passe : " + client.getMDP(), "Mot de passe", JOptionPane.INFORMATION_MESSAGE);
      });
      panel.add(eyeBtn);

      //Ajout d'un bouton avec l'icone de crayon qui permet de changer le mot de passe via un popup
      JButton editPasswordBtn = new JButton(pencilIcon);
      editPasswordBtn.setBounds(330, 240, 20, 20);
      editPasswordBtn.setBackground(Color.decode("#bca8e4"));
      editPasswordBtn.setForeground(Color.decode("#000"));
      editPasswordBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      editPasswordBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      editPasswordBtn.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(editPasswordBtn, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      editPasswordBtn.addActionListener(e -> {
         JPasswordField currentPasswordField = new JPasswordField(); // Champ pour entrer le mot de passe actuel
         JPasswordField newPasswordField = new JPasswordField(); // Champ pour entrer le nouveau mot de passe
     
         int result = JOptionPane.showConfirmDialog(
                 frame,
                 new Object[]{
                     "Entrez votre mot de passe actuel:", currentPasswordField,
                     "Entrez votre nouveau mot de passe:", newPasswordField
                 },
                 "Modifier le mot de passe",
                 JOptionPane.OK_CANCEL_OPTION
         );
     
         if (result == JOptionPane.OK_OPTION) {
             String currentPassword = new String(currentPasswordField.getPassword()).trim();
             String newPassword = new String(newPasswordField.getPassword()).trim();
     
             if (!currentPassword.equals(client.getMDP())) {
                 JOptionPane.showMessageDialog(frame, "Le mot de passe actuel est incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
             } else if (newPassword.length() < 6) {
                 JOptionPane.showMessageDialog(frame, "Le nouveau mot de passe doit contenir au moins 6 caractères.", "Erreur", JOptionPane.ERROR_MESSAGE);
             } else {
                 client.setMDP(newPassword);
                 clientDAO.modifier(client);
                 JOptionPane.showMessageDialog(frame, "Mot de passe modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
             }
         }
      });
      panel.add(editPasswordBtn);




      /*
       * COLONNE 2: SUIVI DE VOYAGE
       *  --> Votre prochain voyage avec le lieu, date de depart et date de retour.
       *    --> Cliquable. Quand on clique on a une popup avec les details de la reservation.
       *  --> Si pas de voyage, on a un message "Pas de voyage en cours"
       *  Votre dernier commentaire avec texte restreint. Cliquer pour voir le commentaire entier.
       *  --> Si pas de commentaire, on a un message "Pas de commentaire"
       *  Vos voyages passés avec le lieu, date de depart et date de retour.
       *  --> Cliquable. Quand on clique on a une popup avec les details de la reservation.
       *  --> Si pas de voyage, on a un message "Pas de voyage passé"
      */

      JLabel element14 = new JLabel("Suivi de voyage : ");
      element14.setBounds(450,120,450,25);
      element14.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element14.setForeground(Color.decode("#000"));
      panel.add(element14);

      JLabel element15 = new JLabel("Prochain voyage : ");
      element15.setBounds(470, 150, 200, 18);
      element15.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element15.setForeground(Color.decode("#000"));
      panel.add(element15);

      //Methode pour afficher le prochain voyage
      afficher_prochain_voyage(client);
      
      JLabel element16 = new JLabel("Dernier commentaire : ");
      element16.setBounds(470, 180, 200, 18);
      element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element16.setForeground(Color.decode("#000"));
      panel.add(element16);

      //Methode pour afficher le dernier commentaire
      afficher_dernier_commentaire(client);

      JLabel element17 = new JLabel("Vos voyages passés : ");
      element17.setBounds(470, 210, 200, 18);
      element17.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
      element17.setForeground(Color.decode("#000"));
      panel.add(element17);

      //Methode pour afficher les voyages passes
      afficher_voyages_passes(client);


      //Ajouter bouton de retour en appelant le fichier return.java dans controlleur
      ImageIcon retourIcon = scaleIcon("src/ressources/emojis/return.png", 20, 20);
      JButton retourBtn = new JButton(retourIcon);
      retourBtn.setBounds(10, 300, 30, 30);
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




      frame.add(panel);
      frame.setVisible(true);
   }

   public void afficher_prochain_voyage(Client client) {
      //A implementer
      //On va chercher le prochain voyage du client dans la base de donnee
      //Si pas de voyage, on affiche "Pas de voyage en cours"
      //Sinon, on affiche le voyage avec le lieu, date de depart et date de retour.
      //Cliquable. Quand on clique on a une popup avec les details de la reservation.
      //On va chercher le prochain voyage du client dans la base de donnee
   }

   public void afficher_dernier_commentaire(Client client) {
      //A implementer
      //On va chercher le dernier commentaire du client dans la base de donnee
      //Si pas de commentaire, on affiche "Pas de commentaire"
      //Sinon, on affiche le commentaire avec le texte restreint. Cliquable. Quand on clique on a une popup avec les details du commentaire.
      //On va chercher le dernier commentaire du client dans la base de donnee
   }

   public void afficher_voyages_passes(Client client) {
      //A implementer
      //On va chercher les voyages passes du client dans la base de donnee
      //Si pas de voyage, on affiche "Pas de voyage passé"
      //Sinon, on affiche les voyages passes avec le lieu, date de depart et date de retour.
      //Cliquable. Quand on clique on a une popup avec les details de la reservation.
      //On va chercher les voyages passes du client dans la base de donnee
   }
}