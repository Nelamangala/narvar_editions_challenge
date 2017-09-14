package com.narvar.challenge.api.response;

public class WordFrequency {
	private Integer totalDocumentsProcessed = 0;
	private Long totalCountOfWord = 0l;
	private String word;
	private Double frequency = 0d;
	public Integer getTotalDocumentsProcessed() {
		return totalDocumentsProcessed;
	}
	public void setTotalDocumentsProcessed(Integer totalDocumentsProcessed) {
		this.totalDocumentsProcessed = totalDocumentsProcessed;
	}
	public Long getTotalCountOfWord() {
		return totalCountOfWord;
	}
	public void setTotalCountOfWord(Long totalCountOfWord) {
		this.totalCountOfWord = totalCountOfWord;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Double getFrequency() {
		return frequency;
	}
	public void setFrequency(Double frequency) {
		this.frequency = frequency;
	}
	
	
	
}
