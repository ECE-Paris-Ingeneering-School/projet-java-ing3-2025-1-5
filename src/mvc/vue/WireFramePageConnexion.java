package mvc.vue;

import mvc.controleur.ClientControl;
import mvc.modele.Client;
import mvc.vue.helper_classes.*;
import java.awt.*;
import javax.swing.*;

/** * WireFramePageConnexion.java
 *
 * Classe pour afficher la page de connexion de l'application.
 * Elle permet à l'utilisateur de se connecter ou de créer un compte.
 *
 */
public class WireFramePageConnexion {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Projet JAVA - WireFrame Page de connexion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(783, 422);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#091f30"));

        JLabel element1 = new JLabel("WhereBnB.com");
        element1.setBounds(0, 30, 783, 30);
        element1.setForeground(Color.decode("#fffffff"));
        element1.setHorizontalAlignment(SwingConstants.CENTER);
        element1.setFont(new Font("SansSerif", Font.BOLD, 30));
        panel.add(element1);

        JTextField element42 = new JTextField("");
        element42.setBounds(307, 110, 165, 36);
        element42.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
        element42.setBackground(Color.decode("#203647"));
        element42.setForeground(Color.decode("#ffffff"));
        element42.setBorder(new RoundedBorder(2, Color.decode("#ffffff"), 1));
        OnFocusEventHelper.setOnFocusText(element42, "Login Mail", Color.decode("#ffffff"),   Color.decode("#ffffff"));
        panel.add(element42);

        JPasswordField element44 = new JPasswordField("");
        element44.setBounds(307, 165, 165, 24);
        element44.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
        element44.setBackground(Color.decode("#203647"));
        element44.setForeground(Color.decode("#ffffff"));
        element44.setBorder(new RoundedBorder(2, Color.decode("#ffffff"), 1));
        OnFocusEventHelper.setOnFocusText(element44, "Mot de passe", Color.decode("#ffffff"),   Color.decode("#ffffff"));
        panel.add(element44);

        //Source: https://stackoverflow.com/questions/19755259/hide-show-password-in-a-jtextfield-java-swing
        ImageIcon eyeIcon = scaleIcon("src/assets/icons/eye.png", 18, 18);
        ImageIcon monkeyIcon = scaleIcon("src/assets/icons/monkey.png", 18, 18);

        JButton element_mdptoggle = new JButton(eyeIcon);
        element_mdptoggle.setBounds(475, 165, 30, 24);
        element_mdptoggle.setBackground(Color.decode("#203647"));
        element_mdptoggle.setForeground(Color.decode("#ffffff"));
        element_mdptoggle.setBorder(new RoundedBorder(2, Color.decode("#ffffff"), 1));
        element_mdptoggle.setFocusPainted(false);

        element_mdptoggle.addActionListener(e -> {
            toggleMdp(element44, element_mdptoggle, eyeIcon, monkeyIcon);
        });

        panel.add(element_mdptoggle);

        JButton element45 = new JButton("Connexion");
        element45.setBounds(307, 223, 167, 44);
        element45.setBackground(Color.decode("#003c6b"));
        element45.setForeground(Color.decode("#ffffff"));
        element45.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 24));
        element45.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
        element45.setFocusPainted(false);
        OnClickEventHelper.setOnClickColor(element45, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
        element45.addActionListener(e -> {
            String login = element42.getText();
            String password = new String(element44.getPassword());

            ClientControl clientControl = new ClientControl("", "", "");
            Client client = clientControl.gererConnexion(login, password, frame);

            if (client != null) {
                JOptionPane.showMessageDialog(frame, "Connexion réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);

                if (client.isAdmin()) {
                    try {
                        WireFramePageAccueilAdmin accueilPageAdmin = new WireFramePageAccueilAdmin();
                        accueilPageAdmin.WF_AccueilAdmin(client.getEmail());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Erreur lors du chargement de la page admin.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    WireFramePageAccueil accueilPage = new WireFramePageAccueil();
                    accueilPage.WF_Accueil(client.getEmail());
                }

                frame.dispose();
            }
        });
        panel.add(element45);

        JLabel element46 = new JLabel("Pas de compte ? Créer un compte !");
        element46.setBounds(273, 276, 258, 21);
        element46.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        element46.setForeground(Color.decode("#ffffff"));
        element46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WireFramePageInscription.main(null);
                frame.dispose();
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