package uva11800;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	
	static double lastAngle = 0;
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String  str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int cases = Integer.parseInt(str);
		Integer points[][] = new Integer[4][2];
		int vectors[][] = new int[4][2];
		int sideLengths[] = new int[4];
		
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
			
			swap(points,0,maxX(points));
			sort(points);
			
			
			
			vectors[0][0] = points[1][0] - points[0][0];
			vectors[0][1] = points[1][1] - points[0][1];
			
			vectors[1][0] = points[2][0] - points[1][0];
			vectors[1][1] = points[2][1] - points[1][1];
			
			vectors[2][0] = points[3][0] - points[2][0];
			vectors[2][1] = points[3][1] - points[2][1];
			
			vectors[3][0] = points[0][0] - points[3][0];
			vectors[3][1] = points[0][1] - points[3][1];
			
			
			sideLengths[0] = vectors[0][0]*vectors[0][0] + vectors[0][1]*vectors[0][1];
			sideLengths[1] = vectors[1][0]*vectors[1][0] + vectors[1][1]*vectors[1][1];
			sideLengths[2] = vectors[2][0]*vectors[2][0] + vectors[2][1]*vectors[2][1];
			sideLengths[3] = vectors[3][0]*vectors[3][0] + vectors[3][1]*vectors[3][1];
		
			
			if (sideLengths[0] == sideLengths[2] && sideLengths[1] == sideLengths[3]) {
				
				if (sideLengths[0] == sideLengths[1]) {
					
					if (perpendicular(vectors[0],vectors[1])) {
						figure = "Square";
					}
					else {
						figure = "Rhombus";
					}
				}
				else {
					
					if (perpendicular(vectors[0],vectors[1])) {
						figure = "Rectangle";
					}
					else {
						figure = "Parallelogram";
					}
				}
			}
			else {
				
				if (parallel(vectors[0], vectors[2])|| parallel(vectors[1], vectors[3]))
					figure = "Trapezium";
				else
					figure = "Ordinary Quadrilateral";
			}
			
			try {
				bw.write("Case " + i + ": " + figure + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static int maxX(Integer[][] points) {
		
		int max = 0;
		for (int i = 0 ; i < points.length ; i++) {
			
			if (earlier(points[i],points[max]))
				max = i;
		}
		return max;
	}

	private static boolean earlier(Integer[] integers, Integer[] integers2) {
		
		
			return integers[0] > integers2[0];
		
	}

	private static void sort(Integer[][] points) {
		
		lastAngle = 0;
		int sp = ccwisePoint(points, 0);
		swap(points, 1, sp);
		sp = ccwisePoint(points, 1);
		swap(points, 2, sp);
		
		
	}

	private static int dotProduct(int[] ds, int[] ds2) {
		
		return ds[0]*ds2[0] + ds[1]*ds2[1];
	}

	private static int crossProduct(int[] ds, int[] ds2) {
		
		return ds[0]*ds2[1] - ds[1]*ds2[0];
	}
	
	private static boolean parallel(int[] ds, int[] ds2) {
		return crossProduct(ds, ds2) == 0;
	}
	
	private static boolean perpendicular(int[] ds, int[] ds2) {
		return dotProduct(ds, ds2) == 0;
	}
	
	private static void swap(Integer[][] points, int i, int j) {
		
		Integer[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
		
	}
	
	private static int ccwisePoint(Integer[][] points, int spoint) {
		
		double angle = Double.POSITIVE_INFINITY;
		int smallest = spoint+1;
		for (int i = smallest ; i < points.length ; i++) {
			
			double nangle = angleAt(points[spoint],points[i]);
			if (nangle < angle) {
				angle = nangle;
				smallest = i;
			}
		}
		
		lastAngle += angle;
		return smallest;
	}

	private static double angleAt(Integer[] integers, Integer[] integers2) {
		
		double tan1 = Math.atan2(integers2[1] - integers[1], integers2[0] - integers[0]);
		
		tan1 -= lastAngle;
		
		if (tan1 < 0)
			tan1 += 2*Math.PI;
		
		return tan1;
	}



}
