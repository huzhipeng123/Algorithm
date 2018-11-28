package utils.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 编码转换工具类
 * @author Administrator
 *
 */
public class CodeConversionUtil {
	
	/**
	 * 获取源路径下所有的文件，并对所有文件执行编码转换
	 * @param srcFolder 源路径
	 * @param oldCode 转换前编码
	 * @param newCode 转换后编码
	 * @throws FileNotFoundException 
	 */
	public static void getAllFilePaths(File srcFolder, String oldCode, String newCode) throws FileNotFoundException {
		//获取该目录下所有的文件或者文件夹的File数组
		File[] fileArray = srcFolder.listFiles();
		
		//遍历该File数组，得到每一个File对象
		for(File file : fileArray) {
			//继续判断是否是文件夹，如果是文件夹的话递归调用getAllFilePaths
			if(file.isDirectory()) {
				getAllFilePaths(file, oldCode, newCode);
			}else {
				//如果是文件，调用编码转换
				codeConversion(file, oldCode, newCode);
			}
		}
	}

	/**
	 * 编码转换
	 * @param file 目标文件
	 * @param oldCode 转换前编码
	 * @param newCode
	 * @throws FileNotFoundException 
	 */
	private static void codeConversion(File file, String oldCode, String newCode) throws FileNotFoundException {
		//以oldCode格式读取文件
		FileInputStream fis = new FileInputStream(file);
	
	}
	
}
