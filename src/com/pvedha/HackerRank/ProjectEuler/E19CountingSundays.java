package com.pvedha.HackerRank.ProjectEuler;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class E19CountingSundays {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		Long weekInMilliSeconds = TimeUnit.DAYS.toMillis(7);
		Long dayInMilliSeconds = TimeUnit.DAYS.toMillis(1);
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		Calendar fC = Calendar.getInstance();
			Calendar tC = Calendar.getInstance();
		for (int c = 0; c < cases; c++) {
			Long fYear = in.nextLong();
			int fMonth = in.nextInt() - 1;
			int fDate = in.nextInt();
			Long tYear = in.nextLong();
			int tMonth = in.nextInt() - 1;
			int tDate = in.nextInt();			
			if (fYear > 18000) {
				fYear %= 18000;
			}
			if (tYear > 18000) {
				tYear %= 18000;
			}

			fC.set(fYear.intValue(), fMonth, fDate);
			tC.set(tYear.intValue(), tMonth, tDate);
			Long fMs = fC.getTimeInMillis();
			Long tMs = tC.getTimeInMillis();
			int count = 0;
			// System.out.println(fC.get(Calendar.DAY_OF_WEEK) + " " +
			// fC.get(Calendar.DATE) );
			while (fC.get(Calendar.DAY_OF_WEEK) != 1) {
				fMs += dayInMilliSeconds;
				fC.setTimeInMillis(fMs);
			}
			// System.out.println(fC.get(Calendar.DAY_OF_WEEK) + " " +
			// fC.get(Calendar.DATE) );
			System.out.println(fMs + " " + tMs);
			while (fMs <= tMs) {
				// System.out.println(fC.get(Calendar.DATE) + " " +
				// fC.get(Calendar.MONTH) + " " + fC.get(Calendar.YEAR));
				// System.out.println(fC.get(Calendar.DAY_OF_WEEK) + " " +
				// fC.get(Calendar.DATE) );
				if (fC.get(Calendar.DAY_OF_WEEK) == 1 && fC.get(Calendar.DATE) == 1) {
					// System.out.println(fC.get(Calendar.DATE) + " " +
					// fC.get(Calendar.MONTH) + " " + fC.get(Calendar.YEAR));
					count++;
				}
				fMs += weekInMilliSeconds;
				fC.setTimeInMillis(fMs);
			}

			System.out.println(count);
		}

	}

}
