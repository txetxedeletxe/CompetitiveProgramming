package datastruct.tree;

import java.util.Comparator;

public class PQ {

	Comparator<Integer> comp;

	int[] vertexes;
	int[] vertexPosition;

	int nextItem;

	public PQ(int size, Comparator<Integer> comp) {

		this.comp = comp;

		vertexes = new int[size];
		vertexPosition = new int[size];
		nextItem = 0;
	}

	public void add(int v) {
		vertexes[nextItem] = v;
		vertexPosition[v] = nextItem;
		flotate(nextItem);
		nextItem++;
	}

	public boolean isEmpty() {
		return nextItem == 0;
	}

	private void flotate(int item) {

		if (item != 0) {

			int onTop = 0;

			if (item % 2 == 0)
				onTop = (item - 2) / 2;
			else
				onTop = (item - 1) / 2;

			if (comp.compare(vertexes[onTop], vertexes[item]) > 0) {

				int temp = vertexes[onTop];
				vertexes[onTop] = vertexes[item];
				vertexes[item] = temp;

				vertexPosition[vertexes[onTop]] = onTop;
				vertexPosition[vertexes[item]] = item;
				flotate(onTop);
			}

		}

	}

	public int poll() {

		int temp = vertexes[0];
		nextItem--;
		vertexes[0] = vertexes[nextItem];
		vertexPosition[vertexes[0]] = 0;
		sink(0);

		return temp;
	}

	private void sink(int item) {

		if (item * 2 + 1 < nextItem) {

			int bot = item * 2 + 1;

			if (item * 2 + 2 < nextItem && comp.compare(vertexes[bot], vertexes[item * 2 + 2]) > 0)
				bot += 1;

			if (comp.compare(vertexes[bot], vertexes[item]) < 0) {

				int temp = vertexes[bot];
				vertexes[bot] = vertexes[item];
				vertexes[item] = temp;

				vertexPosition[vertexes[bot]] = bot;
				vertexPosition[vertexes[item]] = item;

				sink(bot);
			}

		}

	}

	public void update(int visited) {

		flotate(vertexPosition[visited]);
	}
	
	public static void main(String[] args) {
		
		
		PQ pq = new PQ(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				
				return arg0 - arg1;
			}
		});
		
		for (int i = 0 ; i < 10 ; i++) {
			pq.add(i);
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			pq.add(i);
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
}
