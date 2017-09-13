package com.narvar.challenge.data.store;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class WordCountStore implements DataStore<String, Long>{

	private Map<String, Long> wordCountData = new HashMap<>();

	@Override
	public Long getByKey(String key) {
		return wordCountData.get(key);
	}

	@Override
	public void upsertKeyValue(String key, Long value) {
		wordCountData.put(key, value);
	}
}
