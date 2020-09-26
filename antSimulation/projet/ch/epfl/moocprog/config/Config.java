package ch.epfl.moocprog.config;

import ch.epfl.moocprog.utils.Time;
import ch.epfl.moocprog.utils.Pair;

/**
 * Classe contenant toutes les constantes utiles
 * permettant d'obtenir les valeurs de configuration de
 * la simulation
 */
public final class Config {
    private Config() {}

    public static final Pair<String, Class<Integer>> WORLD_WIDTH =
            new Pair<>("WORLD_WIDTH", Integer.class);

    public static final Pair<String, Class<Integer>> WORLD_HEIGHT =
            new Pair<>("WORLD_HEIGHT", Integer.class);

	public static final Pair<String, Class<Double>> TIME_FACTOR =
            new Pair<>("TIME_FACTOR",  Double.class);


    public static final Pair<String, Class<Double>> ANIMAL_LIFESPAN_DECREASE_FACTOR =
            new Pair<>("ANIMAL_LIFESPAN_DECREASE_FACTOR", Double.class);

    public static final Pair<String, Class<Double>> ANIMAL_SIGHT_DISTANCE =
            new Pair<>("ANIMAL_SIGHT_DISTANCE", Double.class);

    public static final Pair<String, Class<Time>> ANIMAL_NEXT_ROTATION_DELAY =
            new Pair<>("ANIMAL_NEXT_ROTATION_DELAY", Time.class);

    public static final Pair<String, Class<Time>> ANTHILL_SPAWN_DELAY =
            new Pair<>("ANTHILL_SPAWN_DELAY", Time.class);

    public static final Pair<String, Class<Double>> ANTHILL_WORKER_PROB_DEFAULT =
            new Pair<>("ANTHILL_WORKER_PROB_DEFAULT", Double.class);

    public static final Pair<String, Class<Double>> ANT_MAX_PERCEPTION_DISTANCE =
            new Pair<>("ANT_MAX_PERCEPTION_DISTANCE", Double.class);

    public static final Pair<String, Class<Double>> PHEROMONE_EVAPORATION_RATE =
            new Pair<>("PHEROMONE_EVAPORATION_RATE", Double.class);

    public static final Pair<String, Class<Double>> PHEROMONE_THRESHOLD =
            new Pair<>("PHEROMONE_THRESHOLD", Double.class);

    public static final Pair<String, Class<Double>> ANT_PHEROMONE_DENSITY =
            new Pair<>("ANT_PHEROMONE_DENSITY", Double.class);

    public static final Pair<String, Class<Double>> ANT_PHEROMONE_ENERGY =
            new Pair<>("ANT_PHEROMONE_ENERGY", Double.class);

    public static final Pair<String, Class<Double>> ANT_SMELL_MAX_DISTANCE =
            new Pair<>("ANT_SMELL_MAX_DISTANCE", Double.class);




    public static final Pair<String, Class<Double>> ANT_MAX_FOOD =
            new Pair<>("ANT_MAX_FOOD", Double.class);

    public static final Pair<String, Class<Integer>> ANT_WORKER_HP =
            new Pair<>("ANT_WORKER_HP", Integer.class);

    public static final Pair<String, Class<Time>> ANT_WORKER_LIFESPAN =
            new Pair<>("ANT_WORKER_LIFESPAN", Time.class);

    public static final Pair<String, Class<Time>> ANT_WORKER_ATTACK_DURATION =
            new Pair<>("ANT_WORKER_ATTACK_DURATION", Time.class);

    public static final Pair<String, Class<Integer>> ANT_WORKER_MIN_STRENGTH =
            new Pair<>("ANT_WORKER_MIN_STRENGTH", Integer.class);

    public static final Pair<String, Class<Integer>> ANT_WORKER_MAX_STRENGTH =
            new Pair<>("ANT_WORKER_MAX_STRENGTH", Integer.class);

    public static final Pair<String, Class<Double>> ANT_WORKER_SPEED =
            new Pair<>("ANT_WORKER_SPEED", Double.class);





    public static final Pair<String, Class<Integer>> ANT_SOLDIER_HP =
            new Pair<>("ANT_SOLDIER_HP", Integer.class);

    public static final Pair<String, Class<Time>> ANT_SOLDIER_LIFESPAN =
            new Pair<>("ANT_SOLDIER_LIFESPAN", Time.class);

    public static final Pair<String, Class<Time>> ANT_SOLDIER_ATTACK_DURATION =
            new Pair<>("ANT_SOLDIER_ATTACK_DURATION", Time.class);

    public static final Pair<String, Class<Integer>> ANT_SOLDIER_MIN_STRENGTH =
            new Pair<>("ANT_SOLDIER_MIN_STRENGTH", Integer.class);

    public static final Pair<String, Class<Integer>> ANT_SOLDIER_MAX_STRENGTH =
            new Pair<>("ANT_SOLDIER_MAX_STRENGTH", Integer.class);

    public static final Pair<String, Class<Double>> ANT_SOLDIER_SPEED =
            new Pair<>("ANT_SOLDIER_SPEED", Double.class);



    public static final Pair<String, Class<Time>> FOOD_GENERATOR_DELAY =
            new Pair<>("FOOD_GENERATOR_DELAY", Time.class);

    public static final Pair<String, Class<Double>> NEW_FOOD_QUANTITY_MIN =
            new Pair<>("NEW_FOOD_QUANTITY_MIN", Double.class);

    public static final Pair<String, Class<Double>> NEW_FOOD_QUANTITY_MAX =
            new Pair<>("NEW_FOOD_QUANTITY_MAX", Double.class);





    public static final Pair<String, Class<Integer>> TERMITE_HP =
            new Pair<>("TERMITE_HP", Integer.class);

    public static final Pair<String, Class<Time>> TERMITE_LIFESPAN =
            new Pair<>("TERMITE_LIFESPAN", Time.class);

    public static final Pair<String, Class<Integer>> TERMITE_MIN_STRENGTH =
            new Pair<>("TERMITE_MIN_STRENGTH", Integer.class);

    public static final Pair<String, Class<Integer>> TERMITE_MAX_STRENGTH =
            new Pair<>("TERMITE_MAX_STRENGTH", Integer.class);

    public static final Pair<String, Class<Double>> TERMITE_SPEED =
            new Pair<>("TERMITE_SPEED", Double.class);

    public static final Pair<String, Class<Time>> TERMITE_ATTACK_DURATION =
            new Pair<>("TERMITE_ATTACK_DURATION", Time.class);




    public static final Pair<String, Class<Double>> BETA_D =
            new Pair<>("BETA_D", Double.class);

    public static final Pair<String, Class<Double>> Q_ZERO =
            new Pair<>("Q_ZERO", Double.class);

    public static final Pair<String, Class<Integer>> ALPHA =
            new Pair<>("ALPHA", Integer.class);
}
