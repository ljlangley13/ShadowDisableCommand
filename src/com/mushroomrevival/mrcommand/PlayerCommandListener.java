package com.mushroomrevival.mrcommand;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandListener implements Listener {
	public static MRCommand plugin;
	public static List<String> admins = new LinkedList<String>();

	public PlayerCommandListener(MRCommand instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler
	public void onCommandPostProcess(PlayerCommandPreprocessEvent event) {
		readAdmins();
		Player player = (Player) event.getPlayer();
		String message = event.getMessage();
		if ((admins.contains(player.getName()))) {
		} else {
			if (message.startsWith(plugin.getConfig().getString("CommandOne")) || message.startsWith(plugin.getConfig().getString("CommandTwo")) || message.startsWith(plugin.getConfig().getString("CommandThree")) || message.startsWith(plugin.getConfig().getString("CommandFour")) || message.startsWith(plugin.getConfig().getString("CommandFive")) || message.startsWith(plugin.getConfig().getString("CommandSix")) || message.startsWith(plugin.getConfig().getString("CommandSeven")) || message.startsWith(plugin.getConfig().getString("CommandEight")) || message.startsWith(plugin.getConfig().getString("CommandNine")) || message.startsWith(plugin.getConfig().getString("CommandTen")) || message.startsWith(plugin.getConfig().getString("CommandEleven")) || message.startsWith(plugin.getConfig().getString("CommandTwelve")) || message.startsWith(plugin.getConfig().getString("CommandThirteen")) || message.startsWith(plugin.getConfig().getString("CommandFourteen")) || message.startsWith(plugin.getConfig().getString("CommandFifteen")) || message.startsWith(plugin.getConfig().getString("CommandSixteen")) || message.startsWith(plugin.getConfig().getString("CommandSeventeen")) || message.startsWith(plugin.getConfig().getString("CommandEighteen")) || message.startsWith(plugin.getConfig().getString("CommandNineteen")) || message.startsWith(plugin.getConfig().getString("CommandTwenty"))) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.WHITE
						+ "Unknown command. Type \"/help\" for help.");
			}
		}
	}
	public void readAdmins() {
		try {
			File file = new File("plugins/MRCommand/admins.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String string = scanner.nextLine();
				admins.add(string);
			}
			scanner.close();
		} catch (Exception exception) {

		}

	}

}
