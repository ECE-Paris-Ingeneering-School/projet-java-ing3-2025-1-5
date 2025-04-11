package dao;

// import des packages
import MVC.modele.Reservation;
import java.util.ArrayList;

/**
 * On utilise une interface ClientDao pour définir les méthodes d'accès aux données de la table clients,
 * indépendamment de la méthode de stockage. On indique juste des noms de méthodes ici.
 */
public interface daoReservationInterface {
    /**
     * Afficher les données de l'objet de la classe Client en paramètre
     * @param : client = objet de la classe Client à afficher
     */
    void afficherReservation(Reservation reservation);

    /**
     * Récupérer de la base de données tous les objets des clients dans une liste
     * @return : liste retournée des objets des clients récupérés
     */
    public ArrayList<Reservation> getAllReservation();

    /**
     Ajouter un nouveau client en paramètre dans la base de données
     @params : client = objet de Client à insérer dans la base de données
     */
    public int ajouterReservation(Reservation reservation) ;

    /**
     * Permet de chercher et récupérer un objet de Client dans la base de données via son id en paramètre
     * @param : id
     * @return : objet de classe Client cherché et retourné
     */
    public Reservation chercherReservation(int id);

    /**
     * Permet de modifier les données du nom de l'objet de la classe Client en paramètre
     * dans la base de données à partir de l'id de cet objet en paramètre
     * @param : client = objet en paramètre de la classe Client à mettre à jour
     * @return : objet client en paramètre mis à jour  dans la base de données à retourner
     */
    public Reservation modifierReservation(Reservation reservation);

    /**
     * Supprimer un objet de la classe Reservation en paramètre dans la base de données en respectant la contrainte
     * d'intégrité référentielle : en supprimant une reservation, supprimer aussi en cascade toutes les commandes de la
     * table commander qui ont l'id du client supprimé.
     *
     * @return
     * @params : reservation = objet de Reservation en paramètre à supprimer de la base de données
     */
    public Reservation supprimerClient (Reservation reservation);
}
