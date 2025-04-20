package MVC.controleur;

// Gere connexion/inscription des clients

public class ClientControl {
    
    // Attributs
    private String nom;
    private String email;
    private String mdp;
    
    // Constructeur
    public ClientControl(String nom, String email, String mdp) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }
    
    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
