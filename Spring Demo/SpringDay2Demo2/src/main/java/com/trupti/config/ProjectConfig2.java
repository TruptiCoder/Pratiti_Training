package com.trupti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.trupti.editor.TextEditor;
import com.trupti.spellchecker.SpellChecker;
import com.trupti.spellchecker.SpellCheckerHindi;
import com.trupti.spellchecker.SpellCheckerMarathi;

@Configuration
public class ProjectConfig2 {
	
	@Bean
	@Primary
	public SpellChecker hindi() {
		return new SpellCheckerHindi();
	}
	
	@Bean
	public SpellChecker marathi() {
		return new SpellCheckerMarathi();
	}
}
