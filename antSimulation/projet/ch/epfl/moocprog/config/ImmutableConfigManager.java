package ch.epfl.moocprog.config;

import ch.epfl.moocprog.utils.Time;
import ch.epfl.moocprog.utils.Pair;
import ch.epfl.moocprog.utils.Utils;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe concrète contenant la configuration de la simulation.
 */
public final class ImmutableConfigManager implements ConfigManager {
    private final Map<String, Double> doubleConfig;
    private final Map<String, Integer> intConfig;
    private final Map<String, Time> timeConfig;
    private final File configFile;

    /**
     * Construit une nouvelle instance de cette classe à partir
     * des {@link Map} passés en paramètres.
     *
     * @param doubleConfig La configuration des valeurs du types {@code double}
     * @param intConfig La configuration des valeurs du types {@code int}
     * @param timeConfig La configuration des valeurs du types {@link Time}
     */
    public ImmutableConfigManager(Map<String, Double> doubleConfig,
                                  Map<String, Integer> intConfig,
                                  Map<String, Time> timeConfig)
    {
        Utils.requireNonNull(doubleConfig);
        Utils.requireNonNull(intConfig);
        Utils.requireNonNull(timeConfig);
        configFile = null;

        this.doubleConfig = Collections.unmodifiableMap(new HashMap<>(doubleConfig));
        this.intConfig = Collections.unmodifiableMap(new HashMap<>(intConfig));
        this.timeConfig = Collections.unmodifiableMap(new HashMap<>(timeConfig));
    }

    /**
     * Construit une instance de cette classe à partir
     * du fichier passé en paramètre.
     *
     * @param file Le fichier de configuration de la simulation
     */
    public ImmutableConfigManager(File file) {
        Utils.requireNonNull(file);
        configFile = file;
        ConfigReader configReader = new ConfigReader(file);

        //ici on utilise le fait que configReader retourne des config immuables
        this.doubleConfig = configReader.getDoubleConfig();
        this.intConfig = configReader.getIntConfig();
        this.timeConfig = configReader.getTimeConfig();
    }

    /**
     * Construit une instance de cette classe à partir
     * du fichier passé en paramètre.
     *
     * @param file Le fichier de configuration de la simulation
     */
    public ImmutableConfigManager reload() {
       
        return new ImmutableConfigManager(configFile);

    }
    @Override
    public double getDouble(Pair<String, Class<Double>> paramName) {
        return doubleConfig.get(paramName.first);
    }

    @Override
    public int getInt(Pair<String, Class<Integer>> paramName) {
        return intConfig.get(paramName.first);
    }

    @Override
    public Time getTime(Pair<String, Class<Time>> paramName) {
        return timeConfig.get(paramName.first);
    }

    @Override
    public Map<String, Double> getDoubleConfig() {
        return doubleConfig;
    }

    @Override
    public Map<String, Integer> getIntConfig() {
        return intConfig;
    }

    @Override
    public Map<String, Time> getTimeConfig() {
        return timeConfig;
    }
}
