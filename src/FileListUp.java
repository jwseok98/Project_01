import java.io.File;

public class FileListUp {
	
	public static void main(String[] args) {
		File root = new File("D:\\workspaces\\java-sample-worksapce\\samples-java8\\src\\sample");
		StringBuilder buffer = new StringBuilder();
		
		traverse(root, buffer);
		
		System.out.println(buffer);
	}
	
	public static void traverse(File file, StringBuilder buffer) {
		if(file == null || !file.exists()) {
			return;
		}
		
		if(file.isDirectory()) {
			buffer.append(file.getName() + "," + System.lineSeparator());
			
			File[] childs = file.listFiles();
			if(childs != null) {
				for(File child : childs) {
					traverse(child, buffer);
				}
			}
		} else {
			buffer.append("," + file.getName() + System.lineSeparator());
		}
	}
	
	public void selectMember() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA2");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA3");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA6");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA7");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA8");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA9");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA10");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA11");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA12");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA13");
		buffer.append("SELECT * FROM AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA14");
	}
}
