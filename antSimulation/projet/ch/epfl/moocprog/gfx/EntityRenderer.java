package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.Positionable;
import ch.epfl.moocprog.utils.Vec2d;
import javafx.scene.canvas.Canvas;
import javafx.scene.transform.Affine;

interface EntityRenderer<T extends Positionable> {
    void render(JavaFXAntSimulationCanvas canvas, T entity);

    double getWidth(T entity);

    double getHeight(T entity);

    double getDirection(T entity);

    default Affine getTransformation(T entity) {
        Vec2d entityPos = entity.getPosition().toVec2d();
        double direction = getDirection(entity);

        Affine result = new Affine();

        // Oui, c'est bien la taille de l'entité que l'on prend
        // pas la taille de son sprite !
        double w = getWidth(entity);
        double h = getHeight(entity);
        // D'abord, on place l'entité de telle sorte que
        // le milieu de l'image correspondent à l'origine
        result.prependTranslation(-w/2, -h/2);
        // Simple rotation
        result.prependRotation(Math.toDegrees(direction));
        // Ensuite, on déplace l'entité à sa position.
        // Notons qu'on ne rajoute pas le w/2 et h/2 qu'on a retiré auparavant
        result.prependTranslation(entityPos.getX(), entityPos.getY());

        return result;
    }
}
