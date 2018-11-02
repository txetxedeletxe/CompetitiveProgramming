package datastruct.tree;

public class SegmentTree<T> {

	PropertySelector<T> ph;
	
	T rootProperty;
	SegmentTree<T> leftStree;
	SegmentTree<T> rightStree;
	
	int lbound;
	int rbound;
	
	public SegmentTree(T[] segmentationArray, PropertySelector<T> ph) {
		SegmentTree<T> st = new SegmentTree<T>(segmentationArray, ph,0,segmentationArray.length);
		
		this.ph = st.ph;
		this.rootProperty = st.rootProperty;
		this.leftStree = st.leftStree;
		this.rightStree = st.rightStree;
		this.lbound = st.lbound;
		this.rbound = st.rbound;
	
	}
	
	public SegmentTree(T[] segmentationArray, PropertySelector<T> ph, int lbound, int rbound) {
		
		this.ph = ph;
		
		this.lbound = lbound;
		this.rbound = rbound;
		
		
		if (segmentationArray.length == 1) {
			rootProperty = segmentationArray[0];
			leftStree = null;
			rightStree = null;
		}
		else {
			
			T[] leftSa = (T[]) new Object[segmentationArray.length/2];
			T[] rightSa = (T[]) new Object[segmentationArray.length - leftSa.length];
		
			
			for (int i = 0 ; i < leftSa.length ; i++) {
				
				leftSa[i] = segmentationArray[i];
			}
			
			for (int i = 0 ; i < rightSa.length ; i++) {
				
				rightSa[i] = segmentationArray[i + leftSa.length];
			}
			
			leftStree = new SegmentTree<>(leftSa, ph,lbound,lbound+leftSa.length);
			rightStree = new SegmentTree<>(rightSa, ph,lbound+leftSa.length,rbound);
			
			rootProperty = ph.selectProperty(leftStree.rootProperty, rightStree.rootProperty);
			
			
		}	
		
		
	}
	
	public T query(int lbound,int rbound) {
		
		if (this.lbound == lbound && this.rbound == rbound) {
			return rootProperty;
		}
		else {
			
			if (leftStree != null && leftStree.containsInterval(lbound, rbound)) {
				return leftStree.query(lbound, rbound);
			}
			else if (rightStree.containsInterval(lbound, rbound)) {
				return rightStree.query(lbound, rbound);
			}
			else {
				T ql = leftStree.query(lbound, leftStree.rbound);
				T qr = rightStree.query(rightStree.lbound, rbound);
				return ph.selectProperty(ql, qr);
			}
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[" + lbound + ":" + rbound + "]:");
		sb.append(rootProperty);
		
		if (leftStree != null) {
			sb.append("," + leftStree.toString());
		}
		if (rightStree != null) {
			sb.append("," + rightStree.toString());
		}
		
		return sb.toString();
	}
	
	private boolean containsInterval(int lbound, int rbound) {
		
		return this.lbound <= lbound && this.rbound >= rbound;
	}
	
	
	public static void main(String[] args) {
		
		PropertySelector<Integer> ps = new PropertySelector<Integer>() {
			
			@Override
			public Integer selectProperty(Integer t1, Integer t2) {
				
				return Integer.max(t1, t2);
			}
		};
		
		
		SegmentTree<Integer> st = new SegmentTree<>(new Integer[] {10,2,7,43,13},ps);
		System.out.println(st);
		
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = i+1 ; j < 6 ; j++) {
				System.out.println(i + "," + j + ":" + st.query(i, j));
			}
		}
		
	}
	
}
