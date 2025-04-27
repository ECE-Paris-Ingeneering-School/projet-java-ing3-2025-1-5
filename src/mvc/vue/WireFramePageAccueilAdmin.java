package mvc.vue;

import mvc.controleur.ClientControl;
import mvc.controleur.LogementControl;
import mvc.controleur.ReservationControl;
import mvc.controleur.Retour;
import mvc.modele.Client;
import mvc.vue.helper_classes.*;
import dao.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;


/** * Classe de la page d'accueil de l'administrateur
 */

public class WireFramePageAccueilAdmin {
   public static void main(String[] args) throws Exception {
        //Lancement d'une instance par defaut
        WireFramePageAccueilAdmin wireFrame = new WireFramePageAccueilAdmin();
        String client_mail = "leondalle@mail.com";
        wireFrame.WF_AccueilAdmin(client_mail);
   }

   public void WF_AccueilAdmin(String client_mail) throws Exception {

       ClientControl clientControl = new ClientControl("wherebnb", "root", "");
       Client client = clientControl.getClientByMail(client_mail);
       System.out.println(client.getNom());
      System.out.println(client.getNom());

     JFrame frame = new JFrame("Page accueil admin");
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

      ImageIcon emojiIcon = scaleIcon("src/assets/icons/anger.png", 20, 20);
      JButton element5 = new JButton("Se deconnecter", emojiIcon);
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
         //Se deconnecter
         System.out.println("Se deconnecter");
         WireFramePageConnexion page_connexion = new WireFramePageConnexion();
         page_connexion.main(null);
         frame.dispose();
      });
      Navig_Bar.add(element5);

     JLabel element78 = new JLabel("Accueil Admin");
     element78.setBounds(350, 83, 220, 33);
     element78.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element78.setForeground(Color.decode("#ffffff"));
     panel.add(element78);

     JLabel element79 = new JLabel("STATISTIQUES");
     element79.setBounds(41, 83, 178, 30);
     element79.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element79.setForeground(Color.decode("#ffffff"));
     panel.add(element79);

     JLabel element80 = new JLabel("Nombre de clients :");
     element80.setBounds(60, 123, 135, 18);
     element80.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element80.setForeground(Color.decode("#ffffff"));
     panel.add(element80);

     JLabel element81 = new JLabel("Nombre de logements :");
     element81.setBounds(60, 143, 163, 18);
     element81.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element81.setForeground(Color.decode("#ffffff"));
     panel.add(element81);

     JLabel element82 = new JLabel("Moyenne de durée de séjour :");
     element82.setBounds(60, 163, 206, 21);
     element82.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element82.setForeground(Color.decode("#ffffff"));
     panel.add(element82);

     JLabel element83 = new JLabel("Pays d'origine des logements :");
     element83.setBounds(60, 183, 216, 23);
     element83.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element83.setForeground(Color.decode("#ffffff"));
     panel.add(element83);

     JLabel element84 = new JLabel("xxx");
     //appel de la fonction daoLogement.getLogements() pour recuperer le nombre de logements
     //int nombreClients = clientDAO.nb_clients();
     int nombreClients = clientControl.getNombreClients();
     element84.setText(String.valueOf(nombreClients));

     element84.setBounds(204, 123, 106, 18);
     element84.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element84.setForeground(Color.decode("#ffffff"));
     panel.add(element84);

     JLabel element85 = new JLabel("xxx");
     //appel de la fonction daoLogement.getLogements() pour recuperer le nombre de logements
       LogementControl logementControl = new LogementControl();
       int nombreLogements = logementControl.getNombreLogements();
       element85.setText(String.valueOf(nombreLogements));

     element85.setBounds(232, 143, 106, 18);
     element85.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element85.setForeground(Color.decode("#ffffff"));
     panel.add(element85);


     JLabel element86 = new JLabel("xxx");
       ReservationControl reservationControl = new ReservationControl();
       double moyenneDureeSejour = reservationControl.getMoyenneDureeSejour();
       element86.setText(String.valueOf(moyenneDureeSejour) + " jours");

     element86.setBounds(264, 163, 106, 18);
     element86.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element86.setForeground(Color.decode("#ffffff"));
     panel.add(element86);

       /// //////////////////PIE CHART PONDERE//////////////////////
       PieChart element87 = new PieChartBuilder().width(1200).height(1200).build();
       LogementControl adresseControl = new LogementControl();
       ArrayList<String> Listepays = adresseControl.getPaysLocation();

       Map<String, Integer> counts = new HashMap<>(); // Compter le nombre de fois qu'il y a un même pays
       for (String pays : Listepays) {
           counts.put(pays, counts.getOrDefault(pays, 0) + 1);
       }
       element87.getStyler().setPlotBorderVisible(false);
       element87.getStyler().setStartAngleInDegrees(90);

       for (Map.Entry<String, Integer> entry : counts.entrySet()) {
           element87.addSeries(entry.getKey(), entry.getValue());
       }

       element87.getStyler().setChartBackgroundColor(new Color(9, 31, 48)); //on met les couleurs de la page principale pour une cohérence esthétique
       element87.getStyler().setPlotBackgroundColor(new Color(9, 31, 48));

       XChartPanel<PieChart> element87Chart = new XChartPanel<>(element87);
       element87Chart.setBounds(110, 183, 200, 200);
       panel.add(element87Chart);

       /// //////////////////////////////////////////////////////////////////////



     JButton element88 = new JButton("Voir clients");
     element88.setBounds(350, 162, 155, 30);
     element88.setBackground(Color.decode("#003c6b"));
     element88.setForeground(Color.decode("#ffffff"));
     element88.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element88.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element88.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element88, Color.decode("#003c6b"), Color.decode("#003c6b"));
     element88.addActionListener(e -> {
         WireFramePageDossierClients pageClients = new WireFramePageDossierClients();
         pageClients.WF_DossierClients(client_mail, "WF_AccueilAdmin");
     });
     panel.add(element88);

     JButton element89 = new JButton("Modifier logement(s)");
     element89.setBounds(350, 212, 155, 30);
     element89.setBackground(Color.decode("#003c6b"));
     element89.setForeground(Color.decode("#ffffff"));
     element89.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element89.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element89.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element89, Color.decode("#003c6b"), Color.decode("#003c6b"));
     element89.addActionListener(e -> {
         WireFramePageModificationLogement pageModificationLogement = new WireFramePageModificationLogement();
         pageModificationLogement.WF_ModifierLogements(client_mail, "WF_AccueilAdmin");
     });
     panel.add(element89);

     JButton element90 = new JButton("Modifier réduction");
     element90.setBounds(350, 261, 155, 29);
     element90.setBackground(Color.decode("#003c6b"));
     element90.setForeground(Color.decode("#ffffff"));
     element90.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element90.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element90.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element90, Color.decode("#003c6b"), Color.decode("#003c6b"));
     element90.addActionListener(e -> {
         WireFramePageReduction pageReduction = new WireFramePageReduction();
         pageReduction.WF_Reduction(client_mail, "WF_AccueilAdmin");
     });
     panel.add(element90);

     JButton element91 = new JButton("Contactez nous");
     element91.setBounds(627, 340, 125, 30);
     element91.setBackground(Color.decode("#003c6b"));
     element91.setForeground(Color.decode("#ffffff"));
     element91.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element91.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element91.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element91, Color.decode("#003c6b"), Color.decode("#003c6b"));
     element91.addActionListener(e -> {
         WireFramePageAide pageAide = new WireFramePageAide();
         pageAide.WF_Aide(client_mail, "WF_AccueilAdmin");
     });
     panel.add(element91);


      JLabel element92 = new JLabel("Votre profil");
      element92.setBounds(575, 144, 178, 30);
      element92.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element92.setForeground(Color.decode("#ffffff"));
      panel.add(element92);

     JLabel element93 = new JLabel(scaleIcon("src/assets/icons/person.png", 20, 20));
     element93.setText("Nom : ");
     element93.setBounds(575, 180, 105, 18);
     element93.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element93.setForeground(Color.decode("#ffffff"));
     panel.add(element93);

      JLabel element94 = new JLabel(client.getNom());
      element94.setBounds(670, 180, 143, 18);
      element94.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
      element94.setForeground(Color.decode("#ffffff"));
      panel.add(element94);

      ImageIcon pencilIcon = new ImageIcon("src/assets/icons/pencil2.png");
      pencilIcon = scaleIcon("src/assets/icons/pencil2.png", 20, 20);
      JButton editNameBtn = new JButton(pencilIcon);
      editNameBtn.setBounds(740, 177, 20, 20);
      editNameBtn.setBackground(Color.decode("#003c6b"));
      editNameBtn.setForeground(Color.decode("#ffffff"));
      editNameBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      editNameBtn.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
      editNameBtn.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(editNameBtn, Color.decode("#003c6b"), Color.decode("#003c6b"));
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
               element94.setText(newName);
               client.setNom(newName);
               //clientDAO.modifier(client);
                clientControl.modifierNom(client, newName, frame);
            }
         }
      });
      panel.add(editNameBtn);

       JLabel element95 = new JLabel(scaleIcon("src/assets/icons/email.png", 20, 20));
       element95.setText("Mail : ");
       element95.setBounds(573, 205, 105, 18);
       element95.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
       element95.setForeground(Color.decode("#ffffff"));
       panel.add(element95);

       JLabel element96 = new JLabel(client_mail);
       element96.setBounds(663, 205, 143, 18);
       element96.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
       element96.setForeground(Color.decode("#ffffff"));
       panel.add(element96);

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
           //Se deconnecter
           System.out.println("Se deconnecter");
           WireFramePageConnexion page_connexion = new WireFramePageConnexion();
           page_connexion.main(null);
           frame.dispose();
       });
       frame.add(retourBtn);


       JLabel element10 = new JLabel(scaleIcon("src/assets/icons/telephone_receiver.png", 20, 20));
       element10.setText("Tel : ");
       element10.setBounds(573, 240, 105, 18);
       element10.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
       element10.setForeground(Color.decode("#ffffff"));
       panel.add(element10);

       JLabel element11 = new JLabel(client.getNumTelephone());
       element11.setBounds(655, 240, 143, 18);
       element11.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
       element11.setForeground(Color.decode("#ffffff"));
       panel.add(element11);
       JButton editPhoneBtn = new JButton(pencilIcon);
       editPhoneBtn.setBounds(740, 240, 20, 20);
       editPhoneBtn.setBackground(Color.decode("#003c6b"));
       editPhoneBtn.setForeground(Color.decode("#ffffff"));
       editPhoneBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
       editPhoneBtn.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
       editPhoneBtn.setFocusPainted(false);
       OnClickEventHelper.setOnClickColor(editPhoneBtn, Color.decode("#003c6b"), Color.decode("#003c6b"));
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
                   //clientDAO.modifier(client);
                     clientControl.modifierTelephone(client, newPhone, frame);
               }
           }
       });
       panel.add(editPhoneBtn);


       JLabel element18 = new JLabel(scaleIcon("src/assets/icons/lock.png", 20, 20));
       element18.setBounds(595, 280, 20, 18);
       element18.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
       element18.setForeground(Color.decode("#ffffff"));
       panel.add(element18);

       JLabel element19 = new JLabel("*************");
       element19.setBounds(625, 280, 143, 18);
       element19.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 11));
       element19.setForeground(Color.decode("#ffffff"));
       panel.add(element19);

       //Ajout d'un bouton avec l'oeil eye.png qui permet de voir le mot de passe via un popup
       ImageIcon eyeIcon = scaleIcon("src/assets/icons/eye.png", 20, 20);
       JButton eyeBtn = new JButton(eyeIcon);
       eyeBtn.setBounds(710, 280, 20, 20);
       eyeBtn.setBackground(Color.decode("#003c6b"));
       eyeBtn.setForeground(Color.decode("#ffffff"));
       eyeBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
       eyeBtn.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
       eyeBtn.setFocusPainted(false);
       OnClickEventHelper.setOnClickColor(eyeBtn, Color.decode("#003c6b"), Color.decode("#003c6b"));
       eyeBtn.addActionListener(e -> {
           JOptionPane.showMessageDialog(frame, "Mot de passe : " + client.getMDP(), "Mot de passe", JOptionPane.INFORMATION_MESSAGE);
       });
       panel.add(eyeBtn);

       //Ajout d'un bouton avec l'icone de crayon qui permet de changer le mot de passe via un popup
       JButton editPasswordBtn = new JButton(pencilIcon);
       editPasswordBtn.setBounds(740, 280, 20, 20);
       editPasswordBtn.setBackground(Color.decode("#003c6b"));
       editPasswordBtn.setForeground(Color.decode("#ffffff"));
       editPasswordBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
       editPasswordBtn.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
       editPasswordBtn.setFocusPainted(false);
       OnClickEventHelper.setOnClickColor(editPasswordBtn, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
       editPasswordBtn.addActionListener(e -> modifierPassword(client, element19, frame));
       panel.add(editPasswordBtn);


      frame.add(panel);
     frame.setVisible(true);
  }


   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }

    private void modifierPassword(Client client, JLabel element19, JFrame frame) {
        JPasswordField oldPasswordField = new JPasswordField();
        JPasswordField newPasswordField = new JPasswordField();

        int result = JOptionPane.showConfirmDialog(
                frame,
                new Object[]{
                        "Entrez votre ancien mot de passe :", oldPasswordField,
                        "Entrez votre nouveau mot de passe :", newPasswordField
                },
                "Modifier le mot de passe",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {
            String oldPassword = new String(oldPasswordField.getPassword()).trim();
            String newPassword = new String(newPasswordField.getPassword()).trim();

            ClientControl clientControl = new ClientControl("", "", "");
            boolean success = clientControl.modifierPassword(client, oldPassword, newPassword, frame);

            if (success) {
                element19.setText("**********");
            }
        }
    }
}