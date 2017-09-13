package com.narvar.challenge.parser.service;

import java.util.Map;

public interface ParserService {
	
	/**
	 * Extracts words from given input and returns a map of word and its count.
	 * @param input
	 * @return
	 * 		Empty map if input is null OR empty OR no words extracted.
	 * 		Map of words & their count extracted from input.
	 */
	public Map<String, Long> parse(String input);
}
