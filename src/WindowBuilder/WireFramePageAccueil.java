package WindowBuilder;

import MVC.modele.Logement;
import WindowBuilder.helper_classes.*;
import dao.daoConnect;
import dao.daoLogement;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.*;

public class WireFramePageAccueil {
   public static void main(String[] args) {

      JFrame frame = new JFrame("Projet JAVA - WireFrame Page d'accueil");
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

      ImageIcon emojiIcon = scaleIcon("src/ressources/emojis/hug.png", 20, 20);
      JButton element5 = new JButton("Mon compte", emojiIcon);
      element5.setBounds(600, 6, 150, 40);
      element5.setBackground(Color.decode("#bca8e4"));
      element5.setForeground(Color.decode("#000000"));
      element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element5.setFocusPainted(false);
      element5.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
      element5.setHorizontalTextPosition(SwingConstants.RIGHT);
      OnClickEventHelper.setOnClickColor(element5, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      Navig_Bar.add(element5);

      JLabel element6 = new JLabel("Trouvez votre prochain s\u00e9jour");
      element6.setBounds(190, 105, 600, 44);
      element6.setFont(new Font("SansSerif", Font.BOLD, 30));
      element6.setForeground(Color.decode("#000"));
      panel.add(element6);

      // Label avec une image d'emoji de maison.png a gauche de element6
      JLabel element7 = new JLabel(scaleIcon("src/ressources/emojis/house.png", 40, 40));
      element7.setBounds(140, 105, 40, 40);
      element6.setFont(new Font("SansSerif", Font.BOLD, 30));
      element7.setForeground(Color.decode("#000"));
      panel.add(element7);

      JTextField element_localisation = new JTextField();
      JTextField element_arrivee = new JTextField();
      JTextField element_depart = new JTextField();
      JTextField element_personnes = new JTextField();
      panel.add(merge_icon_Text("O\u00f9 allez-vous ?", "src/ressources/emojis/localisation.png", element_localisation, 59, 195, 137, 24));
      panel.add(merge_icon_Text("Date d'arriv\u00e9e", "src/ressources/emojis/arrivee.png", element_arrivee, 216, 195, 124, 24));
      panel.add(merge_icon_Text("Date de d\u00e9part", "src/ressources/emojis/depart.png", element_depart, 346, 195, 124, 24));
      //panel.add(merge_Icon_text_Date("📅 Date d'arrivée", "src/ressources/emojis/arrivee.png", 216, 195, 124, 24));
      //panel.add(merge_Icon_text_Date("📅 Date de départ", "src/ressources/emojis/depart.png", 346, 195, 124, 24));

      panel.add(merge_icon_Text("Personnes", "src/ressources/emojis/person.png", element_personnes, 483, 195, 119, 24));

      JLabel element8 = new JLabel("Format: jj/mm/aaaa");
      element8.setBounds(216, 220, 124, 24);
      element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 10));
      element8.setForeground(Color.decode("#000"));
      panel.add(element8);

