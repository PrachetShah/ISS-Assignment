package file_read_write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/*
 * We can create files in Java in multiple ways:
 * 1. Using FileOutputStream() constructor
 * 2. Using File.createNewFile() method
 * 3. Using Files.write() method
 */

public class CreatingFiles {

	public static void main(String[] args) {
		/*
		 * create file using FileOutputStream()
		 * he stream would create a file, if it doesn't already exist, before opening it for output
		 * 
		 * 2 ways to create are by:
		 *  -1 OutputStream o = new FileOutputStream(path);
		 *  -2 File f = new File(path);
		 *    OutputStream o = new FileOutputStream(f);
		 */
		try {
			// writing file
			byte bWrite[] = {65,66,67,68,69};
			OutputStream os = new FileOutputStream("file_read_write\\test1.txt");
			for(int i = 0; i<bWrite.length; i++) {
				os.write(bWrite[i]);
			}
			os.close();
			
			// reading file
			InputStream is = new FileInputStream("file_read_write\\test1.txt");
			int size = is.available();

			for(int i = 0; i < size; i++) {
				System.out.print((char)is.read() + "  ");
			}
			is.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 2. Using File.createNewFile() method
		 */
		try {
			System.out.println("\n\n");
			File f = new File("file_read_write\\test2.txt");
			// create the file, .createNewFile() return true if file gets created
			if(f.createNewFile()) {
				System.out.println("New File Created using Method 2");
			}else {
				System.out.println("File not created");
			}
			
			// write content, to append, add true as second arg in writer
			FileWriter writer = new FileWriter(f);
			writer.write("Test Data");
			writer.write("\nData 2");
			writer.close();
			
			// read content
			FileReader reader = new FileReader(f);
			int c;
			while((c =reader.read()) != -1) {
				char ch = (char) c;
				System.out.print(ch);
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 3. Using Files.write() method
		 * Paths.get() gets error in Eclipse so avoid using it in Eclipse, or use javac to compile
		 * does not run, try to avoid
		 */
		try {
			String data = "test data 3";
//			Files.write(Paths.get("file_read_write//test3.txt"), data.getBytes());
			List<String> lines = Arrays.asList("1 line", "2 line");
//			Files.write(Paths.get("file_read_write//test3.txt"), lines, 
//				StandardCharsets.UTF_8, 
//				StandardOpenOption.CREATE, 
//				StandardOpenOption.APPEND);
//			List<String> content = Files.readAllLines(Paths.get("file_read_write//test3.txt"));
//			System.out.println("\n" + content);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
		
	}

}
