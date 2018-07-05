package com.abdul.springprojects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Date today = new Date();
		 LocalDate currentDate = LocalDate.now();
		 System.out.println("currentDate : " + currentDate);
		// TemporalUnit unit  = TemporalUnit.
		 LocalDate currentDate1 =  currentDate.minus(4, ChronoUnit.DAYS);
		 
		 System.out.println("currentDate1 : " + currentDate1);
		
		 
		// LocalDate first = LocalDate.ofEpochDay(364);
		// System.out.println("Tis : " + first);
		 
	  //   System.out.println("Today is : " + today);
	  //   System.out.println("int is : " + toNumber(today));
	     
	     GregorianCalendar c = new GregorianCalendar();
		    c.setTime(today);
	     
	        int year = c.get(Calendar.YEAR);
	        int month = c.get(Calendar.MONTH);
	        int hour12 = c.get(Calendar.HOUR);
	        int hour24 = c.get(Calendar.HOUR_OF_DAY);
	       
	        System.out.println("year is : " + year);
	        System.out.println("month is : " + month);
	        System.out.println("hour12 is : " + hour12);
	        System.out.println("hour24 is : " + hour24);
	     //   c.get(78);
	       // System.out.println("hour24 is : " + c.get(78));
	       // long log1 = c.get(Calendar.LONG_FORMAT);
	      //  String str = String.valueOf(c.get(Calendar.NARROW_STANDALONE));
	      //  Integer.parseInt(new String(c.get(Calendar.LONG_STANDALONE)));
	      //   String log2 = c.get(Calendar.LONG_STANDALONE);
	    //  System.out.println("logstr is : " + str);
	      //  System.out.println("log2 is : " + Long.parseLong(String.valueOf(log2)));
	        
	        

	}
	
	
	 public static float toNumber(Date now) {
		    GregorianCalendar c = new GregorianCalendar();
		    c.setTime(now);
		    int hour = c.get(Calendar.HOUR_OF_DAY);// 0-23
		    int minute = c.get(Calendar.MINUTE);// 0-59
		    int day  = c.get(Calendar.HOUR);// 0-59
		    System.out.println("day is : " + day);
		   

		    return toNumber(hour, minute);
		  }

		  public static float toNumber(int hour, int minute) {
		    return hour + minute / 60f;
		  }
		  
		  

}
