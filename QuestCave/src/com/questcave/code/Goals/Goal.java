package com.questcave.code.Goals;

import com.questcave.code.Enums.Difficulty;
import com.questcave.code.Enums.GoalType;

public class Goal {
	private GoalType goalType;
	private Difficulty goalDifficulty;
	private boolean finished; 
	
	public Goal(GoalType goalType, Difficulty goalDifficulty) {
		this.goalType = goalType;
		this.goalDifficulty = goalDifficulty;
		this.finished = false;
	}

	public GoalType getGoalType() {
		return goalType;
	}
	
	public Difficulty getGoalDifficulty() {
		return goalDifficulty;
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void setFinished(boolean state) {
		finished = state;
	}
	
	
}
