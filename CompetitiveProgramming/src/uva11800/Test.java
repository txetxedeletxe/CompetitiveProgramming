package uva11800;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {

	
	public static void main(String[] args) {
		
		File f = new File("/home/sophy/git/CompetitiveProgramming/CompetitiveProgramming/src/uva11800/test.txt");
		System.out.println(f.exists());
		try {
			FileInputStream fis = new FileInputStream(f);
			System.setIn(fis);
			long ct = System.currentTimeMillis();
			Main.main(null);
			System.out.println( System.currentTimeMillis() - ct);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
 