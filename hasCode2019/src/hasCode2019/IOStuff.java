package hasCode2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOStuff {
	public static List<String> loadMainInputFile() {
		List<String> readAllLines = new ArrayList<String>();
		
		Path path = Paths.get("/home/zornch/Desktop/test123");
		try {
			readAllLines = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readAllLines;
	}
	
	public void writeOut() {

	}
}
