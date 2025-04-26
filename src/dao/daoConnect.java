package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 * La DAO Factory (daoConnect.java) permet d'initialiser le DAO en chargeant notamment les drivers nécessaires
 * (ici un driver JDBC MySQL) et se connecte à la base de données. La Factory peut fournir plusieurs DAO (ici,
 * il n'y en a qu'un seul, UtilisateurDao, qui correspond à une table de la base).
 */
public class daoConnect {
    /**
     * Attributs private pour la connexion JDBC
     */
    private static String url;
    private String username;
    private String password;

    // constructeur
    public daoConnect(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Méthode qui retourne 1 objet de daoConnect
     * @param : url, username et password de la base de données
     * @return : objet de la classe DaoFactoru
     */
    public static daoConnect getInstance(String database, String username, String password) {
        try {
            // chargement driver "com.mysql.cj.jdbc.Driver"
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de connexion à la base de données");
        }

        url = "jdbc:mysql://localhost:3306/" + database;

        // Instancier une instance l'objet de daoConnect
        daoConnect instance = new daoConnect(url, username,password );

        // Retourner cette instance
        return instance;
    }

    /**
     * Méthode qui retourne le driver de base de données approprié
     * @return : le driver approprié
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        // Retourner la connection du driver de la base de données
        System.out.println("63");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     *     Fermer la connexion à la base de données
     */
    public void disconnect() {
        Connection connexion = null;

        try {
            // création d'un ordre SQL (statement)
            connexion = this.getConnection();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de déconnexion à la base de données");
        }
    }

    public void resetBDD(){
        try {
            // connexion
            Connection connexion = this.getConnection();
            Statement statement = connexion.createStatement();

            // read bdd.sql
            String readsql = "src/bdd.sql";
            List<String> lines = Files.readAllLines(Paths.get(readsql));
            StringBuilder sql = new StringBuilder();
            for (String line : lines) {
                sql.append(line).append("\n");
            }
            // execute sql
            String[] queries = sql.toString().split(";");
            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    statement.executeUpdate(query);
                }
            }
            System.out.println("Base de données réinitialisée avec succès");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de réinitialisation de la base de données");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}