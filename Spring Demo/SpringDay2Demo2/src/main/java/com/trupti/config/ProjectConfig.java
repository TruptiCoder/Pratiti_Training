package com.trupti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.trupti.editor.TextEditor;

@Configuration
public class ProjectConfig {
	
	@Bean
	@Lazy
	public TextEditor getEditor() {
		return new TextEditor();
	}
}
