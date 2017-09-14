package com.narvar.challenge.data.store;

public interface DataStore<K, V> {

	/**
	 * Get value for given key. Returns NULL if key not found.
	 * @param key
	 * @return
	 * 		Returns V corresponding to K.
	 * 		Returns NULL if K is not found.
	 */
	public V getByKey(K key);
	
	/**
	 * Update value if entry for key K already exists. Else add new entry into data store for this Key, Value pair.
	 * @param key
	 * @param value
	 */
	public void upsertKeyValue(K key, V value);
	
	/**
	 * Clears all data held and it is irreversible.
	 */
	public void reset();
	
	/**
	 * Returns the current size of data store, i.e the number of elements inside data store.
	 * @return
	 */
	public Integer getDataStoreSize();
}
