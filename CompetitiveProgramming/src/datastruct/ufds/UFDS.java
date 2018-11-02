package datastruct.ufds;

public class UFDS {

	int[] elemRep;
	int numSets;
	int[] sizes;
	public UFDS(int elementCount) {
		
		elemRep = new int[elementCount];
		sizes = new int[elementCount];
		
		for (int i = 0 ; i < elementCount ; i++) {
			elemRep[i] = i;
			sizes[i] = 1;
		}
		
		numSets = elementCount;
	}
	
	public int findSet(int element) {
		
		return (elemRep[element] == element) ? element : (elemRep[element] = findSet(elemRep[element]));
	}
	
	public void unionSet(int elem1, int elem2) {
		
		if (!sameSet(elem1,elem2)) {
			numSets--;
			sizes[findSet(elem1)] += sizes[findSet(elem2)]; 
		}
		
		elemRep[findSet(elem2)] = findSet(elem1);
		
	}
	
	public boolean sameSet(int elem1, int elem2) {
		return findSet(elem1) == findSet(elem2);
	}
	
	public int sizeOfSet(int element) {
		
		int set = findSet(element);
		return sizes[set];
	}
	
}
