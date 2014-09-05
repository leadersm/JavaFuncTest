package image;
import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;


/**
 * 图片缩放
 * @author lsm
 *
 */
public class ImageHandle {
	static String dir = "E:/cygwin/home/Administrator/twsm/舆情";
	
	public static void main(String[] args) {
		File temp = new File(dir);
		for(final File file:temp.listFiles()){
			new Thread(){public void run() {
				try {
					Thumbnails.of(file)
					.scale(0.078f)
					.toFile(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			};}.start();
		}
	}
	
}
