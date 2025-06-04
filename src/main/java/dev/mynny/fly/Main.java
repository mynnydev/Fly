package dev.mynny.fly;

import dev.mynny.fly.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String NO_PLAYER_MESSAGE = "This command can only be executed by the player!";
    public static String NO_PERMISSION_MESSAGE = "You do not have permission to execute this command!";
    public static String fly_perm_use = "fly.use";

    @Override
    public void onEnable() {
        getLogger().info("Fly Plugin enabled!");
        getLogger().info("Author: Mynny");
        getLogger().info("Discord: http://discord.seasonworld.net");

        this.getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Fly Plugin disabled!");
    }
}
