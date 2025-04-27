package mvc.controleur;

import dao.*;
import mvc.modele.Client;
import mvc.modele.Commentaire;
import mvc.vue.WireFramePageCommentaire;
import mvc.vue.WireFramePagePrincipale;
import mvc.modele.Logement;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;


/**
 * Controleur pour gérer les filtres de recherche de logements
 */
public class ControleurFiltres {
    public static List<Logement> rechercherLogements(String typeLogement, int prixMin, int prixMax, int nbPersonnes, String ville, String dateDebut, String dateFin) {
        try {
            // Connexion au DAO
            daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
            daoLogement daoLogementInstance = new daoLogement(dao);

            LocalDate dateDebutLocal = convertirEnLocalDate(dateDebut);
            LocalDate dateFinLocal = convertirEnLocalDate(dateFin);


            // Exécution de la recherche
            return daoLogementInstance.rechercherAvecFiltres(typeLogement, prixMin, prixMax, nbPersonnes, ville, dateDebutLocal, dateFinLocal);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la recherche des logements.");
            return List.of(); // Retourne une liste vide en cas d'erreur
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                WireFramePagePrincipale.main(args); // Lancement de l'interface utilisateur
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du lancement de l'application.");
            }
        });
    }


    public static LocalDate convertirEnLocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Format de date invalide : " + dateStr);
            return null;
        }
    }

    public static void verifierReservationetlancercommentaire(String clientMail, int logementId, String nom, float prix, String dateArriveeStr, String dateDepartStr) {
        //1. Vérifier que le client a déjà réservé le logement dans le passé

        //2. Si oui, lancer la fenêtre de commentaire
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");

        // Récupérer l'id du client
        daoClient daoClient = new daoClient(dao);
        Client client = daoClient.getClientByMail(clientMail);
        int id_client = client.getClientId();

        daoReservation daoReservation = new daoReservation(dao);
        boolean adejareserve = daoReservation.dejaReserve(id_client, logementId);
        if (adejareserve) {
            // Lancer la fenêtre de commentaire
            SwingUtilities.invokeLater(() -> {
                try {
                    WireFramePageCommentaire.WF_Commentaire(id_client, logementId, clientMail);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Erreur lors du lancement de la fenêtre de commentaire.");
                }
            });
        } else {
            //alerte swing
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Vous n'avez pas encore réservé ce logement !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}