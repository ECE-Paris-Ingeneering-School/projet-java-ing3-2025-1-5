package mvc.controleur;
import dao.daoConnect;
import dao.daoReservation;
import dao.daoReservation;
import mvc.modele.Reservation;

public class PaiementControleur {
    public void effectuerPaiement(Reservation reservation) {
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoReservation reservationdao = new daoReservation(dao);
        reservationdao.ajouter(reservation);
    }
}