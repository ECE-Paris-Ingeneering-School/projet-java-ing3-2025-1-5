package MVC.modele;

public class Logement {
    private int logementId;
    private String nom;
    private String adresse;
    private String geoCoord;
    private float prix;
    private String description;
    private String listePhotos;
    private int proprioId;

    // Constructeur
    public Logement(int logementId, String nom, String adresse, String geoCoord, float prix, String description, String listePhotos, int proprioId) {
        this.logementId = logementId;
        this.nom = nom;
        this.adresse = adresse;
        this.geoCoord = geoCoord;
        this.prix = prix;
        this.description = description;
        this.listePhotos = listePhotos;
        this.proprioId = proprioId;
    }

    // Getters et Setters
    public int getLogementId() { return logementId; }
    public void setLogementId(int logementId) { this.logementId = logementId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getGeoCoord() { return geoCoord; }
    public void setGeoCoord(String geoCoord) { this.geoCoord = geoCoord; }

    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getListePhotos() { return listePhotos; }
    public void setListePhotos(String listePhotos) { this.listePhotos = listePhotos; }

    public int getProprioId() { return proprioId; }
    public void setProprioId(int proprioId) { this.proprioId = proprioId; }

    @Override
    public String toString() {
        return "Logement{" +
                "logementId=" + logementId +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", geoCoord='" + geoCoord + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", listePhotos='" + listePhotos + '\'' +
                ", proprioId=" + proprioId +
                '}';
    }
}