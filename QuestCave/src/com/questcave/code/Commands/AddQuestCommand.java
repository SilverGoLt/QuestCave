package com.questcave.code.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.questcave.code.Enums.Error;

public class AddQuestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("questcave.addquest")) {
				
			} else {
				player.sendMessage(Error.NO_PERMISSION.getError());
			}
		} else {
			sender.sendMessage(Error.PLAYERS_ONLY.getError());
		}
		return false;
	}

}
