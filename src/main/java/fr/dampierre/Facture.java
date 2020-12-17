package fr.dampierre;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Facture {
    private double montantTTC;
    private HashMap<Produit, Integer> produits = new HashMap<Produit, Integer>();
    private double montantHT;
    private int id;
    private Date date;
    private Client client;

    public Facture(Client client) {
        this.id = id++;
        montantHT = 0;
        date = new Date();
        this.client = client;

    }

    public void ajouterProduit(Produit produit, int quantité) {
        if (produits.containsKey(produit)) {
            produits.put(produit, produits.get(produit) + quantité);
        } else {
            produits.put(produit, quantité);
        }
    }

    public void retirerProduit(Produit produit, int quantité) {
        if (produits.containsKey(produit)) {
            if (produits.get(produit) >= quantité) {
                produits.put(produit, produits.get(produit) - quantité);
            }
        } else {
            produits.remove(produit);
        }
    }

    public boolean produitExistant(Produit produit) {
        if (produits.containsKey(produit)) {
            return true;
        } else {
            return false;
        }
    }

    public double MontantTotalTTC() {
        montantTTC = 0;
        double prix;
        for (Entry<Produit, Integer> key : produits.entrySet()) {
            prix = key.getKey().prixTTC();
            montantTTC += key.getValue() * prix;
        }
        return montantTTC;
    }

    public double MontantTotalHT() {
        montantHT = 0;
        double prix;
        for (Entry<Produit, Integer> key : produits.entrySet()) {
            prix = key.getKey().getPrixHT();
            montantHT += key.getValue() * prix;
        }
        return montantHT;
    }

    private String toStringProduit() {
        String res = "";
        for (HashMap.Entry<Produit, Integer> produits : produits.entrySet()) {
            res += produits.getKey() + "\n" + "Quantité : " + produits.getValue() + "\n";
        }
        return res;
    }

    public int getQuantiteTotalProduitConfondue() {
        int quantiteGlobale = 0;
        for (HashMap.Entry<Produit, Integer> key : produits.entrySet()) {
            quantiteGlobale += key.getValue();
        }
        return quantiteGlobale;
    }

    public int getQuantiteDUnProduit(Produit p) {
        if (produits.containsKey(p)) {
            return produits.get(p);
        } else {
            return 0;
        }
    }

    public String toString() {

        return "\n" + "Date : " + date + "\n" + "Montant Total HT : " + MontantTotalHT() + "\n" + "Montant Total TTC : "
                + MontantTotalTTC() + "\n" + toStringProduit() + "\n" + client.toString();
    }

}
