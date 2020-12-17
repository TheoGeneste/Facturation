package fr.dampierre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProduitTest {
    /**
     * Rigorous Test.
     */
    @Test
    void produitSansTVA_getPrixTTC_renvoiePrixHT() {
        // Arrange

        TypeProduit pasDeTVA = new TypeProduit(0.0, " ");
        int prixHT = 100;
        Produit p = new Produit(1, "produit", prixHT, pasDeTVA);

        // AGIS

        double res = p.getPrixHT();

        // ASSERT

        assertEquals(prixHT, res, "Devrait renvoyer le prix HT");
    }

    @Test
    void produitTVA55_getPrixTTC_renvoiePrixTVA() {
        // Arrange

        TypeProduit tva55 = new TypeProduit(5.5, " ");
        int prixHT = 100;
        Produit p = new Produit(1, "produit", prixHT, tva55);

        // AGIS

        double res = p.prixTTC();

        // ASSERT

        assertEquals(105.5, res, "Devrait renvoyer le prix TTC");
    }

    
}