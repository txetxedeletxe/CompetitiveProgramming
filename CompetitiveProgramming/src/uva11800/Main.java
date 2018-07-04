package uva11800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {

	
	static final Comparator<Integer[]> cmp= new Comparator<Integer[]>() {

		@Override
		public int compare(Integer[] o1, Integer[] o2) {
			
			return o1[1].compareTo(o2[1]);
		}};
	
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int cases = Integer.parseInt(str);
		Integer points[][] = new Integer[4][2];
		float vectors[][] = new float[4][2];
		float sideLengths[] = new float[4];
		
		for (int i = 1 ; i <= cases ; i++) {
		
			String figure = null;
			for (int j = 0 ; j < 4 ; j++) {
				
				try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				String[] splited = str.split(" ");
				points[j][0] = Integer.parseInt(splited[0]);
				points[j][1] = Integer.parseInt(splited[1]);
			}
			
			Arrays.sort(points, cmp);
			
			if ((points[0][0] > points[1][0] && points[2][0] < points[3][0]) || (points[0][0] < points[1][0] && points[2][0] > points[3][0])) {
				swap(points,0,1);
			}
			
			
			
			vectors[0][0] = points[1][0] - points[0][0];
			vectors[0][1] = points[1][1] - points[0][1];
			
			vectors[1][0] = points[3][0] - points[2][0];
			vectors[1][1] = points[3][1] - points[2][1];
			
			vectors[2][0] = points[2][0] - points[0][0];
			vectors[2][1] = points[2][1] - points[0][1];
			
			vectors[3][0] = points[3][0] - points[1][0];
			vectors[3][1] = points[3][1] - points[1][1];
			
			
			sideLengths[0] = vectors[0][0]*vectors[0][0] + vectors[0][1]*vectors[0][1];
			sideLengths[1] = vectors[1][0]*vectors[1][0] + vectors[1][1]*vectors[1][1];
			sideLengths[2] = vectors[2][0]*vectors[2][0] + vectors[2][1]*vectors[2][1];
			sideLengths[3] = vectors[3][0]*vectors[3][0] + vectors[3][1]*vectors[3][1];
		
			
			if (sideLengths[0] == sideLengths[1]) {
				if (sideLengths[2] == sideLengths[3]) {
					if (sideLengths[0] == sideLengths[2]) {
						if (dotProduct(vectors[0], vectors[2]) == 0) {
							figure = "Square";
						}
						else {
							figure = "Rhombus";
						}
						
					}
					else {
						if (dotProduct(vectors[0], vectors[2]) == 0) {
							figure = "Rectangle";
						}
						else {
							figure = "Parallelogram";
						}
					}
				}else {
					double dp = dotProduct(vectors[0],vectors[1]);
					if (dp*dp == sideLengths[0]*sideLengths[1]) {
						figure ="Trapezium";
					}
					else {
						dp = dotProduct(vectors[2], vectors[3]);
						if (dp*dp == sideLengths[2]*sideLengths[3]) {
							figure = "Trapezium";
						}
						else
							figure = "Ordinary Quadrilateral";
					}
						
					
				}
			}
			else{
				double dp = dotProduct(vectors[0],vectors[1]);
				if (dp*dp == sideLengths[0]*sideLengths[1]) {
					figure ="Trapezium";
				}
				else {
					dp = dotProduct(vectors[2], vectors[3]);
					if (dp*dp == sideLengths[2]*sideLengths[3]) {
						figure = "Trapezium";
					}
					else
						figure = "Ordinary Quadrilateral";
				}
					
				
			}
			
			
			System.out.println("Case " + i + ": " + figure);
			
		}
		
	}

	private static float dotProduct(float[] ds, float[] ds2) {
		
		return ds[0]*ds2[0] + ds[1]*ds2[1];
	}

	private static void swap(Integer[][] points, int i, int j) {
		
		Integer[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
		
	}

}
