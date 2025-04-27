package mvc.modele;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private int resaId;
    private int clientId;
    private int logId;
    private Date dateDebut;
    private Date dateFin;
    private float prixTotal;
    private boolean statutPaiement;
    private Date datePaiement;
    private int nbAdultes;
    private int nbEnfants;

    // Constructeur
    public Reservation(int resaId, int clientId, int logId, Date dateDebut, Date dateFin, float prixTotal, boolean statutPaiement, Date datePaiement, int nbAdultes, int nbEnfants) {
        this.resaId = resaId;
        this.clientId = clientId;
        this.logId = logId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.statutPaiement = statutPaiement;
        this.datePaiement = datePaiement;
        this.nbAdultes = nbAdultes;
        this.nbEnfants = nbEnfants;
    }

    // Getters et Setters
    public int getResaId() { return resaId; }
    public void setResaId(int resaId) { this.resaId = resaId; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public int getLogId() { return logId; }
    public void setLogId(int logId) { this.logId = logId; }

    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public float getPrixTotal() { return prixTotal; }
    public void setPrixTotal(float prixTotal) { this.prixTotal = prixTotal; }

    public boolean getStatutPaiement() { return statutPaiement; }
    public void setStatutPaiement(boolean statutPaiement) { this.statutPaiement = statutPaiement; }

    public Date getDatePaiement() { return datePaiement; }
    public void setDatePaiement(Date datePaiement) { this.datePaiement = datePaiement; }

    public int getNbAdultes() { return nbAdultes; }
    public void setNbAdultes(int nbAdultes) { this.nbAdultes = nbAdultes; }

    public int getNbEnfants() { return nbEnfants; }
    public void setNbEnfants(int nbEnfants) { this.nbEnfants = nbEnfants; }



    //calculer duree du sejour
    //source : https://www.delftstack.com/fr/howto/java/java-subtract-dates/
    public long DureeSejour() throws Exception {
        if (dateDebut != null && dateFin != null){

            long diff = dateFin.getTime() - dateDebut.getTime();
            //TimeUnit time = TimeUnit.DAYS;
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        }
        return 0;
    }
}
