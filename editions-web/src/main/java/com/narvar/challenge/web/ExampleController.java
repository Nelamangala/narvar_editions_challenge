package com.narvar.challenge.web;

import com.narvar.challenge.api.request.Edition;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@Log4j
public class ExampleController {

    @GetMapping("/edition/title/word/leader-board")
    List<String> getTopTenTitleWords() {
        return Arrays.asList("Return", "Top", "Ten", "Words", "Here", "...");
    }

    @GetMapping("/edition/title/word/frequency")
    String getTitleWordFrequency(@RequestParam("word") String word) {
        return String.format("The frequency of the word \"%s\" is %.2f%%", word, 49.2);
    }

    @PostMapping(value = "/edition")
    public String addEdition(@Valid @RequestBody Edition edition) {
        return "Edition Posted with title: \"" + edition.getTitle() + "\"";
    }

}
