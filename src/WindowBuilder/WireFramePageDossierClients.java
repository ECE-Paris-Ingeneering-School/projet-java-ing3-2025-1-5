package WindowBuilder;

import javax.swing.*;
import java.awt.Color;
import WindowBuilder.helper_classes.*;

public class WireFramePageDossierClients {
  public static void main(String[] args) {

     //Lancement d'une instance par defaut
     WireFramePageDossierClients wireFrame = new WireFramePageDossierClients();
     String client_mail = "leondalle@mail.com";
     wireFrame.WF_DossierClients(client_mail, "WF_DossierClients");
  }

  public void WF_DossierClients(String client_mail, String page_precedente) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page dossier clients");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#E9DAAF"));

     JLabel element78 = new JLabel("Dossier des clients");
     element78.setBounds(275, 40, 220, 33);
     element78.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element78.setForeground(Color.decode("#000"));
     panel.add(element78);

     JButton element91 = new JButton("Retour");
     element91.setBounds(25, 337, 83, 32);
     element91.setBackground(Color.decode("#bca8e4"));
     element91.setForeground(Color.decode("#000"));
     element91.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element91.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element91.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element91, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element91);

     JLabel element92 = new JLabel("Nom_ID");
     element92.setBounds(118, 112, 123, 30);
     element92.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element92.setForeground(Color.decode("#000"));
     panel.add(element92);

     JLabel element93 = new JLabel("Nom");
     element93.setBounds(268, 110, 115, 28);
     element93.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element93.setForeground(Color.decode("#000"));
     panel.add(element93);

     JLabel element94 = new JLabel("Mail");
     element94.setBounds(392, 112, 122, 26);
     element94.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element94.setForeground(Color.decode("#000"));
     panel.add(element94);

     JLabel element95 = new JLabel("Statut_Hebergement");
     element95.setBounds(497, 110, 209, 29);
     element95.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 20));
     element95.setForeground(Color.decode("#000"));
     panel.add(element95);

     JLabel element96 = new JLabel("1");
     element96.setBounds(167, 164, 106, 18);
     element96.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element96.setForeground(Color.decode("#000"));
     panel.add(element96);

     JLabel element97 = new JLabel("2");
     element97.setBounds(167, 215, 106, 18);
     element97.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element97.setForeground(Color.decode("#000"));
     panel.add(element97);

     JLabel element98 = new JLabel("3");
     element98.setBounds(167, 274, 106, 18);
     element98.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element98.setForeground(Color.decode("#000"));
     panel.add(element98);

     JLabel element99 = new JLabel("4");
     element99.setBounds(167, 327, 106, 18);
     element99.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element99.setForeground(Color.decode("#000"));
     panel.add(element99);

     JLabel element100 = new JLabel("Toto");
     element100.setBounds(267, 169, 106, 18);
     element100.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element100.setForeground(Color.decode("#000"));
     panel.add(element100);

     JLabel element101 = new JLabel("Tata");
     element101.setBounds(268, 219, 106, 18);
     element101.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element101.setForeground(Color.decode("#000"));
     panel.add(element101);

     JLabel element102 = new JLabel("Titi");
     element102.setBounds(272, 276, 106, 18);
     element102.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element102.setForeground(Color.decode("#000"));
     panel.add(element102);

     JLabel element103 = new JLabel("Tutu");
     element103.setBounds(272, 327, 106, 18);
     element103.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element103.setForeground(Color.decode("#000"));
     panel.add(element103);

     JLabel element104 = new JLabel("toto@gmail.com");
     element104.setBounds(367, 167, 124, 19);
     element104.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element104.setForeground(Color.decode("#000"));
     panel.add(element104);

     JLabel element105 = new JLabel("tata@gmail.com");
     element105.setBounds(366, 220, 128, 17);
     element105.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element105.setForeground(Color.decode("#000"));
     panel.add(element105);

     JLabel element106 = new JLabel("titi@gmail.com");
     element106.setBounds(370, 279, 106, 18);
     element106.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element106.setForeground(Color.decode("#000"));
     panel.add(element106);

     JLabel element107 = new JLabel("tutu@gmail.com");
     element107.setBounds(364, 330, 127, 17);
     element107.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element107.setForeground(Color.decode("#000"));
     panel.add(element107);

     JLabel element108 = new JLabel("En cours");
     element108.setBounds(550, 160, 106, 18);
     element108.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element108.setForeground(Color.decode("#000"));
     panel.add(element108);

     JLabel element109 = new JLabel("Nouveau");
     element109.setBounds(548, 220, 106, 18);
     element109.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element109.setForeground(Color.decode("#000"));
     panel.add(element109);

     JLabel element110 = new JLabel("Ancien");
     element110.setBounds(549, 272, 106, 18);
     element110.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element110.setForeground(Color.decode("#000"));
     panel.add(element110);

     JLabel element111 = new JLabel("Nouveau");
     element111.setBounds(545, 325, 106, 18);
     element111.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 16));
     element111.setForeground(Color.decode("#000"));
     panel.add(element111);

     frame.add(panel);
     frame.setVisible(true);
  }
}