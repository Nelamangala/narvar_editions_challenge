package com.narvar.challenge.parser.service;

import static org.hamcrest.CoreMatchers.is;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TitleWordsParserServiceTest {

	TitleWordsParserService parserService = new TitleWordsParserService();
	
	@Test
	public void testParseTitleNull() {
		
		Map<String, Long> parseResult = parserService.parse(null);
		Assert.assertNotNull(parseResult);
		Assert.assertTrue(parseResult.isEmpty());
	}
	
	@Test
	public void testParseTitleEmpty() {
		
		Map<String, Long> parseResult = parserService.parse("");
		Assert.assertNotNull(parseResult);
		Assert.assertTrue(parseResult.isEmpty());
	}
	
	@Test
	public void testParseTitleWithBraces() {
		String title = "The Borough of Copeland (Electoral Changes) Order 1998 (Statutory Instruments: 1998: 2570)";
		Map<String, Long> parseResult = parserService.parse(title);
		Assert.assertNotNull(parseResult);
		Assert.assertThat(parseResult.get("ELECTORAL"), is(1L));
	}
	
	
	@Test
	public void testParseTitleWithApostrophe() {
		String title = "The Education (School Teachers' Pay and Conditions) (No. 2) Order 1994 (Statutory Instruments: 1994: 1673)";
		Map<String, Long> parseResult = parserService.parse(title);
		Assert.assertNotNull(parseResult);
		Assert.assertThat(parseResult.get("TEACHERS'"), is(1L));
	}
	
	@Test
	public void testParseTitleWithDateRange() {
		String title = "Parliamentary Debates, House of Lords, Bound Volumes, 1992-93";
		Map<String, Long> parseResult = parserService.parse(title);
		Assert.assertNotNull(parseResult);
		Assert.assertThat(parseResult.get("1992-93"), is(1L));
	}
	
	@Test
	public void testParseTitleExcludesIndefiniteArticles() {
		String title = "an The the THE AN THEY";
		Map<String, Long> parseResult = parserService.parse(title);
		Assert.assertNotNull(parseResult);
		Assert.assertThat(parseResult.get("THEY"), is(1L));
		Assert.assertNull(parseResult.get("an"));
		Assert.assertNull(parseResult.get("AN"));
		Assert.assertNull(parseResult.get("the"));
		Assert.assertNull(parseResult.get("THE"));
	}
	
	@Test
	public void testParseGetsAllowedSingleCharsOnly() {
		String title = "an The the THE AN THEY i x o h M O";
		Map<String, Long> parseResult = parserService.parse(title);
		Assert.assertNotNull(parseResult);
		Assert.assertThat(parseResult.get("O"), is(2L));
		Assert.assertNull(parseResult.get("x"));
		Assert.assertNull(parseResult.get("M"));
	}
}
