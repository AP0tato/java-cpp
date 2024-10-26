package com.nextlevel.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class CheckDeath implements Listener, CommandExecutor
{
	static Location location = new Location(null, 0, 0, 0);
	Location temp;
	ArrayList<Location> deathLocations = new ArrayList<Location>();
	ArrayList<String> players = new ArrayList<String>();
	
	@EventHandler
	public boolean returnToDeathPoint(Player p)
	{
		if(p.isDead())
		{
			p.setBedSpawnLocation(location);
			if(players.size() < 1)
			{
				players.add(p.getName());
			}
			else
			{
				for(int i = 0; i < players.size(); i++)
				{
					if(p.getName() != players.get(i))
					{
						players.add(p.getName());
					}
					else
					{
						deathLocations.add(p.getLocation());
					}
				}
			}
			p.teleport(location);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(command.getName().equalsIgnoreCase("setlocation"))
		{
			if(args.length == 0)
			{
				temp = new Location(null, 0, 65, 0);
				location = temp;
			} 
			else if(args.length == 1)
			{
				temp = new Location(null, Integer.parseInt(args[0]), 65, 0);
				location = temp;
			}
			else if(args.length == 2)
			{
				temp = new Location(null, Integer.parseInt(args[0]), Integer.parseInt(args[1]), 0);
				location = temp;
			}
			else if(args.length == 3)
			{
				temp = new Location(null, Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				location = temp;
			}
			else if(args.length > 3)
			{
				sender.sendMessage("Too many arguments");
			}
			sender.sendMessage("Location set to " + location.getX() + " " + location.getY() + " " + location.getZ());
			return true;
		}
		else if(command.getName().equalsIgnoreCase("getlocation"))
		{
			sender.sendMessage("Location is " + location.getX() + " " + location.getY() + " " + location.getZ());
			return true;
		}
		else
		{
			return false;
		}
	}
}
