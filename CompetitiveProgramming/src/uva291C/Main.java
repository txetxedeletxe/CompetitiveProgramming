package uva291C;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) {
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			bw.write("123153452\n" + 
					"123154352\n" + 
					"123451352\n" + 
					"123453152\n" + 
					"123513452\n" + 
					"123543152\n" + 
					"125134532\n" + 
					"125135432\n" + 
					"125315432\n" + 
					"125345132\n" + 
					"125431532\n" + 
					"125435132\n" + 
					"132153452\n" + 
					"132154352\n" + 
					"132534512\n" + 
					"132543512\n" + 
					"134512352\n" + 
					"134512532\n" + 
					"134521532\n" + 
					"134523512\n" + 
					"134532152\n" + 
					"134532512\n" + 
					"135123452\n" + 
					"135125432\n" + 
					"135215432\n" + 
					"135234512\n" + 
					"135432152\n" + 
					"135432512\n" + 
					"152134532\n" + 
					"152135432\n" + 
					"152345312\n" + 
					"152354312\n" + 
					"153123452\n" + 
					"153125432\n" + 
					"153213452\n" + 
					"153254312\n" + 
					"153452132\n" + 
					"153452312\n" + 
					"154312352\n" + 
					"154312532\n" + 
					"154321352\n" + 
					"154325312\n" + 
					"154352132\n" + 
					"154352312\n" + 
					"");
			bw.flush();
		}catch(IOException e) {}
	}

}
