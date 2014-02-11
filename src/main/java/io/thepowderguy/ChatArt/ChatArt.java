package io.github.thepowderguy.ChatArt;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatArt extends JavaPlugin {

	@Override
	public void onEnable(){
		saveDefaultConfig();
	}

	@Override
	public void onDisable(){
		saveConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("art")){
			if (args.length != 1)
			{
				return false;
			}
			if (getConfig().getStringList("art." + args[0]) != null)
			{
				for (Integer index = 0; index < getConfig().getStringList("art." + args[0]).size();)
				{
					getServer().broadcastMessage(getConfig().getString("prefix") + getConfig().getStringList("art." + args[0]).get(index));
				}
			}
		}
		return false;
	}
}
