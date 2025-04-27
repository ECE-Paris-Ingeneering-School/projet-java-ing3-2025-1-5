package dao;

// Import des packages nécessaires

import java.util.ArrayList;

/**
 * Interface daoInterface pour définir les méthodes d'accès aux données de la table objets,
 * indépendamment de la méthode de stockage. On indique juste des noms de méthodes ici.
 *
 * @param <Objet> le type générique représentant l'objet manipulé par cette interface
 */
public interface daoInterface<Objet> {
    /**
     * Dans les exemples suivants, l'Objet vaut pour l'objet de la classe implémentée
     */


    /**
     * Afficher les données de l'objet de la classe Objet en paramètre
     * @param objet : objet de la classe Objet à afficher
     */
    void afficher(Objet objet);

    /**
     * Récupérer de la base de données tous les objets des objets dans une liste
     * @return : liste retournée des objets récupérés
     */
    ArrayList<Objet> getAll();

    /**
     * Ajouter un nouvel objet en paramètre dans la base de données
     * @param objet : objet à insérer dans la base de données
     * @return : ID du objet ajouté
     */
    int ajouter(Objet objet);

    /**
     * Permet de chercher et récupérer un objet de Objet dans la base de données via son id en paramètre
     * @param id : identifiant de l'objet à chercher
     * @return : objet de classe Objet cherché et retourné
     */
    Objet chercher(int id);

    /**
     * Permet de modifier les données de l'objet de la classe Objet en paramètre
     * dans la base de données à partir de l'id de cet objet en paramètre
     * @param objet : objet en paramètre de la classe Objet à mettre à jour
     * @return : objet mis à jour dans la base de données
     */
    Objet modifier(Objet objet);

    /**
     * Supprimer un objet de la classe Objet en paramètre dans la base de données
     * @param objet : objet en paramètre à supprimer de la base de données
     * @return : objet objet supprimé
     */
    Objet supprimer(Objet objet);
}