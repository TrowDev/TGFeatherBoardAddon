package me.trow.tgfba;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;

public class HookTrabalho {

	private static boolean using = false,usingTGJob;

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
		}if (Bukkit.getPluginManager().getPlugin("TGTrabalho") != null) {
			b.sendMessage("§3[TGTrabalho] §bEncontrado! Hook habilitado.");
			usingTGJob = true;
		} else {
			b.sendMessage("§4[TGTrabalho] §cNao Encontrado! Hook desabilitado.");
		}
		board();
	}

	public static void board() {
		if (using && usingTGJob) {
			new BukkitRunnable() {
				public void run() {
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgtrabalho:trabalho",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									return me.trow.tgtrabalho.Main.pl.getPD(e.getPlayer().getName()).getJob().getJob();
								}
							});
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgtrabalho:progresso",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									return me.trow.tgtrabalho.Main.pl.getPD(e.getPlayer().getName()).getQntAtual()+"";
								}
							});
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgtrabalho:necessario",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									return me.trow.tgtrabalho.Main.pl.getPD(e.getPlayer().getName()).getJob().getQntNecessaria()+"";
								}
							});
				}
			}.runTaskTimer(Main.pl, 20L, 20L*60);
		}
	}
	
}
