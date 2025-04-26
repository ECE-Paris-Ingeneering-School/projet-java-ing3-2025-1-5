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
        System.out.println("16");
        daoConnect connect = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationDAO = new daoReservation(connect);
        System.out.println("17");
        Reservation reservation = reservationDAO.prochain_Reservation(clientId);
        System.out.println("18");
        if (reservation == null) {
            System.out.println("Aucune réservation trouvée pour le client avec ID : " + clientId);
            return null;
        } else {
            System.out.println("Prochaine réservation trouvée : " + reservation.toString());
            return reservation;
        }
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


}
 