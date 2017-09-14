package com.narvar.challenge.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvar.challenge.data.store.DataStore;
import com.narvar.challenge.data.store.WordCountStore;

/**
 * This is a thread safe class as it does not store any state information.
 * @author nelamangala
 *
 */
@Service
public class WordCountDataService implements DataService<String, Long>{

	private DataStore<String, Long> dataStore;
	
	public WordCountDataService(@Autowired WordCountStore wordCountStore) {
		dataStore = wordCountStore;
	}
	
	@Override
	public Long get(String key) {
		return dataStore.getByKey(key);
	}

	@Override
	public void update(String key, Long value) {
		Long wordCount = dataStore.getByKey(key);
		if(wordCount == null) {
			dataStore.upsertKeyValue(key, value);
		}else {
			dataStore.upsertKeyValue(key, value + dataStore.getByKey(key));
		}
	}

	@Override
	public void reset() {
		dataStore.reset();
	}

}
