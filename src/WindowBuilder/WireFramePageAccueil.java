package WindowBuilder;

import WindowBuilder.helper_classes.*;
import java.awt.Color;
import javax.swing.*;

public class WireFramePageAccueil {
  public static void main(String[] args) {

     JFrame frame = new JFrame("Projet JAVA - WireFrame Page d'accueil");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(783, 422);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#f4c064"));

     JLabel element1 = new JLabel("WhereBnB.com");
     element1.setBounds(29, 12, 109, 19);
     element1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 15));
     element1.setForeground(Color.decode("#000"));
     panel.add(element1);

     JLabel element2 = new JLabel("EUR");
     element2.setBounds(465, 18, 40, 19);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 13));
     element2.setForeground(Color.decode("#000"));
     panel.add(element2);

     JLabel element3 = new JLabel("🟦⬜🟥");
     element3.setBounds(508, 16, 68, 22);
     element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element3.setForeground(Color.decode("#000"));
     panel.add(element3);

     JLabel element4 = new JLabel("");
     element4.setBounds(518, 125, 106, 17);
     element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element4.setForeground(Color.decode("#000"));
     panel.add(element4);

     JButton element5 = new JButton("🤗 Votre compte");
     element5.setBounds(612, 12, 144, 34);
     element5.setBackground(Color.decode("#bca8e4"));
     element5.setForeground(Color.decode("#000"));
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element5.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element5.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element5, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element5);

     JLabel element6 = new JLabel("Trouvez votre prochain séjour");
     element6.setBounds(121, 128, 459, 44);
     element6.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 32));
     element6.setForeground(Color.decode("#000"));
     panel.add(element6);

     JTextField element10 = new JTextField("");
     element10.setBounds(59, 208, 137, 21);
     element10.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element10.setBackground(Color.decode("#ffe7bf"));
     element10.setForeground(Color.decode("#73664e"));
     element10.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element10, "🛌 Où allez-vous ? ", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element10);

     JButton element11 = new JButton("Rechercher");
     element11.setBounds(629, 204, 106, 29);
     element11.setBackground(Color.decode("#bca8e4"));
     element11.setForeground(Color.decode("#000"));
     element11.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element11.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     element11.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element11, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(element11);

     JTextField element13 = new JTextField("");
     element13.setBounds(216, 208, 124, 21);
     element13.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element13.setBackground(Color.decode("#ffe7bf"));
     element13.setForeground(Color.decode("#73664e"));
     element13.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element13, "📅 Date d'arrivée", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element13);

     JTextField element14 = new JTextField("");
     element14.setBounds(483, 208, 119, 21);
     element14.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element14.setBackground(Color.decode("#ffe7bf"));
     element14.setForeground(Color.decode("#73664e"));
     element14.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element14, "🧑🧒 Personnes", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element14);

     JTextField element15 = new JTextField("");
     element15.setBounds(346, 207, 116, 24);
     element15.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element15.setBackground(Color.decode("#ffe7bf"));
     element15.setForeground(Color.decode("#73664e"));
     element15.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(element15, "Date de départ", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(element15);

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
}