package ch.epfl.moocprog.config;

import ch.epfl.moocprog.utils.Time;
import ch.epfl.moocprog.utils.Utils;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe utilitaire permettant d'extraire
 * des informations sur la simulation
 * à partir d'un fichier
 */
class ConfigReader {
    private final Map<String, Double> doubleConfig;
    private final Map<String, Integer> intConfig;
    private final Map<String, Time> timeConfig;

    ConfigReader(File file) {
        Utils.requireNonNull(file);

        Map<String, Integer> tmpIntConfig = new HashMap<>();
        Map<String, Double> tmpDoubleConfig = new HashMap<>();
        Map<String, Time> tmpTimeConfig = new HashMap<>();

        try(BufferedReader is = new BufferedReader(new FileReader(file)))
        {
            String read;
            while((read = is.readLine()) != null) {
                if(read.trim().isEmpty()) {
                    continue;
                }
                Matcher configMatcher = Pattern.compile(
                        "(?<key>\\w+):(?<type>\\w+):(?<value>.*)"
                ).matcher(read);

                if(!configMatcher.matches()) {
                    throw new IllegalArgumentException();
                }

                String key = configMatcher.group("key");
                String type = configMatcher.group("type");
                String value = configMatcher.group("value");

                assert !key.isEmpty();

                switch (type) {
                    case "int":
                        try {
                            int valueAsInt = Integer.parseInt(value);
                            tmpIntConfig.put(key, valueAsInt);
                        } catch (NumberFormatException nfe) {
                            throw new IllegalArgumentException();
                        }
                        break;

                    case "double":
                        try {
                            double valueAsDouble = Double.parseDouble(value);
                            tmpDoubleConfig.put(key, valueAsDouble);
                        } catch (NumberFormatException nfe) {
                            throw new IllegalArgumentException();
                        }
                        break;

                    case "time":
                        Matcher timeMatcher = Pattern.compile(
                                "(?<floatingPoint>(\\d+\\.\\d*)|(\\d*\\.\\d+)|(\\d+))"+
                                        "(?<unit>s|ms|$)"
                        ).matcher(value);

                        if(timeMatcher.matches()) {
                            double timeValue = Double.parseDouble(timeMatcher.group("floatingPoint"));
                            String unit = timeMatcher.group("unit");

                            switch (unit) {
                                case "ms":
                                    tmpTimeConfig.put(
                                            key,
                                            //On perd p-ê de la précision, mais c'est ok...
                                            Time.fromMilliseconds((long)timeValue)
                                    );
                                    break;

                                case "s":
                                    //On laisser "couler"

                                case "":
                                    tmpTimeConfig.put(
                                            key,
                                            Time.fromSeconds(timeValue)
                                    );
                                    break;

                                default:
                                    throw new IllegalArgumentException();
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }

                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }

        //Pas besoin de copier les collections, seulement les wrapper pour
        //éviter de les modifier accidentellement...
        this.doubleConfig = Collections.unmodifiableMap(tmpDoubleConfig);
        this.intConfig = Collections.unmodifiableMap(tmpIntConfig);
        this.timeConfig = Collections.unmodifiableMap(tmpTimeConfig);
    }

    /**
     * Retourne la configuration des {@code double} qui a été
     * lue depuis le fichier sous forme de {@link Map} non-modifiable.
     *
     * @return La configuration concernant les {@code double}
     *         sous la forme de {@link Map} non-modifiable.
     */
    Map<String, Double> getDoubleConfig() {
        return doubleConfig;
    }

    /**
     * Retourne la configuration des {@code int} qui a été
     * lue depuis le fichier sous forme de {@link Map} non-modifiable.
     *
     * @return La configuration concernant les {@code int}
     *         sous la forme de {@link Map} non-modifiable.
     */
    Map<String, Integer> getIntConfig() {
        return intConfig;
    }

    /**
     * Retourne la configuration des {@link Time} qui a été
     * lue depuis le fichier sous forme de {@link Map} non-modifiable.
     *
     * @return La configuration concernant les {@link Time}
     *         sous la forme de {@link Map} non-modifiable.
     */
    Map<String, Time> getTimeConfig() {
        return timeConfig;
    }
}
