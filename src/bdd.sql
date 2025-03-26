--BDD V1.0

DROP DATABASE IF EXISTS wherebnb;
CREATE DATABASE wherebnb;
USE wherebnb;

-- Table CLIENT
DROP TABLE IF EXISTS CLIENT;
CREATE TABLE CLIENT (
    Client_ID INT PRIMARY KEY,
    Nom VARCHAR(255),
    Email VARCHAR(255),
    Num_telephone VARCHAR(15),
    Mot_de_passe VARCHAR(255),
    AncienClient BOOLEAN,
    Statut_Admin BOOLEAN,
    UNIQUE (Email(191)) -- Limite la longueur de l'index pour éviter l'erreur
);


-- Table RESERVATION
DROP TABLE IF EXISTS RESERVATION;
CREATE TABLE RESERVATION (
    Resa_ID INT PRIMARY KEY,
    Client_ID INT, -- Clé étrangère vers CLIENT
    Log_ID INT, -- Clé étrangère vers LOGEMENT
    Date_debut DATE,
    Date_fin DATE,
    Prix_total FLOAT,
    Statut_paiement BOOLEAN,
    Date_paiement DATE,
    Nb_adultes INT,
    Nb_enfants INT,
    FOREIGN KEY (Client_ID) REFERENCES CLIENT(Client_ID),
    FOREIGN KEY (Log_ID) REFERENCES LOGEMENT(Log_ID)
);

-- Table LIEU_ID
DROP TABLE IF EXISTS LIEU_ID;
CREATE TABLE LIEU_ID (
    Logement_ID INT NOT NULL,
    Options_ID INT NOT NULL,
    PRIMARY KEY (Logement_ID, Options_ID) -- Clé primaire composite
);

-- Table LOGEMENT
DROP TABLE IF EXISTS LOGEMENT;
CREATE TABLE LOGEMENT (
    Logement_ID INT PRIMARY KEY, -- Clé étrangère vers LIEU_ID
    Nom VARCHAR(255),
    Adresse VARCHAR(255),
    Geo_coord VARCHAR(255),
    Prix FLOAT,
    Description TEXT,
    Liste_photos TEXT,
    Proprio_ID INT, -- Clé étrangère vers CLIENT
    FOREIGN KEY (Logement_ID) REFERENCES LIEU_ID(Logement_ID),
    FOREIGN KEY (Proprio_ID) REFERENCES CLIENT(Client_ID)
);

--Table COMMENTAIRE
DROP TABLE IF EXISTS COMMENTAIRE;
CREATE TABLE COMMENTAIRE (
    Commentaire_ID INT PRIMARY KEY,
    Client_ID INT, -- Clé étrangère vers CLIENT
    Log_ID INT, -- Clé étrangère vers LOGEMENT
    Note INT,
    Commentaire TEXT,
    Date_commentaire DATE,
    FOREIGN KEY (Client_ID) REFERENCES CLIENT(Client_ID),
    FOREIGN KEY (Log_ID) REFERENCES LOGEMENT(Log_ID)
);

-- Table OPTIONS_LOGEMENT
DROP TABLE IF EXISTS OPTIONS_LOGEMENT;
CREATE TABLE OPTIONS_LOGEMENT (
    Options_ID INT PRIMARY KEY, -- Clé étrangère vers LIEU_ID
    Wifi BOOLEAN,
    Service_menage BOOLEAN,
    Climatisation BOOLEAN,
    Fumeur BOOLEAN,
    Coffre_fort BOOLEAN,
    Vue BOOLEAN,
    Petit_dejeuner BOOLEAN,
    Parking VARCHAR(255),
    Bar BOOLEAN,
    Salle_de_sport BOOLEAN,
    Environnement_naturel BOOLEAN,
    Plage BOOLEAN,
    Transports VARCHAR(255),
    Distance_aeroport FLOAT,
    Distance_centre_ville FLOAT,
    Is_hotel BOOLEAN,
    Nb_chambres INT,
    Nb_lits INT,
    Nb_personnes INT,
    FOREIGN KEY (Options_ID) REFERENCES LIEU_ID(Options_ID)
);
