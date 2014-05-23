package filesecurity;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		
//		jiami("123",new File("twsm.zip"));
		
		jiemi("67",new File("26subyb0x01mmckpjq9kx8tg4"));
	}
	
	static void jiami(String code,File file){
		File jiami = new File("jiami");
		boolean r = FileSecurity.encryptFile(file, jiami.getAbsolutePath(), code, "AES");
		System.out.println("加密："+r);
	}
	
	static void jiemi(String code,File file){
		File jiemi = new File("jiemi.zip");
		boolean b = FileSecurity.decryptFile(file, jiemi.getAbsolutePath(),code, "AES");
		System.out.println("解密："+b);
	}
}
