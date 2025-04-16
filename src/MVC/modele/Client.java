package MVC.modele;

public class Client {
    private int clientId;
    private String nom;
    private String email;
    private String numTelephone;
    private String motDePasse;
    private boolean ancienClient;
    private boolean statutAdmin;

    // Constructeur
    public Client(int clientId, String nom, String email, String numTelephone, String motDePasse, boolean ancienClient, boolean statutAdmin) {
        this.clientId = clientId;
        this.nom = nom;
        this.email = email;
        this.numTelephone = numTelephone;
        this.motDePasse = motDePasse;
        this.ancienClient = ancienClient;
        this.statutAdmin = statutAdmin;
    }

    // Getters et Setters
    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumTelephone() { return numTelephone; }
    public void setNumTelephone(String numTelephone) { this.numTelephone = numTelephone; }

    public String getMDP() { return motDePasse; }
    public void setMDP(String motDePasse) { this.motDePasse = motDePasse; }

    public boolean isAncienClient() { return ancienClient; }
    public void setAncienClient(boolean ancienClient) { this.ancienClient = ancienClient; }

    public boolean isAdmin() { return statutAdmin; }
    public void setAdmin(boolean statutAdmin) { this.statutAdmin = statutAdmin; }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + clientId +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + numTelephone + '\'' +
                ", admin=" + statutAdmin +
                ", ancien_Client=" + ancienClient +
                '}';
    }

}