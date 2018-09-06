package uva127;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Stack;

class Main {

	static class Accordian{
		
		Deck tail;
		int decks;
		int lastDeckIndex;
		
		PriorityQueue<Deck> pq; 
		boolean[] markUpArray;
		
		class Deck implements Comparable<Deck>{
			
			Stack<String> stack;
			Deck left;
			Deck right;
			int deckIndex;
			public Deck(String firstElement,int deckIndex){
				stack = new Stack<>();
				stack.push(firstElement);
				this.deckIndex = deckIndex;
			}
			
			@Override
			public int compareTo(Deck o) {
				
				return this.deckIndex - o.deckIndex;
			}
			
			
		}
		
		public Accordian() {
			
			tail = null;
			decks = 0;
			lastDeckIndex = 0;
			pq = new PriorityQueue<>();
			markUpArray = new boolean[52];
		}
		
		
		public void addCard(String card) {
			
			Deck nDeck = new Deck(card,lastDeckIndex++);
			
			if (tail == null) {
				tail = nDeck;
			}
			else {
				tail.right = nDeck;
				nDeck.left = tail;
				tail = nDeck;
			}
			decks++;
			
			enqueue(nDeck);
			

			while (!pq.isEmpty()) {
				
				Deck nextDeck = dequeue();
				
				updateDeck(nextDeck);
				
				
			}
		}


		private Deck dequeue() {
			
			Deck nextDeck = pq.poll();
			markUpArray[nextDeck.deckIndex] = false;
			return nextDeck;
		}


		private void enqueue(Deck nDeck) {
			
			if (!markUpArray[nDeck.deckIndex]) {
				markUpArray[nDeck.deckIndex] = true;
				pq.add(nDeck);
			}
			
		}


		private void updateDeck(Deck deck) {
			
			
			if (deck.left != null) {
				
				if (deck.left.left != null && 
						deck.left.left.left != null && 
						matches(deck.stack.peek(), deck.left.left.left.stack.peek())) {
					
					move(deck,deck.left.left.left);
					
				}else if (matches(deck.stack.peek(), deck.left.stack.peek())){
					move(deck,deck.left);
					
				}
			}
		}
		


		private void move(Deck out, Deck in) {
			
			in.stack.push(out.stack.pop());
			
			if (out.stack.isEmpty()) {
				decks--;
				if (tail == out) {
					tail = out.left;
				}
				else {
					out.right.left = out.left;
				}
				
				out.left.right = out.right;
				remove(out);
				enqueue(in);
				
				if (in.right != null) {
					
					enqueue(in.right);
					
					if (in.right.right != null && in.right.right.right != null) {
						enqueue(in.right.right.right);
					}
					
					if (out.right != null) {
						enqueue(out.right);
						
						if (out.right.right != null) {
							enqueue(out.right.right);
							
							if (out.right.right.right != null)
								enqueue(out.right.right.right);
						}
					}
				}
				
				
			}
			else {
				
				enqueue(in);
				enqueue(in.right);
				
				if (in.right.right != null && in.right.right.right != null)
					enqueue(in.right.right.right);
				
				enqueue(out);
				if (out.right != null) {
					enqueue(out.right);
				
					if (out.right.right != null && out.right.right.right != null)
						enqueue(out.right.right.right);
				}
			}
		}


		private void remove(Deck out) {
		
			pq.remove(out);
			markUpArray[out.deckIndex] = true;
			
		}


		private boolean matches(String c1, String c2) {
			
			return c1.charAt(0) == c2.charAt(0) || c1.charAt(1) == c2.charAt(1);
		}


		public Stack<String>[] getDecks() {
			
			Stack<String>[] allDecks = new Stack[decks];
			Deck d = tail;
			
			for (int i = decks-1 ; i >= 0 ; i--) {
				allDecks[i] = d.stack;
				d = d.left;
				
			}
			
			return allDecks;
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			String str;
			
			while (true) {
				
				str = br.readLine();
				
				if (str.equals("#")) {
					break;
				}
				
				Accordian acc = new Accordian();
				String[] splitend = str.split(" ");
				
				for (String card : splitend) {
					acc.addCard(card);
				}
				
				str = br.readLine();
				
				splitend = str.split(" ");
				
				for (String card : splitend) {
					acc.addCard(card);
				}
				
			
				Stack<String>[] decks = acc.getDecks();
				
				bw.write(String.valueOf(decks.length));
				
				if (decks.length == 1) {
					bw.write(" pile remaining:");
				}
				else {
					bw.write(" piles remaining:");
				}
				
				for (Stack<String> sts : decks) {
					bw.write(" " + sts.size());
				}
				
				bw.write('\n');
			
			}
			bw.flush();
		}catch(IOException e) {}
	}

}
