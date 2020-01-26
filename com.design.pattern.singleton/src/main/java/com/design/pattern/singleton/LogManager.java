package com.design.pattern.singleton;

import java.io.Serializable;

public class LogManager implements Serializable {

	private static final long serialVersionUID = 8823030873610926300L;

	private static volatile LogManager self;
	
	protected LogManager() {
		System.out.println("Log manager was created!");
	}
	
	public static LogManager getLogManager() {
		
		if(self == null) {
			synchronized (LogManager.class) {
				if(self == null) {
					self = new LogManager();
				}
			}
		}
		return self;
	}
}
