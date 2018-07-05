package com.abdul.springprojects;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ConvertDateUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    	//args[0] = "54";
		 Integer no = new Integer(args[0]);
         int noOfHours =  Integer.parseInt(args[0]);
		 LocalDate currentDate = LocalDate.now();
		 System.out.println("currentDate : " + currentDate);
		 int numOfdays = noOfHours / 24;
		 int numOfHours = noOfHours % 24;
		 
		 Integer numOfdays1 = new Integer(no / 24);
		 Integer numOfHours1 = new Integer(no % 24);
		 
		 
		 /*int numOfdays1 = no / 24;
		 int numOfHours1 = no % 24;*/
		 
		 System.out.println("numOfdays : " + numOfdays);
		 System.out.println("numOfHours : " + numOfHours);
		 
		 
		 System.out.println("numOfdays1 : " + numOfdays1);
		 System.out.println("numOfHours1 : " + numOfHours1);
		 
		 LocalDate currentDate2 = currentDate.minus(numOfdays1, ChronoUnit.DAYS);
		 System.out.println("currentDate2  : " + currentDate2);
		 
		 /**
		  * 
		  */
		 
		 LocalDate currentDate3 = currentDate2.plus(numOfdays, ChronoUnit.DAYS);
		 System.out.println("currentDate3  : " + currentDate3);
		 
		
	}

}
