package WindowBuilder;

import WindowBuilder.helper_classes.*;

import java.awt.*;
import javax.swing.*;

public class WireFramePageReservation {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Projet JAVA - WireFrame Page de réservation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(900, 700); // Augmenté pour inclure les nouveaux composants
      frame.setLayout(new BorderLayout());

      // Panel principal avec BoxLayout vertical
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panel.setBackground(Color.decode("#091f30"));
      panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      frame.add(panel, BorderLayout.CENTER);

      // ===== NavBar =====
      JPanel navig_bar = new JPanel(new BorderLayout());
      navig_bar.setBackground(Color.decode("#091f30"));
      navig_bar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      JLabel title = new JLabel("WhereBnB.com");
      title.setFont(new Font("SansSerif", Font.BOLD, 15));
      title.setForeground(Color.WHITE);
      navig_bar.add(title, BorderLayout.WEST);

      JButton button_my_account = new JButton("Votre compte");
      button_my_account.setBorderPainted(false);
      button_my_account.setMargin(new Insets(7, 10, 7, 10));
      button_my_account.setBackground(Color.decode("#003c6b"));
      button_my_account.setForeground(Color.WHITE);
      button_my_account.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      button_my_account.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(button_my_account, Color.decode("#203647"), Color.decode("#003c6b"));
      navig_bar.add(button_my_account, BorderLayout.EAST);

      frame.add(navig_bar, BorderLayout.NORTH);

      // ===== Infos logement (titre + adresse) =====
      JPanel titreAdresse = new JPanel();
      titreAdresse.setLayout(new BoxLayout(titreAdresse, BoxLayout.Y_AXIS));
      titreAdresse.setOpaque(false);
      titreAdresse.setAlignmentX(Component.LEFT_ALIGNMENT);

      JLabel title_logement = new JLabel("Magnifique appartement au centre-ville");
      title_logement.setFont(new Font("SansSerif", Font.BOLD, 18));
      title_logement.setForeground(Color.WHITE);

      JLabel adresse_logement = new JLabel("123 Rue du Bonheur, Paris 75001");
      adresse_logement.setFont(new Font("SansSerif", Font.PLAIN, 14));
      adresse_logement.setForeground(Color.LIGHT_GRAY);

      titreAdresse.add(title_logement);
      titreAdresse.add(adresse_logement);
      panel.add(titreAdresse);

      // ===== Infos logement (image, étoiles, prix, propriétaire, description) =====
      JPanel infosLogement = new JPanel(new GridBagLayout()); // Utilisation de GridBagLayout
      infosLogement.setBackground(Color.BLUE);
      infosLogement.setOpaque(true);

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(10, 10, 10, 10); // Padding interne de 10px

      // Charger l'image
      ImageIcon originalImage = new ImageIcon("src/WindowBuilder/images/logement.jpeg");
      Integer image_size = 300;
      Image scaledImage = originalImage.getImage().getScaledInstance(image_size, image_size, Image.SCALE_SMOOTH);
      ImageIcon resizedImage = new ImageIcon(scaledImage);

      JLabel image = new JLabel(resizedImage);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      infosLogement.add(image, gbc); // Ajoute l'image dans la première ligne et colonne

      // Ajouter les étoiles et le prix dans la deuxième case
      JPanel prixEtoilesPanel = new JPanel();
      prixEtoilesPanel.setLayout(new BoxLayout(prixEtoilesPanel, BoxLayout.Y_AXIS));
      prixEtoilesPanel.setOpaque(false);

      JLabel label_prix = new JLabel("1200 € / mois");
      label_prix.setFont(new Font("SansSerif", Font.BOLD, 20));
      label_prix.setForeground(Color.WHITE);

      JLabel etoiles = new JLabel("★★★★★");
      etoiles.setFont(new Font("SansSerif", Font.PLAIN, 18));
      etoiles.setForeground(Color.YELLOW);

      prixEtoilesPanel.add(label_prix);
      prixEtoilesPanel.add(etoiles);

      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      // gbc.fill = GridBagConstraints.BOTH;
      infosLogement.add(prixEtoilesPanel, gbc); // Ajoute le panneau des étoiles et du prix dans la deuxième case

      // Ajouter les informations du propriétaire dans la troisième case
      JPanel proprietairePanel = new JPanel();
      proprietairePanel.setLayout(new BoxLayout(proprietairePanel, BoxLayout.Y_AXIS));
      proprietairePanel.setOpaque(false);

      JLabel nomProprietaire = new JLabel("Nom du propriétaire : Jean Dupont");
      nomProprietaire.setFont(new Font("SansSerif", Font.BOLD, 16));
      nomProprietaire.setForeground(Color.WHITE);

      JLabel telephone = new JLabel("Téléphone : 01 23 45 67 89");
      telephone.setFont(new Font("SansSerif", Font.PLAIN, 14));
      telephone.setForeground(Color.WHITE);

      JLabel email = new JLabel("Email : jean.dupont@example.com");
      email.setFont(new Font("SansSerif", Font.PLAIN, 14));
      email.setForeground(Color.WHITE);

      proprietairePanel.add(nomProprietaire);
      proprietairePanel.add(telephone);
      proprietairePanel.add(email);

      gbc.gridx = 2;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      // gbc.fill = GridBagConstraints.BOTH;
      infosLogement.add(proprietairePanel, gbc); // Ajoute le panneau des informations du propriétaire dans la troisième case

      // Ajouter le panneau de description dans les cases 4 et 5
      JPanel descriptionLogementPanel = new JPanel();
      descriptionLogementPanel.setLayout(new BoxLayout(descriptionLogementPanel, BoxLayout.Y_AXIS));
      descriptionLogementPanel.setBackground(Color.decode("#800080")); // Fond violet
      descriptionLogementPanel.setOpaque(true);

      JTextArea descriptionLogement = new JTextArea(
              "Ce magnifique appartement est situé en plein cœur de Paris. Il offre une vue imprenable sur la Tour Eiffel et est idéal pour un séjour romantique ou en famille. " +
                      "L'appartement dispose de deux chambres spacieuses, d'un salon lumineux, d'une cuisine entièrement équipée et d'une salle de bain moderne. " +
                      "Vous apprécierez également la proximité des transports en commun, des restaurants et des attractions touristiques."
      );
      descriptionLogement.setFont(new Font("SansSerif", Font.PLAIN, 14));
      descriptionLogement.setForeground(Color.WHITE);
      descriptionLogement.setBackground(Color.decode("#800080")); // Fond violet
      descriptionLogement.setLineWrap(true);
      descriptionLogement.setWrapStyleWord(true);
      descriptionLogement.setEditable(false);

      descriptionLogementPanel.add(descriptionLogement);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      gbc.gridheight = 2;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      infosLogement.add(descriptionLogementPanel, gbc); // Ajoute le panneau de description dans les cases 4 et 5

      // Ajouter des composants vides pour remplir les autres cellules du GridBagLayout
      for (int i = 0; i < 4; i++) {
         JPanel emptyPanel = new JPanel();
         emptyPanel.setOpaque(false);
         gbc.gridx = i % 3;
         gbc.gridy = 1 + i / 3;
         gbc.gridwidth = 1;
         gbc.gridheight = 1;
         gbc.weightx = 1.0;
         gbc.weighty = 1.0;
         gbc.fill = GridBagConstraints.BOTH;
         infosLogement.add(emptyPanel, gbc);
      }

      panel.add(infosLogement);

      frame.setVisible(true);
   }
}
