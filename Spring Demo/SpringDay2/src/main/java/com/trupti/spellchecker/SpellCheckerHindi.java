package com.trupti.spellchecker;

import org.springframework.stereotype.Component;

@Component("h")
public class SpellCheckerHindi implements SpellChecker {
	public String verifyMessage(String message) {
		return "Sahi hai bidu";
	}
}
