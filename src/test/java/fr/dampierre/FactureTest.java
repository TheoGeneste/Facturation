package fr.dampierre;

import org.junit.jupiter.api.Test;

import fr.dampierre.Client.TypeClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactureTest {
    /**
     * Rigorous Test.
     */
    @Test
    void ajouterUnProduit() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Facture f = new Facture(c);

        // AGIS

        f.ajouterProduit(p, 5);

        // ASSERT

        assertEquals(5, f.getQuantiteDUnProduit(p), "Devrait renvoyer le prix HT");
    }

    /**
     * Rigorous Test.
     */
    @Test
    void retireUnProduit() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Facture f = new Facture(c);
        f.ajouterProduit(p, 5);

        // AGIS

        f.retirerProduit(p, 2);

        // ASSERT

        assertEquals(3, f.getQuantiteDUnProduit(p), "Devrait avoir 2 de quantié en moins");
    }

    /**
     * Rigorous Test.
     */
    @Test
    void MontantTotalHT() {
        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        TypeProduit tva55 = new TypeProduit(5.5, "");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Produit p2 = new Produit(111, "produit2", 200, tva55);
        Facture f = new Facture(c);
        f.ajouterProduit(p, 5);
        f.ajouterProduit(p2, 10);

        // AGIS
        double res = f.MontantTotalHT();

        // ASSERT
        assertEquals(2500, res, "Devrait retouner le montant totale de la facture HT");
    }

    /**
     * Rigorous Test.
     */
    @Test
    void MontantTotalTTC() {
        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        TypeProduit tva55 = new TypeProduit(5.5, "");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Produit p2 = new Produit(111, "produit2", 200, tva55);
        Facture f = new Facture(c);
        f.ajouterProduit(p, 5);
        f.ajouterProduit(p2, 10);

        // AGIS
        double res = f.MontantTotalTTC();

        // ASSERT

        assertEquals(2610, res, "Devrait retouner le montant totale de la facture TTC");
    }

    @Test
    void ajouterUnProduitDejaExistant() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Facture f = new Facture(c);
        f.ajouterProduit(p, 5);
        // AGIS

        f.ajouterProduit(p, 5);

        // ASSERT

        assertEquals(10, f.getQuantiteDUnProduit(p), "Devrait renvoyer le prix HT");
    }

    @Test
    void quantiteDUnProduitDansFacture() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        TypeProduit tva55 = new TypeProduit(5.5, "");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Facture f = new Facture(c);
        Produit p2 = new Produit(111, "produit2", 200, tva55);
        f.ajouterProduit(p, 5);
        f.ajouterProduit(p2, 10);

        // AGIS

        int res = f.getQuantiteDUnProduit(p);

        // ASSERT

        assertEquals(5, res, "Devrait renvoyer le prix HT");
    }

    @Test
    void quantiteDUnProduitDansFacture2() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        TypeProduit tva55 = new TypeProduit(5.5, "");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Facture f = new Facture(c);
        Produit p2 = new Produit(111, "produit2", 200, tva55);
        f.ajouterProduit(p, 5);
        f.ajouterProduit(p2, 10);

        // AGIS

        int res = f.getQuantiteDUnProduit(p2);

        // ASSERT

        assertEquals(10, res, "Devrait renvoyer le prix HT");
    }

    @Test
    void quantiteTotaleProduitConfondu() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        TypeProduit tva55 = new TypeProduit(5.5, "");
        Client c = new Client("Geneste", "theogeneste@hotmail.fr", TypeClient.Particulier);
        int prixHT = 100;
        Produit p = new Produit(333, "produit", prixHT, pasDeTVA);
        Facture f = new Facture(c);
        Produit p2 = new Produit(111, "produit2", 200, tva55);
        f.ajouterProduit(p, 5);
        f.ajouterProduit(p2, 10);

        // AGIS

        int res = f.getQuantiteTotalProduitConfondue();

        // ASSERT

        assertEquals(15, res, "Devrait renvoyer le prix HT");
    }
}