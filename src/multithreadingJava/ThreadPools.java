package multithreadingJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * A thread pool is a collection of pre-initialized threads. The general plan behind a 
 * thread pool is to form variety of threads at method startup and place them into a pool, 
 * wherever they sit and expect work. once a server receives a call for participation, 
 * it awakens a thread from this pool−if one is available−and passes it the request for service.
 * 
 * Why Use Thread Pools in Java? 
 * 1.It saves time as a result of there's no need to produce new thread.
 * 2.It is utilized in *Servlet* and *JSP* wherever instrumentality creates a thread pool to method the request.
 */

public class ThreadPools {

	public static void main(String args[]) {

		// Creating a Thread Pool Using newFixedThreadPool() Method
//		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// Creating a Thread Pool Using newCachedThreadPool() Method
		ExecutorService executor = Executors.newCachedThreadPool();

		// cast object to its class type
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

		// stats before tasks execution
		System.out.println("Largest Executions: "+ pool.getLargestPoolSize());
		System.out.println("Maximum Allowed Threads: "+ pool.getMaximumPoolSize());
		System.out.println("Current Threads in Pool: "+ pool.getPoolSize());
		System.out.println("Currently executing threads: "+ pool.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): "+ pool.getTaskCount());
		
		executor.submit(new Task());
		executor.submit(new Task());
		executor.submit(new Task());
		executor.submit(new Task());
		executor.submit(new Task());
		
		
		
		System.out.println("--------------------------------------------------------------");
		// stats after execution
		System.out.println("Core Executions: "+ pool.getCorePoolSize());
		System.out.println("Largest Executions: "+ pool.getLargestPoolSize());
		System.out.println("Maximum Allowed Threads: "+ pool.getMaximumPoolSize());
		System.out.println("Current Threads in Pool: "+ pool.getPoolSize());
		System.out.println("Currently executing threads: "+ pool.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): "+ pool.getTaskCount());
		
		executor.shutdown();
	}
	
	static class Task implements Runnable{
		public void run() {
			try {
				Long duration = (long) (Math.random()*5);
				System.out.println("Running Thread: "+Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(duration);
				
				System.out.println("Task Completed! Thread: "+Thread.currentThread().getName());
			}catch(InterruptedException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}

}
