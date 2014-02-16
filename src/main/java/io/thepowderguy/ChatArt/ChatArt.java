package io.github.thepowderguy.ChatArt;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatArt extends JavaPlugin {

	@Override
	public void onEnable(){
		this.getCommand("art").setTabCompleter(this);
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

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) 
	{
		List<String> toreturn = new ArrayList<String>();
		toreturn.clear();
		if (command.getName().equalsIgnoreCase("art"))
		{
			if (args.length == 1)
			{
				toreturn.addAll(this.getConfig().getConfigurationSection("art").getKeys(false));
			}
			for (int ind = 0; ind < toreturn.size();)
			{
				if (!toreturn.get(ind).toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
				{
					toreturn.remove(ind);
				}
				else
				{
					ind++;
				}
			}
		}
		return toreturn;
	}
}
