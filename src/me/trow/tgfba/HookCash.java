package me.trow.tgfba;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;

public class HookCash {

	private static boolean using = false,usingTGCash;

	public static void hooks() {
		hook();
	}

	public static void hook() {
		ConsoleCommandSender b = Bukkit.getConsoleSender();
		if (Bukkit.getPluginManager().getPlugin("MVdWPlaceholderAPI") != null) {
			b.sendMessage("§3[FeatherBoard] §bEncontrado! Hook habilitado.");
			using = true;
		} else {
			b.sendMessage("§4[FeatherBoard] §cNao Encontrado! Hook desabilitado.");
		}if (Bukkit.getPluginManager().getPlugin("TGCash") != null) {
			b.sendMessage("§3[TGCash] §bEncontrado! Hook habilitado.");
			usingTGCash = true;
		} else {
			b.sendMessage("§4[TGCash] §cNao Encontrado! Hook desabilitado.");
		}
		board();
	}

	public static void board() {
		if (using && usingTGCash) {
			new BukkitRunnable() {
				public void run() {
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgcash:cash",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									return me.trow.tgcash.Main.pl.getMoney(e.getPlayer().getName())+"";
								}
							});
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgcash:top",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									if(me.trow.tgcash.Main.pl.getMagnatas(1)==null) return "";
									return me.trow.tgcash.Main.pl.getMagnatas(1).get(0);
								}
							});
				}
			}.runTaskTimer(Main.pl, 20L, 20L*60);
		}
	}
	
}
