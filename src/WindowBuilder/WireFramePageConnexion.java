package WindowBuilder;

import MVC.modele.Client;
import WindowBuilder.helper_classes.*;
import dao.*;
import java.awt.*;
import javax.swing.*;

public class WireFramePageConnexion {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page de connexion");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#E9DAAF"));

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(0, 30, 783, 30);
     element1.setForeground(Color.decode("#000"));
     element1.setHorizontalAlignment(SwingConstants.CENTER);
     element1.setFont(new Font("SansSerif", Font.BOLD, 30));
     panel.add(element1);

     JTextField element42 = new JTextField("");
     element42.setBounds(307, 110, 165, 36);
     element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element42.setBackground(Color.decode("#ffe7bf"));
     element42.setForeground(Color.decode("#73664e"));
     element42.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element42, "Login Mail", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element42);

     JPasswordField element44 = new JPasswordField("");
     element44.setBounds(307, 165, 165, 24);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element44.setBackground(Color.decode("#ffe7bf"));
     element44.setForeground(Color.decode("#73664e"));
     element44.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element44, "Mot de passe", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element44);

     //Source: https://stackoverflow.com/questions/19755259/hide-show-password-in-a-jtextfield-java-swing
     ImageIcon eyeIcon = scaleIcon("src/ressources/emojis/eye.png", 18, 18);
     ImageIcon monkeyIcon = scaleIcon("src/ressources/emojis/monkey.png", 18, 18);

     JButton element_mdptoggle = new JButton(eyeIcon);
     element_mdptoggle.setBounds(475, 165, 30, 24);
     element_mdptoggle.setBackground(Color.decode("#ffe7bf"));
     element_mdptoggle.setForeground(Color.decode("#73664e"));
     element_mdptoggle.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     element_mdptoggle.setFocusPainted(false);

     element_mdptoggle.addActionListener(e -> {
          if (element44.getEchoChar() == '\u0000') {
              element44.setEchoChar('•');
              element_mdptoggle.setIcon(eyeIcon);
          } else {
              element44.setEchoChar((char) 0);
              element_mdptoggle.setIcon(monkeyIcon);
          }
     });

     panel.add(element_mdptoggle);

     JButton element45 = new JButton("Connexion");
     element45.setBounds(307, 223, 167, 44);
     element45.setBackground(Color.decode("#bca8e4"));
     element45.setForeground(Color.decode("#000"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     element45.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            String login = element42.getText();
            String password = new String(element44.getPassword());
            if (login.isEmpty() || login.equals("Login Mail") || password.isEmpty() || password.equals("Mot de passe")) {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs !", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
                daoClient clientDAO = new daoClient(dao);
                if (clientDAO.existe(login) == true) {
                  Client client = clientDAO.chercher(login, password);
                
                  if (client != null) {
                      JOptionPane.showMessageDialog(frame, "Connexion reussie ! ", "Succès", JOptionPane.INFORMATION_MESSAGE);

                      if (client.isAdmin()) {
                          //page admin
                          //WireFramePageAccueilAdmin.main(null);
                          WireFramePageAccueilAdmin accueilPageAdmin = new WireFramePageAccueilAdmin();
                          try {
                              accueilPageAdmin.WF_AccueilAdmin(client.getEmail());
                          } catch (Exception e) {
                              throw new RuntimeException(e);
                          }
                      } else {
                          //page client
                          //WireFramePageAccueil.main(null);
                          WireFramePageAccueil accueilPage = new WireFramePageAccueil();
                          accueilPage.WF_Accueil(client.getEmail());
                      }

                      frame.dispose();
                  } else {
                     JOptionPane.showMessageDialog(frame, "Login ou mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
                  }
                } else {
                   JOptionPane.showMessageDialog(frame, "Login ou mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
         }
      });
     panel.add(element45);

     JLabel element46 = new JLabel("Pas de compte ? Créer un compte !");
     element46.setBounds(273, 276, 258, 21);
     element46.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element46.setForeground(Color.decode("#000"));
      element46.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            WireFramePageInscription.main(null);
             frame.dispose();
          }
      });
     panel.add(element46);

     JButton element47 = new JButton("Contactez nous");
     element47.setBounds(614, 337, 141, 35);
     element47.setBackground(Color.decode("#bca8e4"));
     element47.setForeground(Color.decode("#000"));
     element47.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element47.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element47.setFocusPainted(false);
     element47.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Contactez nous"));
     OnClickEventHelper.setOnClickColor(element47, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element47);

     frame.add(panel);
     frame.setVisible(true);

  }

  private static ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
  }
}