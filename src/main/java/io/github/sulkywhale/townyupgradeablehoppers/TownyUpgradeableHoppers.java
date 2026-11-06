package io.github.sulkywhale.townyupgradeablehoppers;

import org.bukkit.plugin.java.JavaPlugin;

public class TownyUpgradeableHoppers extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new UpgradeableHoppersListener(), this);
        getLogger().info("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled.");
    }
}
