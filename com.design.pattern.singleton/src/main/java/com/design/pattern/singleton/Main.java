package com.design.pattern.singleton;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
		
		ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
		for(int i=0; i < 30; i++) {
			Task task = new Task(i);
			threadPool.execute(task);
		}
		threadPool.shutdown();
	}

}
