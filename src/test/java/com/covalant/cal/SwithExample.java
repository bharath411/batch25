package com.covalant.cal;

import org.testng.annotations.Test;

public class SwithExample {

	public static final String  MONDAY = "monday";
	public static final String  TUESDAY = "tuesday";
	public static final String  WEDNESDAY = "wednesday";
	public static final String  THURSDAY = "thursday";
	public static final String  FRIDAY = "friday";
	public static final String  SATURDAY = "saturday";
	public static final String  SUNDAY = "bharath";
	
	public void test2(String weekname) {
	
		switch (weekname) {
		case SUNDAY:
			System.out.println("I am super free today");
			break;
		case MONDAY:
			System.out.println("I am super  dull");
			break;
		case TUESDAY:
			System.out.println("I am busy with work");
			break;
		case WEDNESDAY:
			System.out.println("Middle of the week");
			break;
		case THURSDAY:
			System.out.println("One day to go");
			break;
		case FRIDAY:
			System.out.println("Party time");
			break;
		case SATURDAY:
			System.out.println("Resting  till become restless");
			break;
		default:
			System.out.println("No weekend day is defined .");
			break;
		}
		
	
	}

	
	public void test3(WeekDay day) {
		
		switch (day) {
		case SUNDAY:
			System.out.println("I am super free today");
			break;
		case MONDAY:
			System.out.println("I am super  dull");
			break;
		case TUESDAY:
			System.out.println("I am busy with work");
			break;
		case WEDNESDAY:
			System.out.println("Middle of the week");
			break;
		case THURSDAY:
			System.out.println("One day to go");
			break;
		case FRIDAY:
			System.out.println("Party time");
			break;
		case SATURDAY:
			System.out.println("Resting  till become restless");
			break;
		default:
			System.out.println("No weekend day is defined .");
			break;
		}
		
	
	}

	public void test1(String weekname) {

		if (weekname.equals("sunday")) {
			System.out.println("I am super free today");
		} else if (weekname.equals("monday")) {
			System.out.println("I am super free dull");
		} else if (weekname.equals("tuesday")) {
			System.out.println("I am busy with work");
		} else if (weekname.equals("wednesday")) {
			System.out.println("Middle of the week");
		} else if (weekname.equals("thursday")) {
			System.out.println("One day to go");
		} else if (weekname.equals("friday")) {
			System.out.println("Party time");
		} else if (weekname.equals("saturday")) {
			System.out.println("Resting  till become restless");
		}

	}

}
