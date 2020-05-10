package com.questcave.code.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.questcave.code.Utils;

public class ChooseQuestGUI {
	public ChooseQuestGUI (Player player) {

		//Black Glass
		ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName(" ");
		glass.setItemMeta(glassMeta);
		
		//Easy Quest
		ItemStack easy = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		ItemMeta eMeta = easy.getItemMeta();
		
		eMeta.setDisplayName(ChatColor.GREEN + "Click here to take an easy quest!");
		easy.setItemMeta(eMeta);
		
		//Medium Quest
		ItemStack medium = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		ItemMeta mMeta = medium.getItemMeta();
		mMeta.setDisplayName(ChatColor.YELLOW + "Click here to take a medium quest!");
		medium.setItemMeta(mMeta);
		
		//Hard Quest
		ItemStack hard = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		ItemMeta hMeta = hard.getItemMeta();
		hMeta.setDisplayName(ChatColor.RED + "Click here to take a hard quest!");
		hard.setItemMeta(hMeta);
		
		Inventory gui = Bukkit.createInventory(null, 45 , Utils.Color("&7Quests"));

		for (int i = 0;i < gui.getSize();i++) {
				gui.setItem(i, glass);
				if (i == 20) {
					gui.setItem(i, easy);
				}
				if (i == 22) {
					gui.setItem(i, medium);
				}
				if (i == 24) {
					gui.setItem(i, hard);
				}
		}
		player.openInventory(gui);
	}
}
