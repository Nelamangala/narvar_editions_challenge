package com.narvar.challenge.parser.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class TitleWordsParserService implements ParserService{

	private final Pattern wordPattern = Pattern.compile("\\b(?i)(?!(the|an|a)\\b)\\w+[\\w]+[^\\w]?[\\w]+[.']?");
	
	private final Pattern allowedSingleCharPattern = Pattern.compile("(?i)[iou]{1}");
	
	@Override
	public LinkedHashMap<String, Long> parse(String input) {
		LinkedHashMap<String, Long> parsedWordCounts = new LinkedHashMap<>();
		if(input == null || input.isEmpty()) {
			return parsedWordCounts;
		}
		Pattern splitOnSpacePattern = Pattern.compile("\\s");
		String[] stringComponents = splitOnSpacePattern.split(input);
		for(String component : stringComponents) {
			Matcher wordMatcher = wordPattern.matcher(component);
			while(wordMatcher.find()) {
				String titleWord = wordMatcher.group().toUpperCase();
				addWordToParsedWordCount(titleWord, parsedWordCounts);
			}
			if(component.length() == 1) {
				Matcher singleCharMatcher = allowedSingleCharPattern.matcher(component);
				while(singleCharMatcher.find()) {
					String charMatch = singleCharMatcher.group().toUpperCase();
					addWordToParsedWordCount(charMatch, parsedWordCounts);
				}
			}
		}
			
		
		return parsedWordCounts;
	}

	private void addWordToParsedWordCount(String titleWord, Map<String, Long> parsedWordCounts) {
		Long count = parsedWordCounts.get(titleWord);
		if(count == null) {
			count = 0l;
		}
		parsedWordCounts.put(titleWord, ++count);
	}

}
