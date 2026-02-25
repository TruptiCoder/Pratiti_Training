package com.trupti.editor;

import com.trupti.spellchecker.SpellChecker;

public class TextEditor {

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

	public SpellChecker getChecker() {
		return checker;
	}

	public void setChecker(SpellChecker checker) {
		this.checker = checker;
	}
	
}
