package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.Pheromone;
import ch.epfl.moocprog.app.Context;
import ch.epfl.moocprog.config.Config;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Affine;

class PheromoneRenderer implements EntityRenderer<Pheromone> {
    private static final double SIZE_X = 12;
    private static final double SIZE_Y = 12;
    private static final Color BASE_COLOR = Color.GREENYELLOW;

    @Override
    public void render(JavaFXAntSimulationCanvas canvas, Pheromone entity) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Paint oldPaint = gc.getFill();
        Affine oldTransform = gc.getTransform();
        Affine newTransform = gc.getTransform();
        newTransform.prepend(getTransformation(entity));

        gc.setTransform(newTransform);
        gc.setFill(getColor(entity.getQuantity()));
        gc.fillOval(0, 0, getWidth(entity), getHeight(entity));

        gc.setFill(oldPaint);
        gc.setTransform(oldTransform);
    }

    @Override
    public double getWidth(Pheromone entity) {
        return SIZE_X;
    }

    @Override
    public double getHeight(Pheromone entity) {
        return SIZE_Y;
    }

    @Override
    public double getDirection(Pheromone entity) {
        return 0;
    }

    private static Color getColor(double pheromoneEnergy) {
        double pheromoneMaxEnergy = Context
            .getApplication()
            .getConfigManager()
            .getDouble(Config.ANT_PHEROMONE_ENERGY);

        double ratio = Math.min(pheromoneEnergy/pheromoneMaxEnergy, 1d);

        return new Color(
            BASE_COLOR.getRed(),
            BASE_COLOR.getGreen(),
            BASE_COLOR.getBlue(),
            ratio
        );
    }
}
