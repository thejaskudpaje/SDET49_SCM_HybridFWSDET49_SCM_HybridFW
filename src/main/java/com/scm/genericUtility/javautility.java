package com.scm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	Random random = new Random();
	Date dateObj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * generate random number with in the limit of 40000 for very invocation
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		int ranInt = random.nextInt(999);
		return ranInt;
	}

	/**
	 * used to get the system current date in "yyyy-MM-dd " format
	 * 
	 * @return
	 */
	public String getDate() {

		String date = sim.format(dateObj);
		return date;
	}

	/**
	 * used to get the required date in "yyyy-MM-dd " 
	 * format requiredDateCount is positive number , it provides upcoming date based numeric count
	 * if requiredDateCount is negative number , it provides previous date based numeric count
	 * 
	 * @param requiredDateCount
	 */
	public String getDate(int requiredDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDateCount);
		Date date = cal.getTime();
		String rdata = sim.format(date);
		return rdata;
	}
	
	public String getDateTimeMinSec() {
		Calendar cal = Calendar.getInstance();
		int date = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		String DHMS=date+"_"+hour+"_"+min+"_"+sec;
		return DHMS;
	}

}
