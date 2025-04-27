package mvc.vue;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import dao.daoClient;
import dao.daoConnect;
import dao.daoReservation;
import mvc.controleur.Retour;
import mvc.modele.Client;
import mvc.vue.helper_classes.*;

public class WireFramePageDossierClients {
  public static void main(String[] args) {

     //Lancement d'une instance par defaut
     WireFramePageDossierClients wireFrame = new WireFramePageDossierClients();
     String client_mail = "leondalle@mail.com";
     wireFrame.WF_DossierClients(client_mail, "WF_DossierClients");
  }

  public void WF_DossierClients(String client_mail, String page_precedente) {

      daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");

      JFrame frame = new JFrame("Page dossier clients");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(783, 422);
      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(Color.decode("#E9DAAF"));


      JLabel element1 = new JLabel("Dossier des clients");
      element1.setBounds(275, 40, 220, 33);
      element1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
      element1.setForeground(Color.decode("#000"));
      panel.add(element1);

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

      JLabel element3 = new JLabel("Nom_ID");
      element3.setBounds(118, 112, 123, 30);
      element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element3.setForeground(Color.decode("#000"));
      panel.add(element3);

      JLabel element4 = new JLabel("Nom");
      element4.setBounds(268, 110, 115, 28);
      element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element4.setForeground(Color.decode("#000"));
      panel.add(element4);

      JLabel element5 = new JLabel("Mail");
      element5.setBounds(392, 112, 122, 26);
      element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element5.setForeground(Color.decode("#000"));
      panel.add(element5);

      JLabel element6 = new JLabel("Statut_Hebergement");
      element6.setBounds(497, 110, 209, 29);
      element6.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
      element6.setForeground(Color.decode("#000"));
      panel.add(element6);


      //////////// LES CLIENTS/////////////////////////

      daoClient clientDAO = new daoClient(dao);
      int nb_de_clients = clientDAO.nb_clients(); // on récupère le nombre de clients
      ArrayList<Client> liste_Clients = clientDAO.DossierClients(); //recupere le dossier client (ID, Nom, mail & Statut_client)

      int y = 164; //initialisation de l'axe y à 164 pixels (récupération données précédentes)
      int elementCounter = 8; //pour eviter de réécrire sur les élément précédents


      JScrollPane scrollPane = new JScrollPane(panel);
      scrollPane.setBounds(118, y, 550, 150);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      frame.add(scrollPane); //pour l'instant inutile

     for (int i = 7; i < nb_de_clients + 7; i++) {
          Client client = liste_Clients.get(i - 7);
          String[] infos = {
                  String.valueOf(client.getClientId()),
                  client.getNom(),
                  client.getEmail(),
                  client.isAncienClient() ? "Ancien client" : "Non"
          };

          int[] xPositions = {147, 217, 367, 600}; // X fixés pour les 4 champs

          for (int j = 0; j < nb_de_clients; j++) {
              JLabel element = new JLabel(infos[j]);
              element.setName("element" + elementCounter); //pour avoir la forme element8, element9...
              element.setBounds(xPositions[j], y, 180, 18);
              element.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
              element.setForeground(Color.decode("#000"));
              panel.add(element);

              elementCounter++;
          }

          y += 45; //décalage de 45 pixels entre chaque affichage de client
      }

     frame.add(scrollPane);
     frame.add(panel);
     frame.setVisible(true);
  }

    private static ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}