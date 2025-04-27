package mvc.modele;

import java.util.Date;



/**
 * Classe Commentaire
 *
 * Représente un commentaire laissé par un client sur un logement.
 */
public class Commentaire {
    private int commentaireId;
    private int clientId;
    private int logId;
    private int note;
    private String commentaire;
    private Date dateCommentaire;

    // Constructeur
    public Commentaire(int commentaireId, int clientId, int logId, int note, String commentaire, Date dateCommentaire) {
        this.commentaireId = commentaireId;
        this.clientId = clientId;
        this.logId = logId;
        this.note = note;
        this.commentaire = commentaire;
        this.dateCommentaire = dateCommentaire;
    }

    // Getters et Setters
    public int getCommentaireId() { return commentaireId; }
    public void setCommentaireId(int commentaireId) { this.commentaireId = commentaireId; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public int getLogId() { return logId; }
    public void setLogId(int logId) { this.logId = logId; }

    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public Date getDateCommentaire() { return dateCommentaire; }
    public void setDateCommentaire(Date dateCommentaire) { this.dateCommentaire = dateCommentaire; }
}