package ch.epfl.moocprog.utils;

import java.util.Objects;

/**
 * Simple classe utilitaire représentant une unité de mesure de temps.
 */
public final class Time implements Comparable<Time> {
    public static final Time ZERO = new Time(0);

    private final long timeInMs;

    // Empêche l'instanciation directe de Time car révellerait
    // la représentation interne de cette classe.
    private Time(long timeInMs) {
        this.timeInMs = timeInMs;
    }

    /**
     * Instancie un nouvel objet de type {@link Time} à partir
     * d'un temps en secondes.
     *
     * @param seconds Le temps en secondes
     * @return Une nouvelle instance de {@link Time} avec la valeur
     *         spécifiée en paramètre.
     */
    public static Time fromSeconds(double seconds) {
        return new Time((long) (seconds * 1000));
    }

    /**
     * Instancie un nouvel objet de type {@link Time} à partir
     * d'un temps en milli-secondes.
     *
     * @param milliseconds Le temps en secondes
     * @return Une nouvelle instance de {@link Time} avec la valeur
     *         spécifiée en paramètre.
     */
    public static Time fromMilliseconds(long milliseconds) {
        return new Time(milliseconds);
    }

    /**
     * Retourne la valeur de cette instance en secondes.
     *
     * @return La valeur de cette instance en secondes
     */
    public double toSeconds() {
        return timeInMs / 1000d;
    }

    /**
     * Retourne la valeur de cette instance en milli-secondes.
     *
     * @return La valeur de cette instance en milli-secondes
     */
    public long toMilliseconds() {
        return timeInMs;
    }

    /**
     * Retourne une nouvelle instance de {@link Time} représentée
     * par l'adition des temps de {@code this} et {@code that}.
     * <br/>
     * Note: {@code this} n'est pas modifié, cette méthode
     * renvoie un nouvel objet !
     *
     * @param that Le temps à aditionner avec {@code this}
     * @return Une nouvelle instance représantant l'adition de
     *         {@code this} et {@code that}
     */
    public Time plus(Time that) {
        return new Time(this.timeInMs + that.timeInMs);
    }

    /**
     * Retourne une nouvelle instance de {@link Time} représentée
     * par la soustraction des temps de {@code this} et {@code that}.
     * <br/>
     * Note: {@code this} n'est pas modifié, cette méthode
     * renvoie un nouvel objet !
     *
     * @param that Le temps à aditionner avec {@code this}
     * @return Une nouvelle instance représantant la soustraction de
     *         {@code this} et {@code that}
     */
    public Time minus(Time that) {
        return new Time(this.timeInMs - that.timeInMs);
    }

    /**
     * Retourne une nouvelle instance de {@link Time} représentée
     * par la multiplication du temps de {@code this} par {@code scalar}.
     * <br/>
     * Note: {@code this} n'est pas modifié, cette méthode
     * renvoie un nouvel objet !
     *
     * @param scalar Le nombre multiplié par la valeur du temps
     * @return Une nouvelle intance représentant la multiplication de
     *         {@code this} et {@code scalar}
     */
    public Time times(double scalar) {
        return new Time((long) (this.timeInMs * scalar));
    }

    /**
     * Indique si le temps répresenté par {@code this} est positif ou nul.
     *
     * @return {@code true} si le temps est positif ou nul, {@code false} sinon
     */
    public boolean isPositive() {
        return timeInMs >= 0;
    }

    /**
     * Compare {@code this} avec {@code that}. Retourne un entier négatif, zéro ou
     * positif si {@code this} est plus petit, égal ou plus grand que {@code that}.
     *
     * @param that L'objet {@link Time} à comparer avec {@code this}
     * @return un entier négatif, zéro ou positif si {@code this} est plus petit,
     *         égal ou plus grand que {@code that}.
     */
    @Override
    public int compareTo(Time that) {
        //On utilise des "if" car il y a un risque que this - that overflow
        if(this.timeInMs < that.timeInMs) {
            return -1;
        } else if(this.timeInMs > that.timeInMs) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Time) {
            Time that = (Time) o;
            return that.timeInMs == this.timeInMs;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeInMs);
    }

    @Override
    public String toString() {
        return timeInMs + " ms";
    }
}
