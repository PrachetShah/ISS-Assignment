package multithreadingJava;

class RunnableDemoJoin implements Runnable {
	RunnableDemoJoin( ) {
		System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: New");
	}

	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Running");
		for(int i = 4; i > 0; i--) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread: " + Thread.currentThread().getName() + ", " + i);         
		}
		System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "State: Dead");
	}
}

public class JoiningThreads {
	public static void main(String args[]) throws InterruptedException {
		Thread t1 = new Thread( new RunnableDemoJoin(), "Thread-1");
		Thread t2 = new Thread( new RunnableDemoJoin(), "Thread-2");
		Thread t3 = new Thread( new RunnableDemoJoin(), "Thread-3");
		// start t1 thread and join main thread
		t1.start();
		t1.join(200);	  
		// t2 will start when t1 is dead or 200 ms is elapsed
		t2.start();        
		t2.join(100);
		// t3 will start when t2 is dead or 100 ms is elapsed
		t3.start();
	}
}