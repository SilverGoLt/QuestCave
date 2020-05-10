package com.questcave.code.Goals;

import org.bukkit.inventory.ItemStack;

import com.questcave.code.Utils;
import com.questcave.code.Enums.Difficulty;
import com.questcave.code.Enums.GoalType;

public class GetGoal extends Goal {
	private ItemStack goalItem;
	
	public GetGoal( Difficulty goalDifficulty,ItemStack goalItem) {
		super(GoalType.GET, goalDifficulty);
		this.goalItem = goalItem;
	}

	public ItemStack getGoalItem() {
		return goalItem;
	}
	
	@Override
	public String getGoalMessage() {
		return Utils.Color("&7You have to get &6" + goalItem.getAmount() + " " + goalItem.getItemMeta().getDisplayName() + "!");
	}

}
