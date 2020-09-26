package ch.epfl.moocprog.app;

import ch.epfl.moocprog.config.ConfigManager;

/**
 * Classe contenant la configuration de la simulation
 */
public final class Application {
    private ConfigManager configManager;

    /*package*/
    Application(ConfigManager configManager) {
        assert configManager != null;
        this.configManager = configManager;
    }

    /**
     * Retourne la configuration de la simulation.
     *
     * @return La configuration de la simulation.
     */
    public ConfigManager getConfigManager() {
        return configManager;
    }
    
    public void reload() {
    	configManager = configManager.reload();
    }
}
