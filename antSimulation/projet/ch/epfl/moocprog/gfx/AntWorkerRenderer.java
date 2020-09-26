package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.AntWorker;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import static ch.epfl.moocprog.gfx.GFXUtil.loadSprite;

final class AntWorkerRenderer implements SimpleEntitySpriteRenderer<AntWorker> {
    private static final double SIZE_X = 50;
    private static final double SIZE_Y = 50;
    private final Image sprite;

    AntWorkerRenderer() {
        sprite = loadSprite(GFXUtil.RES_PATH+"fourmi_noire.png");
    }

    @Override
    public void render(JavaFXAntSimulationCanvas canvas, AntWorker entity) {
    	displayEntityInfo(canvas, entity);
        drawSingleSprite(canvas, entity);
    }

    @Override
    public double getWidth(AntWorker entity) {
        return SIZE_X;
    }

    @Override
    public double getHeight(AntWorker entity) {
        return SIZE_Y;
    }

    @Override
    public double getDirection(AntWorker entity) {
        return entity.getDirection();
    }

    @Override
    public Image getSprite(AntWorker entity) {
        return sprite;
    }
}
