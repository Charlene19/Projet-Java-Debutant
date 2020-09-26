package ch.epfl.moocprog.utils;

import ch.epfl.moocprog.Positionable;
import ch.epfl.moocprog.random.UniformDistribution;

import java.util.*;

/**
 * Classe utilitaire fournissant diverse méthodes
 * statiques
 */
public final class Utils {
    // Empêche l'instanciation de cette classe
    private Utils() {}

    /**
     * Sélectionne une valeur du tableau {@code values} conformément
     * au probabilités spécifiées par {@code probs}.
     *
     * @param values Les valeurs à considérer
     * @param probs Un tableau représentant la probabilité
     *              associée à chaque valeur du tableau {@code values}
     * @return Une valeur de {@code values} tirée au hasard.
     */
    public static double pickValue(double[] values,
                                   double[] probs)
    {
        requireNonNull(values);
        requireNonNull(probs);
        require(values.length == probs.length);

        if (values.length == 0) {
            throw new IllegalArgumentException();
        } else {
            List<Double> filteredValues = new ArrayList<>();
            List<Double> filteredProbs = new ArrayList<>();
            double sum = 0;
            double maxProb = Double.NEGATIVE_INFINITY;

            for (int i = 0; i < values.length; ++i) {
                if (probs[i] < 0) {
                    throw new IllegalArgumentException();
                } else if (probs[i] > 0) {
                    filteredValues.add(values[i]);
                    filteredProbs.add(probs[i]);
                    sum += probs[i];
                    maxProb = Math.max(maxProb, probs[i]);
                }
            }
            assert filteredProbs.size() == filteredValues.size();

            if (filteredProbs.size() == 0) {
                assert sum == 0;
                throw new IllegalArgumentException();
            }

            double draw = UniformDistribution.getValue(0, sum);
            double acc = 0;
            for (int i = 0; i < filteredProbs.size(); ++i) {
                if (draw < acc + filteredProbs.get(i)) {
                    return filteredValues.get(i);
                }
                acc += filteredProbs.get(i);
            }

            return maxProb;
        }
    }

    /**
     * Lance une exception de type {@code IllegalArgumentException}
     * si la condition donnée n'est pas satisfaite.
     *
     * @param message Le message de l'erreur
     * @param condition La condition qui, si évaluée à {@code false}
     *                  provoque l'exception {@code IllegalArgumentException}
     */
    public static void require(String message, boolean condition) {
        if(!condition) {
            if (message == null) {
                throw new IllegalArgumentException();
            } else {
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Possède le même comportement que {@link #require(String, boolean)}
     * mais sans message détaillé de l'erreur.
     *
     * @param condition La condition qui, si est évaluée à {@code false}
     *                  provoque l'exception {@code IllegalArgumentException}
     *
     * @see #require(String, boolean)
     */
    public static void require(boolean condition) {
        require(null, condition);
    }

    /**
     * Lance une exception de type {@code IllegalArgumentException}
     * si la l'objet {@code toTest} est {@code null}.
     *
     * @param message Le message détaillé de l'erreur
     * @param toTest L'objet qui, si vaut {@code null}, provoque
     *               l'exception {@code IllegalArgumentException}
     */
    public static void requireNonNull(String message, Object toTest) {
        if(toTest == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Possède le même comportement que {@link #requireNonNull(String, Object)}
     * mais sans message détaillé de l'erreur.
     *
     * @param toTest L'objet qui, si vaut {@code null}, provoque
     *               l'exception {@code IllegalArgumentException}
     *
     * @see #requireNonNull(String, Object)
     */
    public static void requireNonNull(Object toTest) {
        if(toTest == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Retourne l'objet {@link Positionable} de {@code collection} qui est le plus proche
     * en terme de distance torique de l'objet {@link Positionable} {@code entity}.
     *
     * @param entity L'entité dont on souhaite trouver l'objet le plus proche
     * @param collection La collection que l'on considère pour trouver l'objet
     *                   le plus proche de {@code entity}
     * @param <T> Le type de {@code entity}
     * @param <S> Le type des éléments de {@code collection}
     * @return L'objet le plus proche de {@code entity}
     */
    public static <T extends Positionable, S extends Positionable>
    S closestFromPoint(T entity, Collection<S> collection)
    {
        requireNonNull(entity);
        requireNonNull(collection);

        if(collection.isEmpty()) {
            return null;
        } else {
            return Collections.min(collection, (a, b) -> {
                double aDist = a.getPosition().toricDistance(entity.getPosition());
                double bDist = b.getPosition().toricDistance(entity.getPosition());

                if(aDist < bDist) {
                    return -1;
                } else if(aDist > bDist) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
    }
}
