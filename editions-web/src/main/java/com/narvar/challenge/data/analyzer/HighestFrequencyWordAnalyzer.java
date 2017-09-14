package com.narvar.challenge.data.analyzer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.narvar.challenge.api.response.WordCount;
import com.narvar.challenge.api.response.WordFrequency;
import com.narvar.challenge.api.response.WordLeaderBoard;
import com.narvar.challenge.data.service.DataService;
import com.narvar.challenge.data.service.WordCountDataService;
import com.narvar.challenge.parser.service.ParserService;
import com.narvar.challenge.parser.service.TitleWordsParserService;

/**
 * By default spring maintains singleton for this object.
 * 
 * @author nelamangala
 *
 */
@Component
public class HighestFrequencyWordAnalyzer implements WordAnalyzer{

	private ParserService parserService;

	private DataService<String, Long> dataService;
	
	@Autowired
	public HighestFrequencyWordAnalyzer(TitleWordsParserService parserService, WordCountDataService dataService) {
		this.parserService = parserService;
		this.dataService = dataService;
	}
	// For thread safety
	private Set<String> documentsProcessed = Collections.synchronizedSet(new HashSet<String>());
	
	public static final int DEFAULT_LEADERS_TRACKED = 10;
	
	private Integer totalLeadersToBeTracked = DEFAULT_LEADERS_TRACKED;
	
	// For thread safety
	private PriorityBlockingQueue<WordCount> priorityQueue = new PriorityBlockingQueue<>(DEFAULT_LEADERS_TRACKED);
	
	@Override
	public WordFrequency getWordFrequency(String word) {
		WordFrequency wordFrequency = new WordFrequency();
		wordFrequency.setWord(word);
		Long wordCount = dataService.get(word);
		int totalDocumentsProcessed = documentsProcessed.size();
		wordFrequency.setTotalDocumentsProcessed(totalDocumentsProcessed);
		wordFrequency.setTotalCountOfWord(wordCount);
		
		if(wordCount != null && totalDocumentsProcessed > 0) {
			wordFrequency.setFrequency((double) wordCount / totalDocumentsProcessed);
		}
		
		return wordFrequency;
	}

	@Override
	public WordLeaderBoard getWordCountLeaders() {
		WordLeaderBoard leaderBoard = new WordLeaderBoard();
		
		WordCount[] array = new WordCount[priorityQueue.size()];
		Iterator<WordCount> pqIterator = priorityQueue.iterator();
		int count = 0;
		while(pqIterator.hasNext()) {
			array[count++] = pqIterator.next();
		}
		Arrays.sort(array);
		leaderBoard.setLeadingWords(array);
		return leaderBoard;
	}

	@Override
	public void resetAndInitAnalyzer(int size) {
		dataService.reset();
		priorityQueue.clear();
		totalLeadersToBeTracked = new Integer(size);
		documentsProcessed.clear();
	}

	@Override
	public boolean addData(String documentKey, String title) {
		
		if(documentsProcessed.contains(documentKey)) {
			return false;
		}
		documentsProcessed.add(documentKey);
		
		Map<String, Long> wordCounts = parserService.parse(title);
		for(Entry<String, Long> wordAndCount : wordCounts.entrySet()) {
			WordCount priorityQueueBottom = priorityQueue.peek();
			
			Long existingCount = dataService.get(wordAndCount.getKey());
			Long newCount = (existingCount != null ? existingCount : 0l) + wordAndCount.getValue();
			
			// If this word already exists in priority queue top words, just update count
			WordCount currentParsedWord = new WordCount(wordAndCount.getKey(), newCount);
			if(priorityQueue.contains(currentParsedWord)) {
				priorityQueue.remove(currentParsedWord);
				priorityQueue.add(currentParsedWord);
			} else if(priorityQueue.size() < totalLeadersToBeTracked) {
				priorityQueue.add(currentParsedWord);
			} else if(newCount >= priorityQueueBottom.getCount()){
				priorityQueue.remove();
				priorityQueue.add(currentParsedWord);
			}
			dataService.update(wordAndCount.getKey(), wordAndCount.getValue());
		}
		
		return true;
	}

}
