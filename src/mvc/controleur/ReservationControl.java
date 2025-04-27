package mvc.controleur;

import mvc.modele.Reservation;
import dao.daoReservation;
import dao.daoConnect; // Ensure daoConnect is imported

import java.util.ArrayList;

// Gere les reservations (ajout, suppression, modification, affichage)

public class ReservationControl {
    //private daoReservation reservationDAO;

    public ReservationControl() {
        //this.reservationDAO = reservationDAO;
    }

    public Reservation getProchainVoyage(int clientId) {
        daoConnect connect = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationDAO = new daoReservation(connect);
        return reservationDAO.prochain_Reservation(clientId);
    }

    public String getNomLogement(int logId) {
        daoConnect connect = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationDAO = new daoReservation(connect);
        return reservationDAO.getNomLgt(logId);
    }

    /**
     * Récupère les voyages passés d'un client
     * @param clientId ID du client
     * @return Liste de réservations
     */
    public ArrayList<Reservation> getVoyagesPasses(int clientId) {
        daoConnect connect = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationDAO = new daoReservation(connect);
        return reservationDAO.getVoyagesPasses(clientId);

    }

    public double getMoyenneDureeSejour() {
        daoConnect connect = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationDAO = new daoReservation(connect);
        try {
            return reservationDAO.moyenneDureeSejour();
        } catch (Exception e) {
            System.err.println("Erreur lors du calcul de la moyenne de durée de séjour : " + e.getMessage());
            e.printStackTrace();
            return 0.0;
        }
    }

}
 