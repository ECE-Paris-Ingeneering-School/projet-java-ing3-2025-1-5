package MVC.controleur;

import MVC.modele.Reservation;
import dao.daoReservation;
import dao.daoConnect; // Ensure daoConnect is imported

import java.sql.*;

// Gere les reservations (ajout, suppression, modification, affichage)

public class ReservationControl {
    //private daoReservation reservationDAO;

    public ReservationControl() {
        //this.reservationDAO = reservationDAO;
    }

    public Reservation getProchainVoyage(int clientId) {
        System.out.println("16");
        daoConnect connect = new daoConnect("wherebnb", "root", "");
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
}
 