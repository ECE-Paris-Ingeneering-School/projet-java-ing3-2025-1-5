package mvc.controleur;

import dao.daoCommentaire;
import dao.daoConnect;
import mvc.modele.Commentaire;
import java.util.Date;


/**
 * Controleur pour gérer les commentaires
 *
 */
public class CommentaireControleur {
    public void ajouterCommentaire(int clientId, int logId, int note, String commentaire) {

        Commentaire nouveauCommentaire = new Commentaire(0, clientId, logId, note, commentaire, new Date());

        // Appelle la méthode existante dans daoCommentaire
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoCommentaire daoCommentaire = new daoCommentaire(dao);
        int idGenere = daoCommentaire.ajouter(nouveauCommentaire);
    }
}