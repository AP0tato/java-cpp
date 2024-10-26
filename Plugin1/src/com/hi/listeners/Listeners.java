package com.hi.listeners;

import java.util.*;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.*;

@SuppressWarnings("unused")
public class Listeners implements Listener{
	ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
	ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
	ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
	ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
	ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
	ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
	ItemStack bow = new ItemStack(Material.BOW);
	int random;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent event) 
	{
		if(event.getEntityType() == EntityType.CREEPER) 
		{
			random = (int) Math.floor(Math.random() * 101);
			Creeper creeper = (Creeper) event.getEntity();
			if(random < 90) 
			{
				creeper.setPowered(true);
			}
		}
		
		if(event.getEntityType() == EntityType.SPIDER) 
		{
			Spider spider = (Spider) event.getEntity();
			spider.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 2));
			spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
			spider.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));	
		}
		
		if(event.getEntityType() == EntityType.ZOMBIE) 
		{
			Zombie zombie = (Zombie) event.getEntity();
			zombie.getEquipment().setHelmet(helmet);
			zombie.getEquipment().setChestplate(chestplate);
			zombie.getEquipment().setLeggings(leggings);
			zombie.getEquipment().setBoots(boots);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			zombie.setBaby(true);
			random = (int) Math.floor(Math.random() * 101);
			if(random < 90) 
			{
				zombie.getEquipment().setItemInMainHand(axe);
				axe.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			} 
			else if(random >= 90) 
			{
				zombie.getEquipment().setItemInMainHand(sword);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
				sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
			}
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 2));
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
		}
		
		if(event.getEntityType() == EntityType.SKELETON) 
		{
			Skeleton skeleton = (Skeleton) event.getEntity();
			skeleton.getEquipment().setHelmet(helmet);
			skeleton.getEquipment().setChestplate(chestplate);
			skeleton.getEquipment().setLeggings(leggings);
			skeleton.getEquipment().setBoots(boots);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			skeleton.getEquipment().setItemInMainHand(bow);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
			bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		}
	}
}
