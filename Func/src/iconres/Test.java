package iconres;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		FileInputStream f;
		try {
			f = new FileInputStream("./res.txt");
			BufferedReader dr=new BufferedReader(new InputStreamReader(f)); 
			while(dr.readLine() != null){
//				d_zuohengheng=0x7f0200c2
				String[] split = dr.readLine().split("=");
//				<public type="drawable" name="d_beishang" id="0x7f0201fc" />
				System.out.println("<public type=\"drawable\" name=\""+split[0]+"\" id=\""+split[1]+"\"/>");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
