-- BDD V1.1

DROP DATABASE IF EXISTS wherebnb;
CREATE DATABASE wherebnb;
USE wherebnb;

DROP TABLE IF EXISTS COMMENTAIRE;
DROP TABLE IF EXISTS RESERVATION;
DROP TABLE IF EXISTS LOGEMENT_GENERAL;
DROP TABLE IF EXISTS OPTIONS_HOTEL;
DROP TABLE IF EXISTS OPTIONS_APPARTEMENT;
DROP TABLE IF EXISTS OPTIONS_MAISON;
DROP TABLE IF EXISTS OPTIONS_COMMUNES;
DROP TABLE IF EXISTS LOGEMENT;
DROP TABLE IF EXISTS CLIENT;
DROP TABLE IF EXISTS ADRESSE;

-- Table CLIENT
CREATE TABLE CLIENT (
    Client_ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Email VARCHAR(255),
    Num_telephone VARCHAR(15),
    Mot_de_passe VARCHAR(255),
    AncienClient BOOLEAN,
    Statut_Admin BOOLEAN,
    Adresse_ID INT,
    UNIQUE (Email(191)),
    FOREIGN KEY (Adresse_ID) REFERENCES ADRESSE(Adresse_ID)
);

-- Table RESERVATION
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

-- Table ADRESSE
DROP TABLE IF EXISTS ADRESSE;
CREATE TABLE ADRESSE (
    Adresse_ID INT PRIMARY KEY AUTO_INCREMENT,
    Numero VARCHAR(10),
    Rue VARCHAR(255),
    Code_postal VARCHAR(5),
    Ville VARCHAR(255),
    Pays VARCHAR(255),
    Complement_adresse VARCHAR(255),
    Geo_coord VARCHAR(255)
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

-- Table LOGEMENT avec auto-increment
CREATE TABLE LOGEMENT (
    Logement_ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Prix FLOAT,
    Description TEXT,
    Liste_photos TEXT,
    Note FLOAT,
    Proprio_ID INT,
    Adresse_ID INT,
    FOREIGN KEY (Proprio_ID) REFERENCES CLIENT(Client_ID),
    FOREIGN KEY (Adresse_ID) REFERENCES ADRESSE(Adresse_ID)
);

-- Table de jonction LOGEMENT_GENERAL
CREATE TABLE LOGEMENT_GENERAL (
    Logement_ID INT,
    Options_ID INT,
    Type_logement ENUM('HOTEL', 'APPARTEMENT', 'MAISON'),
    PRIMARY KEY (Logement_ID, Options_ID),
    FOREIGN KEY (Logement_ID) REFERENCES LOGEMENT(Logement_ID),
    FOREIGN KEY (Options_ID) REFERENCES OPTIONS_COMMUNES(Options_ID)
);

-- Table OPTIONS_COMMUNES
CREATE TABLE OPTIONS_COMMUNES (
    Options_ID INT PRIMARY KEY AUTO_INCREMENT,
    Wifi BOOLEAN,
    Climatisation BOOLEAN,
    Parking VARCHAR(255),
    Vue BOOLEAN,
    Nb_personnes INT,
    Distance_centre_ville FLOAT,
    Distance_aeroport FLOAT,
    Service_menage BOOLEAN
);

-- Tables OPTIONS_HOTEL, OPTIONS_APPARTEMENT, OPTIONS_MAISON
-- Ces tables contiennent des options spécifiques à chaque type de logement
CREATE TABLE OPTIONS_HOTEL (
    Options_ID INT PRIMARY KEY,
    Petit_dejeuner BOOLEAN,
    Bar BOOLEAN,
    Salle_de_sport BOOLEAN,
    Service_etage BOOLEAN,
    Nb_etoiles INT,
    FOREIGN KEY (Options_ID) REFERENCES OPTIONS_COMMUNES(Options_ID)
);
CREATE TABLE OPTIONS_APPARTEMENT (
    Options_ID INT PRIMARY KEY,
    Etage INT,
    Ascenseur BOOLEAN,
    Surface INT,
    Nb_pieces INT,
    FOREIGN KEY (Options_ID) REFERENCES OPTIONS_COMMUNES(Options_ID)
);
CREATE TABLE OPTIONS_MAISON (
    Options_ID INT PRIMARY KEY,
    Jardin BOOLEAN,
    Piscine BOOLEAN,
    Surface_terrain INT,
    Nb_etages INT,
    FOREIGN KEY (Options_ID) REFERENCES OPTIONS_COMMUNES(Options_ID)
);

-- Ajout de données dans la table ADRESSE (inchangé)
INSERT INTO ADRESSE (Numero, Rue, Code_postal, Ville, Pays, Complement_adresse, Geo_coord)
VALUES
    ('1', 'rue de la Paix', '75001', 'Paris', 'France', 'Apt 4B', '48.8566, 2.3522'),
    ('2', 'rue de la Paix', '75001', 'Paris', 'France', NULL, '48.8566, 2.3522'),
    ('3', 'rue de la Paix', '75001', 'Paris', 'France', '1er étage', '48.8566, 2.3522'),
    ('4', 'rue de la Paix', '75001', 'Paris', 'France', NULL, '48.8566, 2.3522'),
    ('5', 'avenue des Champs-Élysées', '75008', 'Paris', 'France', 'Bâtiment B', '48.8698, 2.3076'),
    ('6', 'boulevard Haussmann', '75009', 'Paris', 'France', NULL, '48.8753, 2.3287'),
    ('7', 'rue Oberkampf', '75011', 'Paris', 'France', 'Code porte 1234', '48.8643, 2.3795'),
    ('8', 'rue Sainte-Catherine', '33000', 'Bordeaux', 'France', 'Appartement 5C', '44.8378, -0.5792'),
    ('9', 'place Bellecour', '69002', 'Lyon', 'France', NULL, '45.7578, 4.8320'),
    ('10', 'rue du Faubourg Saint-Antoine', '75012', 'Paris', 'France', '3e étage gauche', '48.8516, 2.3798');

-- Ajout de données dans la table CLIENT (inchangé)
INSERT INTO CLIENT (Nom, Email, Num_telephone, Mot_de_passe, AncienClient, Statut_Admin, Adresse_ID)
VALUES
    ('Felix Cadene', 'felixcadene@mail.com', '0601020304', 'felixmdp', true, false, 1),
    ('Leon Dalle', 'leondalle@mail.com', '0601020305', 'leonmdp', true, true, 2),
    ('Annabelle Leoni', 'annabelleleoni@mail.com', '0601020306', 'annabellemdp', false, false, 3),
    ('Alfred De Vulpian', 'alfreddevulpian@mail.com', '0601020307', 'alfredmdp', false, false, 4);

-- Ajout des options communes
INSERT INTO OPTIONS_COMMUNES (Wifi, Climatisation, Parking, Vue, Nb_personnes, Distance_centre_ville, Distance_aeroport, Service_menage)
VALUES
    (true, true, 'Parking couvert', true, 2, 5.0, 10.0, true),
    (true, true, 'Parking extérieur', true, 2, 5.0, 10.0, true),
    (true, true, 'Parking privé', true, 4, 5.0, 10.0, true),
    (true, true, 'Parking gratuit', true, 6, 5.0, 10.0, true),
    (true, false, 'Parking extérieur', false, 2, 3.0, 8.0, true),   
    (true, true, 'Parking privé', true, 4, 2.0, 5.0, true),         
    (false, true, 'Aucun', false, 1, 1.0, 12.0, false),             
    (true, true, 'Parking gratuit', true, 6, 7.0, 9.0, true),       
    (true, true, 'Parking couvert', true, 3, 4.0, 11.0, true),      
    (false, false, 'Parking privé', false, 2, 2.5, 6.0, false); 

-- Ajout des options spécifiques
INSERT INTO OPTIONS_APPARTEMENT (Options_ID, Etage, Ascenseur, Surface, Nb_pieces)
VALUES
    (1, 3, true, 50, 2),
    (2, 2, true, 60, 3),
    (5, 1, false, 40, 2),
    (6, 4, true, 70, 3);

INSERT INTO OPTIONS_HOTEL (Options_ID, Petit_dejeuner, Bar, Salle_de_sport, Service_etage, Nb_etoiles)
VALUES 
    (3, true, true, true, true, 4),
    (7, false, false, false, false, 2);

INSERT INTO OPTIONS_MAISON (Options_ID, Jardin, Piscine, Surface_terrain, Nb_etages)
VALUES 
    (4, true, true, 1000, 2),
    (8, true, false, 600, 1),
    (9, false, true, 850, 2),
    (10, true, true, 1200, 2);

-- Ajout des logements
INSERT INTO LOGEMENT (Nom, Prix, Description, Liste_photos, Note, Proprio_ID, Adresse_ID)
VALUES
    ('Appartement Gustave', 100, 'Appartement de 50m2', 'photo1,photo2,photo3', 4.5, 1, 1),
    ('Appartement Louis', 150, 'Appartement de 60m2', 'photo4,photo5,photo6', 4.2, 2, 2),
    ('Hotel Marie', 200, 'Hotel de 100m2', 'photo7,photo8,photo9', 4.8, 3, 3),
    ('Maison de campagne', 300, 'Maison de 200m2', 'photo10,photo11,photo12', 4.6, 4, 4),
    ('Appartement Montaigne', 120, 'Appartement cosy près des Champs-Élysées', 'photo13,photo14', 4.3, 1, 5),
    ('Appartement Haussmannien', 180, 'Bel appartement avec vue sur Paris', 'photo15,photo16', 4.7, 2, 6),
    ('Hotel Simplet', 90, 'Petit hôtel 2 étoiles', 'photo17,photo18', 3.9, 3, 7),
    ('Maison Bordelaise', 250, 'Maison typique à Bordeaux', 'photo19,photo20', 4.4, 4, 8),
    ('Villa Bellecour', 350, 'Maison luxueuse en plein cœur de Lyon', 'photo21,photo22', 4.9, 1, 9),
    ('Maison Bastille', 280, 'Maison calme proche centre', 'photo23,photo24', 4.1, 2, 10);

-- Ajout des liaisons dans LOGEMENT_GENERAL
INSERT INTO LOGEMENT_GENERAL (Logement_ID, Options_ID, Type_logement)
VALUES
    (1, 1, 'APPARTEMENT'),
    (2, 2, 'APPARTEMENT'),
    (3, 3, 'HOTEL'),
    (4, 4, 'MAISON');

-- Ajout des réservations (inchangé)
INSERT INTO RESERVATION (Client_ID, Log_ID, Date_debut, Date_fin, Prix_total, Statut_paiement, Date_paiement, Nb_adultes, Nb_enfants)
VALUES
    (1, 1, '2024-01-01', '2024-01-02', 100, true, '2024-01-01', 2, 0),
    (3, 2, '2024-01-01', '2024-01-02', 150, true, '2024-01-01', 2, 0),
    (3, 3, '2024-02-15', '2024-02-20', 400, true, '2024-02-10', 2, 1),
    (4, 1, '2024-04-01', '2024-04-05', 500, true, '2024-03-30', 2, 2),
    (1, 3, '2024-05-05', '2024-05-08', 270, true, '2024-05-01', 1, 1),
    (1, 2, '2025-07-15', '2025-07-18', 300, true, '2024-07-10', 2, 0);

-- Ajout des commentaires (inchangé)
INSERT INTO COMMENTAIRE (Client_ID, Log_ID, Note, Commentaire, Date_commentaire)
VALUES
    (1, 2, 5, 'Très bon séjour', '2024-01-03'),
    (2, 1, 4, 'Agréable mais un peu bruyant', '2024-01-03');