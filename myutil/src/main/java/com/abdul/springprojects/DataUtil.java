package com.abdul.springprojects;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {  //9949488483

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		     Date today = new Date();
	        System.out.println("Today is : " + today);
	        String date24 = get24HourFormat("78");
	}

	
	public static String get24HourFormat(String dateString){
        Date date = new Date();
        DateTime date1=new DateTime();

        //  String date="";
        int hour=0;
        //int year=0;
        if(dateString!=null){

            try {
             //   DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss.SSS aa");
                DateTimeFormatter output = DateTimeFormat.forPattern("kk");

            //    date1=formatter.parseDateTime(dateString);
                hour=date1.getHourOfDay();
                System.out.println(output.print(date1));
                //  System.out.println(date);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return hour+"";
    }
	
	
}
