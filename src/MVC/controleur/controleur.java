package MVC.controleur;

// import des packages autres
import java.sql.*;
import dao.*;

public class controleur {
    private static Connexion maconnexion;
    private static java.awt.List listeDeTables = new java.awt.List();
    private static java.awt.List listeDeRequetes = new java.awt.List();
    private static java.awt.TextField nameBDDTexte = new java.awt.TextField();

    public static void main(String[] args) {
        try{
            try {
                maconnexion = new Connexion("achats", "root", "");

                // effacer les listes de tables et de requêtes
                listeDeTables.removeAll();
                listeDeRequetes.removeAll();
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Connexion echouee : probleme de classe");
                cnfe.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
        }

        System.out.println("Connexion réussie");
    }
}