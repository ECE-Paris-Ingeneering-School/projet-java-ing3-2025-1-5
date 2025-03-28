-- BDD V1.0

DROP DATABASE IF EXISTS wherebnb;
CREATE DATABASE wherebnb;
USE wherebnb;

-- Table CLIENT
DROP TABLE IF EXISTS CLIENT;
CREATE TABLE CLIENT (
    Client_ID INT PRIMARY KEY AUTO_INCREMENT,
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
    Resa_ID INT PRIMARY KEY AUTO_INCREMENT,
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
    PRIMARY KEY (Logement_ID, Options_ID), -- Clé primaire composite
    FOREIGN KEY (Logement_ID) REFERENCES LOGEMENT(Logement_ID),
    FOREIGN KEY (Options_ID) REFERENCES OPTIONS_LOGEMENT(Options_ID)
);

-- Table LOGEMENT
DROP TABLE IF EXISTS LOGEMENT;
CREATE TABLE LOGEMENT (
    Logement_ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Adresse VARCHAR(255),
    Geo_coord VARCHAR(255),
    Prix FLOAT,
    Description TEXT,
    Liste_photos TEXT,
    Proprio_ID INT, -- Clé étrangère vers CLIENT
    FOREIGN KEY (Proprio_ID) REFERENCES CLIENT(Client_ID)
);

-- Table COMMENTAIRE
DROP TABLE IF EXISTS COMMENTAIRE;
CREATE TABLE COMMENTAIRE (
    Commentaire_ID INT PRIMARY KEY AUTO_INCREMENT,
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
    Options_ID INT PRIMARY KEY AUTO_INCREMENT,
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
    Nb_personnes INT
);



-- Ajout de données dans la table CLIENT
INSERT INTO CLIENT (Nom, Email, Num_telephone, Mot_de_passe, AncienClient, Statut_Admin)
VALUES
  ('Felix Cadene', 'felixcadene@mail.com', '0601020304', 'felixmdp', false, false),
  ('Leon Dalle', 'leondalle@mail.com', '0601020305', 'leonmdp', false, true),
  ('Annabelle Leoni', 'annabelleleoni@mail.com', '0601020306', 'annabellemdp', false, false),
  ('Alfred De Vulpian', 'alfreddevulpian@gmail.com', '0601020307', 'alfredmdp', false, false);

-- Ajout de données dans la table LOGEMENT
INSERT INTO LOGEMENT (Nom, Adresse, Geo_coord, Prix, Description, Liste_photos, Proprio_ID)
VALUES
  ('Appartement Gustave', '1 rue de la Paix', '48.8566, 2.3522', 100, 'Appartement de 50m2', 'photo1,photo2,photo3', 1),
  ('Appartement Louis', '2 rue de la Paix', '48.8566, 2.3522', 150, 'Appartement de 60m2', 'photo4,photo5,photo6', 2),
  ('Hotel Marie', '3 rue de la Paix', '48.8566, 2.3522', 200, 'Hotel de 100m2', 'photo7,photo8,photo9', 3),
  ('Maison de campagne', '4 rue de la Paix', '48.8566, 2.3522', 300, 'Maison de 200m2', 'photo10,photo11,photo12', 4);

-- Ajout de données dans la table OPTIONS_LOGEMENT
INSERT INTO OPTIONS_LOGEMENT (Wifi, Service_menage, Climatisation, Fumeur, Coffre_fort, Vue, Petit_dejeuner, Parking, Bar, Salle_de_sport, Environnement_naturel, Plage, Transports, Distance_aeroport, Distance_centre_ville, Is_hotel, Nb_chambres, Nb_lits, Nb_personnes)
VALUES
  (true, true, true, false, false, true, true, 'Parking', true, true, true, true, 'Bus', 10, 5, 10, 1, 1, 2),
  (true, true, true, false, false, true, true, 'Parking', true, true, true, true, 'Bus', 10, 5, 10, 1, 1, 2),
  (true, true, true, false, false, true, true, 'Parking', true, true, true, true, 'Bus', 10, 5, 10, 1, 1, 2),
  (true, true, true, false, false, true, true, 'Parking', true, true, true, true, 'Bus', 10, 5, 10, 1, 1, 2);

-- Ajout de données dans la table RESERVATION
INSERT INTO RESERVATION (Client_ID, Log_ID, Date_debut, Date_fin, Prix_total, Statut_paiement, Date_paiement, Nb_adultes, Nb_enfants)
VALUES
  (1, 1, '2021-01-01', '2021-01-02', 100, true, '2021-01-01', 2, 0),
  (2, 2, '2021-01-01', '2021-01-02', 150, true, '2021-01-01', 2, 0);