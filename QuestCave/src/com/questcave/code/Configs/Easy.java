package com.questcave.code.Configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import com.questcave.code.Main;



/*
 * 
 * quests:
 *   hazirgang:
 *     Job:
 *     XPPrize:
 * 	   ItemPrize:
 * 	   - "item"
 *     - "item"
 *     goals:
 *     - "KILL:ORC:16"
 *     - "KILL:COW:16"
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class Easy {
	private static File file;
	private static YamlConfiguration config;
    public Easy(Main main) {
  	  file = new File(main.getDataFolder(), "EasyQuests.yml");
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
