package ch.epfl.moocprog.app;

import ch.epfl.moocprog.config.ConfigManager;

public final class ApplicationInitializer {

    private ApplicationInitializer() {}

    public static void initializeApplication(ConfigManager configManager) {
        Context.initializeApplication(new Application(configManager));
    }
}
