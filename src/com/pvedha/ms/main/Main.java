package com.pvedha.ms.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayList<Float> data = new ArrayList<>();
		FileReader fr = new FileReader();
		try {
			data = fr.readData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<20;i++){
			Bidder.maxLevel = i;
			Executor.startBidding(data);
		}
		
		System.out.println("Swithcing Strategy");
		for(int i=0;i<20;i++){
			Bidder.maxLevel = i;
			Executor.startBiddingSwitchStrategy(data);
		}
		
		System.out.println("SkipTrades");
		
		for(int i=0;i<20;i++){
			Bidder.maxLevel = i;
			Executor.startBiddingSkipTrades(data);
		}

	}

}
