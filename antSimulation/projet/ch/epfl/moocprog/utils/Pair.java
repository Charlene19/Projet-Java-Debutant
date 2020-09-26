package ch.epfl.moocprog.utils;

import java.util.Objects;

/**
 * Une simple classe représentant une paire d'objet
 *
 * @param <F> Le type du premier objet
 * @param <S> Le type du second objet
 */
public final class Pair<F, S> {
    public final F first;
    public final S second;

    /**
     * Construit une nouvelle instance de {@link Pair }
     * avec les paramètres donnés.
     *
     * @param first Le premier objet de la paire
     * @param second Le second objet de la paire
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Pair) {
            Pair that = (Pair) o;
            return this.first.equals(that.first)
                    && this.second.equals(that.second);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
