package com.trupti.spellchecker;

import org.springframework.stereotype.Component;

@Component("m")
public class SpellCheckerMarathi implements SpellChecker {
	public String verifyMessage(String message) {
		return "Barobar ahe!";
	}
}
