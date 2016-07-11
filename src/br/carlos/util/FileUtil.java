package br.carlos.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static void saveFile(String path, MultipartFile file) {
		File saveFile = new File(path);

		try {
			FileUtils.writeByteArrayToFile(saveFile, file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
