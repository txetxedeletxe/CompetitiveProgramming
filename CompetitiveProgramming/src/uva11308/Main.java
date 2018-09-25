package uva11308;

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
			
			int caseCount = Integer.parseInt(str);
			
			for (int caseIndex = 0 ; caseIndex < caseCount ; caseIndex++) {
				
				str = br.readLine();
				bw.write(str.toUpperCase()+"\n");
				
				str = br.readLine();
				String[] splitend = str.split(" ");
				
				int ingredientCount = Integer.parseInt(splitend[0]);
				int recipeCount = Integer.parseInt(splitend[1]);
				int budget = Integer.parseInt(splitend[2]);
				
				Map<String,Integer> ingredientMap = new HashMap();
				List<Object[]> recipeList = new ArrayList<>();
				
				for (int ingredientIndex = 0 ; ingredientIndex < ingredientCount ; ingredientIndex++) {
					
					str = br.readLine();
					splitend = str.split(" ");
					
					ingredientMap.put(splitend[0], Integer.parseInt(splitend[1]));
					
					
				}
				
				for (int recipeIndex = 0 ; recipeIndex < recipeCount ; recipeIndex++) {
					
					String recipeName = br.readLine();
					
					str = br.readLine();
					int recipeIngredientCount = Integer.parseInt(str);
					
					int totalCost = 0;
					
					for (int recipeIngredientIndex = 0 ; recipeIngredientIndex < recipeIngredientCount ; recipeIngredientIndex++) {
						
						str = br.readLine();
						
						splitend = str.split(" ");
						
						if (totalCost <= budget)
							totalCost += ingredientMap.get(splitend[0])*Integer.parseInt(splitend[1]);
						
					}
					
					if (totalCost <= budget)
						recipeList.add(new Object[] {recipeName,totalCost});
					
				}
				
				Collections.sort(recipeList, new Comparator<Object[]>() {

					@Override
					public int compare(Object[] o1, Object[] o2) {


						if (o1[1] == o2[1]) {
							return ((String)o1[0]).compareTo((String)o2[0]);
						}
						else {
							return (int)o1[1] - (int)o2[1];
						}
						
						
					}
				});
				
				if (recipeList.size() == 0)
					bw.write("Too expensive!\n");
				
				for (Object[] obj : recipeList) {
					bw.write(obj[0] + "\n");
				}
				bw.write('\n');
			}
			bw.flush();
			
		}catch(IOException e) {}
	}

}
