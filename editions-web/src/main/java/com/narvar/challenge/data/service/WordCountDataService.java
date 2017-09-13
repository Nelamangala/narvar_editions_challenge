package com.narvar.challenge.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvar.challenge.data.store.DataStore;
import com.narvar.challenge.data.store.WordCountStore;

@Service
public class WordCountDataService implements DataService<String, Long>{

	DataStore<String, Long> dataStore;
	
	public WordCountDataService(@Autowired WordCountStore wordCountStore) {
		dataStore = wordCountStore;
	}
	
	@Override
	public Long get(String key) {
		return dataStore.getByKey(key);
	}

	@Override
	public Long update(String key, Long value) {
		Long wordCount = dataStore.getByKey(key);
		if(wordCount == null) {
			wordCount = value;
		}else {
			wordCount += value;
		}
		dataStore.upsertKeyValue(key, wordCount);
		return wordCount;
	}

}
