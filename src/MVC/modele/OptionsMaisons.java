package MVC.modele;

public class OptionsMaisons {
    private int optionsId;
    private boolean jardin;
    private boolean piscine;
    private int surfaceTerrain;
    private int nbEtages;

    // Getters et Setters
    public int getOptionsId() { return optionsId; }
    public void setOptionsId(int optionsId) { this.optionsId = optionsId; }

    public boolean isJardin() { return jardin; }
    public void setJardin(boolean jardin) { this.jardin = jardin; }

    public boolean isPiscine() { return piscine; }
    public void setPiscine(boolean piscine) { this.piscine = piscine; }

    public int getSurfaceTerrain() { return surfaceTerrain; }
    public void setSurfaceTerrain(int surfaceTerrain) { this.surfaceTerrain = surfaceTerrain; }

    public int getNbEtages() { return nbEtages; }
    public void setNbEtages(int nbEtages) { this.nbEtages = nbEtages; }
}