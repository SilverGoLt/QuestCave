package com.questcave.code.Enums;

import org.bukkit.ChatColor;

import com.questcave.code.Main;

public enum Error {

    PLAYERS_ONLY(Color(getString("messages.playersOnly"))),
    NO_PERMISSION(Color(getString("messages.noPermission"))),
    PLAYER_ALREADY_HAS_QUEST(Color(getString("messages.playerAlreadyHasQuest"))),
	NO_AVAILABLE_QUESTS(Color(getString("messages.noAvailableQuests")));

    private String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
    
    private static String Color(String text) {
    	return ChatColor.translateAlternateColorCodes('&', text);
    }
    
    private static String getString(String path) {
    	return Main.getPlugin(Main.class).getConfig().getString(path);
    }
}
