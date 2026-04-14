package CollectionProject.task;

import java.time.Instant;

public class Task {
	
	private int id;
	private String name;
	private int priority;
	private Instant timestamp;
	
	public Task(int id, String name, int priority, Instant timestamp) {
		super();
		this.id = id;
		this.name = name;
		this.priority = priority;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public Instant getTimestamp() {
		return timestamp;
	}
	
	

}
