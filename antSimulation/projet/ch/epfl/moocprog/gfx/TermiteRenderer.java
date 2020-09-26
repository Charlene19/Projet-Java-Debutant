package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.Termite;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import static ch.epfl.moocprog.gfx.GFXUtil.loadSprite;

class TermiteRenderer implements SimpleEntitySpriteRenderer<Termite> {
    private static final double SIZE_X = 50;
    private static final double SIZE_Y = 50;
    private final Image sprite;

    TermiteRenderer() {
        sprite = loadSprite(GFXUtil.RES_PATH+"termite.png");
    }

    @Override
    public void render(JavaFXAntSimulationCanvas canvas, Termite entity) {
    	displayEntityInfo(canvas, entity);
        drawSingleSprite(canvas, entity);
    }

    @Override
    public double getWidth(Termite entity) {
        return SIZE_X;
    }

    @Override
    public double getHeight(Termite entity) {
        return SIZE_Y;
    }

    @Override
    public double getDirection(Termite entity) {
        return entity.getDirection();
    }

    @Override
    public Image getSprite(Termite entity) {
        return sprite;
    }
}
