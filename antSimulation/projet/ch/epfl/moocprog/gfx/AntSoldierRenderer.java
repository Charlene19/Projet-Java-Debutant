package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.AntSoldier;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import static ch.epfl.moocprog.gfx.GFXUtil.loadSprite;

final class AntSoldierRenderer implements SimpleEntitySpriteRenderer<AntSoldier> {
    private static final double SIZE_X = 50;
    private static final double SIZE_Y = 50;
    private final Image sprite;

    AntSoldierRenderer() {
        sprite = loadSprite(GFXUtil.RES_PATH+"fourmi_rouge.png");
    }

    @Override
    public void render(JavaFXAntSimulationCanvas canvas, AntSoldier entity) {
    	displayEntityInfo(canvas, entity);
        drawSingleSprite(canvas, entity);
    }

    @Override
    public double getWidth(AntSoldier entity) {
        return SIZE_X;
    }

    @Override
    public double getHeight(AntSoldier entity) {
        return SIZE_Y;
    }

    @Override
    public double getDirection(AntSoldier entity) {
        return entity.getDirection();
    }

    @Override
    public Image getSprite(AntSoldier entity) {
        return sprite;
    }
}