      JLabel element9 = new JLabel("Format: jj/mm/aaaa");
      element9.setBounds(346, 220, 124, 24);
      element9.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 10));
      element9.setForeground(Color.decode("#000"));
      panel.add(element9);
      

      JButton element11 = new JButton("Rechercher");
      element11.setBounds(629, 192, 106, 29);
      element11.setBackground(Color.decode("#bca8e4"));
      element11.setForeground(Color.decode("#000"));
      element11.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element11.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      element11.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(element11, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      element11.addActionListener(e -> {
      String localisation = element_localisation.getText().trim();
      String arrivee = element_arrivee.getText().trim();
      String depart = element_depart.getText().trim();
      String nbPersonnes = element_personnes.getText().trim();

      if (localisation.isEmpty()) {
         localisation = "";
      } if (arrivee.isEmpty()) {
         arrivee = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      } if (depart.isEmpty()) {
         depart = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      } if (nbPersonnes.isEmpty()) {
         nbPersonnes = "1";
      }

      /*
      * VERIFICATION DE LA LOCALISATION:
      * --> La localisation ne doit pas contenir de chiffres/caractères spéciaux
      */
      for (char c : localisation.toCharArray()) {
        if (Character.isDigit(c)) {
            JOptionPane.showMessageDialog(frame, "La localisation ne doit pas contenir de chiffres.");
            return;
        }
      }


      /*
      * VERIFICATION DU NOMBRE DE PERSONNES:
      * --> Le nombre de personnes doit être supérieur à 0
      * --> Le nombre de personnes doit être un nombre entier
      */

      int nbPersonnesInt = Integer.parseInt(nbPersonnes);
      if (nbPersonnesInt < 1) { 
         JOptionPane.showMessageDialog(frame, "Le nombre de personnes doit être supérieur à 0.");
         return;
      }

      try {
         Integer.parseInt(nbPersonnes);
      } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(frame, "Le nombre de personnes doit être un nombre entier.");
         return;
      }

      
      /*
      * VERIFICATION DES DATES:
      * --> La date d'arrivée doit être au format jj/mm/aaaa
      * --> La date de départ doit être au format jj/mm/aaaa
      * --> La date d'arrivée et de départ ne peuvent pas être identiques
      * --> La date de départ doit être après la date d'arrivée
      * --> La date d'arrivée et de départ ne doivent pas être dans le passé
      */
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      try {
         LocalDate.parse(arrivee, dtf);
      } catch (Exception ex) {
         JOptionPane.showMessageDialog(frame, "La date d'arrivée doit être au format jj/mm/aaaa.");
         return;
      }
      try {
         LocalDate.parse(depart, dtf);
      } catch (Exception ex) {
         JOptionPane.showMessageDialog(frame, "La date de départ doit être au format jj/mm/aaaa.");
         return;
      }

      if (arrivee.equals(depart)) {
         JOptionPane.showMessageDialog(frame, "La date d'arrivée et de départ ne peuvent pas être identiques.");
         return;
      }

      LocalDate dateArrivee = LocalDate.parse(arrivee, dtf);
      LocalDate dateDepart = LocalDate.parse(depart, dtf);
      if (dateDepart.isBefore(dateArrivee)) {
         JOptionPane.showMessageDialog(frame, "La date de départ doit être après la date d'arrivée.");
         return;
      }

      LocalDate today = LocalDate.now();
      if (dateArrivee.isBefore(today) || dateDepart.isBefore(today)) {
         JOptionPane.showMessageDialog(frame, "La date d'arrivée et de départ ne doivent pas être dans le passé.");
         return;
      }


      daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
      daoLogement daoLogementInstance = new daoLogement(dao);
      List<Logement> resultats = daoLogementInstance.rechercher(localisation, dateArrivee, dateDepart, nbPersonnesInt);
      if (resultats.isEmpty()) {
         JOptionPane.showMessageDialog(frame, "Aucun logement trouvé pour les critères donnés.");
      } else {
         JOptionPane.showMessageDialog(frame, resultats.size() + " logements trouvés.");
      }

});

      panel.add(element11);


      JButton element16 = new JButton("Contactez nous");
      element16.setBounds(614, 337, 141, 35);
      element16.setBackground(Color.decode("#bca8e4"));
      element16.setForeground(Color.decode("#000"));
      element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element16.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      element16.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(element16, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      element16.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Contactez nous"));
      panel.add(element16);


      frame.add(panel);
      frame.setVisible(true);
   }

   private static JPanel merge_icon_Text(String txt_defaut, String iconPath, JTextField textField, int x, int y, int width, int height) {
      JPanel merger = new JPanel();
      merger.setLayout(new BorderLayout(5, 0));
      merger.setBounds(x, y, width, height);
      merger.setBackground(Color.decode("#ffe7bf"));
      merger.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
  
      JLabel iconLabel = new JLabel(scaleIcon(iconPath, 18, 18));
      iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
      merger.add(iconLabel, BorderLayout.WEST);
  
      // Use the textField passed in
      textField.setText(txt_defaut);
      textField.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      textField.setBackground(Color.decode("#ffe7bf"));
      textField.setForeground(Color.decode("#73664e"));
      textField.setBorder(null);
      textField.setOpaque(true);
      textField.setCaretColor(Color.BLACK);
  
      OnFocusEventHelper.setOnFocusText(textField, txt_defaut, Color.BLACK, Color.decode("#73664e"));
  
      merger.add(textField, BorderLayout.CENTER);
      return merger;
  }
  


   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}