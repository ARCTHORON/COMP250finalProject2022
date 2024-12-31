package finalproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashTable<K,V> implements Iterable<MyPair<K,V>>{
	// num of entries to the table
	private int size;
	// num of buckets 
	private int capacity = 16;
	// load factor needed to check for rehashing 
	private static final double MAX_LOAD_FACTOR = 0.75;
	// ArrayList of buckets. Each bucket is a LinkedList of HashPair
	private ArrayList<LinkedList<MyPair<K,V>>> buckets; 


	// constructors
	public MyHashTable() {
		// ADD YOUR CODE BELOW THIS
		this(16);
		//ADD YOUR CODE ABOVE THIS
	}

	public MyHashTable(int initialCapacity) {
		// ADD YOUR CODE BELOW THIS
		this.size=0;
		this.buckets=new ArrayList<LinkedList<MyPair<K,V>>>(initialCapacity);
		for(int i=0; i<initialCapacity; i++){
			buckets.add(new LinkedList<MyPair<K, V>>());
		}
		this.capacity=initialCapacity;
		//ADD YOUR CODE ABOVE THIS
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int numBuckets() {
		return this.capacity;
	}

	/**
	 * Returns the buckets variable. Useful for testing  purposes.
	 */
	public ArrayList<LinkedList< MyPair<K,V> > > getBuckets(){
		return this.buckets;
	}

	/**
	 * Given a key, return the bucket position for the key. 
	 */
	public int hashFunction(K key) {
		int hashValue = Math.abs(key.hashCode())%this.capacity;
		return hashValue;
	}

	/**
	 * Takes a key and a value as input and adds the corresponding HashPair
	 * to this HashTable. Expected average run time  O(1)
	 */
	public V put(K key, V value) {
		//  ADD YOUR CODE BELOW HERE

		MyPair<K, V> input =new MyPair<K, V>(key, value);
		int index = hashFunction(key);
		if (this.buckets.get(index).isEmpty()){
			this.buckets.get(index).add(input);
			size+=1;
			if (((float)size)/capacity>MAX_LOAD_FACTOR){
					this.rehash();
			}
		} else{
			for (MyPair<K, V> node:this.buckets.get(index)){
				if (node.getKey().equals(key)){
					MyPair<K, V> tmp=node;
					this.buckets.get(index).remove(node);
					this.buckets.get(index).add(input);
					return tmp.getValue();
				}
			}
			this.buckets.get(index).add(input);
			size+=1;
			if (((float)size)/capacity>MAX_LOAD_FACTOR){
				this.rehash();
			}
			return null;
		}
		return null;

		//  ADD YOUR CODE ABOVE HERE
	}


	/**
	 * Get the value corresponding to key. Expected average runtime O(1)
	 */

	public V get(K key) {
		//ADD YOUR CODE BELOW HERE

		if (this.buckets.get(hashFunction(key)).isEmpty()){
			return null;
		} else{
			LinkedList<MyPair<K,V>> inner=this.buckets.get(hashFunction(key));
			for (MyPair<K,V> node:inner){
				if (node.getKey().equals(key)){
					return node.getValue();
				}
			}
			return null;
		}

		//ADD YOUR CODE ABOVE HERE
	}

	/**
	 * Remove the HashPair corresponding to key . Expected average runtime O(1) 
	 */
	public V remove(K key) {
		//ADD YOUR CODE BELOW HERE

		if (this.buckets.get(hashFunction(key)).isEmpty()){
			return null;
		} else{
			LinkedList<MyPair<K,V>> inner=this.buckets.get(hashFunction(key));
			for (MyPair<K,V> node:inner){
				if (node.getKey().equals(key)){
					V val=node.getValue();
					buckets.get(hashFunction(key)).remove(node);
					size-=1;
					return val;
				}
			}
			return null;
		}

		//ADD YOUR CODE ABOVE HERE
	}


	/** 
	 * Method to double the size of the hashtable if load factor increases
	 * beyond MAX_LOAD_FACTOR.
	 * Made public for ease of testing.
	 * Expected average runtime is O(m), where m is the number of buckets
	 */
	public void rehash() {
		//ADD YOUR CODE BELOW HERE
		ArrayList<MyPair<K, V>> holder=new ArrayList<MyPair<K, V>>(70);
		for (LinkedList<MyPair<K,V>> innerlist:this.buckets){
			if (!innerlist.isEmpty()){
				for(MyPair<K,V> node:innerlist){
					holder.add(node);
					
				}
			}
		}
		
		capacity*=2;
		
		this.buckets=new ArrayList<LinkedList<MyPair<K,V>>>(capacity);
		size=0;
		for(int i=0; i<capacity; i++){
			buckets.add(new LinkedList<MyPair<K, V>>());
		}
		for (MyPair<K, V> value: holder){
			put(value.getKey(), value.getValue());
		}
		
		//ADD YOUR CODE ABOVE HERE
	}


	/**
	 * Return a list of all the keys present in this hashtable.
	 * Expected average runtime is O(m), where m is the number of buckets
	 */

	public ArrayList<K> getKeySet() {
		//ADD YOUR CODE BELOW HERE
		
		ArrayList<K> holder=new ArrayList<K>(70);
		for (LinkedList<MyPair<K,V>> innerlist:this.buckets){
			if (!innerlist.isEmpty()){
				for(MyPair<K,V> node:innerlist){
					if (!holder.contains(node.getKey())) {
						holder.add(node.getKey());
					}
				}
			}
		}
		return holder;

		//ADD YOUR CODE ABOVE HERE
	}

	/**
	 * Returns an ArrayList of unique values present in this hashtable.
	 * Expected average runtime is O(m) where m is the number of buckets
	 */
	public ArrayList<V> getValueSet() {
		//ADD CODE BELOW HERE

		ArrayList<V> holder=new ArrayList<V>(70);
		for (LinkedList<MyPair<K,V>> innerlist:this.buckets){
			if (!innerlist.isEmpty()){
				for(MyPair<K,V> node:innerlist){
					if (!holder.contains(node.getValue())) {
						holder.add(node.getValue());
					}
				}
			}
		}
		return holder;

		//ADD CODE ABOVE HERE
	}


	/**
	 * Returns an ArrayList of all the key-value pairs present in this hashtable.
	 * Expected average runtime is O(m) where m is the number of buckets
	 */
	public ArrayList<MyPair<K, V>> getEntries() {
		//ADD CODE BELOW HERE

		ArrayList<MyPair<K, V>> holder=new ArrayList<MyPair<K, V>>(70);
		for (LinkedList<MyPair<K,V>> innerlist:this.buckets){
			if (!innerlist.isEmpty()){
				for(MyPair<K,V> node:innerlist){
					holder.add(node);
				}
			}
		}
		return holder;

		//ADD CODE ABOVE HERE
	}

	
	
	@Override
	public MyHashIterator iterator() {
		return new MyHashIterator();
	}   

	
	private class MyHashIterator implements Iterator<MyPair<K,V>> {
		private ArrayList<MyPair<K, V>> list;
		private int location;

		private MyHashIterator() {
			//ADD YOUR CODE BELOW HERE
			list=getEntries();
			location=0;
			//ADD YOUR CODE ABOVE HERE
		}

		@Override
		public boolean hasNext() {
			//ADD YOUR CODE BELOW HERE
			
			if (location<list.size()){
				return true;
			}
			return false;

			//ADD YOUR CODE ABOVE HERE
		}

		@Override
		public MyPair<K,V> next() {
			//ADD YOUR CODE BELOW HERE

			if (this.hasNext()) {
				location += 1;
				return list.get(location - 1);
			}
			return null;
			
			//ADD YOUR CODE ABOVE HERE
		}

	}
	
}
