package multithreadingJava;

/*
 * Method vs Block Synchronization
 * In block sync, we add the block to be synchronized inside synchronized keyword like in this eg
 * For Method Sync, we define method as synchronized direcctly
 * for eg: public synchronized void printCount() instead of in run() method
 * 
 * 
 * Volatile Keyword
 * Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread-safe. 
 * Thread-safe means that a method or class instance can be used by multiple threads at the same 
 * time without any problem.
 */

class PrintDemo {
	public void printCount() {
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println("Counter   ---   "  + i + " " + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}
}

class ThreadDemoSyn extends Thread {
	private Thread t;
	private String threadName;
	PrintDemo  PD;

	ThreadDemoSyn( String name,  PrintDemo pd) {
		threadName = name;
		PD = pd;
	}

	public void run() {
		synchronized(PD) {
			PD.printCount();
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

public class SynchronizedThread {

	public static void main(String args[]) {
		PrintDemo PD = new PrintDemo();

		ThreadDemoSyn T1 = new ThreadDemoSyn( "Thread - 1 ", PD );
		ThreadDemoSyn T2 = new ThreadDemoSyn( "Thread - 2 ", PD );

		T1.start();
		T2.start();

		// wait for threads to end
		try {
			T1.join();
			T2.join();
		} catch ( Exception e) {
			System.out.println("Interrupted");
		}
	}
}
