package multithreading.completablefuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1,TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		
		CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
			return "task completed";
		}, poolExecutor);
		
		try {
			System.out.println(asyncTask1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "hello ";
		}, poolExecutor).thenApply((String val)->{
			System.out.println( "thread which runs thenApply " + Thread.currentThread().getName());
			return val + "athira";
		});
		try {
			System.out.println(asyncTask2.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		
		CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(() -> {
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "hello ";
		}, poolExecutor).thenApplyAsync((String val)->{
			System.out.println( "thread which runs thenApplyAsync " + Thread.currentThread().getName());
			return val + "athira";
		});
		try {
			System.out.println(asyncTask3.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		
		CompletableFuture<String> asyncTask4 = CompletableFuture.supplyAsync(() -> {
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "hello ";
		}, poolExecutor).thenCompose((String val)->{
			return CompletableFuture.supplyAsync(() -> {
				System.out.println( "thread which runs thenCompose " + Thread.currentThread().getName());
				return val + "athira";
			});
			
		});
		
		try {
			System.out.println(asyncTask4.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		
		CompletableFuture<String> asyncTask5 = CompletableFuture.supplyAsync(() -> {
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "hello ";
		}, poolExecutor).thenComposeAsync((String val)->{
			return CompletableFuture.supplyAsync(() -> {
				System.out.println( "thread which runs thenComposeAsync " + Thread.currentThread().getName());
				return val + "athira";
			});
			
		});
		
		try {
			System.out.println(asyncTask5.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		
		CompletableFuture<Void> asyncTask6 = CompletableFuture.supplyAsync(() -> {
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "hello ";
		}, poolExecutor).thenAccept((String val) -> {
			System.out.println("thread which runs thenAccept " + Thread.currentThread().getName());
		});
			
			
		
		try {
			System.out.println(asyncTask6.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		
		CompletableFuture<Void> asyncTask7 = CompletableFuture.supplyAsync(() -> {
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "hello ";
		}, poolExecutor).thenAcceptAsync((String val) -> {
			System.out.println("thread which runs thenAcceptAsync " + Thread.currentThread().getName());
		});
			
			
		
		try {
			System.out.println(asyncTask7.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		
		CompletableFuture<Integer> asyncTask8 = CompletableFuture.supplyAsync(()->{
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return 10;
			},poolExecutor);
		CompletableFuture<String> asyncTask9 = CompletableFuture.supplyAsync(()->{
			System.out.println("thread which runs supplyAsync " + Thread.currentThread().getName());
			return "k";
			},poolExecutor);
		
		CompletableFuture<String> combinedFuture = asyncTask8.thenCombine(asyncTask9,(Integer val1, String val2) -> {
			System.out.println("thread which runs thenCombine " + Thread.currentThread().getName());
			return val1 + val2; });
		
		try {
			System.out.println(combinedFuture.get());
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		poolExecutor.shutdown();

	}

}
