package io.github.thepowderguy.ChatArt;

import java.util.List;
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
				List<String> artlist = getConfig().getStringList("art." + args[0]);
				for (int index = 0; index < artlist.size(); index++)
				{
					getServer().broadcastMessage(getConfig().getString("prefix") + artlist.get(index));
				}
				return true;
			}
		}
		return false;
	}
}
