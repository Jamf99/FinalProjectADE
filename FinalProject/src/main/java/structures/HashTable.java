package structures;

public class HashTable<P,T> {
	
    private HashEntry<P,T>[] entries;
    
    public HashTable(int entrie) {
    	entries = new HashEntry[entrie];
    }
    
    public void put(P key, T value) {
        int hash = getHash(key);
        final HashEntry<P,T> hashEntry = new HashEntry<P,T>(key, value);
        if(entries[hash] == null) {
            entries[hash] = hashEntry;
        }
        else {
            HashEntry<P,T> temp = entries[hash];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }
    
    public T get(P key) {
        int hash = getHash(key);
        if(entries[hash] != null) {
            HashEntry<P,T> temp = entries[hash];
            while( !temp.key.equals(key)
                    && temp.next != null ) {
                temp = temp.next;
            }
            return temp.value;
        }

        return null;
    }

    private int getHash(P key) {
        return key.hashCode() % entries.length;
    }

    public static class HashEntry<P,T> {
    	private P key;
        private T value;
     
        private HashEntry<P,T> next;

        public HashEntry(P key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        
        public T getValue() {
        	return value;
        }
        
        public P getKey() {
        	return key;
        }
    }
}