package WindowBuilder;

import WindowBuilder.helper_classes.*;
import dao.*;
import java.awt.*;
import javax.swing.*;

public class WireFramePageInscription {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page d'inscription");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#f4c064"));

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(0, 30, 783, 30);
     element1.setForeground(Color.decode("#000"));
     element1.setHorizontalAlignment(SwingConstants.CENTER);
     element1.setFont(new Font("SansSerif", Font.BOLD, 30));
     panel.add(element1);

     JTextField element42 = new JTextField("");
     element42.setBounds(305, 110, 165, 36);
     element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element42.setBackground(Color.decode("#ffe7bf"));
     element42.setForeground(Color.decode("#73664e"));
     element42.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element42, "Nom", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element42);

     JPasswordField element44 = new JPasswordField("");
     element44.setBounds(306, 155, 165, 24);
     element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element44.setBackground(Color.decode("#ffe7bf"));
     element44.setForeground(Color.decode("#73664e"));
     element44.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element44, "Mot de passe", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element44);

     

     JTextField element48 = new JTextField("");
     element48.setBounds(306, 201, 165, 24);
     element48.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element48.setBackground(Color.decode("#ffe7bf"));
     element48.setForeground(Color.decode("#73664e"));
     element48.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element48, "Mail", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element48);

     JButton element45 = new JButton("Inscription");
     element45.setBounds(307, 258, 167, 44);
     element45.setBackground(Color.decode("#bca8e4"));
     element45.setForeground(Color.decode("#000"));
     element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
     element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element45.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     element45.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            String nom = element42.getText();
            String mail = element48.getText();
            String mdp = new String(element44.getPassword());
            if (nom.isEmpty() || mail.isEmpty() || mdp.isEmpty() || nom.equals("Nom") || mail.equals("Mail") || mail.equals("Mot de passe")) {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
                daoClient clientDAO = new daoClient(dao);
                //Client newClient = new Client(nom, mail, mdp);
                if (clientDAO.existe(mail) == true) {
                    JOptionPane.showMessageDialog(frame, "Cet utilisateur existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //clientDAO.create(newClient);
                JOptionPane.showMessageDialog(frame, "Inscription réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }

          }
      });
     panel.add(element45);

     JButton element49 = new JButton("Contactez nous");
     element49.setBounds(614, 337, 141, 35);
     element49.setBackground(Color.decode("#bca8e4"));
     element49.setForeground(Color.decode("#000"));
     element49.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element49.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element49.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element49, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element49);


     frame.add(panel);
     frame.setVisible(true);

  }
}