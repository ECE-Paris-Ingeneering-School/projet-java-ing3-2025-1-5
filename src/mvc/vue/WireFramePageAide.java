package mvc.vue;

import mvc.vue.helper_classes.*;
import java.awt.*;
import javax.swing.*;

public class WireFramePageAide {
  public static void main(String[] args) {

     //Lancement d'une instance par defaut
     WireFramePageAide wireFrame = new WireFramePageAide();
     String client_mail = "felixcadene@mail.com";
     wireFrame.WF_Aide(client_mail, "WF_Accueil");
  }


  public void WF_Aide(String client_mail, String page_precedente) {
     JFrame frame = new JFrame("Page aide");
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
     JLabel element3 = new JLabel(scaleIcon("src/assets/icons/fr.png", 20, 20));
     element3.setBounds(500, 15, 20, 20);
     element3.setForeground(Color.decode("#000"));
     Navig_Bar.add(element3);

     JButton element4 = WireFramePagePrincipale.emojiIconPlacer(scaleIcon("src/assets/icons/hug.png", 20, 20));
     Navig_Bar.add(element4);

     JLabel element5 = new JLabel("Bienvenue sur le centre d'aide");
     element5.setBounds(206, 103, 382, 33);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 25));
     element5.setForeground(Color.decode("#000"));
     panel.add(element5);


     ImageIcon emojiIcon2 = scaleIcon("src/assets/icons/email.png", 20, 20);
     JLabel element8 = new JLabel();
     element8.setIcon(emojiIcon2);
     element8.setText("Envoyez-nous un mail");
     element8.setBounds(170, 148, 222, 25);
     element8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 17));
     element8.setForeground(Color.decode("#000"));
     panel.add(element8);

     JButton element13 = new JButton("Envoyer");
     element13.setBounds(329, 338, 106, 30);
     element13.setBackground(Color.decode("#bca8e4"));
     element13.setForeground(Color.decode("#000"));
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element13.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element13, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element13);
     element13.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Envoi du mail avec succes"));
     element13.addActionListener(e -> {
        frame.dispose();
     });

     JLabel element27 = new JLabel("Contactez nos agents en cas de besoin. Nous reviendrons");
     element27.setBounds(224, 183, 415, 18);
     element27.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element27.setForeground(Color.decode("#000"));
     panel.add(element27);

     JLabel element28 = new JLabel("vers vous dans les meilleurs délais.");
     element28.setBounds(226, 203, 256, 19);
     element28.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element28.setForeground(Color.decode("#000"));
     panel.add(element28);

     JTextField element29 = new JTextField("");
     element29.setBounds(163, 244, 439, 24);
     element29.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element29.setBackground(Color.decode("#ffe7bf"));
     element29.setForeground(Color.decode("#73664e"));
     element29.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element29, "Sujet :", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element29);

     JTextArea element30 = new JTextArea("");
     element30.setBounds(163, 270, 439, 41);
     element30.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element30.setBackground(Color.decode("#ffe7bf"));
     element30.setForeground(Color.decode("#73664e"));
     element30.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element30, "Message :", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element30);


     JButton element31 = new JButton("Retour");
     element31.setBounds(27, 340, 80, 30);
     element31.setBackground(Color.decode("#bca8e4"));
     element31.setForeground(Color.decode("#000"));
     element31.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element31.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element31.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element31, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     element31.addActionListener(e -> {
        //Retour
        System.out.println("Se deconnecter");
        WireFramePageConnexion page_connexion = new WireFramePageConnexion();
        page_connexion.main(null);
        frame.dispose();
     });
     panel.add(element31);

     frame.add(panel);
     frame.setVisible(true);
  }


   private static ImageIcon scaleIcon(String path, int width, int height) {
      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
}