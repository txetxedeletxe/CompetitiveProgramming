package uva10226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			String str = br.readLine();
			br.readLine();
			int caseCount = Integer.parseInt(str);
			
			for (int caseIndex = 0 ; caseIndex < caseCount ;  caseIndex++ ) {
				
				if (caseIndex != 0)
					bw.write("\n");
				
				Map<String,Integer> treeMap = new HashMap<String,Integer>();
				List<String> treeList = new ArrayList<String>();
				int treeCount = 0;
				
				str = br.readLine();
				while(str != null) {
					
					if (str.equals(""))
						break;
					
					treeCount++;
					
					if (!treeMap.containsKey(str)) {
						treeMap.put(str, 0);
						treeList.add(str);
					}
					
					treeMap.put(str, treeMap.get(str)+1);
					
					str = br.readLine();
					
				}
				
				Collections.sort(treeList, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						
						return o1.compareTo(o2);
					}
					
				});
				
				for (String s : treeList) {
					
					float perc = ((float)treeMap.get(s))/treeCount*100;
					bw.write(s + String.format(" %.4f\n", perc));
					
				}
				
			}
			bw.flush();
		}catch(IOException e) {}
	}

}
