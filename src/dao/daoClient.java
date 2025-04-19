package dao;

// import des packages

import MVC.modele.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Implémentation MySQL du stockage dans la base de données des méthodes définies dans l'interface ClientDao
 */
public class daoClient implements daoInterface<Client> {
    // attribut privé pour l'objet du daoConnect
    private daoConnect daoConnect;
    public daoClient(daoConnect daoConnect) { // constructeur dépendant de la classe daoConnect
        this.daoConnect = daoConnect;
    }

    /**
     * Afficher un client
     * @param : client = objet de Client à afficher
     */
    @Override
    public void afficher(Client client) {
        if (client == null) {
            System.out.println("Client inexistant");
            return;
        }
        String space = " / ";
        System.out.print("Client ID : "+client.getClientId()+ space);
        System.out.print("Nom : "+client.getNom()+ space);
        System.out.print("Email : "+client.getEmail()+ space);
        System.out.print("Numéro de téléphone : "+client.getNumTelephone()+ space);
        System.out.print("Mot de passe : "+client.getMDP()+ space);
        System.out.print("Ancien client : "+client.isAncienClient()+ space);
        System.out.println("Statut admin : "+client.isAdmin());
    }

    /** fetch tous les clients de la db
     * @return : liste retournée des objets des clients récupérés
     */
    @Override
    public ArrayList<Client> getAll() {
        ArrayList<Client> listeClients = new ArrayList<Client>();

        try {
            // connexion
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();

            // récupération des produits de la base de données avec la requete SELECT
            ResultSet résultats = statement.executeQuery("select * from client");

            // 	Se déplacer sur le prochain enregistrement : retourne false si la fin est atteinte
            while (résultats.next()) {
                // récupérer tous les champs de la table clients dans la base de données
                int clientId = résultats.getInt(1);
                String clientNom = résultats.getString(2);
                String clientMail = résultats.getString(3);
                String clientTel = résultats.getString(4);
                String clientMdp = résultats.getString(5);
                boolean clientAncien = résultats.getBoolean(6);
                boolean clientAdmin = résultats.getBoolean(7);

                // instancier un objet de Produit avec ces 3 champs en paramètres
                Client client = new Client(clientId,clientNom,clientMail,clientTel,clientMdp,clientAncien,clientAdmin);

                // ajouter ce client à la listeClients
                listeClients.add(client);
            }
        }catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
            System.out.println("Création de la liste de clients impossible");
        }

        return listeClients;
    }

    /**
     Ajouter un nouveau client en paramètre dans la base de données
     @params : client = objet de Client à insérer dans la base de données
     @return : id du client ajouté dans la base de données
     */
    @Override
    public int ajouter(Client client){
        // récupération des champs de l'objet client en paramètre
        String nom = client.getNom();
        String mail = client.getEmail();
        String tel = client.getNumTelephone();
        String mdp = client.getMDP();
        boolean ancien = client.isAncienClient();
        boolean admin = client.isAdmin();

        int id = 0;

        try {
            // connexion
            Connection connexion = daoConnect.getConnection();;
            Statement statement = connexion.createStatement();

            // insertion du client dans la base de données
            statement.executeUpdate("insert into client (Nom, Email, Num_telephone, Mot_de_passe, AncienClient, Statut_Admin) values ('"+nom+"','"+mail+"','"+tel+"','"+mdp+"',"+ancien+","+admin+")");


            // récupération de l'id du client ajouté
            ResultSet resultats = statement.executeQuery("select Client_ID from client WHERE Email='"+mail+"'");
            while (resultats.next()) {
                id = resultats.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ajout du client impossible");
        }

        return id;

    }

    /**
     * Permet de chercher et récupérer un objet de Client dans la base de données via son id en paramètre
     * @param : id
     * @return : objet de classe Client cherché et retourné
     */
    public Client chercher(int id)  {
        Client client = null;

        try {
            // connexion
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();

            // Exécution de la requête SELECT pour récupérer le client de l'id dans la base de données
            ResultSet resultats = statement.executeQuery("select * from client where Client_ID="+id);

            // 	Lire les données du client
            while (resultats.next()) {
                // récupérer les 3 champs de la table clients
                int clientId = resultats.getInt(1);
                String clientNom = resultats.getString(2);
                String clientMail = resultats.getString(3);
                String clientTel = resultats.getString(4);
                String clientMdp = resultats.getString(5);
                boolean clientAncien = resultats.getBoolean(6);
                boolean clientAdmin = resultats.getBoolean(7);

                // instancier un objet de Client
                client = new Client(clientId,clientNom,clientMail,clientTel,clientMdp,clientAncien,clientAdmin);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Client non trouvé dans la base de données");
        }

        return client;
    }

    /**
     * Permet de modifier les données du nom de l'objet de la classe Client en paramètre
     * dans la base de données à partir de l'id de cet objet en paramètre
     * @param : client = objet en paramètre de la classe Client à mettre à jour à partir de son id
     * @return : objet client en paramètre mis à jour dans la base de données à retourner
     */
    public Client modifier(Client client) {
        try {
            // connexion
            Connection connexion = daoConnect.getConnection();
            StringBuilder query = new StringBuilder("UPDATE client SET ");
            boolean first = true;

            if (client.getNom() != null) {
                query.append("Nom = '").append(client.getNom()).append("'");
                first = false;
            }
            if (client.getEmail() != null) {
                if (!first) query.append(", ");
                query.append("Email = '").append(client.getEmail()).append("'");
                first = false;
            }
            if (client.getNumTelephone() != null) {
                if (!first) query.append(", ");
                query.append("Num_telephone = '").append(client.getNumTelephone()).append("'");
                first = false;
            }
            if (client.getMDP() != null) {
                if (!first) query.append(", ");
                query.append("Mot_de_passe = '").append(client.getMDP()).append("'");
                first = false;
            }

            if (client.isAncienClient()) {
                if (!first) query.append(", ");
                query.append("AncienClient = ").append(client.isAncienClient());
                first = false;
            }

            if (client.isAdmin()) {
                if (!first) query.append(", ");
                query.append("Statut_Admin = ").append(client.isAdmin());
                first = false;
            }

            query.append(" WHERE Client_ID = ").append(client.getClientId());

            Statement statement = connexion.createStatement();
            statement.executeUpdate(query.toString());

            // Récupérer le client mis à jour
            client = chercher(client.getClientId());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Modification du client impossible");
        }

        return client;
    }

    @Override
    /**
     * Supprimer un objet de la classe Client en paramètre dans la base de données en respectant la contrainte
     * d'intégrité référentielle : en supprimant un client, supprimer aussi en cascade toutes les commandes de la
     * table commander qui ont l'id du client supprimé.
     * @params : client = objet de Client en paramètre à supprimer de la base de données
     * @return : client supprimé
     */
    public Client supprimer(Client client) {
        try {
            // connexion
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();

            // suppression du client dans la base de données
            statement.executeUpdate("delete from client where Client_ID="+client.getClientId());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Suppression du client impossible");
        }
        return client;
    }


    /**
     * Permet de chercher et envoyer un boolen si le client existe ou non dans la base de données via le mail en paramètre
     * @param : mail
     * @return : boolean = true si le client existe, false sinon
     */
    public boolean existe(String mail) {
        boolean existe = false;
        try {
            Connection connexion = daoConnect.getConnection();
            Statement statement = connexion.createStatement();

            ResultSet resultat = statement.executeQuery("select * from client where Email='"+mail+"'");

            while (resultat.next()) {
                existe = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Client non trouvé dans la base de données");
        }
        return existe;
    }
}