package com.pvedha.ms.main;

import java.util.ArrayList;

public class Executor {

	private static boolean UP = true;
	private static boolean DOWN = false;
	private static boolean currentStrategy = UP;
	public Executor() {
		// TODO Auto-generated constructor stub
	}
	
	public static void startBiddingSkipTrades(ArrayList<Float> data){
		Bidder bidder = new Bidder();

		Float currentValue = (float) 0;
		int currentBid = 0;
		int profit = 0;
		int cashReserve = 100;
		boolean success = true;
		int maxBidReached = 1;
		int lowestProfitLevel = 0;
		int highestProfitLevel = 0;
		int failureStreak = 0;
		int numberOfSwitches = 0;
		boolean skipTrades = false;
		int tradesToSkip = 10;
        currentStrategy = DOWN;
		for (Float item : data) {
			
			currentBid = bidder.getBid();
			if(maxBidReached < currentBid){
				maxBidReached = currentBid;
			}
			
			
//			if(bidder.isMaxLevelReached()){				
//				failureStreak ++;
//				System.out.println("isMaxLevelReached" + failureStreak + " " + bidder.getCurrentLevel());
//			} else {
//				failureStreak = 0;
//			}
			
			if(failureStreak == 1 * bidder.getMaxLevel()){
				//System.out.println("Switching strategy" + failureStreak);
				skipTrades = true;
				tradesToSkip = failureStreak;
				numberOfSwitches++;
			}
			
			if(tradesToSkip-- > 0){
				continue;
			}
			
			if(currentStrategy){
			if (item < currentValue) {
				profit += currentBid;
				bidder.resetCurrentLevel();
				failureStreak = 0;
			} else {
				profit -= currentBid;
				failureStreak ++;
			}
			} else {
				if (item > currentValue) {
					profit += currentBid;
					bidder.resetCurrentLevel();
					failureStreak = 0;
				} else {
					profit -= currentBid;
					failureStreak ++;
				}
			}
			if(lowestProfitLevel > profit){
				lowestProfitLevel = profit;
			}
			if(highestProfitLevel < profit){
				highestProfitLevel = profit;			}
			//System.out.println("BidAmount : " + currentBid + "\t Old : " + currentValue 
				//	+ "\t New : " + item + "\tProfit : " + profit);
			if(profit + cashReserve < 0) {
				//System.out.println("Busted!!");
				//break;
			}
			currentValue = item;
		}

		System.out.println("Max Bid Reached " + maxBidReached + ", \tTrades " 
		+ data.size() + ", \tLowest Profit Level " + lowestProfitLevel
		+ ", \tHighest Profit Level " + highestProfitLevel
		+ ", \tSwitches " + numberOfSwitches
		+ " \t Final profit " + profit);
	
	}
	
	public static void startBiddingSwitchStrategy(ArrayList<Float> data){
		Bidder bidder = new Bidder();

		Float currentValue = (float) 0;
		int currentBid = 0;
		int profit = 0;
		int cashReserve = 100;
		boolean success = true;
		int maxBidReached = 1;
		int lowestProfitLevel = 0;
		int highestProfitLevel = 0;
		int failureStreak = 0;
		int numberOfSwitches = 0;
		

		for (Float item : data) {
			
			currentBid = bidder.getBid();
			if(maxBidReached < currentBid){
				maxBidReached = currentBid;
			}
			
			
//			if(bidder.isMaxLevelReached()){				
//				failureStreak ++;
//				System.out.println("isMaxLevelReached" + failureStreak + " " + bidder.getCurrentLevel());
//			} else {
//				failureStreak = 0;
//			}
			
			if(failureStreak == 2 * bidder.getMaxLevel()){
				//System.out.println("Switching strategy" + failureStreak);
				currentStrategy = !currentStrategy;
				numberOfSwitches++;
			}
			
			if(currentStrategy){
			if (item < currentValue) {
				profit += currentBid;
				bidder.resetCurrentLevel();
				failureStreak = 0;
			} else {
				profit -= currentBid;
				failureStreak ++;
			}
			} else {
				if (item > currentValue) {
					profit += currentBid;
					bidder.resetCurrentLevel();
					failureStreak = 0;
				} else {
					profit -= currentBid;
					failureStreak ++;
				}
			}
			if(lowestProfitLevel > profit){
				lowestProfitLevel = profit;
			}
			if(highestProfitLevel < profit){
				highestProfitLevel = profit;			}
			//System.out.println("BidAmount : " + currentBid + "\t Old : " + currentValue 
				//	+ "\t New : " + item + "\tProfit : " + profit);
			if(profit + cashReserve < 0) {
				//System.out.println("Busted!!");
				//break;
			}
			currentValue = item;
		}

		System.out.println("Max Bid Reached " + maxBidReached + ", \tTrades " 
		+ data.size() + ", \tLowest Profit Level " + lowestProfitLevel
		+ ", \tHighest Profit Level " + highestProfitLevel
		+ ", \tSwitches " + numberOfSwitches
		+ " \t Final profit " + profit);
	
	}
	
	
	
	public static void startBidding(ArrayList<Float> data){
		Bidder bidder = new Bidder();

		Float currentValue = (float) 0;
		int currentBid = 0;
		int profit = 0;
		int cashReserve = 100000;
		boolean success = true;
		int maxBidReached = 1;
		int lowestProfitLevel = 0;

		for (Float item : data) {
			
			currentBid = bidder.getBid();
			if(maxBidReached < currentBid){
				maxBidReached = currentBid;
			}
			if (item < currentValue) {
				profit += currentBid;
				bidder.resetCurrentLevel();
				success = true;
			} else {
				profit -= currentBid;
				success = false;
			}
			
			if(lowestProfitLevel > profit){
				lowestProfitLevel = profit;
			}
			//System.out.println("BidAmount : " + currentBid + "\t Old : " + currentValue 
					//+ "\t New : " + item + "\tProfit : " + profit);
			if(profit + cashReserve < 0) {
				System.out.println("Busted!!");
				break;
			}
			currentValue = item;
		}

		System.out.println("Max Bid Reached " + maxBidReached + ", \tTrades " + data.size() + ", \tLowest Profit Level " + lowestProfitLevel);
	
	}

	private void startBidding(){
		Bidder bidder = new Bidder();

		int currentValue = 0;
		int currentBid = 0;
		int profit = 0;
		int cashReserve = 100;
		boolean success = true;
		int maxBidReached = 1;
		int lowestProfitLevel = 0;

		for (Integer item : Data.data) {
			
			currentBid = bidder.getBid();
			if(maxBidReached < currentBid){
				maxBidReached = currentBid;
			}
			if (item > currentValue) {
				profit += currentBid;
				bidder.resetCurrentLevel();
				success = true;
			} else {
				profit -= currentBid;
				success = false;
			}
			
			if(lowestProfitLevel > profit){
				lowestProfitLevel = profit;
			}
			System.out.println("BidAmount : " + currentBid + "\t Old : " + currentValue 
					+ "\t New : " + item + "\tProfit : " + profit);
			if(profit + cashReserve < 0) {
				System.out.println("Busted!!");
				break;
			}
			currentValue = item;
		}

		System.out.println("Max Bid Reached " + maxBidReached + ", \tLowest Profit Level " + lowestProfitLevel);
	
	}
}
