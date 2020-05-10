package com.questcave.code.Enums;

public enum Difficulty {
	EASY("&aEasy"),
	NORMAL("&eNormal"),
	HARD("&4Hard");
	
	private String name;
	
	Difficulty(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
