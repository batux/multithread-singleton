package com.design.pattern.singleton;

public class Task implements Runnable {

	private int id;
	
	public Task(int id) {
		this.id = id;
	}
	
	public void run() {
		
		int hashCode = LogManager.getLogManager().hashCode();
		System.out.println("Task-" + this.id + ", Log Manager Hashcode: " + hashCode);
	}
}
