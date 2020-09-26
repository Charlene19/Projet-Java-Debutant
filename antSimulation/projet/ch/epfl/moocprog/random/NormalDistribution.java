package ch.epfl.moocprog.random;

import java.util.Random;

/**
 * Classe utilitaire fournissant un moyen d'obtenir des valeurs
 * pseudo-aléatoires suivant une distribution gaussienne
 */
public final class NormalDistribution {
    private static final Random random = new Random();

    // Empêche l'instanciation de cette classe
    private NormalDistribution() {}

    /**
     * Retourne une valeur suivant une distribution gaussienne
     * d'espérence mu et de variance sigma2.
     *
     * @param mu L'espérence de la loi normale
     * @param sigma2 La variance de la loi normale
     * @return Une valeur suivant une loi normale d'espérence mu et
     *         de variance sigma2
     */
    public static double getValue(double mu, double sigma2) {
        if(sigma2 < 0) {
            throw new IllegalArgumentException();
        }
        return mu + Math.sqrt(sigma2) * random.nextGaussian();
    }
}
