package com.covalant.cal;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class IO {

	@Test
	public void test1(){
		
		File file = new File("D:\\searchResults.txt");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line1 = "";
			
			while(  (line1 = reader.readLine()) != null){
				System.out.println(line1);
			}
			/*do{
					line1 = reader.readLine();
					System.out.println(line1);
			}
			while(line1!=null);*/
			
			reader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeFile(){
		
		File file  =new File("D:\\batch23.txt");
		
		try {
			FileWriter writer = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(writer);
			br.write("I am bharath and this is batch23 and adding");
			br.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void readFile2(){
		File file = new File("D:\\searchResults.txt");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bfs = new BufferedInputStream(fis);
			char c  = 0;
			char x = (char) -1;
			while( (c = (char)bfs.read()) !=  x){
				System.out.print(c);
			}
			
			bfs.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
