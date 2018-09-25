package uva11239;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str = br.readLine();
			
			
			while (!str.equals("0")) {
				
				Map<String,Object[]> studentMap = new HashMap<>();
				
				List<Object[]> projectList = new ArrayList<>();
				
				Object[] theProject = null;
				
				Object[] marginatedStudent = new Object[]{};
				
				while (!str.equals("1")) {
					
					if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')
					{
						theProject = new Object[] {str,0};
						projectList.add(theProject);
				
					}
					else {
						
						if (studentMap.containsKey(str)) {
							
							Object[] project = studentMap.get(str);
							
							
							if (project != marginatedStudent && !project[0].equals(theProject[0])) {
								
								
								project[1] = (int)project[1] - 1; 
								studentMap.put(str, marginatedStudent);
								
							}
						}
						else {
							studentMap.put(str, theProject);
							theProject[1] = (int)theProject[1] + 1;
						}
					}
					
					str = br.readLine();
				}
				
				Collections.sort(projectList, new Comparator<Object[]>() {

					@Override
					public int compare(Object[] o1, Object[] o2) {
						
						if (o1[1] == o2[1]){
							return ((String)o1[0]).compareTo((String)o2[0]);
						}
						else {
							return  (int)o2[1] - (int)o1[1];
						}
					}

				});
				
				for (Object[] oa : projectList) {
				
					bw.write(oa[0] + " " + oa[1] + "\n");
				}
				
				str = br.readLine();
			}
			bw.flush();
		}catch(IOException e) {}
	}

}
