package taskscheduler;

import java.time.Instant;
import java.util.Objects;

//public class Task implements Comparable {
public class Task {
	
	private int id;
	private String name;
	private int priority;
	private Instant timestamp;
	
	public Task(int id, String name, int priority) {
		super();
		this.id = id;
		this.name = name;
		this.priority = priority;
		this.timestamp = Instant.now();
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
/*
	@Override
	public int compareTo(Task other) {
		return Integer.compare(this.priority, other.priority);
	}
*/	
	@Override
	public String toString() {
		return String.format("Task[ID=%d, Priority=%d, Name=%s, Task created = %s]", id, priority, name, timestamp);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Task task = (Task) o;
		return Objects.equals(this.id, task.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

}
