package patten;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PattenTest {

	
	public static void main(String[] args) {
//		handle();
		
		String s = "date^in^out";
		System.out.println(s.split("\\^").length);
	}
	static String s = "$(sh600756)$😍😍😍😍 $(sh600758)$😡😡😡😡😡😡 $(sh60050)$.../-+/☜";
	static void handle(){
		String regex = "\\$(.*?)\\$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(s);
		while(m.find()){
			System.out.println(m.group(0));
			System.out.println(s.indexOf(m.group(0)));
		}
	}
}
