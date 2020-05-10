package com.questcave.code.Events;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.questcave.code.Main;
import com.questcave.code.Quest;
import com.questcave.code.Utils;
import com.questcave.code.Configs.Easy;
import com.questcave.code.Configs.Hard;
import com.questcave.code.Configs.Medium;
import com.questcave.code.Enums.Error;
import com.questcave.code.Goals.Goal;

public class GUIClickEvent implements Listener {
	@EventHandler
	public void onGUIClickEvent(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(Utils.Color("&7Quests"))) {
			e.setCancelled(true);
			if (e.getClickedInventory().equals(e.getView().getTopInventory())) {
				Player player = (Player) e.getWhoClicked();
				int slot = e.getSlot();
				if (slot != 20 && slot != 22 && slot != 24) {return;}
				if (!Main.takenQuests.containsKey(player.getUniqueId())) {
					ArrayList<Quest> quests = null;
					if (slot == 20) {
						quests = Easy.getQuests();
					}
					
					if (slot == 22) {
						quests = Medium.getQuests();
					}
					
					if (slot == 24) {
						quests = Hard.getQuests();
					}
					
					if (quests.isEmpty() || quests == null) {
						player.sendMessage(Error.NO_AVAILABLE_QUESTS.getError());
						player.closeInventory();
						return;
					}
					Random ran = new Random();
					Quest quest = quests.get(ran.nextInt(quests.size()));
					Main.takenQuests.put(player.getUniqueId(), quest);
					player.sendMessage(Utils.Color("&7Information about your quest:"));
					player.sendMessage(Utils.Color("&7Name: " + quest.getName()));
					player.sendMessage(Utils.Color("&7Goals: "));
					for (Goal goal:quest.getGoals()) {
						player.sendMessage(goal.getGoalMessage());
					}
					player.sendMessage(Utils.Color("&7Difficulty: " + quest.getDifficulty().getName()));
					player.sendMessage(Utils.Color("&7XP Prize: &6" + quest.getXpAmount()));
					if (!quest.getItemPrizes().isEmpty()) {
						player.sendMessage(Utils.Color("&7Prizes: "));
						for (ItemStack item:quest.getItemPrizes()) {
							player.sendMessage(Utils.Color("&6" + item.getItemMeta().getDisplayName() + "&7x&6" + item.getAmount()));
						}
					}
					player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
					player.closeInventory();
				} else {
					player.sendMessage(Error.PLAYER_ALREADY_HAS_QUEST.getError());
				}
			}
		}
	}
}
