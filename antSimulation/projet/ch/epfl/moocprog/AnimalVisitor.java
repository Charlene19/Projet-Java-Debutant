package ch.epfl.moocprog;

/**
 * Interface permettant à un RenderingMedia de « visiter »
 * un animal et de déterminer son type dynamique.
 *
 */
public interface AnimalVisitor {
    /**
     * Indique que l'animal visité est un {@link AntWorker}.
     *
     * @param antWorker L'instance de la fourmi ouvrière
     * @param s le support de rendu
     */
    void visit(AntWorker antWorker, RenderingMedia s);

    /**
     * Indique que l'animal visité est un {@link AntSoldier}.
     * Retourne le résultat de la visite de la fourmi soldate.
     *
     * @param antSoldier L'instance de la fourmi soldate
     * @param s le support de rendu
     */
    void visit(AntSoldier antSoldier, RenderingMedia s);

    /**
     * Indique que l'animal visité est un {@link Termite}.
     * Retourne le résultat de la visite de la termite.
     *
     * @param termite L'instance de la termite
     * @param s le support de rendu
     */
    void visit(Termite termite, RenderingMedia s);
}
