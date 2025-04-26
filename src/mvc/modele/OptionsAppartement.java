package mvc.modele;

    public class OptionsAppartement {
        private int optionsId;
        private int etage;
        private boolean ascenseur;
        private int surface;
        private int nbPieces;

        // Getters et Setters
        public int getOptionsId() { return optionsId; }
        public void setOptionsId(int optionsId) { this.optionsId = optionsId; }

        public int getEtage() { return etage; }
        public void setEtage(int etage) { this.etage = etage; }

        public boolean isAscenseur() { return ascenseur; }
        public void setAscenseur(boolean ascenseur) { this.ascenseur = ascenseur; }

        public int getSurface() { return surface; }
        public void setSurface(int surface) { this.surface = surface; }

        public int getNbPieces() { return nbPieces; }
        public void setNbPieces(int nbPieces) { this.nbPieces = nbPieces; }
    }