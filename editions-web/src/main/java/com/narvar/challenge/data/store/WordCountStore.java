package com.narvar.challenge.data.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class WordCountStore implements DataStore<String, Long>{

	/**
	 * Synchronized data store for thread safety.
	 */
	private Map<String, Long> wordCountData = new ConcurrentHashMap<>();

	@Override
	public Long getByKey(String key) {
		return wordCountData.get(key);
	}

	@Override
	public void upsertKeyValue(String key, Long value) {
		wordCountData.put(key, value);
	}

	@Override
	public void reset() {
		wordCountData.clear();
	}

	@Override
	public Integer getDataStoreSize() {
		return wordCountData.size();
	}
}
