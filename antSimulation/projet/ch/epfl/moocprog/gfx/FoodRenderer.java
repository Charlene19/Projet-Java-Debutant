package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.Food;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import static ch.epfl.moocprog.gfx.GFXUtil.loadSprite;

class FoodRenderer implements SimpleEntitySpriteRenderer<Food> {
    private static final double SIZE_X = 40;
    private static final double SIZE_Y = 40;
    private final Image sprite;

    FoodRenderer() {
        sprite = loadSprite(GFXUtil.RES_PATH+"food.png");
    }

    @Override
    public void render(JavaFXAntSimulationCanvas canvas, Food entity) {
    	displayEntityInfo(canvas, entity);
        drawSingleSprite(canvas, entity);
    }

    @Override
    public double getWidth(Food entity) {
        return SIZE_X;
    }

    @Override
    public double getHeight(Food entity) {
        return SIZE_Y;
    }

    @Override
    public double getDirection(Food entity) {
        return entity.hashCode();
    }

    @Override
    public Image getSprite(Food entity) {
        return sprite;
    }
}
