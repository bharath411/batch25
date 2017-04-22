package com.covalant.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesExample {

	
	@Test
	public void test1(){
		
		File file =new File("D:\\testdata.properties");
		Properties props = new Properties();
		FileInputStream fis = null;
		
		try {
		fis = new FileInputStream(file);
		props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 String url = props.getProperty("name", "bhaarath");
		 System.out.println(url);
		 
		String timeOut =  props.getProperty("timeout");
		System.out.println(timeOut);
	}
}
