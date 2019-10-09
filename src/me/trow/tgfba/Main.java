package me.trow.tgfba;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main pl;
	
	public void onEnable(){
		ConsoleCommandSender b = Bukkit.getConsoleSender();
		saveDefaultConfig();
		pl = this;
		b.sendMessage("§6=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		b.sendMessage("§3[TGFeatherBoard-Addon] §bAtivado...");
		b.sendMessage("§3Criador: §bTrow");
		b.sendMessage("§bAgradeco por usar meu(s) plugin(s)");
		b.sendMessage("§6=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		HookCash.hooks();
		HookTrabalho.hooks();
		HookTGRankUP.hooks();
	}
	
	public void onDisable(){
		ConsoleCommandSender b = Bukkit.getConsoleSender();
		b.sendMessage("§6=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		b.sendMessage("§3[TGFeatherBoard-Addon] §bDesativado...");
		b.sendMessage("§3Criador: §bTrow");
		b.sendMessage("§bAgradeco por usar meu(s) plugin(s)");
		b.sendMessage("§6=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
	
}
