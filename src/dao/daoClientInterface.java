package dao;

// import des packages
import MVC.modele.Client;
import java.util.ArrayList;

/**
 * On utilise une interface ClientDao pour définir les méthodes d'accès aux données de la table clients,
 * indépendamment de la méthode de stockage. On indique juste des noms de méthodes ici.
 */
public interface daoClientInterface {
    /**
     * Afficher les données de l'objet de la classe Client en paramètre
     * @param : client = objet de la classe Client à afficher
     */
    void afficher(Client client);

    /**
     * Récupérer de la base de données tous les objets des clients dans une liste
     * @return : liste retournée des objets des clients récupérés
     */
    public ArrayList<Client> getAll();

    /**
     Ajouter un nouveau client en paramètre dans la base de données
     @params : client = objet de Client à insérer dans la base de données
     */
    public int ajouter(Client client) ;

    /**
     * Permet de chercher et récupérer un objet de Client dans la base de données via son id en paramètre
     * @param : id
     * @return : objet de classe Client cherché et retourné
     */
    public Client chercher(int id);

    /**
     * Permet de modifier les données du nom de l'objet de la classe Client en paramètre
     * dans la base de données à partir de l'id de cet objet en paramètre
     * @param : client = objet en paramètre de la classe Client à mettre à jour
     * @return : objet client en paramètre mis à jour  dans la base de données à retourner
     */
    public Client modifier(Client client);

    /**
     * Supprimer un objet de la classe Client en paramètre dans la base de données en respectant la contrainte
     * d'intégrité référentielle : en supprimant un client, supprimer aussi en cascade toutes les commandes de la
     * table commander qui ont l'id du client supprimé.
     *
     * @return
     * @params : client = objet de Client en paramètre à supprimer de la base de données
     */
    public Client supprimer (Client client);

}

