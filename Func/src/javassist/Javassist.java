package javassist;

import java.io.IOException;

/**
 * 破解Jword
 * @author lsm
 *
 */
public class Javassist {

	public static void main(String[] args) {
		ClassPool pool = ClassPool.getDefault();
		try {
//			pool.insertClassPath("E://download/JWord/jword-1.0.jar");
			pool.insertClassPath("./jword-1.0.jar");
			CtClass cc = pool.get("com.independentsoft.office.word.a");
			
			CtMethod cm = cc.getDeclaredMethod("a", new CtClass[]{});
			
			System.out.println(cm.toString());
			
			cc.removeMethod(cm);
			
			CtMethod cm1 = CtNewMethod.make("public static void a(){" +
					"System.out.println(\"hello yunTianYi..\");"+
					"return;}", cc);
			cc.addMethod(cm1);
			
//			cc.writeFile("E://download/JWord/");
			cc.writeFile("./JWord/");
			
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
	}
}
