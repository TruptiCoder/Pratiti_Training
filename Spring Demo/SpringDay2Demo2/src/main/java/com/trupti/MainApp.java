package com.trupti;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.trupti.config.ProjectConfig;
import com.trupti.config.ProjectConfig2;
import com.trupti.editor.TextEditor;

public class MainApp {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.trupti.config");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ProjectConfig.class);
		context.register(ProjectConfig2.class);
		context.refresh();
		
		TextEditor editor = context.getBean(TextEditor.class);
		editor.write("Trupti");
		
		context.close();
	}
}
