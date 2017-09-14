package com.narvar.challenge.api.response;

public class WordCount implements Comparable<WordCount>{
	private String word;
	private Long count;
	
	public WordCount(String word, Long count) {
		this.word = word;
		this.count = count;
	}
	
	public WordCount() {
		
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordCount other = (WordCount) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	@Override
	public int compareTo(WordCount o) {
		return (int) ( this.count - o.count);
	}

	@Override
	public String toString() {
		return "WordCount [word=" + word + ", count=" + count + "]";
	}
	
}
