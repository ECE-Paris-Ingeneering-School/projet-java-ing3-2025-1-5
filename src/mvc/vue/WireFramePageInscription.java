package mvc.vue;

import mvc.controleur.ClientControl;
import mvc.vue.helper_classes.*;
import java.awt.*;
import javax.swing.*;


/**
 * WireFramePageInscription.java
 *
 * Classe de la page d'inscription
 */
public class WireFramePageInscription {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Page d'inscription");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#091f30"));

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(0, 30, 783, 30);
     element1.setForeground(Color.decode("#ffffff"));
     element1.setHorizontalAlignment(SwingConstants.CENTER);
     element1.setFont(new Font("SansSerif", Font.BOLD, 30));
     panel.add(element1);

     JTextField element42 = new JTextField("");
     element42.setBounds(305, 110, 165, 36);
     element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element42.setBackground(Color.decode("#203647"));
     element42.setForeground(Color.decode("#ffffff"));
     element42.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element42, "Nom", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element42);


     JPasswordField element44 = new JPasswordField("");
     element44.setBounds(306, 155, 165, 36);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element44.setBackground(Color.decode("#203647"));
     element44.setForeground(Color.decode("#ffffff"));
     element44.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element44, "Mot de passe", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element44);

     ImageIcon eyeIcon = scaleIcon("src/assets/icons/eye.png", 18, 18);
     ImageIcon monkeyIcon = scaleIcon("src/assets/icons/monkey.png", 18, 18);

     JButton element_mdptoggle = new JButton(eyeIcon);
     element_mdptoggle.setBounds(475, 165, 30, 24);
     element_mdptoggle.setBackground(Color.decode("#203647"));
     element_mdptoggle.setForeground(Color.decode("#ffffff"));
     element_mdptoggle.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     element_mdptoggle.setFocusPainted(false);

     element_mdptoggle.addActionListener(e -> {
        toggleMdp(element44, element_mdptoggle, eyeIcon, monkeyIcon);
    });

      panel.add(element_mdptoggle);




     JTextField element48 = new JTextField("");
     element48.setBounds(306, 201, 165, 36);
     element48.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element48.setBackground(Color.decode("#203647"));
     element48.setForeground(Color.decode("#ffffff"));
     element48.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element48, "Mail", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element48);

     JTextField element49 = new JTextField("");
     element49.setBounds(306, 248, 165, 36);
     element49.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element49.setBackground(Color.decode("#203647"));
     element49.setForeground(Color.decode("#ffffff"));
     element49.setBorder(new RoundedBorder(2, Color.decode("#203647"), 1));
     OnFocusEventHelper.setOnFocusText(element49, "Telephone", Color.decode("#ffffff"),   Color.decode("#ffffff"));
     panel.add(element49);

      element42.setCaretColor(Color.WHITE);
      element44.setCaretColor(Color.WHITE);
      element48.setCaretColor(Color.WHITE);
      element49.setCaretColor(Color.WHITE);

     JButton element45 = new JButton("Inscription");
     element45.setBounds(307, 300, 167, 44);
     element45.setBackground(Color.decode("#003c6b"));
     element45.setForeground(Color.decode("#ffffff"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element45.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#003c6b"), Color.decode("#003c6b"));
     element45.addActionListener(e -> {
            String nom = element42.getText();
            String mail = element48.getText();
            String telephone = element49.getText();
            String mdp = new String(element44.getPassword());

            ClientControl clientControl = new ClientControl("", "", "");
            boolean inscriptionReussie = clientControl.gererInscription(nom, mail, telephone, mdp, frame);

            if (inscriptionReussie) {
                frame.dispose(); // Ferme la fenêtre actuelle
                WireFramePageConnexion.main(null); // Ouvre la page de connexion
            }
        });
     panel.add(element45);

     //Ajout d'un bouton retour pour retourner à la page de connexion
        JButton element46 = new JButton("Retour");
        element46.setBounds(614, 300, 141, 35);
        element46.setBackground(Color.decode("#003c6b"));
        element46.setForeground(Color.decode("#ffffff"));
        element46.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        element46.setBorder(new RoundedBorder(4, Color.decode("#003c6b"), 1));
        element46.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(element46, Color.decode("#003c6b"), Color.decode("#003c6b"));
        element46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.dispose(); // Ferme la fenêtre actuelle
                WireFramePageConnexion.main(null); // Ouvre la page de connexion
            }
        });
        panel.add(element46);

      JButton element16 = new JButton("Contactez nous");
      element16.setBounds(614, 337, 141, 35);
      //this.searchButton.setBounds(646, 350, 100, 30);
      element16.setBackground(Color.decode("#bca8e4"));
      element16.setForeground(Color.decode("#000"));
      element16.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
      element16.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
      element16.setFocusPainted(false);
      OnClickEventHelper.setOnClickColor(element16, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
      //On click, call the method afficher_moncompte de la classe WireFramePageMonCompte
      element16.addActionListener(e -> {
          WireFramePageAide pageAide = new WireFramePageAide();
          pageAide.WF_Aide("", "WF_Principale");
          //frame.dispose();
      });
      panel.add(element16);


     frame.add(panel);
     frame.setVisible(true);

  }

  private static ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
  }

  private static void toggleMdp(JPasswordField passwordField, JButton toggleButton, ImageIcon visibleIcon, ImageIcon hiddenIcon) {
    if (passwordField.getEchoChar() == '\u0000') {
        passwordField.setEchoChar('•');
        toggleButton.setIcon(visibleIcon);
    } else {
        passwordField.setEchoChar('\u0000');
        toggleButton.setIcon(hiddenIcon);
    }
  }

}