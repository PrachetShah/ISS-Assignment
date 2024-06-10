package multithreadingJava;


/*
 * There are two different ways to create a thread in Java. We have listed them as follows:
 * 1. By Implementing a Runnable Interface
 * 2. By Extending a Thread Class
 */

/*
 * Create a Thread by implementing Runnable Interface
 * 1. Implement a run() method: public void run()
 * 2. Instantiate a thread object: Thread(Runnable threadobj, String threadName)
 * 3. Call a thread using start() method: void start()
 */

/*
 * Create a Thread by extending Thread
 * 1. override run() method: public void run()
 * 2. Once thread is created, start it by calling start()
 */

// create thread by extending runnable interface
class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;

	RunnableDemo(String name){
		this.threadName = name;
		System.out.println("Creating Thread: " + threadName);
	}

	public void run() {
		System.out.println("Running " +  threadName );
		try {
			for(int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}

	public void start () {
		System.out.println("Starting " +  threadName );
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
		}
	}

}

// creating thread by Extending Thread Class
class ThreadDemo extends Thread {
	ThreadDemo( String name) {
		super(name);
		System.out.println("Thread: " + name + ", " + "State: New");
	}
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Running");
		for(int i = 4; i > 0; i--) {
			System.out.println("Thread: " + Thread.currentThread().getName() + ", " + i); 
		}
		System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Dead");
	}

	public void start () {
		System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Start");
		super.start();
	}
}

public class ThreadImplementation {	
	public static void main(String[] args) {
		// Using Runnable Interface
		RunnableDemo R1 = new RunnableDemo( "Thread-1");
		R1.start();

		RunnableDemo R2 = new RunnableDemo( "Thread-2");
		R2.start();

		// By Extending Thread Class
		ThreadDemo thread1 = new ThreadDemo( "Thread-3");
		ThreadDemo thread2 = new ThreadDemo( "Thread-4");
		thread1.start();
		thread2.start();
	}
}
