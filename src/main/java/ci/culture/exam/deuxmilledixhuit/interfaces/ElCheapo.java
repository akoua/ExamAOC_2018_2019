package ci.culture.exam.deuxmilledixhuit.interfaces;

import ci.culture.exam.deuxmilledixhuit.entities.Offer;

public interface ElCheapo {
    /**
     * Retourne la meilleure offre parmi l'ensemble des vendeurs connus de ElCheapo * @param productName le nom du produit recherché
     * @return la meilleure offre (prix,vendeur)
     */
     Offer getBestOffer(String productName);
}
