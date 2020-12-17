package fr.dampierre;

import fr.dampierre.Client.TypeClient;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        TypeProduit typeProduit1 = new TypeProduit(0.15, "Vetements");
        Produit produit1 = new Produit(1111, "Chino", 13, typeProduit1);
        Produit produit2 = new Produit(1112, "Chino", 13, typeProduit1);
        Client client1 = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        Facture facture1 = new Facture(client1);
        facture1.ajouterProduit(produit1, 5);
        facture1.ajouterProduit(produit2, 5);
        facture1.retirerProduit(produit1, 2);
        System.out.println(facture1.toString());
    }
}