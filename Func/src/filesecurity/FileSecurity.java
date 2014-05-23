package filesecurity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileSecurity {
	
	private static final String CIPHER_TYPE = "AES/CBC/PKCS5Padding";
	private static byte[] iv = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

	public static boolean encryptFile(File inFile ,String outFile,String strKey,String alg){
		byte [] outputBytes = encrypt(getBytesFromFile(inFile), strKey, alg);
		if(outputBytes==null){
			return false;
		}
		int fowbr = writeBytes(outFile, outputBytes);
		if(fowbr!=0){
			return false;
		}
		return true;
	}
	
	public static boolean decryptFile(File inFile,String outFile,String strKey ,String alg){
		System.out.println( "解密文件："+inFile.getAbsolutePath());
		byte[] outputBytes = decrypt(getBytesFromFile(inFile), strKey, alg);
		if(outputBytes==null){
			return false;
		}
		int fowbr = writeBytes(outFile, outputBytes);
		if(fowbr!=0){
			return false;
		}
		return true;
	}
	
//	private static Key getKey(byte[] seed,String alg){
//		try {
//			KeyGenerator kgen = KeyGenerator.getInstance("AES"); 
//			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG"); 
//			sr.setSeed(seed); 
//			kgen.init(128, sr); // 192 and 256 bits may not be available 
//			SecretKey skey = kgen.generateKey();
//			SecretKeySpec key = new SecretKeySpec(skey.getEncoded(), "AES");
//			return key;
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public static Key getKey(byte[] arrBTmp, String alg){
		if(!(alg.equals("DES")||alg.equals("DESede")||alg.equals("AES"))){
			System.out.println("alg type not find: "+alg);
			return null;
		}
		byte[] arrB;
		if(alg.equals("DES")){
			arrB = new byte[8];
		}
		else if(alg.equals("DESede")){
			arrB = new byte[24];
		}
		else{
			arrB = new byte[16];
		}
		int i=0;
		int j=0;
		while(i < arrB.length){
			if(j>arrBTmp.length-1){
				j=0;
			}
			arrB[i] = arrBTmp[j];
			i++;
			j++;
		}
		Key key = new SecretKeySpec(arrB, alg);
		return key;
	}
	
	public static byte[] encrypt(byte[] data,String strKey,String alg){
		if(!(alg.equals("DES")||alg.equals("DESede")||alg.equals("AES"))){
			System.out.println("alg type not find: "+alg);
			return null;
		}
		try {
			Key key = getKey(strKey.getBytes(),alg);
			Cipher c = Cipher.getInstance(CIPHER_TYPE);
			c.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
			return Base64.encodeToString(c.doFinal(data), Base64.DEFAULT).getBytes();
			//System.out.println("加密后的二进串:" + FileDigest.byte2Str(r));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decrypt(byte[] data,String strKey,String alg){
		if(!(alg.equals("DES")||alg.equals("DESede")||alg.equals("AES"))){
			System.out.println("alg type not find: "+alg);
			return null;
		}
		try {
			Key key = getKey(strKey.getBytes(),alg);
			Cipher c = Cipher.getInstance(CIPHER_TYPE);
			c.init(Cipher.DECRYPT_MODE,key, new IvParameterSpec(iv));
			return c.doFinal(Base64.decode(data, Base64.DEFAULT)); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static int writeBytes(String file, byte[] bytes){
		FileOutputStream out;
		File temp = new File(file);
		try {
			out = new FileOutputStream(temp);
			out.write(bytes);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -2;
		}
		return 0;
	}
	
	public static byte[] getBytesFromFile(File file){
		try {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if(length>Integer.MAX_VALUE){
			System.err.println("file length too big....");
			return null;
		}
		
		byte[] bytes = new byte[(int)length];
		
		int offset = 0 ;
		int numRead = 0;
			while (offset<bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length))>=0){
				offset += numRead;
			}
			if(offset<bytes.length){
				throw new IOException("Could not complete read file:"+file.getName());
			}
			is.close();
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
