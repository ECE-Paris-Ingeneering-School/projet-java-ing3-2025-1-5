package mvc.controleur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.daoAdresse;
import dao.daoCommentaire;
import dao.daoConnect;
import dao.daoLogement;
import mvc.modele.Commentaire;
import mvc.modele.Logement;


/**
 * Controleur pour gérer les logements
 *
 */
public class LogementControl {


    public ArrayList<Commentaire> getCommentaires(int clientId) {
        daoConnect connect = daoConnect.getInstance("wherebnb", "root", "");
        daoCommentaire commentaireDAO = new daoCommentaire(connect);
        return commentaireDAO.getCommentairesByClientId(clientId);
    }

    

    public boolean validerRecherche(String localisation, String nbPersonnes, String arrivee, String depart, JFrame frame) {
        // Vérification de la localisation
        for (char c : localisation.toCharArray()) {
            if (Character.isDigit(c)) {
                JOptionPane.showMessageDialog(frame, "La localisation ne doit pas contenir de chiffres.");
                return false;
            }
        }

        // Vérification du nombre de personnes
        try {
            int nbPersonnesInt = Integer.parseInt(nbPersonnes);
            if (nbPersonnesInt < 1) {
                JOptionPane.showMessageDialog(frame, "Le nombre de personnes doit être supérieur à 0.");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Le nombre de personnes doit être un nombre entier.");
            return false;
        }

        // Vérification des dates
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dateArrivee = LocalDate.parse(arrivee, dtf);
            LocalDate dateDepart = LocalDate.parse(depart, dtf);

            if (dateArrivee.equals(dateDepart)) {
                JOptionPane.showMessageDialog(frame, "La date d'arrivée et de départ ne peuvent pas être identiques.");
                return false;
            }

            if (dateDepart.isBefore(dateArrivee)) {
                JOptionPane.showMessageDialog(frame, "La date de départ doit être après la date d'arrivée.");
                return false;
            }

            LocalDate today = LocalDate.now();
            if (dateArrivee.isBefore(today) || dateDepart.isBefore(today)) {
                JOptionPane.showMessageDialog(frame, "Les dates ne doivent pas être dans le passé.");
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Les dates doivent être au format jj/mm/aaaa.");
            return false;
        }

        return true; // Toutes les validations sont passées
    }

        public int getNombreLogements() {
            daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
            daoLogement logementDAO = new daoLogement(dao);
            return logementDAO.nb_logements();
        }
    
        public String getNomLogement(int logId) {
            daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
            daoLogement logementDAO = new daoLogement(dao);
            Logement logement = logementDAO.getLogementById(logId);
    
            if (logement != null) {
                return logement.getNom();
            } else {
                return "Logement inconnu";
            }
        }
    
        public List<Logement> rechercherLogements(String localisation, LocalDate dateArrivee, LocalDate dateDepart, int nbPersonnes) {
            daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
            daoLogement logementDAO = new daoLogement(dao);
            return logementDAO.rechercher(localisation, dateArrivee, dateDepart, nbPersonnes);
        }

        public ArrayList<String> getPaysLocation() {
            daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
            daoAdresse adresseDAO = new daoAdresse(dao);
            return adresseDAO.getPaysLocation();
        }
    
}
