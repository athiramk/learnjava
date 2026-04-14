package taskscheduler;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;



public class TaskManager {
	
	//private Queue<Task> taskQueue = new PriorityQueue<>((Task a, Task b) -> (a.getName()).compareTo(b.getName()));
	
	//private Queue<Task> taskQueue = new PriorityQueue<>((Task a, Task b) -> (b.getName()).compareTo(a.getName()));
	
	private Queue<Task> taskQueue = new PriorityQueue<>((Task a, Task b) -> a.getPriority() - b.getPriority() );
	
	//private Queue<Task> taskQueue = new PriorityQueue<>((Task a, Task b) -> b.getPriority() - a.getPriority());
	
	//private Queue<Task> taskQueue = new PriorityQueue<>((Task a, Task b) -> a.getTimestamp().compareTo(b.getTimestamp()));
	
	private Set<Integer> processedIds = new HashSet<>();
	
	private Map<Integer,Task> taskRegister = new HashMap<>();
	
	private List<Task> execLog = new ArrayList<>();
	
	private Deque<Task> undoStack = new ArrayDeque<>();
	
	public void addTask(Task t) {
		
		if (processedIds.contains(t.getId())) {
			System.out.println("Rejected : Task ID " + t.getId() + " already exists");
			return;
		}
		taskRegister.put(t.getId(), t);
		
		taskQueue.add(t);
		
		System.out.println("Added: " + t.getName());
	}
	
	public void processNext() {
		Task t = taskQueue.poll();
		if (t != null) {
			processedIds.add(t.getId());
			execLog.add(t);
			
			if(undoStack.size()==10) undoStack.removeLast();
			undoStack.push(t);
			
			System.out.println("processing : " + t);
			System.out.println("processed : " + t);
		}
		else {
			System.out.println("No tasks in the queue");
		}
		
	}
	
	public Task getTaskbyId(int id) {
		return taskRegister.get(id);
	}
	
	public List<Task> getCompletedTaskByPriority(int priority) {
		return execLog.stream()
				.filter(t -> t.getPriority() == priority)
				.peek(t -> System.out.println(t.getName()))
				.collect(Collectors.toList());
				
	}
	
	public static void main(String[] args) {
		TaskManager manager = new TaskManager();
		
		// adding tasks out of order
		manager.addTask(new Task(101, "Routine Backup", 5));
		manager.addTask(new Task(102, "Security Patch", 2));
		manager.addTask(new Task(103, "CRITICAL: Database Leak", 1));
		manager.addTask(new Task(104, "Password Update", 4));
		
		
		manager.processNext();
		manager.processNext();
		manager.processNext();
		manager.processNext();
		manager.addTask(new Task(103, "CRITICAL: Database Leak", 1));
		
		
		System.out.println("Task 103 --> " + manager.getTaskbyId(103));
		
		
		List <Task> completedTask = manager.getCompletedTaskByPriority(2);
		System.out.println(completedTask);
		
	}
	

}
