package com.covalant.automation.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class DataDriver {

	private Properties props =null;
	private File file = null;
	private FileInputStream fis = null;
	
	public DataDriver(){
		init();
	}
	public  String getProperty(String key){
		return props.getProperty(key);
	}
	
	
	private  void init(){
		file = new File("./src/main/java/testdata.properties");
		try {
			fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		DataDriver d = new DataDriver();
		d.init();
	}
}
