package me.trow.tgfba;

import me.trow.tgrankup.RankPlayer;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;

public class HookTGRankUP {

	private static boolean using = false,usingTGRankUP;

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
		}
		if (Bukkit.getPluginManager().getPlugin("TGRankUP") != null) {
			b.sendMessage("§3[TGRankUP] §bEncontrado! Hook habilitado.");
			usingTGRankUP = true;
		} else {
			b.sendMessage("§4[TGRankUP] §cNao Encontrado! Hook desabilitado.");
		}
		board();
	}

	public static void board() {
		if (using && usingTGRankUP) {
			new BukkitRunnable() {
				public void run() {
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgrankup:rank",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									return me.trow.tgrankup.Main.pl.getRankPlayer(e.getPlayer().getName()).getRank();
								}
							});
					PlaceholderAPI.registerPlaceholder(
							Main.pl, "tgrankup:tag",
							new PlaceholderReplacer() {
								public String onPlaceholderReplace(
										PlaceholderReplaceEvent e) {
									RankPlayer rp = me.trow.tgrankup.Main.pl.getRankPlayer(e.getPlayer().getName());
									if(rp.getRank().equals("")||rp.getRank().length()==0) return "";
									String tag = me.trow.tgrankup.Main.pl.getMsg("Ranks."+rp.getRank()+".Tag");
									return tag;
								}
							});
				}
			}.runTaskTimer(Main.pl, 20L, 20L*60);
		}
	}
	
}
