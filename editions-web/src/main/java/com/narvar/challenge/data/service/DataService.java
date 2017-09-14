package com.narvar.challenge.data.service;

public interface DataService<K, V> {

	/**
	 * Retrieves value for given key from underlying datastore;
	 * @param key
	 * @return
	 *   Value if found. NULL if key not found.
	 */
	public V get(K key);
	
	/**
	 * Increments value of given key by specified amount. If key does not exist then a new entry is created in datastore for 
	 * this key,value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void update(K key, V value);
	
	/**
	 * Clears the data contained in the store. This is irreversible.
	 */
	public void reset();
}
