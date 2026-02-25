package com.trupti;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trupti.editor.TextEditor;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		TextEditor editor = applicationContext.getBean(TextEditor.class);
		editor.write("Trupti");
	}
}
