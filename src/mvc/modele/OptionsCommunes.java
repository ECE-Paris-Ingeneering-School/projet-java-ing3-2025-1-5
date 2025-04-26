package mvc.modele;

public class OptionsCommunes {
    private int optionsId;
    private boolean wifi;
    private boolean climatisation;
    private String parking;
    private boolean vue;
    private int nbPersonnes;
    private float distanceCentreVille;
    private float distanceAeroport;
    private boolean serviceMenage;

    // Getters et Setters
    public int getOptionsId() { return optionsId; }
    public void setOptionsId(int optionsId) { this.optionsId = optionsId; }

    public boolean isWifi() { return wifi; }
    public void setWifi(boolean wifi) { this.wifi = wifi; }

    public boolean isClimatisation() { return climatisation; }
    public void setClimatisation(boolean climatisation) { this.climatisation = climatisation; }

    public String getParking() { return parking; }
    public void setParking(String parking) { this.parking = parking; }

    public boolean isVue() { return vue; }
    public void setVue(boolean vue) { this.vue = vue; }

    public int getNbPersonnes() { return nbPersonnes; }
    public void setNbPersonnes(int nbPersonnes) { this.nbPersonnes = nbPersonnes; }

    public float getDistanceCentreVille() { return distanceCentreVille; }
    public void setDistanceCentreVille(float distanceCentreVille) { this.distanceCentreVille = distanceCentreVille; }

    public float getDistanceAeroport() { return distanceAeroport; }
    public void setDistanceAeroport(float distanceAeroport) { this.distanceAeroport = distanceAeroport; }

    public boolean isServiceMenage() { return serviceMenage; }
    public void setServiceMenage(boolean serviceMenage) { this.serviceMenage = serviceMenage; }
}