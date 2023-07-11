package Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.scm.genericUtility.javautility;

public class DateDummy {
public static void main(String[] args) {
//	Date d=new Date();
//	System.out.println(d);
	SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
//	System.out.println(sd.format(d));	
Calendar c=Calendar.getInstance();
Date todaydate = c.getTime();
System.out.println(todaydate);
c.add(Calendar.DATE, 10);
Date reqDate = c.getTime();
String d = sd.format(reqDate);
System.out.println(d);
int day = c.get(Calendar.DATE);
System.out.println(day);
Calendar cal = Calendar.getInstance();
	
int date = cal.get(Calendar.DAY_OF_MONTH);
System.out.println(date);
javautility ju=new javautility();
System.out.println(ju.getDateTimeMinSec());
	//welcome to git helloo
}
}
