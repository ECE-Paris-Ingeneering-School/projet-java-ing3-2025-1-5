package MVC.controleur;

import MVC.vue.WireFramePagePrincipale;
import dao.daoConnect;
import dao.daoLogement;
import MVC.modele.Logement;

import javax.swing.SwingUtilities;
import java.util.List;

public class ControleurFiltres {
    public static List<Logement> rechercherLogements(String typeLogement, int prixMin, int prixMax, int nbPersonnes, String ville) {
        try {
            // Connexion au DAO
            daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
            daoLogement daoLogementInstance = new daoLogement(dao);

            // Exécution de la recherche
            return daoLogementInstance.rechercherAvecFiltres(typeLogement, prixMin, prixMax, nbPersonnes, ville);
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
}