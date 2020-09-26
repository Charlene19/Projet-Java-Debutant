package ch.epfl.moocprog.config;

import ch.epfl.moocprog.utils.Time;
import ch.epfl.moocprog.utils.Pair;

import java.util.Map;

/**
 * Interface représentant la configuration de la simulation.
 */
public interface ConfigManager {
	
	ConfigManager reload();

    /**
     * Renvoie la valeur associé au paramètre donnée
     * @param paramName La constante dont on souhaite obtenir
     *                  la valeur à laquelle elle a été
     *                  associée
     * @return La valeur associé au paramètre donné
     */
    double getDouble(Pair<String, Class<Double>> paramName);

    /**
     * Renvoie la valeur associé au paramètre donnée
     * @param paramName La constante dont on souhaite obtenir
     *                  la valeur à laquelle elle a été
     *                  associée
     * @return La valeur associé au paramètre donné
     */
    int getInt(Pair<String, Class<Integer>> paramName);

    /**
     * Renvoie la valeur associé au paramètre donnée
     * @param paramName La constante dont on souhaite obtenir
     *                  la valeur à laquelle elle a été
     *                  associée
     * @return La valeur associé au paramètre donné
     */
    Time getTime(Pair<String, Class<Time>> paramName);

    /**
     * Renvoie la configuration concernant les {@code double}
     * sous forme de {@link Map}.
     *
     * @return La configuration concernant les {@code double}
     */
    Map<String, Double> getDoubleConfig();

    /**
     * Renvoie la configuration concernant les {@code int}
     * sous forme de {@link Map}.
     *
     * @return La configuration concernant les {@code int}
     */
    Map<String, Integer> getIntConfig();

    /**
     * Renvoie la configuration concernant les temps
     * sous forme de {@link Map}.
     *
     * @return La configuration concernant les temps
     */
    Map<String, Time> getTimeConfig();
}
