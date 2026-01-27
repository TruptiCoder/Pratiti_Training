package com.trupti;

import java.util.logging.Logger;

import com.trupti.view.EmployeeView;

public class MainApp {
	
	private static final Logger log = Logger.getLogger(MainApp.class.getName());

	public static void main(String[] args) {
		
		log.info("Start of App");
		new EmployeeView();
		log.info("End of App");
	}

}
