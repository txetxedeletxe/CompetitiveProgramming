package uva11616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

	static Map<Character,Integer> conversionMap;
	static Map<Character,Integer> conversionMap2;
	static Map<Character,String>[] conversions;
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		build();
		try {
			while ((str = br.readLine()) != null) {
				String printend = null;
				try {
					Integer.parseInt(str);
					printend = toRoman(str);
					
				} catch (NumberFormatException e) {
					printend = toArabic(str);
				}
				
				System.out.println(printend);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void build() {
		
		conversionMap = new HashMap<Character,Integer>();
		
		conversionMap.put('M', 1000);
		conversionMap.put('D', 500);
		conversionMap.put('C', 100);
		conversionMap.put('L', 50);
		conversionMap.put('X', 10);
		conversionMap.put('V', 5);
		conversionMap.put('I', 1);
		
		conversionMap2 = new HashMap<Character,Integer>();
		
		conversionMap2.put('M', 800);
		conversionMap2.put('D', 300);
		conversionMap2.put('C', 80);
		conversionMap2.put('L', 30);
		conversionMap2.put('X', 8);
		conversionMap2.put('V', 3);
		
		conversions = new Map[4];
		conversions[0] = new HashMap<Character,String>();
		conversions[0].put('1', "I");
		conversions[0].put('2', "II");
		conversions[0].put('3', "III");
		conversions[0].put('4', "IV");
		conversions[0].put('5', "V");
		conversions[0].put('6', "VI");
		conversions[0].put('7', "VII");
		conversions[0].put('8', "VIII");
		conversions[0].put('9', "IX");
		
		
	}

	private static String toArabic(String roman) {
		
		int sum = 0;
		int last = Integer.MAX_VALUE;
		
		for (int i = 0 ; i < roman.length() ; i++) {
			char charat = roman.charAt(i);
			int converted = conversionMap.get(charat);
			
			if (converted > last) {
				converted = conversionMap2.get(charat);
				
			}
			
			sum += converted;
			last = converted;
		}
		
		return String.valueOf(sum);
	}
	
	private static String toRoman(String arabic) {
		
		StringBuilder returnend = new StringBuilder();
		
		for (int i = arabic.length() ; i > 0 ; --i) {
			
		}
	}

}
