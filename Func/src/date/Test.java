package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import freemarker.template.SimpleDate;

public class Test {

	public static void main(String[] args) {
		func1();
		
		
//		func2();
		
//		func3();
		
	}
	
	public static void func3(){
		String date = "Mon, 19 Jan 2015 10:00:00 +8000";
		Date dd = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(dd));
	}

	public static void func1() {
		SimpleDateFormat f=new SimpleDateFormat("E, dd MM yyyy HH:mm:ss Z",Locale.CHINA);
//		String t="Tue Jan 02 00:05:52 CST 1900";
		String t="Mon, 19 Jan 2015 10:00:00 +8000";
		try{
			Date d=f.parse(t);
			System.out.println(t+" => "+(d.getTime()/1000));
			
			int ts=1322184161;
			d.setTime(ts*1000L);
			System.out.println(ts+" => "+f.format(d));
		}catch (ParseException e){		
			e.printStackTrace();
		}
	}

	public static void func2() {
		TimeZone.setDefault(TimeZone.getTimeZone("CST"));
		try{   
			String d = "Wed Jan 15 00:00:00 CST 2014";
			SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd hh:mm:ss z yyyy");
			Date date = formatter.parse(d);   System.out.println(date);
		 
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dd =format.format(date );
		   Date ddd;   ddd = format.parse(dd); 
		   System.out.println("dd>>>>  "+dd);
		   System.out.println("ddd>>>  "+format.format(ddd));
		 
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
