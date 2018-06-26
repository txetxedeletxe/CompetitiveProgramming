package uva10420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Main {

	static final Comparator<String> stringComparator = new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			
			return o1.compareTo(o2);
		}
	};
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int nConq = Integer.parseInt(s);
		
		ArrayList<String> as = new ArrayList<String>();
		Map<String,Integer> countPerC = new HashMap<String,Integer>();
		
		for (int i = 0 ; i < nConq ; i++) {
			
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String country = s.split(" ")[0];
			
			if (!countPerC.containsKey(country)) {
				as.add(country);
				countPerC.put(country, 1);
				
			}
			else {
				countPerC.put(country, countPerC.get(country)+1);
			}
		}
		
		as.sort(stringComparator);

		for (String si : as) {
			
			System.out.println(si + " " + countPerC.get(si));
			
		}
		
	}

}
