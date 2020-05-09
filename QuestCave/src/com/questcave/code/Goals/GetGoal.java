package com.questcave.code.Goals;

import org.bukkit.inventory.ItemStack;

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

}
