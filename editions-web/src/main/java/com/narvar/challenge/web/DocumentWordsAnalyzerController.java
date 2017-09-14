package com.narvar.challenge.web;

import com.narvar.challenge.api.request.Edition;
import com.narvar.challenge.api.response.WordFrequency;
import com.narvar.challenge.api.response.WordLeaderBoard;
import com.narvar.challenge.data.analyzer.HighestFrequencyWordAnalyzer;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Log4j
public class DocumentWordsAnalyzerController {

	@Autowired
	HighestFrequencyWordAnalyzer wordAnalyzer;
	
    @GetMapping("/edition/title/word/leader-board")
    WordLeaderBoard getTopTenTitleWords() {
        return wordAnalyzer.getWordCountLeaders();
    }

    @GetMapping("/edition/title/word/frequency")
    WordFrequency getTitleWordFrequency(@RequestParam("word") String word) {
        return wordAnalyzer.getWordFrequency(word);
    }

    @PostMapping(value = "/edition")
    public ResponseEntity<String> addEdition(@Valid @RequestBody Edition edition) {
    	
    	if(edition.getKey().isEmpty() || edition.getTitle().isEmpty()) {
    		return new ResponseEntity<String>("Invalid Input : Document Key & Title must be present.", HttpStatus.BAD_REQUEST);
    	}
        boolean addData = wordAnalyzer.addData(edition.getKey(), edition.getTitle());
        if(addData) {
        	return new ResponseEntity<String>("Success", HttpStatus.OK);
        }else {
        	return new ResponseEntity<String>("Duplicate processing request: Document with this key was already processed.", HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/edition/title/word/reset")
    public ResponseEntity<String> titleWordsReset(@RequestParam("size") Integer size) {
       wordAnalyzer.resetAndInitAnalyzer(size);
       return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}
