import MVC.controleur.controleur;
import MVC.modele.*;
import dao.*;
import java.util.*;
import MVC.vue.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        controleur.main(args);

        daoConnect dao = daoConnect.getInstance("wherebnb", "root", "");

        //Reset BDD
        dao.resetBDD();

        daoClient clientDAO = new daoClient(dao);
        daoLogement logementDAO = new daoLogement(dao);
        daoAdresse adresseDAO = new daoAdresse(dao);
        List<Client> clients = clientDAO.getAll();
        List<Logement> logement = logementDAO.getAll();
        List<Adresse> adresses = adresseDAO.getAll();

        System.out.println("Liste des clients :");
        for (Client client : clients) {
            System.out.println(client);
        }
        System.out.println("Liste des logements :");
        for (Logement logementItem : logement) {
            System.out.println(logementItem);
        }
        System.out.println("Liste des adresses :");
        for (Adresse adresse : adresses) {
            System.out.println(adresse);
        }

        //WireFramePageAccueil.main(args);
        WireFramePageConnexion.main(args);
    }
}