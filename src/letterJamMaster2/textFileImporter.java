package letterJamMaster2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;

public class textFileImporter {
	
	public static List<String> array(String filePath) {
		
		List<String> lines = Collections.emptyList();
	    try {
	      lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
	    } catch (IOException e) {
	      System.out.print("oopsies, we ended up in this IO exception I don't understand!  ");
	      e.printStackTrace();
	    }
	    return(lines);
	}

}
