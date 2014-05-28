package decompiler;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.CPInfo;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.InvalidByteCodeException;
import org.gjt.jclasslib.structures.constants.ConstantIntegerInfo;
import org.gjt.jclasslib.structures.constants.ConstantMethodHandleInfo;
import org.gjt.jclasslib.structures.constants.ConstantMethodrefInfo;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

public class Test {

	
	public static void main(String[] args) {
		try {
			String filePath = "E://download/JWord/jword-1.0/a.class";     
			FileInputStream fis = new FileInputStream(filePath);     
			     
			DataInput di = new DataInputStream(fis);     
			ClassFile cf = new ClassFile();     
			cf.read(di);     
			CPInfo[] infos = cf.getConstantPool();     
			     
			int count = infos.length;     
			for (int i = 0; i < count; i++) {     
			    if (infos[i] != null) {     
			        System.out.print(i);     
			        System.out.print(" = ");     
			        System.out.print(infos[i].getVerbose());     
			        System.out.print(" = ");     
			        System.out.println(infos[i].getTagVerbose());     
			        if(i == 48){     
			        	ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];     
			        	uInfo.setBytes("JWord过期啦".getBytes());     
			        	infos[i]=uInfo;     
			        }
			        if(i == 57){     
			        	ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];     
			        	uInfo.setBytes("JWord.测试版".getBytes());     
			        	infos[i]=uInfo;     
			        }
			        if(i == 97){     
			        	ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];     
			        	uInfo.setBytes("JWord.获取扩展版".getBytes());     
			        	infos[i]=uInfo;     
			        }
			    }     
			}     
			cf.setConstantPool(infos);
			fis.close();     
			File f = new File(filePath);     
			ClassFileWriter.writeToFile(f, cf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidByteCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
