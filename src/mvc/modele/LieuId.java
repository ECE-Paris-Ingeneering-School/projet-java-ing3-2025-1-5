package mvc.modele;


/**
 * Classe LieuId
 *
 * Cette classe représente l'identifiant d'un lieu, qui est composé de deux identifiants :
 * logementId et optionsId.
 */
public class LieuId {
    private int logementId;
    private int optionsId;

    // Constructeur
    public LieuId(int logementId, int optionsId) {
        this.logementId = logementId;
        this.optionsId = optionsId;
    }

    // Getters et Setters
    public int getLogementId() { return logementId; }
    public void setLogementId(int logementId) { this.logementId = logementId; }

    public int getOptionsId() { return optionsId; }
    public void setOptionsId(int optionsId) { this.optionsId = optionsId; }
}