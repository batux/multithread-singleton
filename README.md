# multithread-singleton
MultiThread Singleton Pattern with LogManager Sample

Singleton Design Pattern gives an unique instance of object. But, When you try to develop multi thread application, this native case of design pattern can not give guarantee for an unique object reference because of race condition.

For that reason, we have to make some extra code blocks to prevent from race condition factor. As everybody knows, In Java we can use lock objects or synchronized keyword to write thread safe applications. Also, It is known as "Double-Checked Locking Singleton". You can read details of this topic in Wikipedia (https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java).

In our LogManager example, we designed a class which has procted constructor. So with this way, any client can not create an instance of LogManager class directly. We will give LogManager unique instance with a static method with lazy loading. Example:

```java
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
```

We used ExecutorService to run Runnable tasks. For that reason, we created a fixed thread pool. This pool has prepared Thread instances. Creating a new thread is an expensive action in operating system side, so we want to improve performance.

```java
ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
for(int i=0; i < 5; i++) {
	Task task = new Task(i);
	threadPool.execute(task);
}
threadPool.shutdown();
```

Results with Double Checked Locking:

Log manager was created!
Task-1, Log Manager Hashcode: 1651719081
Task-2, Log Manager Hashcode: 1651719081
Task-4, Log Manager Hashcode: 1651719081
Task-3, Log Manager Hashcode: 1651719081
Task-0, Log Manager Hashcode: 1651719081

Results without Double Checked Locking:

Log manager was created!
Log manager was created!
Log manager was created!
Log manager was created!
Log manager was created!
Task-3, Log Manager Hashcode: 1651719081
Task-1, Log Manager Hashcode: 399577663
Task-0, Log Manager Hashcode: 1861575018
Task-4, Log Manager Hashcode: 1761651196
Task-2, Log Manager Hashcode: 327110963
