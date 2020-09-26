package ch.epfl.moocprog;

import java.util.Objects;

/**
 * Simple classe représentant un identifieur unique
 */
public final class Uid {
    private static long counter = 0;
    private final long id;

    // Empêche l'instanciation directe de Uid car révellerait
    // la représentation interne de cette classe.
    private Uid(long id) {
        this.id = id;
    }

    /**
     * Crée un nouveau identifiant unique.
     *
     * @return Un nouveau identifiant unique
     */
    public static Uid createUid() {
        return new Uid(counter++);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Uid) {
            Uid that = (Uid) o;
            return that.id == this.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
