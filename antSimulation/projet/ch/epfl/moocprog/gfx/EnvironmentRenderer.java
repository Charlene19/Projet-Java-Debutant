package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.Animal;
import ch.epfl.moocprog.Anthill;
import ch.epfl.moocprog.Food;
import ch.epfl.moocprog.Pheromone;

public interface EnvironmentRenderer {
    void clear();

    void renderAnimal(Animal animal);

    void renderPheromone(Pheromone pheromone);

    void renderAnthill(Anthill anthill);

    void renderFood(Food food);
}
