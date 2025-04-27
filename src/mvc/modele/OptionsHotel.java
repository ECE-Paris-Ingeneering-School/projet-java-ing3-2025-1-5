package mvc.modele;


/**
 * Classe OptionsHotel
 */
public class OptionsHotel {
    private int optionsId;
    private boolean petitDejeuner;
    private boolean bar;
    private boolean salleDeSport;
    private boolean serviceEtage;
    private int nbEtoiles;

    // Getters et Setters
    public int getOptionsId() { return optionsId; }
    public void setOptionsId(int optionsId) { this.optionsId = optionsId; }

    public boolean isPetitDejeuner() { return petitDejeuner; }
    public void setPetitDejeuner(boolean petitDejeuner) { this.petitDejeuner = petitDejeuner; }

    public boolean isBar() { return bar; }
    public void setBar(boolean bar) { this.bar = bar; }

    public boolean isSalleDeSport() { return salleDeSport; }
    public void setSalleDeSport(boolean salleDeSport) { this.salleDeSport = salleDeSport; }

    public boolean isServiceEtage() { return serviceEtage; }
    public void setServiceEtage(boolean serviceEtage) { this.serviceEtage = serviceEtage; }

    public int getNbEtoiles() { return nbEtoiles; }
    public void setNbEtoiles(int nbEtoiles) { this.nbEtoiles = nbEtoiles; }
}