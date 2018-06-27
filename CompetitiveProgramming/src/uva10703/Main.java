package uva10703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

	static class BoardRecorder{
		
		int width;
		int height;
		boolean[][] board;
		int freeSpots;
		public BoardRecorder(int width, int height) {
			
			this.width = width;
			this.height = height;
			this.freeSpots = width*height;
			this.board = new boolean[height][width];
		}

		public void add(int[] coordenates) {
			
			
			int x1;
			int x2;
			int y1;
			int y2;
			
			if (coordenates[0] < coordenates[2]) {
				x1 = coordenates[0] - 1;
				x2 = coordenates[2];
			}
			else {
				x1 = coordenates[2] - 1;
				x2 = coordenates[0];
			}
			
			if (coordenates[1] < coordenates[3]) {
				y1 = coordenates[1] -1;
				y2 = coordenates[3];
			}
			else {
				y1 = coordenates[3] -1;
				y2 = coordenates[1];
			}
			
			for (int i = y1; i < y2 ; i++) {
				for (int j = x1 ; j < x2 ; j++) {
					
					freeSpots -= (board[i][j]) ? 0 : 1;
					board[i][j] = true;
				}
			}
			
		}

		public int freeSpots() {
			// TODO Auto-generated method stub
			return freeSpots;
		}
		
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		String[] splitedS ;
		
		while (true) {
		
			
			
			try {
				readLine = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			splitedS = readLine.split(" ");
			
			int width = Integer.parseInt(splitedS[0]);
			int height = Integer.parseInt(splitedS[1]);
			int count = Integer.parseInt(splitedS[2]);
			
			if (width == 0 && height == 0 && count == 0) {
				return;
			}
			
			BoardRecorder boardR = new BoardRecorder(width, height);
			
			for (int i = 0; i < count ; i++) {
				
				try {
					readLine = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				splitedS = readLine.split(" ");
				
				int[] coordenates = new int[4];
				
				
					
				coordenates[0] = Integer.parseInt(splitedS[0]);
				coordenates[1] = Integer.parseInt(splitedS[1]);
				coordenates[2] = Integer.parseInt(splitedS[2]);
				coordenates[3] = Integer.parseInt(splitedS[3]);
				
				boardR.add(coordenates);
				
				
				
				
			}
			
			int freeSpots = boardR.freeSpots();
			
			if (freeSpots == 0) {
				System.out.println("There is no empty spots.");
			}
			else if (freeSpots == 1){
				System.out.println("There is one empty spot.");
			}
			else
				System.out.println("There are " + freeSpots + " empty spots.");
			
			try {
				br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}

}
