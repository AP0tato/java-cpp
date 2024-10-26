package com.hello;

import org.bukkit.plugin.java.JavaPlugin;

import com.hello.listener.Listeners;

public class Main extends JavaPlugin{
	private static Main instance;
	
	private static Main instance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
}
