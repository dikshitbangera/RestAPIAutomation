package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	
	public static String randomname() {
		String rndmname=RandomStringUtils.randomAlphabetic(1);
		String name="john"+rndmname;
		return name;
		
	}
	
	public static String randomage() {
		String rndmage=RandomStringUtils.randomNumeric(2);
		return rndmage;
	}
	
	public static String randomsalary() {
		String rndmsalary=RandomStringUtils.randomNumeric(5);
		return rndmsalary;
	}
}
