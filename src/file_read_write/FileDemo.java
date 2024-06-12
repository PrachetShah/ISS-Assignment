package file_read_write;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		File f = null;
		String[] strs = {"test1.txt", "test2.txt"};
		try {
			// for each string in array
			for(String str: strs) {
				// create a new file
				f = new File(str);
				
				// true if file is executable
				boolean bool = f.canExecute();
				System.out.println("Is File Executable: " + bool);
				
				// find absolute path
				String a = f.getAbsolutePath();
				System.out.println("Absolute Path: " + a);
				
				// get path name
				String g = f.getPath();
				System.out.println("Path: " + g);
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
