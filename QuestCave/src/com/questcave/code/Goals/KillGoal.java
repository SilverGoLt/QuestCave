package com.questcave.code.Goals;

import org.bukkit.entity.Entity;

import com.questcave.code.Enums.Difficulty;
import com.questcave.code.Enums.GoalType;

public class KillGoal extends Goal {
	
	private Entity goalTarget;
	private int goalKillsAmount;
	private int killsAmount;
	
	public KillGoal(Difficulty goalDifficulty,int goalKillsAmount,Entity goalTarget) {
		super(GoalType.KILL, goalDifficulty);
		this.goalKillsAmount = goalKillsAmount;
		this.goalTarget = goalTarget;
		this.killsAmount = 0;
	}

	public int getGoalKillAmount() {
		return goalKillsAmount;
	}

	public Entity getGoalTarget() {
		return goalTarget;
	}
	
	public int getKillsAmount() {
		return killsAmount;
	}
	
	public void addKill() {
		killsAmount = killsAmount + 1;
		
	}

}
