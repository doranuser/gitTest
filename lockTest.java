import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class window implements Runnable {

	@Override
	public void run() {

		locktest.sellTicket();
	}

}

public class lockTest {
	
	private static int ticket = 100;

	private static ReentrantLock lock = new ReentrantLock(true);

	public static void main(String[] args) {
		window w = new window();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("test1");
		t2.setName("test2");
		t3.setName("test3");

		t1.start();
		t2.start();
		t3.start();

	}
	static public void sellTicket() {
		while (true) {
			try {
				lock.lock();
				if (ticket > 0) {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + ":票" + ticket);
					ticket--;
				} else {
					break;
				}
			} finally {
				lock.unlock();
			}
		}
	}

}
