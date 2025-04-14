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

        System.out.println("On démarre le testeur");
        //call testeur
        testeur.main(args);
    }
}