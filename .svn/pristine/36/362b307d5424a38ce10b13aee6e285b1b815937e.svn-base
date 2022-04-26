package sample.dataflow.pathtraversalandresourceinjection;

public class DownloadValidator {
	
	
	public static boolean checkRelativePath(String path) {
		return path.contains("../") || path.contains("..\\");
	}
	
	public static String getFileName(String fileName) {
		return fileName.replace("../", "").replace("..\\", "");
	}
}
