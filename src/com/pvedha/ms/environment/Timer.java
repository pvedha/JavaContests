package com.pvedha.ms.environment;

public class Timer {

	long startTime = 0;
	long endTime = 0;
	
	public Timer() {
		startTime   = System.currentTimeMillis();
	}
	
	public void elapsedTime(){
		System.out.println("Time Taken " + (System.currentTimeMillis() - startTime));
	}

}
