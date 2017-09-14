package com.narvar.challenge.data.analyzer;

import com.narvar.challenge.api.response.WordFrequency;
import com.narvar.challenge.api.response.WordLeaderBoard;

public interface WordAnalyzer {

	/**
	 * Gets the frequency of the word. i.e (number of times it appeared / total titles processed)
	 * @param word
	 * @return
	 * 		Frequency of word among documents processed. 
	 */
	public WordFrequency getWordFrequency(String word);
	
	/**
	 * Returns the leader board for word counts. By default top 10 leaders are maintained.
	 * @return
	 *  	Leading word counts. (Default is 10)
	 */
	public WordLeaderBoard getWordCountLeaders();
	
	/**
	 * Extracts data from input title and updates leader board accordingly. Also persists individual 
	 * word counts in the underlying store.
	 * @param title
	 * 		FALSE - If document is already processed before OR internal error.
	 * 		TRUE  - If document was successfully processed.
	 */
	public boolean addData(String documentKey, String title);
	
	/**
	 * Resets the data processed so far and initializes the leading counts maintained to given size. 
	 * @param size
	 * 	
	 */
	public void resetAndInitAnalyzer(int size);
}
