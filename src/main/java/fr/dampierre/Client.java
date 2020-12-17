package fr.dampierre;

public class Client {
    enum TypeClient {
        Particulier, Professionnel
    }

    private String nom;
    private String mail;
    private TypeClient typeClient;

    public Client(String nom, String mail, TypeClient typeClient) {
        this.nom = nom;
        this.mail = mail;
        this.typeClient = typeClient;

    }

    public String toString() {
        return "Nom Client : " + nom + "\n" + "Mail CLient : " + mail + "\n" + "Type Client : " + typeClient;
    }
}
