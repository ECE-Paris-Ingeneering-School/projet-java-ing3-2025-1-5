package MVC.modele;

public class Logement {
    private int logementId;
    private String nom;
    private String geoCoord;
    private float prix;
    private float note;
    private String description;
    private String listePhotos;
    private int proprioId;
    private int adresseId;

    // Constructeur
    public Logement(int logementId, String nom, float prix, String description, String listePhotos, float note, int proprioId, int adresse_id) {
        this.logementId = logementId;
        this.nom = nom;
        this.prix = prix;
        this.note = note;
        this.description = description;
        this.listePhotos = listePhotos;
        this.proprioId = proprioId;
        this.adresseId = adresse_id;
    }

    // Getters et Setters
    public int getLogementId() { return logementId; }
    public void setLogementId(int logementId) { this.logementId = logementId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getAdresseId() { return adresseId; }
    public void setAdresseId(int adresseId) { this.adresseId = adresseId; }

    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getListePhotos() { return listePhotos; }
    public void setListePhotos(String listePhotos) { this.listePhotos = listePhotos; }

    public int getProprioId() { return proprioId; }
    public void setProprioId(int proprioId) { this.proprioId = proprioId; }

    public float getNote() { return note; }
    public void setNote(float note) { this.note = note; }

    @Override
    public String toString() {
        return "Logement{" +
                "logementId=" + logementId +
                ", nom='" + nom + '\'' +
                ", adresseId='" + adresseId + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", listePhotos='" + listePhotos + '\'' +
                ", proprioId=" + proprioId +
                '}';
    }
}