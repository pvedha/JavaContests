package com.pvedha.ms.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	public FileReader() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Float> readData() throws FileNotFoundException{
		ArrayList<Float> data = new ArrayList<>();
		File file = new File("d:\\tmp\\eurusd_aug17_1min.txt");
		//FileInputStream fis = new FileInputStream(file);
		Scanner in = new Scanner(file);
		while(in.hasNext()){
			//System.out.println(in.nextLine());
			data.add(in.nextFloat());
		}
		return data;
			
	}
	
}
