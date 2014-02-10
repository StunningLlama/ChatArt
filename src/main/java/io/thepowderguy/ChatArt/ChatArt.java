public class ChatArt extends JavaPlugin {

	@Override
	public void onEnable(){
		saveDefaultConfig();
    }

	@Override
	pubic void onDisable(){
		saveConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("channel")){
			if (args.length < 1)
			{
				return false;
			}
		}
		return false;
	}
}
