package vTiger.Practice;

import java.util.Random;

public class GenericUtilityPractice {

	public static void main(String[] args) {        // calling or caller function
		
		Random ran  = new Random();
		int random = ran.nextInt(500);
		System.out.println(random);
		
	 	int ran1 = ran.nextInt(100);
	 	System.out.println(ran1);
		
		int value = GenericUtilityPractice.add(random, ran1);
		System.out.println(value);

	}
    public static int add(int a, int b)  // called function   //parameterizing the method to perform a generic process
    {
    	int c =a+b;
    	return c;
    }
}
