package MVC.controleur;

// import des packages autres
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import MVC.modele.Client;
import dao.*;

public class controleur {
    private static List listeDeTables = new List();
    private static List listeDeRequetes = new List();
    private static TextField nameBDDTexte = new TextField();

    public static void main(String[] args) {
        System.out.println("Connexion réussie");

        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");
        daoClient clientdao = new daoClient(dao);

        afficherClients(clientdao);

        // Créer un client
        Random rand = new Random();
        int id = rand.nextInt(1000);
        Client client = new Client(1, "Antoine", "antoine"+id+"@mail.com", "123456", "abcdsécurité", false, false);
        id = clientdao.ajouterClient(client);
        System.out.println("Client ajouté, son id est : "+id);
        afficherClients(clientdao);

        // Chercher un client
        Client client_recherche = clientdao.chercherClient(1);
        System.out.print("\nRésultat de la recherche : ");
        clientdao.afficherClient(client_recherche);

        //Modifier un client
        Client client_modif = clientdao.chercherClient(1);
        client_modif.setNom("Titouan");
        client_modif.setEmail("titouan_fdpdu92@mail.com");
        client_modif.setNumTelephone("696969696969");
        client_modif.setAdmin(true);
        Client modifié = clientdao.modifierClient(client_modif);

        //Afficher le client modifié
        System.out.print("\nClient modifié : ");
        clientdao.afficherClient(modifié);

        // Supprimer un client
        Client client_suppr = clientdao.supprimerClient(client_modif);

        // afficher tous les clients
        System.out.println("\nTous les clients : ");
        afficherClients(clientdao);


        //resetbdd
        dao.resetBDD();

        // afficher tous les clients
        System.out.println("\nTous les clients après reset : ");
        afficherClients(clientdao);

    }


    public static void afficherClients(daoClient dao){
        ArrayList<Client> clients = dao.getAllClient();
        for (Client client : clients){
            dao.afficherClient(client);
        }
    }
}