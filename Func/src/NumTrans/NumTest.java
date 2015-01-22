package NumTrans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 给英的写的
 * @author lsm
 *
 */
public class NumTest {

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("4e0b	".trim(),16));
		
		File file = new File("./num.txt");
		System.out.println(file.exists());

		readFileByChars(file);
	}
	
	public static void readFileByChars(File file) {
        Reader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
                    sb.append((char) tempchar);
                }
            }
            String str = sb.toString();
            
            String[] split = str.split("	");
            
            StringBuffer result = new StringBuffer();
            for(int i=0;i<split.length;i++){
            	int x = Integer.parseInt(split[i].trim(),16);

            	result.append(x+"-"+x+"	");
            	if((i+1)%8==0)
            		result.append("\n");
            	
            }
            System.out.println(result.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
