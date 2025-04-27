package mvc.vue;

import dao.daoClient;
import dao.daoConnect;
import dao.daoLogement;
import mvc.modele.Client;
import mvc.modele.Logement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WireFramePageModificationLogement {

  public static void main(String[] args) {
    WireFramePageModificationLogement wireframe = new WireFramePageModificationLogement();
    String clientMail = "alfreddevulpian@mail.com";
    wireframe.WF_ModifierLogements(clientMail, "WF_Accueil");
  }

  public void WF_ModifierLogements(String clientMail, String pagePrecedente) {
    System.out.println("Lancement de la page modification des logements");

    daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
    daoClient clientDAO = new daoClient(dao);
    Client client = clientDAO.getClientByMail(clientMail);
    daoLogement logementDAO = new daoLogement(dao);
    ArrayList<Logement> logements = logementDAO.getAll();

    JFrame frame = new JFrame("Modifier les logements");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 650);
    frame.setLayout(new BorderLayout(10, 10));
    frame.getContentPane().setBackground(Color.decode("#091f30")); // fond général

    // Panel haut
    JPanel panel_haut = new JPanel(new BorderLayout());
    panel_haut.setBackground(Color.decode("#091f30"));
    panel_haut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel title = new JLabel("WhereBnB.com");
    title.setFont(new Font("SansSerif", Font.BOLD, 22));
    title.setForeground(Color.WHITE);
    panel_haut.add(title, BorderLayout.WEST);

    JButton bouton_mon_compte = new JButton("Votre compte");
    bouton_mon_compte.setBackground(Color.decode("#003c6b"));
    bouton_mon_compte.setForeground(Color.WHITE);
    bouton_mon_compte.addActionListener(e -> {
      WireFramePageMonCompte pageMonCompte = new WireFramePageMonCompte();
      pageMonCompte.WF_MonCompte(clientMail, "WF_ModifierLogements");
      frame.dispose();
    });
    panel_haut.add(bouton_mon_compte, BorderLayout.EAST);

    frame.add(panel_haut, BorderLayout.NORTH);

    // Panel principal scrollable
    JPanel panel_logements = new JPanel();
    panel_logements.setLayout(new BoxLayout(panel_logements, BoxLayout.Y_AXIS));
    panel_logements.setBackground(Color.decode("#091f30"));

    for (Logement logement : logements) {
      JPanel panel_logement = new JPanel();
      panel_logement.setLayout(new GridLayout(0, 2, 10, 10));
      panel_logement.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Suppression des bordures solides
      panel_logement.setBackground(Color.decode("#203647"));

      // Champs éditables
      JTextField champ_nom = new JTextField(logement.getNom());
      JTextField champ_prix = new JTextField(String.valueOf(logement.getPrix()));
      JTextField champ_note = new JTextField(String.valueOf(logement.getNote()));
      JTextField champ_description = new JTextField(logement.getDescription());

      // Labels blancs
      JLabel label_nom = new JLabel("Nom :");
      label_nom.setForeground(Color.WHITE);
      JLabel label_prix = new JLabel("Prix (€) :");
      label_prix.setForeground(Color.WHITE);
      JLabel label_note = new JLabel("Note :");
      label_note.setForeground(Color.WHITE);
      JLabel label_description = new JLabel("Description :");
      label_description.setForeground(Color.WHITE);

      panel_logement.add(label_nom);
      panel_logement.add(champ_nom);
      panel_logement.add(label_prix);
      panel_logement.add(champ_prix);
      panel_logement.add(label_note);
      panel_logement.add(champ_note);
      panel_logement.add(label_description);
      panel_logement.add(champ_description);

      // Bouton Valider modification
      JButton bouton_valider = new JButton("Valider modification");
      bouton_valider.setBackground(new Color(76, 175, 80)); // vert
      bouton_valider.setForeground(Color.WHITE);
      bouton_valider.addActionListener(e -> {
        logement.setNom(champ_nom.getText());
        logement.setPrix(Float.parseFloat(champ_prix.getText()));
        logement.setNote(Float.parseFloat(champ_note.getText()));
        logement.setDescription(champ_description.getText());

        logementDAO.modifier(logement);
        JOptionPane.showMessageDialog(frame, "Modification enregistrée !");
      });
      panel_logement.add(bouton_valider);

      // Bouton Supprimer
      JButton bouton_supprimer = new JButton("Supprimer");
      bouton_supprimer.setBackground(new Color(220, 53, 69)); // rouge
      bouton_supprimer.setForeground(Color.WHITE);
      bouton_supprimer.addActionListener(e -> {
        int confirmation = JOptionPane.showConfirmDialog(frame, "Confirmer la suppression ?", "Suppression", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
          logementDAO.supprimer(logement);
          panel_logements.remove(panel_logement);
          panel_logements.revalidate();
          panel_logements.repaint();
          JOptionPane.showMessageDialog(frame, "Logement supprimé !");
        }
      });
      panel_logement.add(bouton_supprimer);

      panel_logements.add(panel_logement);
      panel_logements.add(Box.createVerticalStrut(10)); // espace entre les cartes
    }

    JScrollPane scrollPane = new JScrollPane(panel_logements);
    scrollPane.getViewport().setBackground(Color.decode("#091f30"));
    frame.add(scrollPane, BorderLayout.CENTER);

    // Panel bas : bouton Retour
    JPanel panel_bas = new JPanel(new BorderLayout());
    panel_bas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel_bas.setBackground(Color.decode("#091f30"));

    JButton bouton_retour = new JButton("Retour");
    bouton_retour.setBackground(Color.decode("#003c6b"));
    bouton_retour.setForeground(Color.WHITE);
    bouton_retour.addActionListener(e -> {
      WireFramePagePrincipale pagePrincipale = new WireFramePagePrincipale();
      pagePrincipale.WF_Principale(clientMail, "WF_ModifierLogements");
      frame.dispose();
    });

    panel_bas.add(bouton_retour, BorderLayout.WEST);
    frame.add(panel_bas, BorderLayout.SOUTH);

    frame.setVisible(true);
  }
}
