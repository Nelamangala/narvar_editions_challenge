package com.narvar.challenge.parser.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleWordsParserService implements ParserService{

	@Override
	public Map<String, Long> parse(String input) {
		Map<String, Long> parsedWordCounts = new HashMap<>();
		if(input == null || input.isEmpty()) {
			return parsedWordCounts;
		}
		Pattern splitOnSpacePattern = Pattern.compile("\\s");
		String[] stringComponents = splitOnSpacePattern.split(input);
		for(String component : stringComponents) {
			Pattern wordPattern = Pattern.compile("[\\w]+[^\\w]?[\\w]+[.']?");
			Matcher matcher = wordPattern.matcher(component);
			matcher.
		}
			
		return parsedWordCounts;
	}

}
