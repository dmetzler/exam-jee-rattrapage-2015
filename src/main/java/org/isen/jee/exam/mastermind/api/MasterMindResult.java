package org.isen.jee.exam.mastermind.api;

/**
 * Représente le résultat d'un essai
 *
 */
public interface MasterMindResult {

    /**
     * Retourne le nombre de pions bien placés.
     * @return
     */
    public int compteBienPlaces();

    /**
     * Retourne le nombre de pions de bonne couleur
     * mais mal placés.
     * @return
     */
    public int compteMalPlaces();
}
