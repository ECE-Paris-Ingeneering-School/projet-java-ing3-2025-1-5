package mvc.vue;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import mvc.controleur.ControleurFiltres;
import mvc.controleur.Retour;
import mvc.modele.Logement;

import mvc.vue.helper_classes.*;

public class WireFramePagePrincipale {
    private static JPanel resultsPanel;
    private JSpinner arrivalDateSpinner;
    private JSpinner departureDateSpinner;
    private JSpinner peopleSpinner;
    private JButton searchButton;
    private JTextField searchField;

    public static void main(String[] args) {
        //Lancement d'une instance par defaut
        WireFramePagePrincipale wireFrame = new WireFramePagePrincipale();
        String client_mail = "felixcadene@mail.com";
        wireFrame.WF_Principale(client_mail, "WF_Accueil");
    }

    public void WF_Principale(String client_mail, String page_precedente) {
        JFrame frame = new JFrame("Page principale");
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

        JLabel headerLabel3 = new JLabel(scaleIcon("src/assets/icons/fr.png", 20, 20));
        headerLabel3.setBounds(500, 15, 20, 20);
        headerLabel3.setForeground(Color.decode("#000"));
        headerPanel.add(headerLabel3);

        JButton headerLabel4 = emojiIconPlacer(scaleIcon("src/assets/icons/hug.png", 20, 20));
        headerLabel4.addActionListener(e -> {
            WireFramePageMonCompte pageMonCompte = new WireFramePageMonCompte();
            pageMonCompte.WF_MonCompte(client_mail, "WF_Principale");
            frame.dispose();
        });
        headerPanel.add(headerLabel4);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        //######################## FILTRE HAUT ######################
        JPanel searchPanel = new JPanel(null);
        searchPanel.setBounds(45, 63, 720, 30);
        searchPanel.setBackground(Color.decode("#E9DAAF"));

        // Ajout de l'emoji maison
        JLabel houseIcon = new JLabel(scaleIcon("src/assets/icons/house.png", 20, 20));
        houseIcon.setBounds(5, 0, 25, 25);
        houseIcon.setBackground(Color.decode("#ffffff"));
        houseIcon.setOpaque(true);
        searchPanel.add(houseIcon);

        // Barre de recherche avec texte
        this.searchField = new JTextField("Où allez-vous ?");
        this.searchField.setBounds(30, 0, 180, 25);
        this.searchField.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        this.searchField.setForeground(Color.BLACK);
        this.searchField.setBackground(Color.decode("#ffffff"));
        this.searchField.setBorder(null);
        this.searchField.setCaretColor(Color.BLACK);

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

        searchPanel.add(this.searchField, BorderLayout.CENTER);

        // Panel pour la date d'arrivée
        JPanel arrivalSelector = new JPanel(null);
        arrivalSelector.setBounds(220, 0, 150, 25);
        arrivalSelector.setBackground(Color.decode("#ffffff"));

        // Emoji avion pour la date d'arrivée
        JLabel arrivalIcon = new JLabel(scaleIcon("src/assets/icons/depart.png", 20, 20));
        arrivalIcon.setBounds(5, 0, 20, 25);
        arrivalIcon.setBackground(Color.decode("#ffffff"));
        arrivalIcon.setOpaque(true);
        arrivalSelector.add(arrivalIcon);

        // Sélecteur de date d'arrivée
        this.arrivalDateSpinner = new JSpinner(new SpinnerDateModel());
        this.arrivalDateSpinner.setBounds(30, 0, 115, 25);
        this.arrivalDateSpinner.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        this.arrivalDateSpinner.setForeground(Color.BLACK);
        this.arrivalDateSpinner.setBackground(Color.decode("#ffffff"));
        this.arrivalDateSpinner.setBorder(null);

        JSpinner.DateEditor arrivalEditor = new JSpinner.DateEditor(this.arrivalDateSpinner, "dd/MM/yyyy");
        this.arrivalDateSpinner.setEditor(arrivalEditor);
        searchPanel.add(this.arrivalDateSpinner);

        // Gestion du texte par défaut
        this.arrivalDateSpinner.addChangeListener(e -> {
            if (this.arrivalDateSpinner.getValue() == null) {
                this.arrivalDateSpinner.setValue("Date d'arrivée");
            }
        });
        arrivalSelector.add(this.arrivalDateSpinner, BorderLayout.CENTER);
        searchPanel.add(arrivalSelector, BorderLayout.EAST);

        // Panel pour la date de départ
        JPanel departureSelector = new JPanel(null);
        departureSelector.setBounds(383, 0, 150, 25);
        departureSelector.setBackground(Color.decode("#ffffff"));

        JLabel departureIcon = new JLabel(scaleIcon("src/assets/icons/arrivee.png", 20, 20));
        departureIcon.setBounds(5, 0, 20, 25);
        departureIcon.setBackground(Color.decode("#ffffff"));
        departureIcon.setOpaque(true);
        departureSelector.add(departureIcon);

        this.departureDateSpinner = new JSpinner(new SpinnerDateModel());
        this.departureDateSpinner.setBounds(30, 0, 115, 25);
        this.departureDateSpinner.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        this.departureDateSpinner.setForeground(Color.BLACK);
        this.departureDateSpinner.setBackground(Color.decode("#ffffff"));
        this.departureDateSpinner.setBorder(null);
        JSpinner.DateEditor departureEditor = new JSpinner.DateEditor(this.departureDateSpinner, "dd/MM/yyyy");
        this.departureDateSpinner.setEditor(departureEditor);
        searchPanel.add(this.departureDateSpinner);

        // Gestion du texte par défaut
        this.departureDateSpinner.addChangeListener(e -> {
            if (this.departureDateSpinner.getValue() == null) {
                this.departureDateSpinner.setValue("Date de départ");
            }
        });
        departureSelector.add(this.departureDateSpinner, BorderLayout.CENTER);
        searchPanel.add(departureSelector);


        // Panel pour le nombre de personnes
        JPanel peopleSelector = new JPanel(null);
        peopleSelector.setBounds(546, 0, 90, 25);
        peopleSelector.setBackground(Color.decode("#ffffff"));

        JLabel peopleIcon = new JLabel(scaleIcon("src/assets/icons/person.png", 20, 20));
        peopleIcon.setBounds(5, 0, 20, 25);
        peopleIcon.setBackground(Color.decode("#ffffff"));
        peopleIcon.setOpaque(true);
        peopleSelector.add(peopleIcon);

        this.peopleSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        this.peopleSpinner.setBounds(30, 0, 55, 25);
        this.peopleSpinner.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        this.peopleSpinner.setForeground(Color.BLACK);
        this.peopleSpinner.setBackground(Color.decode("#ffffff"));
        this.peopleSpinner.setBorder(null);
        peopleSelector.add(this.peopleSpinner);
        searchPanel.add(peopleSelector);

        peopleSelector.add(this.peopleSpinner, BorderLayout.CENTER);
        searchPanel.add(peopleSelector);

        // Ajout d'un espace entre le sélecteur de personnes et le bouton "Chercher"
        searchPanel.add(Box.createRigidArea(new Dimension(100, 10))); // Espacement vertical

        mainPanel.add(searchPanel, BorderLayout.CENTER);

        //##################### FILTRE Côté ######################
        // Création du panneau des filtres
        JPanel filtersPanel = new JPanel();
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
        this.searchButton = new JButton("Chercher");
        this.searchButton.setBounds(646, 63, 100, 1); // Position ajustée pour un espacement cohérent
        this.searchButton.setBackground(Color.decode("#bca8e4"));
        this.searchButton.setForeground(Color.decode("#000"));
        this.searchButton.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        this.searchButton.setFocusPainted(false);
        this.searchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));

        this.searchButton.addActionListener(e -> {
            try {
                // Récupération des valeurs des filtres
                String categorie = (String) categorieComboBox.getSelectedItem();
                int prixMin = (int) prixMinSpinner.getValue();
                int prixMax = (int) prixMaxSpinner.getValue();
                int nbPersonnes = (int) this.peopleSpinner.getValue();
                String ville = searchField.getText();
                //date d'arrivée et de départ
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateArrivee = (Date) this.arrivalDateSpinner.getValue();
                Date dateDepart = (Date) this.departureDateSpinner.getValue();
                String dateArriveeStr = dateFormat.format(dateArrivee);
                String dateDepartStr = dateFormat.format(dateDepart);

                // Appel au contrôleur
                List<Logement> logements = ControleurFiltres.rechercherLogements(categorie, prixMin, prixMax, nbPersonnes, ville, dateArriveeStr, dateDepartStr);

                // Vérification si la liste est vide
                afficherResultats(logements, mainPanel, client_mail, dateArriveeStr, dateDepartStr); // Affichage des résultats

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur lors de la recherche des logements.");
            }
        });

        // Ajout du bouton au panneau principal
        this.searchButton.setBounds(656, 350, 100, 30); // Position ajustée
        mainPanel.add(this.searchButton);

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

        //##################### BOUTON RETOUR ######################
        //Ajouter bouton de retour en appelant le fichier return.java dans controlleur
        ImageIcon retourIcon = scaleIcon("src/assets/icons/return.png", 20, 20);
        JButton retourBtn = new JButton(retourIcon);
        retourBtn.setBounds(10, 350, 40, 30);
        retourBtn.setBackground(Color.decode("#bca8e4"));
        retourBtn.setForeground(Color.decode("#000"));
        retourBtn.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        retourBtn.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
        Retour retour = new Retour();
        retourBtn.addActionListener(e -> {
            System.out.println("Retour à la page précédente : " + page_precedente);
            frame.dispose();
            retour.retour(client_mail, page_precedente);
        });
        mainPanel.add(retourBtn);

        frame.add(mainPanel);
        frame.setVisible(true);

    }

    static JButton emojiIconPlacer(ImageIcon imageIcon) {
        ImageIcon emojiIcon = imageIcon;
        JButton headerLabel4 = new JButton("Votre compte", emojiIcon);
        headerLabel4.setBounds(600, 6, 150, 40);
        headerLabel4.setBackground(Color.decode("#bca8e4"));
        headerLabel4.setForeground(Color.decode("#000000"));
        headerLabel4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        headerLabel4.setFocusPainted(false);
        headerLabel4.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));
        headerLabel4.setHorizontalTextPosition(SwingConstants.RIGHT);
        OnClickEventHelper.setOnClickColor(headerLabel4, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
        return headerLabel4;
    }

    private static ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }


    private static void afficherResultats(List<Logement> logements, JPanel mainPanel, String client_mail, String dateArriveeStr, String dateDepartStr) {
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
                card.setPreferredSize(new Dimension(510, 100)); // Taille fixe
                card.setMaximumSize(new Dimension(510, 100));

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

                // Panneau pour contenir le bouton
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());
                buttonPanel.setPreferredSize(new Dimension(150, 50)); // Taille personnalisée
                buttonPanel.setMaximumSize(new Dimension(150, 50));
                buttonPanel.setBackground(Color.decode("#ffffff")); // Couleur de fond

                // Bouton Réserver
                JButton reserverButton = new JButton("Réserver");
                reserverButton.setPreferredSize(new Dimension(140, 40)); // Taille du bouton
                reserverButton.setBackground(Color.decode("#800080"));
                reserverButton.setForeground(Color.WHITE);
                reserverButton.setFont(new Font("SansSerif", Font.BOLD, 14));
                reserverButton.setFocusPainted(false);
                reserverButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3d364a"), 1, true));

                // Ajout de l'ActionListener pour appeler WF_Reservation
                reserverButton.addActionListener(e -> {
                    LocalDate dateArrivee = LocalDate.parse(dateArriveeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate dateDepart = LocalDate.parse(dateDepartStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    WireFramePageReservation reservationPage = new WireFramePageReservation();
                    reservationPage.WF_Reservation(client_mail, "WF_Principale", logement.getLogementId(), dateArrivee, dateDepart);
                });

                // Ajout du bouton au panneau
                buttonPanel.add(reserverButton, BorderLayout.CENTER);

                // Ajout du panneau contenant le bouton à la card
                card.add(Box.createHorizontalGlue());
                card.add(buttonPanel);

                resultsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
                resultsPanel.add(card);
            }

            resultsPanel.add(Box.createVerticalGlue()); // Ajout d'un espace vide pour forcer l'alignement
        }

        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    public void preRemplirEtChercher(String localisation, String arrivee, String depart, int nbPersonnes) {
        if (this.searchField == null || this.arrivalDateSpinner == null || this.departureDateSpinner == null || this.peopleSpinner == null) {
            System.err.println("Les champs de l'interface ne sont pas initialisés.");
            return;
        }

        System.out.println("Préremplissage des champs : " + localisation + ", " + arrivee + ", " + depart + ", " + nbPersonnes);

        // Préremplir les champs
        this.searchField.setText(localisation);

        // Convertir les dates en objets Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateArrivee = dateFormat.parse(arrivee);
            Date dateDepart = dateFormat.parse(depart);

            this.arrivalDateSpinner.setValue(dateArrivee);
            this.departureDateSpinner.setValue(dateDepart);
        } catch (ParseException e) {
            System.err.println("Erreur de format de date : " + e.getMessage());
            return;
        }

        this.peopleSpinner.setValue(nbPersonnes);

        // Simuler un clic sur le bouton "Chercher"
        this.searchButton.doClick();
    }
}

