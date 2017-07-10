package com.covalant.ng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Abc {

	
	public void test1(){
		
		File file = new File("D:\\git\\batch25_1\\notes.txt");
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bred = new BufferedReader(reader);
		String st = "";
			while(  (st = bred.readLine()) != null   ){
				System.out.println(st);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Abc a= new Abc();
		a.test1();
	}
}
