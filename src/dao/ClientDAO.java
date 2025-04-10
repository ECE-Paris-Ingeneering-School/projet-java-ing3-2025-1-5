package dao;

//Client DAO class
// --> Gestion des operations de la base de données pour les clients

interface InterClientDAO {
    public void create_Client();
    public void update_Client();
    public void delete_Client();
    public void get_ClientID();
    public void get_allClient();
    public void login_Client();
    public void logout_Client();
}

//client dao class
public class ClientDAO implements InterClientDAO {
    //create client

    //Method to create connection
    public void createConnection() {
        String urlDatabase = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "";
        
    }

    public void create_Client() {
        //COMPLETER

    }

    //update client
    public void update_Client() {
        return;
    }

    //delete client
    public void delete_Client() {
        return;
    }

    //get client id
    public void get_ClientID() {
        return;
    }

    //get all clients
    public void get_allClient() {
        return;
    }

    //login client
    public void login_Client() {
        return;
    }

    //logout client
    public void logout_Client() {
        return;
    }
}