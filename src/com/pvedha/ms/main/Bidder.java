package com.pvedha.ms.main;

public class Bidder {

	public static int maxLevel = 3;
	private int minLevel = 0;
	private int currentLevel = 0;
	private int bidPrice = 2; //logic needed for 1, 1 power something wont work.

	public Bidder() {
	}

	public int getBid() {
		if (currentLevel >= maxLevel) {
			resetCurrentLevel();
		} else {
			currentLevel++;
		}
		return (int)( Math.pow(bidPrice,currentLevel) * 1.5);
	}

	public void resetCurrentLevel() {
		currentLevel = minLevel;
	}

	public void setMaxLevl(int max){
		maxLevel = max;
	}
	
	public int getMaxLevel(){
		return maxLevel;
	}
	
	public int getCurrentLevel(){
		return currentLevel;
	}
	
	public boolean isMaxLevelReached(){
		if(currentLevel == maxLevel){
			return true;
		}
		return false;
	}
}
