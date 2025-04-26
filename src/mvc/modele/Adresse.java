package mvc.modele;

public class Adresse {
    private int adresseId;
    private String numero;
    private String rue;
    private String codePostal;
    private String ville;
    private String pays;
    private String complementAdresse;
    private String geoCoord;

    // Constructeur par défaut
    public Adresse() {
    }

    // Constructeur avec tous les paramètres
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

    // Getters et Setters
    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

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

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

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