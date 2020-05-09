package com.questcave.code;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import com.questcave.code.Enums.Difficulty;
import com.questcave.code.Goals.Goal;

public class Quest {
	private String name;
	private ArrayList<Goal> goals;
	private Difficulty difficulty;
	private boolean isFinished;
	private ArrayList<ItemStack> itemPrizes;
	private int xpAmount;
	
	public Quest(String name, ArrayList<Goal> goals, Difficulty difficulty,ArrayList<ItemStack> itemPrizes,int xpAmount) {
		this.name = name;
		this.goals = goals;
		this.difficulty = difficulty;
		this.itemPrizes = itemPrizes;
		this.xpAmount = xpAmount;
		isFinished = false;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Goal> getGoals() {
		return goals;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public boolean isFinished() {
		return isFinished;
	}
	
	public ArrayList<ItemStack> getItemPrizes() {
		return itemPrizes;
	}

	public int getXpAmount() {
		return xpAmount;
	}

	public boolean isGoalsFinished() {
		int goalsAmount = goals.size();
		int complitedGoals = 0;
		for (Goal goal:goals) {
			if (goal.isFinished()) {
				complitedGoals++;
			}
		}
		if (goalsAmount == complitedGoals) {
			return true;
		}
		return false;
	}
	
	public void finishQuest() {
		
	}
}
