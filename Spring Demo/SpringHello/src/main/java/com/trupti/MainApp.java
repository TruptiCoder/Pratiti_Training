package com.trupti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.trupti.provider.MessageProvider;
import com.trupti.render.MessageRenderer;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		Properties properties = new Properties();
		InputStream is = MainApp.class.getClassLoader().getResourceAsStream("application.properties");
		properties.load(is);

		String implClass = properties.getProperty("provider");
		String renderClass = properties.getProperty("renderer");

		Class<?> c = Class.forName(implClass);
		Constructor<?> o = c.getDeclaredConstructor();
		Object obj = o.newInstance();

		MessageProvider provider = (MessageProvider) obj;
		MessageRenderer renderer = (MessageRenderer) Class.forName(renderClass).getDeclaredConstructor().newInstance();

		renderer.setProvider(provider);
		renderer.render();
	}

}
