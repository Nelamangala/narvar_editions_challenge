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
	 * 		Updated value for this key.
	 */
	public V update(K key, V value);
}
