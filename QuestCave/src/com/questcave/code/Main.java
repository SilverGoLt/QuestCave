package com.questcave.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main extends JavaPlugin{
	HashMap<UUID,Quest> takenQuests = new HashMap<UUID,Quest>();
	
	
	@Override
	public void onEnable() {
		
		
		
		// Default Config
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		try {
			Gson gson = new Gson();
			Reader reader = Files.newBufferedReader(Paths.get(getDataFolder() + "/PlayersQuest.json"));
			takenQuests = gson.fromJson(reader, new TypeToken<HashMap<UUID,Quest>>() {
			}.getType());
			reader.close();
			System.out.println("QuestCave >>> Player's Quests has been loaded!");
		} catch (IOException e) {
			takenQuests = new HashMap<>();
		}
	}
	
	
	@Override
	public void onDisable() {
		//Saving hashmap
		try {
			Writer writer = new FileWriter(getDataFolder() + "/PlayersQuest.json");
			new Gson().toJson(takenQuests, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path path = Paths.get(getDataFolder() + "/Backup");
		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			File folder = new File(getDataFolder() + "/Backup");
			File[] listOfBackUps = folder.listFiles();
			ArrayList<File> Backups = new ArrayList<File>();
			for (File file:listOfBackUps) {
				Backups.add(file);
			}
			
			File lastFile = Backups.get(Backups.size() - 1);
			int lastNumber = Integer.valueOf(lastFile.getName().charAt(lastFile.getName().length() - 1));
			try {
				Writer writer = new FileWriter(getDataFolder() + "/Backup/BackUp" + lastNumber +".json");
				new Gson().toJson(takenQuests, writer);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (Backups.size() == 10) {
				Backups.get(0).delete();
			}
			
		} else {
			try {
				Writer writer = new FileWriter(getDataFolder() + "/Backup/BackUp1.json");
				new Gson().toJson(takenQuests, writer);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
