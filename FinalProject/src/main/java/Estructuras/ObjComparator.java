package Estructuras;

import java.util.Comparator;

public class ObjComparator<E extends Comparable<E>> implements Comparator<Object[]>{
	@Override
	public int compare(Object[] o1, Object[] o2) {
		E a=(E)o1[0];
		E b=(E)o2[0];
		return a.compareTo(b);
	}
}
