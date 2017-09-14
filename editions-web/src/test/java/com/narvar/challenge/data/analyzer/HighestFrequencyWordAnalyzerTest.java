package com.narvar.challenge.data.analyzer;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narvar.challenge.api.response.WordLeaderBoard;
import com.narvar.challenge.data.service.WordCountDataService;
import com.narvar.challenge.data.store.WordCountStore;
import com.narvar.challenge.parser.service.TitleWordsParserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HighestFrequencyWordAnalyzer.class, TitleWordsParserService.class, WordCountDataService.class,WordCountStore.class})
public class HighestFrequencyWordAnalyzerTest {

	@Autowired
	HighestFrequencyWordAnalyzer frequencyAnalyzer;
	
	@Test
	public void testAnalyzer() {
		String key1 = "key1";
		String doc1 = "Reading java is a good practice. The worlds best java 1st edition";
		
		String key2 = "key2";
		String doc2 = "Java vs python: It will be a legendary";
		
		String key3 = "key3";
		String doc3 = "NoSQl vs sql data. An introduction to the worlds of data narvar";
		
		frequencyAnalyzer.addData(key1, doc1);
		frequencyAnalyzer.addData(key2, doc2);
		frequencyAnalyzer.addData(key3, doc3);
		
		WordLeaderBoard wordCountLeaders = frequencyAnalyzer.getWordCountLeaders();
		Assert.assertThat(wordCountLeaders.getLeadingWords()[9].getWord(), is("JAVA"));
		Assert.assertThat(wordCountLeaders.getLeadingWords()[8].getWord(), is("WORLDS"));
	}
	
}
