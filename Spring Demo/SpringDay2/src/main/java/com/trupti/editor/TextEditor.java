package com.trupti.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trupti.spellchecker.SpellChecker;

@Component
public class TextEditor {

	@Autowired
	@Qualifier("h")
	private SpellChecker checker;
	
	{
		System.out.println("TextEditor object created");		
	}
	
//	public TextEditor() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public TextEditor(SpellChecker spellChecker) {
//		this.checker = spellChecker;
//	}

	public void write(String message) {
		String msg = checker.verifyMessage(message);
		System.out.println(msg);
	}

//	public SpellChecker getChecker() {
//		return checker;
//	}
//
//	public void setChecker(SpellChecker checker) {
//		this.checker = checker;
//	}
	
	
	public void aaya() {
		System.out.println("Main aaya texteditor mein");
	}
	
	public void gaya() {
		System.out.println("Main gaya texteditor se");
	}
}
