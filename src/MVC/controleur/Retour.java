package MVC.controleur;

import MVC.vue.WireFramePageAccueil;

public class Retour {

    public static void main(String[] args) {
        System.out.println("Retour.java");
    }

    public void retour(String client_mail, String page_precedente) {
        System.out.println("Retour.java retour()");

        if (page_precedente.equals("WF_Accueil")) {
            System.out.println("Retour.java retour() accueil");
            WireFramePageAccueil pageAccueil = new WireFramePageAccueil();
            pageAccueil.WF_Accueil(client_mail);
        }
        else if (page_precedente.equals("WF_Principale")) {
            System.out.println("Retour.java retour() profil");
            
            
        } 
        else if (page_precedente.equals("WF_Details_lgt")) {
            System.out.println("Retour.java retour() historique");
            
            
        } 
        else if (page_precedente.equals("WF_Paiement")) {
            System.out.println("Retour.java retour() paiement");
            
            
        } 
        else if (page_precedente.equals("WF_Commentaire")) {
            System.out.println("Retour.java retour() commentaire");
            
            
        } 
        else if (page_precedente.equals("WF_DossierClient")) {
            System.out.println("Retour.java retour() dossierClient");
            

        } 
        else if (page_precedente.equals("WF_Modif_lgt")) {
            System.out.println("Retour.java retour() Modif_lgt");
            
            
        } 
        else if (page_precedente.equals("WF_Ajout_reduc")) {
            System.out.println("Retour.java retour() Ajout_reduc");
            
            
        }
        else if (page_precedente.equals("WF_MonCompte")) {
            System.out.println("Retour.java retour() MonCompte");
            
            
        } 
        else if (page_precedente.equals("WF_Aide")) {
            System.out.println("Retour.java retour() Aide");
            
            
        }
        else if (page_precedente.equals("WF_AccueilAdmin")) {
            System.out.println("Retour.java retour() AccueilAdmin");
            
            
        } 
        else if (page_precedente.equals("WF_Connexion")) {
            System.out.println("Retour.java retour() Connexion");
            
            
        } 
        else if (page_precedente.equals("WF_Inscription")) {
            System.out.println("Retour.java retour() Inscription");
            
            
        }
        else if (page_precedente.equals("WF_Reservation")) {
            System.out.println("Retour.java retour() Reservation");
        }
        else {
            System.out.println("Retour.java retour() page inconnue");
            
            
        }

    }
}
