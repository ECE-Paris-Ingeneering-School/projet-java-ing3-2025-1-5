package mvc.controleur;

import mvc.vue.WireFramePagePrincipale;
import dao.daoConnect;
import dao.daoLogement;
import mvc.modele.Logement;

import javax.swing.SwingUtilities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

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
}