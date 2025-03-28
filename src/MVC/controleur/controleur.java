package MVC.controleur;

// import des packages autres
import java.awt.*;
import java.sql.*;
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
        id = clientdao.ajouter(client);
        System.out.println("Client ajouté, son id est : "+id);
        afficherClients(clientdao);

        // Chercher un client
        Client client_recherche = clientdao.chercher(1);
        System.out.print("Résultat de la recherche : ");
        clientdao.afficher(client_recherche);

        //Modifier un client
        Client client_modif = clientdao.chercher(1);






    }


    public static void afficherClients(daoClient dao){
        ArrayList<Client> clients = dao.getAll();
        for (Client client : clients){
            dao.afficher(client);
        }
    }
}