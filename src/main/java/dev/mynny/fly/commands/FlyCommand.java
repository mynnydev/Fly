package dev.mynny.fly.commands;

import dev.mynny.fly.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Main.fly_perm_use)) {
                boolean newFlyState = !player.getAllowFlight();
                player.setAllowFlight(newFlyState);
                player.setFlying(newFlyState);
                player.sendMessage(newFlyState ? ChatColor.of("#7afc00") + "Fly enabled △" : ChatColor.of("#fc0000") + "Fly disabled ▽");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1, 1);
            } else {
                player.sendMessage(ChatColor.of("#fc0000") + Main.NO_PERMISSION_MESSAGE);
            }
        } else {
            sender.sendMessage(ChatColor.of("#fc0000") + Main.NO_PLAYER_MESSAGE);
        }
        return false;
    }
}
