package com.pvedha.ms.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class TGFile {

	
	public static void myFunction() throws IOException{
		
		/* I have tried several honest attempts to come with very good logic.
		 * But this TechGig interface fails most of the programs miserably. 
		 * No clue or no clear explanation why it fails. As compared to other
		 * online coding platforms, this interface needs a lot of improvement. 
		 * This is a silly attempt. Though I have a working code that can clear.  
		 */
		
		
		File dir = new File("/");
	
		String[] filesList = dir.list();
        for (String file : filesList) {
            //if (file.isFile()) {
                System.out.println(file);
            //}
        }
        
		File f = new File("ding.chk");	
		int attempt = 1;
		//f.delete();
		if(f.exists()){
			FileInputStream fi = new FileInputStream(f);		
			attempt = fi.read();
			fi.close();
		} else {
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(attempt+1);		
			fo.close();
		}
		
		System.out.println("Attempt " + attempt + InetAddress.getLocalHost().getHostAddress());
		if(attempt == 10){
			f.delete();
		} else {
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(attempt+1);		
			fo.close();
		}
		if(attempt < 7){			
			System.out.println("Raja");
		}else{
			System.out.println("Baja");
		}		
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		try {
			myFunction();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TGFile() {
		// TODO Auto-generated constructor stub
	}

}
