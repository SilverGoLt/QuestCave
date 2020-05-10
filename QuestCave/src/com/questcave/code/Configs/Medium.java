package com.questcave.code.Configs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import com.questcave.code.Main;
import com.questcave.code.Quest;
import com.questcave.code.Enums.Difficulty;
import com.questcave.code.Goals.Goal;

public class Medium {
	private static File file;
	private static YamlConfiguration config;
    public Medium(Main main) {
  	  file = new File(main.getDataFolder(), "MediumQuests.yml");
  	 if (!file.exists()) {
  		 try {
				 file.createNewFile();
		    	 config = YamlConfiguration.loadConfiguration(file);
		    	  	try {
		    				config.save(file);
		    		    	config = YamlConfiguration.loadConfiguration(file);
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
			} catch (IOException e) {
				e.printStackTrace();
			}
  		 
  	 }
  	config = YamlConfiguration.loadConfiguration(file);
   }
	
    @SuppressWarnings("unchecked")
	public static ArrayList<Quest> getQuests() {
    	Set<String> paths = config.getConfigurationSection("quests").getKeys(false);
    	ArrayList<Quest> quests = new ArrayList<Quest>();
    	for (String path:paths) {
    		Quest quest = new Quest(config.getString("quests" + path + ".name"),(ArrayList<Goal>) config.get("quests" + path +".goals"),
    				Difficulty.NORMAL,(ArrayList<ItemStack>) config.get("quests" + path +".ItemPrize"), config.getInt("quests" + path +".XPPRIZE"));
    		
    		quests.add(quest);
    	}
    	return quests;
    }
    
    public static void addQuest(Quest quest) {
    	Random rnd = new Random();
    	int number = 100000 + rnd.nextInt(900000);
    	config.set("quests" + number + ".name", quest.getName());
    	config.set("quests" + number + ".goals", quest.getGoals());
    	config.set("quests" + number + ".ItemPrizes", quest.getItemPrizes());
    	config.set("quests" + number + ".XPPrize", quest.getXpAmount());
    	configReload();
    }
	
	static public void configReload() {
   	 config = YamlConfiguration.loadConfiguration(file);
		try {
			config.save(file);
			config = YamlConfiguration.loadConfiguration(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
