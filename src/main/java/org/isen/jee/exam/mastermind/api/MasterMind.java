package org.isen.jee.exam.mastermind.api;

import java.util.List;

/**
 * Contrat d'un jeu de MasterMind
 *
 *
 */
public interface MasterMind {

    /**
     * Retourne le résultat pour un essai donné.
     *
     * @param cols un tableau de 4 Color représentant l'essai
     * @return
     */
    public MasterMindResult play(Color... colors);

    /**
     * Retourne vrai si le dernier essai était gagnant.
     * @return
     */
    public boolean isWon();

    /**
     * Retourne les couleurs jouées au tour i.
     * @param i
     * @return
     */
    public Color[] getTurn(int i);

    /**
     * Retourne le résultat pour le toure i.
     * @param i
     * @return
     */
    public MasterMindResult getResult(int i);
}
