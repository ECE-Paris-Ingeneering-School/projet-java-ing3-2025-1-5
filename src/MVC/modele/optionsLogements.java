package MVC.modele;

public class optionsLogements {
    private int optionsId;
    private boolean wifi;
    private boolean serviceMenage;
    private boolean climatisation;
    private boolean fumeur;
    private boolean coffreFort;
    private boolean vue;
    private boolean petitDejeuner;
    private String parking;
    private boolean bar;
    private boolean salleDeSport;
    private boolean environnementNaturel;
    private boolean plage;
    private String transports;
    private float distanceAeroport;
    private float distanceCentreVille;
    private boolean isHotel;
    private int nbChambres;
    private int nbLits;
    private int nbPersonnes;

    // Constructeur
    public optionsLogements(int optionsId, boolean wifi, boolean serviceMenage, boolean climatisation, boolean fumeur, boolean coffreFort, boolean vue, boolean petitDejeuner, String parking, boolean bar, boolean salleDeSport, boolean environnementNaturel, boolean plage, String transports, float distanceAeroport, float distanceCentreVille, boolean isHotel, int nbChambres, int nbLits, int nbPersonnes) {
        this.optionsId = optionsId;
        this.wifi = wifi;
        this.serviceMenage = serviceMenage;
        this.climatisation = climatisation;
        this.fumeur = fumeur;
        this.coffreFort = coffreFort;
        this.vue = vue;
        this.petitDejeuner = petitDejeuner;
        this.parking = parking;
        this.bar = bar;
        this.salleDeSport = salleDeSport;
        this.environnementNaturel = environnementNaturel;
        this.plage = plage;
        this.transports = transports;
        this.distanceAeroport = distanceAeroport;
        this.distanceCentreVille = distanceCentreVille;
        this.isHotel = isHotel;
        this.nbChambres = nbChambres;
        this.nbLits = nbLits;
        this.nbPersonnes = nbPersonnes;
    }

    // Getters et Setters
    public int getOptionsId() { return optionsId; }
    public void setOptionsId(int optionsId) { this.optionsId = optionsId; }

    public boolean isWifi() { return wifi; }
    public void setWifi(boolean wifi) { this.wifi = wifi; }

    public boolean isServiceMenage() { return serviceMenage; }
    public void setServiceMenage(boolean serviceMenage) { this.serviceMenage = serviceMenage; }

    public boolean isClimatisation() { return climatisation; }
    public void setClimatisation(boolean climatisation) { this.climatisation = climatisation; }

    public boolean isFumeur() { return fumeur; }
    public void setFumeur(boolean fumeur) { this.fumeur = fumeur; }

    public boolean isCoffreFort() { return coffreFort; }
    public void setCoffreFort(boolean coffreFort) { this.coffreFort = coffreFort; }

    public boolean isVue() { return vue; }
    public void setVue(boolean vue) { this.vue = vue; }

    public boolean isPetitDejeuner() { return petitDejeuner; }
    public void setPetitDejeuner(boolean petitDejeuner) { this.petitDejeuner = petitDejeuner; }

    public String getParking() { return parking; }
    public void setParking(String parking) { this.parking = parking; }

    public boolean isBar() { return bar; }
    public void setBar(boolean bar) { this.bar = bar; }

    public boolean isSalleDeSport() { return salleDeSport; }
    public void setSalleDeSport(boolean salleDeSport) { this.salleDeSport = salleDeSport; }

    public boolean isEnvironnementNaturel() { return environnementNaturel; }
    public void setEnvironnementNaturel(boolean environnementNaturel) { this.environnementNaturel = environnementNaturel; }

    public boolean isPlage() { return plage; }
    public void setPlage(boolean plage) { this.plage = plage; }

    public String getTransports() { return transports; }
    public void setTransports(String transports) { this.transports = transports; }

    public float getDistanceAeroport() { return distanceAeroport; }
    public void setDistanceAeroport(float distanceAeroport) { this.distanceAeroport = distanceAeroport; }

    public float getDistanceCentreVille() { return distanceCentreVille; }
    public void setDistanceCentreVille(float distanceCentreVille) { this.distanceCentreVille = distanceCentreVille; }

    public boolean isHotel() { return isHotel; }
    public void setHotel(boolean isHotel) { this.isHotel = isHotel; }

    public int getNbChambres() { return nbChambres; }
    public void setNbChambres(int nbChambres) { this.nbChambres = nbChambres; }

    public int getNbLits() { return nbLits; }
    public void setNbLits(int nbLits) { this.nbLits = nbLits; }

    public int getNbPersonnes() { return nbPersonnes; }
    public void setNbPersonnes(int nbPersonnes) { this.nbPersonnes = nbPersonnes; }
}