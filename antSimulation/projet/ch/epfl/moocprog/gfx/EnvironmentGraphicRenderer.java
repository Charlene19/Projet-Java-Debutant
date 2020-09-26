package ch.epfl.moocprog.gfx;

import java.util.Map;

import ch.epfl.moocprog.Animal;
import ch.epfl.moocprog.Anthill;
import ch.epfl.moocprog.Food;
import ch.epfl.moocprog.Pheromone;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;

public final class EnvironmentGraphicRenderer extends Parent implements EnvironmentRenderer {
    private final JavaFXAntSimulationCanvas canvas;
    private final AnthillRenderer anthillRenderer;
    private final AnimalsRenderer animalsRenderer;
    private final FoodRenderer foodRenderer;
    private final PheromoneRenderer pheromoneRenderer;
    private final int width;
    private final int height;

    public EnvironmentGraphicRenderer(Map<String,Boolean> debugProps,int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new JavaFXAntSimulationCanvas(debugProps,width, height);
        this.anthillRenderer = new AnthillRenderer();
        this.animalsRenderer = new AnimalsRenderer();
        this.foodRenderer = new FoodRenderer();
        this.pheromoneRenderer = new PheromoneRenderer();

        this.getChildren().add(canvas);
    }


    @Override
    public void clear() {
        canvas.getGraphicsContext2D().clearRect(0, 0, width, height);
    }

    @Override
    public void renderAnimal(Animal animal) {
        animalsRenderer.render(canvas, animal);
    }

    @Override
    public void renderPheromone(Pheromone pheromone) {
        pheromoneRenderer.render(canvas, pheromone);
    }

    @Override
    public void renderAnthill(Anthill anthill) {
        anthillRenderer.render(canvas, anthill);
    }

    @Override
    public void renderFood(Food food) {
        foodRenderer.render(canvas, food);
    }
}
