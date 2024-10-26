package com.nextlevel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import com.nextlevel.listener.CheckDeath;

@SuppressWarnings("unused")
public class Main extends JavaPlugin
{
	private static Main instance;
	
	public static Main getInstance() 
	{
		return instance;
	}
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		this.getCommand("setlocation").setExecutor(new CheckDeath());
		this.getCommand("getlocation").setExecutor(new CheckDeath());
		getServer().getPluginManager().registerEvents(new CheckDeath(), this);
	}
	
	@Override
	public void onDisable()
	{
		instance = null;
	}
}
