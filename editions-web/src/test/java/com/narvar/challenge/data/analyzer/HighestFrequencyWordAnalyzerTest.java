package com.narvar.challenge.data.analyzer;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narvar.challenge.api.response.WordFrequency;
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
		frequencyAnalyzer.resetAndInitAnalyzer(10);
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
		Assert.assertThat(wordCountLeaders.getLeadingWords()[9].getCount(), is(3l));
		Assert.assertThat(wordCountLeaders.getLeadingWords()[8].getWord(), is("WORLDS"));
		Assert.assertThat(wordCountLeaders.getLeadingWords()[8].getCount(), is(2l));
		try {
			boolean tenthHighestOccuringReplaceSuccesss = false;
			for(int i=0;i<wordCountLeaders.getLeadingWords().length;i++) {
				if(wordCountLeaders.getLeadingWords()[i].getWord().equals("NARVAR")) {
					tenthHighestOccuringReplaceSuccesss = true;
					break;
				}
			}
			if(!tenthHighestOccuringReplaceSuccesss){
				throw new Exception("Failed to keep the last processed word with same count as the 10th highest word");
			}
			
		}catch(Exception e) {
			Assert.fail("Last processed word with same count as the 10th element must replace the 10th element.");
		}
	}
	
	@Test
	public void testAnalyzerWordFrequency() {
		frequencyAnalyzer.resetAndInitAnalyzer(10);
		String key1 = "key1";
		String doc1 = "Reading java is a good practice. The worlds best java 1st edition";
		
		String key2 = "key2";
		String doc2 = "Java vs python: It will be a legendary";
		
		String key3 = "key3";
		String doc3 = "NoSQl vs sql data. An introduction to the worlds of data narvar";
		
		frequencyAnalyzer.addData(key1, doc1);
		frequencyAnalyzer.addData(key2, doc2);
		frequencyAnalyzer.addData(key3, doc3);
		
		WordFrequency wordFrequency = frequencyAnalyzer.getWordFrequency("JAVA");
		Assert.assertThat(wordFrequency.getFrequency(), is(1.0));
		
		WordFrequency definiteArticleFrequency = frequencyAnalyzer.getWordFrequency("the");
		Assert.assertThat(definiteArticleFrequency.getFrequency(), is(0.0));
		
		WordFrequency nonExistingWord = frequencyAnalyzer.getWordFrequency("invalid");
		Assert.assertThat(nonExistingWord.getFrequency(), is(0.0));
	}
	
	@Test
	public void testAnalyzerWordFrequencyNoData() {
		frequencyAnalyzer.resetAndInitAnalyzer(10);
		WordFrequency wordFrequency = frequencyAnalyzer.getWordFrequency("JAVA");
		Assert.assertThat(wordFrequency.getFrequency(), is(0.0));
		
		WordFrequency definiteArticleFrequency = frequencyAnalyzer.getWordFrequency("the");
		Assert.assertThat(definiteArticleFrequency.getFrequency(), is(0.0));
		
		WordFrequency nonExistingWord = frequencyAnalyzer.getWordFrequency("invalid");
		Assert.assertThat(nonExistingWord.getFrequency(), is(0.0));
	}
	
	@Test
	public void testAnalyzerWordFrequencyReset() {
		String key1 = "key1";
		String doc1 = "Reading java is a good practice. The worlds best java 1st edition";
		
		String key2 = "key2";
		String doc2 = "Java vs python: It will be a legendary";
		
		String key3 = "key3";
		String doc3 = "NoSQl vs sql data. An introduction to the worlds of data narvar";
		
		frequencyAnalyzer.addData(key1, doc1);
		frequencyAnalyzer.addData(key2, doc2);
		frequencyAnalyzer.addData(key3, doc3);
		
		frequencyAnalyzer.resetAndInitAnalyzer(10);
		
		WordLeaderBoard wordCountLeaders = frequencyAnalyzer.getWordCountLeaders();
		Assert.assertTrue(wordCountLeaders.getLeadingWords().length == 0);
		
		WordFrequency wordFrequency = frequencyAnalyzer.getWordFrequency("JAVA");
		Assert.assertThat(wordFrequency.getFrequency(), is(0.0));
		Assert.assertThat(wordFrequency.getTotalCountOfWord(), is(0L));
		Assert.assertThat(wordFrequency.getTotalDocumentsProcessed(), is(0));
	}
}
