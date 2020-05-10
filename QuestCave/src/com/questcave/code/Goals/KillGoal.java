package com.questcave.code.Goals;

import com.questcave.code.Utils;
import com.questcave.code.Enums.Difficulty;
import com.questcave.code.Enums.GoalType;

public class KillGoal extends Goal {
	
	private String target;
	private int killsAmount;
	private int killed;
	
	public KillGoal(Difficulty goalDifficulty,int killsAmount,String target) {
		super(GoalType.KILL, goalDifficulty);
		this.killsAmount = killsAmount;
		this.target = target;
		this.killed = 0;
	}

	public int getKillGoal() {
		return killsAmount;
	}

	public String getTarget() {
		return target;
	}
	
	public int getKilledAmount() {
		return killed;
	}
	
	public void addKill() {
		killed = killed + 1;
	}
	
	@Override
	public String getGoalMessage() {
		return Utils.Color("&7You have to kill &6" + killsAmount + " " + target + "!");
	}

}
