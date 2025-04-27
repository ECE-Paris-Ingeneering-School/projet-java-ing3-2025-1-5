package mvc.modele;


/**
 * Classe Adresse
 *
 * Cette classe représente une adresse avec ses attributs et méthodes associées.
 *
 */
public class Adresse {
    private int adresseId;
    private String numero;
    private String rue;
    private String codePostal;
    private String ville;
    private String pays;
    private String complementAdresse;
    private String geoCoord;

    /**
     * Constructeur avec paramètres
     * @param adresseId Identifiant de l'adresse
     * @param numero Numéro de l'adresse
     * @param rue Rue de l'adresse
     * @param codePostal Code postal de l'adresse
     * @param ville Ville de l'adresse
     * @param pays Pays de l'adresse
     * @param complementAdresse Complément d'adresse
     * @param geoCoord Coordonnées géographiques de l'adresse
     */

    public Adresse(int adresseId, String numero, String rue, String codePostal, String ville, String pays, String complementAdresse, String geoCoord) {
        this.adresseId = adresseId;
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.complementAdresse = complementAdresse;
        this.geoCoord = geoCoord;
    }

    /*
        * Constructeur sans paramètres
     */
    public int getAdresseId() {
        return adresseId;
    }


    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }


    /*
     * Getters et Setters pour numero
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    /*
     * Getters pour codePostal
     */
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    /*
     * Getters et Setters pour complementAdresse
     */
    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    /*
     * Getters et Setters pour geoCoord
     */
    public String getGeoCoord() {
        return geoCoord;
    }

    public void setGeoCoord(String geoCoord) {
        this.geoCoord = geoCoord;
    }

    // Méthode toString pour afficher les informations de l'adresse
    @Override
    public String toString() {
        return "Adresse{" +
                "adresseId=" + adresseId +
                ", numero='" + numero + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", complementAdresse='" + complementAdresse + '\'' +
                ", geoCoord='" + geoCoord + '\'' +
                '}';
    }

    
}