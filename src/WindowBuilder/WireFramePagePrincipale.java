package WindowBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import MVC.controleur.ControleurFiltres;
import MVC.modele.Logement;

import WindowBuilder.helper_classes.*;

public class WireFramePagePrincipale {
    private static JPanel filtersPanel;
    private static JPanel resultsPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Projet JAVA - WireFrame Page principale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(783, 422);

        // Panneau principal avec BorderLayout
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.decode("#E9DAAF"));

        //#################### HEADER ######################
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, 783, 50);
        headerPanel.setBackground(Color.decode("#017179"));

        JLabel headerLabel = new JLabel("WhereBnB.com");
        headerLabel.setBounds(29, 16, 130, 19);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        headerLabel.setForeground(Color.decode("#ffffff"));
        headerPanel.add(headerLabel);

        JLabel headerLabel2 = new JLabel("EUR");
        headerLabel2.setBounds(465, 16, 40, 19);
        headerLabel2.setFont(new Font("SansSerif", Font.BOLD, 15));
        headerLabel2.setForeground(Color.decode("#ffffff"));
        headerPanel.add(headerLabel2);

        JLabel headerLabel3 = new JLabel(scaleIcon("src/ressources/emojis/fr.png", 20, 20));
        headerLabel3.setBounds(500, 15, 20, 20);
        headerLabel3.setForeground(Color.decode("#000"));
        headerPanel.add(headerLabel3);

        ImageIcon emojiIcon = scaleIcon("src/ressources/emojis/hug.png", 20, 20);
        JButton headerLabel4 = new JButton("Votre compte", emojiIcon);
        headerLabel4.setBounds(600, 6, 150, 40);
        headerLabel4.setBackground(Color.decode("#bca8e4"));
        headerLabel4.setForeground(Color.decode("#000000"));
        headerLabel4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        headerLabel4.setFocusPainted(false);
        headerLabel4.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
        headerLabel4.setHorizontalTextPosition(SwingConstants.RIGHT);
        OnClickEventHelper.setOnClickColor(headerLabel4, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
        headerPanel.add(headerLabel4);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        //######################## FILTRE HAUT ######################
        JPanel searchPanel = new JPanel(null);
        searchPanel.setBounds(45, 63, 720, 30);
        searchPanel.setBackground(Color.decode("#E9DAAF"));

        // Ajout de l'emoji maison
        JLabel houseIcon = new JLabel(scaleIcon("src/ressources/emojis/house.png", 20, 20));
        houseIcon.setBounds(5, 0, 25, 25);
        houseIcon.setBackground(Color.decode("#ffffff"));
        houseIcon.setOpaque(true);
        searchPanel.add(houseIcon);

        // Barre de recherche avec texte
        JTextField searchField = new JTextField("Où allez-vous ?");
        searchField.setBounds(30, 0, 180, 25);
        searchField.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        searchField.setForeground(Color.BLACK);
        searchField.setBackground(Color.decode("#ffffff"));
        searchField.setBorder(null);
        searchField.setCaretColor(Color.BLACK);

        // Gestion du focus pour le texte par défaut
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (searchField.getText().equals("Où allez-vous ?")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Où allez-vous ?");
                    searchField.setForeground(Color.BLACK);
                }
            }
        });

        searchPanel.add(searchField, BorderLayout.CENTER);

        // Panel pour la date d'arrivée
        JPanel arrivalSelector = new JPanel(null);
        arrivalSelector.setBounds(220, 0, 150, 25);
        arrivalSelector.setBackground(Color.decode("#ffffff"));

        // Emoji avion pour la date d'arrivée
        JLabel arrivalIcon = new JLabel(scaleIcon("src/ressources/emojis/depart.png", 20, 20));
        arrivalIcon.setBounds(5, 0, 20, 25);
        arrivalIcon.setBackground(Color.decode("#ffffff"));
        arrivalIcon.setOpaque(true);
        arrivalSelector.add(arrivalIcon);

        // Sélecteur de date d'arrivée
        JSpinner arrivalDateSpinner = new JSpinner(new SpinnerDateModel());
        arrivalDateSpinner.setBounds(30, 0, 115, 25);
        arrivalDateSpinner.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        arrivalDateSpinner.setForeground(Color.BLACK);
        arrivalDateSpinner.setBackground(Color.decode("#ffffff"));
        arrivalDateSpinner.setBorder(null);

        JSpinner.DateEditor arrivalEditor = new JSpinner.DateEditor(arrivalDateSpinner, "dd/MM/yyyy");
        arrivalDateSpinner.setEditor(arrivalEditor);
        searchPanel.add(arrivalDateSpinner);

        // Gestion du texte par défaut
        arrivalDateSpinner.addChangeListener(e -> {
            if (arrivalDateSpinner.getValue() == null) {
                arrivalDateSpinner.setValue("Date d'arrivée");
            }
        });
        arrivalSelector.add(arrivalDateSpinner, BorderLayout.CENTER);
        searchPanel.add(arrivalSelector, BorderLayout.EAST);

        // Panel pour la date de départ
        JPanel departureSelector = new JPanel(null);
        departureSelector.setBounds(383, 0, 150, 25);
        departureSelector.setBackground(Color.decode("#ffffff"));

        JLabel departureIcon = new JLabel(scaleIcon("src/ressources/emojis/arrivee.png", 20, 20));
        departureIcon.setBounds(5, 0, 20, 25);
        departureIcon.setBackground(Color.decode("#ffffff"));
        departureIcon.setOpaque(true);
        departureSelector.add(departureIcon);

        JSpinner departureDateSpinner = new JSpinner(new SpinnerDateModel());
        departureDateSpinner.setBounds(30, 0, 115, 25);
        departureDateSpinner.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        departureDateSpinner.setForeground(Color.BLACK);
        departureDateSpinner.setBackground(Color.decode("#ffffff"));
        departureDateSpinner.setBorder(null);
        JSpinner.DateEditor departureEditor = new JSpinner.DateEditor(departureDateSpinner, "dd/MM/yyyy");
        departureDateSpinner.setEditor(departureEditor);
        searchPanel.add(departureDateSpinner);

        // Gestion du texte par défaut
        departureDateSpinner.addChangeListener(e -> {
            if (departureDateSpinner.getValue() == null) {
                departureDateSpinner.setValue("Date de départ");
            }
        });
        departureSelector.add(departureDateSpinner, BorderLayout.CENTER);
        searchPanel.add(departureSelector);


        // Panel pour le nombre de personnes
        JPanel peopleSelector = new JPanel(null);
        peopleSelector.setBounds(546, 0, 90, 25);
        peopleSelector.setBackground(Color.decode("#ffffff"));

        JLabel peopleIcon = new JLabel(scaleIcon("src/ressources/emojis/person.png", 20, 20));
        peopleIcon.setBounds(5, 0, 20, 25);
        peopleIcon.setBackground(Color.decode("#ffffff"));
        peopleIcon.setOpaque(true);
        peopleSelector.add(peopleIcon);

        JSpinner peopleSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        peopleSpinner.setBounds(30, 0, 55, 25);
        peopleSpinner.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        peopleSpinner.setForeground(Color.BLACK);
        peopleSpinner.setBackground(Color.decode("#ffffff"));
        peopleSpinner.setBorder(null);
        peopleSelector.add(peopleSpinner);
        searchPanel.add(peopleSelector);

        peopleSelector.add(peopleSpinner, BorderLayout.CENTER);
        searchPanel.add(peopleSelector);

        // Ajout d'un espace entre le sélecteur de personnes et le bouton "Chercher"
        searchPanel.add(Box.createRigidArea(new Dimension(100, 10))); // Espacement vertical

        mainPanel.add(searchPanel, BorderLayout.CENTER);

        //##################### FILTRE Côté ######################
        // Création du panneau des filtres
        filtersPanel = new JPanel();
        filtersPanel.setLayout(new BoxLayout(filtersPanel, BoxLayout.Y_AXIS)); // Disposition verticale
        filtersPanel.setBackground(Color.decode("#E9DAAF")); // Couleur de fond
        filtersPanel.setBorder(BorderFactory.createTitledBorder("Filtres"));

        // Catégorie
        JLabel categorieLabel = new JLabel("Catégorie :");
        categorieLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        filtersPanel.add(categorieLabel);

        JComboBox<String> categorieComboBox = new JComboBox<>(new String[]{"Indifférent", "Hôtel", "Maison", "Appartement"});
        categorieComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        categorieComboBox.setMaximumSize(new Dimension(150, 20));
        filtersPanel.add(categorieComboBox);
        filtersPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement vertical

        // Prix
        JLabel prixLabel = new JLabel("Prix (par personne/jour) :");
        prixLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alignement à gauche
        filtersPanel.add(prixLabel);

        JPanel prixPanel = new JPanel();
        prixPanel.setLayout(new BoxLayout(prixPanel, BoxLayout.X_AXIS));
        prixPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alignement à gauche
        prixPanel.setBackground(Color.decode("#E9DAAF"));

        // Spinner pour le prix minimum
        JSpinner prixMinSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1)); // Min : 0, Max : 10000, Step : 1
        prixMinSpinner.setPreferredSize(new Dimension(80, 20));
        prixMinSpinner.setMaximumSize(new Dimension(80, 20));
        prixPanel.add(prixMinSpinner);

        prixPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espacement horizontal

        // Spinner pour le prix maximum
        JSpinner prixMaxSpinner = new JSpinner(new SpinnerNumberModel(300, 0, 10000, 1)); // Min : 0, Max : 10000, Step : 1
        prixMaxSpinner.setPreferredSize(new Dimension(80, 20));
        prixMaxSpinner.setMaximumSize(new Dimension(80, 20));
        prixPanel.add(prixMaxSpinner);

        filtersPanel.add(prixPanel);
        filtersPanel.add(Box.createRigidArea(new Dimension(10, 10))); // Espacement vertical

        // Ajout du panneau des filtres dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(filtersPanel);
        scrollPane.setBounds(5, 100, 200, 250);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Ajout au panneau principal
        mainPanel.add(scrollPane);

        // Bouton "Chercher"
        JButton searchButton = new JButton("Chercher");
        searchButton.setBounds(646, 63, 100, 25); // Position ajustée pour un espacement cohérent
        searchButton.setBackground(Color.decode("#bca8e4"));
        searchButton.setForeground(Color.decode("#000"));
        searchButton.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));

        searchButton.addActionListener(e -> {
            try {
                // Récupération des valeurs des filtres
                String categorie = (String) categorieComboBox.getSelectedItem();
                int prixMin = (int) prixMinSpinner.getValue();
                int prixMax = (int) prixMaxSpinner.getValue();
                int nbPersonnes = (int) peopleSpinner.getValue();
                String ville = searchField.getText();

                // Appel au contrôleur
                List<Logement> logements = ControleurFiltres.rechercherLogements(categorie, prixMin, prixMax, nbPersonnes, ville);

                // Vérification si la liste est vide
                afficherResultats(logements, mainPanel); // Affichage des résultats

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur lors de la recherche des logements.");
            }
        });

        // Ajout du bouton au panneau principal
        searchButton.setBounds(656, 350, 100, 30); // Position ajustée
        mainPanel.add(searchButton);

        //##################### RESULTATS ######################
        // Initialisation du panneau des résultats
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(Color.decode("#E9DAAF"));

        // Ajout du panneau des résultats dans un JScrollPane
        JScrollPane resultsScrollPane = new JScrollPane(resultsPanel);
        resultsScrollPane.setBounds(220, 100, 540, 250); // Ajustez les dimensions et la position
        resultsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        resultsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //remove borders of scrollpane
        resultsScrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Ajout du JScrollPane au panneau principal
        mainPanel.add(resultsScrollPane);

        frame.add(mainPanel);
        frame.setVisible(true);

    }

    private static ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }


    private static void afficherResultats(List<Logement> logements, JPanel mainPanel) {
        resultsPanel.removeAll();

        if (logements.isEmpty()) {
            JLabel noResultsLabel = new JLabel("Aucun résultat");
            noResultsLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            noResultsLabel.setForeground(Color.decode("#3d364a"));
            noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            resultsPanel.add(noResultsLabel);
        } else {
            for (Logement logement : logements) {
                JPanel card = new JPanel();
                card.setLayout(new BoxLayout(card, BoxLayout.X_AXIS));
                card.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
                card.setBackground(Color.decode("#ffffff"));
                card.setPreferredSize(new Dimension(700, 100)); // Taille fixe
                card.setMaximumSize(new Dimension(700, 100));

                // Encart pour l'image
                JPanel imagePanel = new JPanel();
                imagePanel.setPreferredSize(new Dimension(100,100));
                imagePanel.setMaximumSize(new Dimension(100, 100));
                imagePanel.setBackground(Color.decode("#E9DAAF"));

                String photoPath = logement.getListePhotos().split(",")[0]; // Première photo
                JLabel imageLabel = new JLabel(scaleIcon("src/ressources/images/" + photoPath, 64, 64));
                imagePanel.add(imageLabel);

                card.add(imagePanel);

                // Informations textuelles
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                infoPanel.setBackground(Color.decode("#ffffff"));
                infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // Nom du logement (en gras et plus grand)
                JLabel nomLabel = new JLabel(logement.getNom());
                nomLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
                nomLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                infoPanel.add(nomLabel);

                // Adresse (en italique)
                JLabel adresseLabel = new JLabel(logement.getVille());
                adresseLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
                adresseLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                infoPanel.add(adresseLabel);

                // Prix (en gras et coloré)
                JLabel prixLabel = new JLabel(logement.getPrix() + " € / nuit");
                prixLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
                prixLabel.setForeground(Color.decode("#017179"));
                prixLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                infoPanel.add(prixLabel);

                // Description (texte normal, multi-lignes)
                JLabel descriptionLabel = new JLabel("<html>" + logement.getDescription() + "</html>");
                descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
                descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                infoPanel.add(descriptionLabel);

                card.add(infoPanel);

                resultsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
                resultsPanel.add(card);
            }

            resultsPanel.add(Box.createVerticalGlue()); // Ajout d'un espace vide pour forcer l'alignement
        }

        resultsPanel.revalidate();
        resultsPanel.repaint();
    }
}

