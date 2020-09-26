package ch.epfl.moocprog.random;

import java.util.Random;

/**
 * Classe utilitaire fournissant un moyen d'obtenir des valeurs
 * pseudo-aléatoires suivant une distribution uniforme
 */
public final class UniformDistribution {
    private static final Random random = new Random();

    // Empêche l'instanciation de cette classe
    private UniformDistribution() {}

    /**
     * Retourne une valeur suivant une distribution uniforme
     * comprise entre min et max.
     *
     * @param min La borne inférieure de la distribution
     * @param max La borne supérieure de la distribution
     * @return Une valeur pseudo-aléatoire suivant une distribution
     *         uniforme avec les paramètres donnés
     */
    public static double getValue(double min, double max) {
        if(max < min) {
            throw new IllegalArgumentException();
        }
        return random.nextDouble()*(max - min) + min;
    }
}
