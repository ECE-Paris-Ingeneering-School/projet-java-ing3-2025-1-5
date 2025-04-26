<div align="center">

# WhereBnB ¯\\\_(ツ)_/¯

**Application de réservation d’hébergements de vacances**

[Source](https://boostcamp.omneseducation.com/course/view.php?id=377194) •
[Ressource](https://boostcamp.omneseducation.com/course/view.php?id=377194&section=2#tabs-tree-start) •
[Livrable](https://boostcamp.omneseducation.com/course/view.php?id=377194&section=4#tabs-tree-start)

</div>

<details>
    <summary>📖 Table des Matières</summary>
    <ol>
        <li><a href="#-introduction">Introduction</a></li>
        <li><a href="#-fonctionnalités">Fonctionnalités</a></li>
        <li><a href="#-architecture">Architecture</a></li>
        <li><a href="#-prérequis">Prérequis</a></li>
        <li><a href="#-installation">Installation</a></li>
        <li><a href="#-stack">Stack</a></li>
        <li><a href="#-licence">Licence</a></li>
        <li><a href="#-deadlines">Deadlines</a></li>
    </ol>
</details>

---

## 🗒️ Introduction

Dans le cadre du projet de Java de notre année d'ING3, nous avons choisi de réaliser une application de réservation d'hébergements.

---

## ⚙️ Fonctionnalités

- **🔎 Recherche et filtrage** : Recherche d'hébergements par catégorie, prix, dates, et lieux.
- **🛏️ Réservation** : Réservation des hébergements avec options personnalisées (nombre d'adultes, d'enfants, de chambres).
- **👨‍💼 Interface Administrateur** : Mise à jour des hébergements, gestion des offres et des dossiers clients.
- **📊 Reporting** : Génération de rapports et statistiques sous forme de graphiques.

---

## 🏗️ Architecture

Le projet suit une architecture **MVC** *(modèle-MVC.vue-contrôleur)* combinée avec le pattern **DAO** *(Data Access Object)* et **JDBC** pour l'accès à la base de données.

---

## 🛠️ Prérequis

- **JDK (Java Development Kit)**

  ```sh
  wget https://corretto.aws/downloads/latest/amazon-corretto-21-x64-linux-jdk.tar.gz
  ```
- **MySQL** (Base de données)

# 💾 Installation

1. Clonez le projet :

   ```sh
   git clone https://github.com/ECE-Paris-Ingeneering-School/projet-java-ing3-2025-1-5.git
   ```
2. Configurez la base de données MySQL en utilisant le fichier [bdd.sql](/src/bdd.sql).

# 📚 Stack

[![](https://skillicons.dev/icons?i=java,mysql)](https://skillicons.dev)

# 📜 Licence

Ce projet est sous licence.
*Voir le fichier* [LICENSE](/LICENSE) *pour plus de détails.*
