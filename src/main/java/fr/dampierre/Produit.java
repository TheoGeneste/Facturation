package fr.dampierre;

public class Produit {
    private int code;
    private String libelle;
    private double prixHT;
    private double prixTTC;
    private TypeProduit typeProduit;

    public Produit(int code, String libelle, double prixHT, TypeProduit typeProduit) {
        this.code = code;
        this.libelle = libelle;
        this.prixHT = prixHT;
        this.typeProduit = typeProduit;
    }

    public double prixTTC() {
        prixTTC = (1 + typeProduit.getTva() / 100) * prixHT;
        return prixTTC;
    }

    public double getPrixHT() {
        return this.prixHT;
    }

    public String toString() {
        return "Code Produit : " + code + "\n" + "Produit : " + libelle + "\n" + "Prix HT : " + prixHT + "\n"
                + "Prix TTC : " + prixTTC() + "\n" + "Type Produit : " + typeProduit.getType() + "\n" + "TVA Produit : "
                + typeProduit.getTva();
    }
}

