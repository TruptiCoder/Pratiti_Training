package com.trupti.editor;

import org.springframework.beans.factory.annotation.Autowired;

import com.trupti.spellchecker.SpellChecker;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class TextEditor {

	@Autowired
	private SpellChecker checker;

	{
		System.out.println("TextEditor object created");
	}

	public void write(String message) {
		String msg = checker.verifyMessage(message);
		System.out.println(msg);
	}

	@PostConstruct
	public void aaya() {
		System.out.println("Main aaya texteditor mein!");
	}

	@PreDestroy
	public void gaya() {
		System.out.println("Main gaya texteditor se!");
	}
}
