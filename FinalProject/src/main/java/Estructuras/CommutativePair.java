package Estructuras;

import java.util.HashSet;

public class CommutativePair<K,V> {
	HashSet<Object>values;
	private K key;
	private V value;
	public CommutativePair(K k,V v) {
		key=k;
		value=v;
		values=new HashSet<Object>();
		values.add(key);
		values.add(value);
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return values.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		CommutativePair<K,V> p=(CommutativePair<K,V>)obj;
		if((key.equals(p.key)&&value.equals(p.value)) || (key.equals(p.value)&&value.equals(p.key))) {
			return true;
		}
		return false;
	}
	
}
