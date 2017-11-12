package de.apoehlmann.gps.configuration;

/**
 * Created by apoehlmann on 05.11.17.
 */

public enum GpsModus {
    WALK(new Configuration(3000, 50)),
    RUN(new Configuration(1500, 25)),
    BIKE(new Configuration(1000, 50)),
    CAR(new Configuration(700, 100)),
    TRAIN_SLOW(new Configuration(700, 300)),
    TRAIN_FAST(new Configuration(500, 500));

    private final Configuration mConfiguration;

    GpsModus(Configuration configuration) {
        mConfiguration = configuration;
    }

    public Configuration getConfiguration() {
        return mConfiguration;
    }
}
