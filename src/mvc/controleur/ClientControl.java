package mvc.controleur;

import mvc.modele.Client;
import dao.daoClient;
import dao.daoConnect;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

    public Client verifierConnexion(String login, String password) {
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientDAO = new daoClient(dao);

        if (clientDAO.existe(login)) {
            Client client = clientDAO.chercher(login, password);
            if (client != null) {
                System.out.println("Connexion réussie !");
                return client;
            }
        }
        return null;
    }

    public Client gererConnexion(String login, String password, JFrame frame) {
        if (login.isEmpty() || login.equals("Login Mail") || password.isEmpty() || password.equals("Mot de passe")) {
            JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientDAO = new daoClient(dao);

        if (clientDAO.existe(login)) {
            Client client = clientDAO.chercher(login, password);
            if (client != null) {
                return client; // Retourne le client si la connexion est réussie
            }
        }

        JOptionPane.showMessageDialog(frame, "Login ou mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
        return null; // Retourne null si la connexion échoue
    }

    public boolean gererInscription(String nom, String mail, String telephone, String mdp, JFrame frame) {
        if (nom.isEmpty() || mail.isEmpty() || mdp.isEmpty() || telephone.isEmpty() || 
            nom.equals("Nom") || mail.equals("Mail") || mdp.equals("Mot de passe") || telephone.equals("Telephone")) {
            JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        if (!mail.contains("@") || !mail.contains(".")) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un email valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        if (telephone.length() != 10 || !telephone.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un numéro de téléphone valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientDAO = new daoClient(dao);
    
        if (clientDAO.existe(mail)) {
            JOptionPane.showMessageDialog(frame, "Cet utilisateur existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        Client nouveauClient = new Client(0, nom, mail, telephone, mdp, false, false);
    
        int idAjoute = clientDAO.ajouter(nouveauClient);
    
        if (idAjoute != 0) {
            JOptionPane.showMessageDialog(frame, "Inscription réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Erreur lors de l'inscription.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean modifierNom(Client client, String nouveauNom, JFrame frame) {
        if (nouveauNom == null || nouveauNom.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Le nom ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientDAO = new daoClient(dao);
    
        client.setNom(nouveauNom);
        Client nvClient = clientDAO.modifier(client);
    
        if (nvClient != null) {
            JOptionPane.showMessageDialog(frame, "Nom modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Erreur lors de la modification du nom.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean modifierTelephone(Client client, String nouveauTelephone, JFrame frame) {
        if (nouveauTelephone == null || nouveauTelephone.trim().isEmpty() || !nouveauTelephone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un numéro de téléphone valide (10 chiffres).", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientDAO = new daoClient(dao);
    
        client.setNumTelephone(nouveauTelephone);
        Client nvClient = clientDAO.modifier(client);
    
        if (nvClient != null) {
            JOptionPane.showMessageDialog(frame, "Numéro de téléphone modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Erreur lors de la modification du numéro de téléphone.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean modifierPassword(Client client, String ancienPassword, String nouveauPassword, JFrame frame) {
        if (ancienPassword == null || ancienPassword.trim().isEmpty() || nouveauPassword == null || nouveauPassword.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Les champs de mot de passe ne peuvent pas être vides.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        if (!ancienPassword.equals(client.getMDP())) {
            JOptionPane.showMessageDialog(frame, "L'ancien mot de passe est incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        if (nouveauPassword.length() < 6) {
            JOptionPane.showMessageDialog(frame, "Le nouveau mot de passe doit contenir au moins 6 caractères.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientDAO = new daoClient(dao);
    
        client.setMDP(nouveauPassword);
        Client nvClient = clientDAO.modifier(client);
    
        if (nvClient != null) {
            JOptionPane.showMessageDialog(frame, "Mot de passe modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Erreur lors de la modification du mot de passe.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
