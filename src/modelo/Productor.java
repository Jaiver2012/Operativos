package modelo;

import java.util.concurrent.Semaphore;

/**
 * @author Made by Jaiver Andres Orozco && Luis Fernando Cruces
 * Class where implement Productor
 */
public class Productor extends Thread {

	/**
	 * Buffer class - Class where is array of integers
	 */
	private BufferContoler buffer;
	
	/**
	 * Semaphore class used to avoid the Productor and Consumidor modify at the same time
	 * the buffer
	 */
	private Semaphore mutex;
	
	/**
	 * Semaphore class that indicate if on the buffer there is or is not in any space
	 */
	private Semaphore empty;
	
	/**
	 * Semaphore class that indicate if exist data in the buffer
	 */
	private Semaphore full;

	/**
	 * Constructor method of Productor
	 * @param buff
	 * @param mutex
	 * @param empty
	 * @param full
	 */
	public Productor(BufferContoler buff, Semaphore mutex, Semaphore empty, Semaphore full) {
		this.buffer = buff;
		this.mutex = mutex;
		this.empty = empty;
		this.full = full;

	}

	/**
	 * Main method to run the thread
	 */
	public void run() {

		while (true) {
			try {
				
				//Acquires a permit blocking until one is available, or the thread is interrupted.
				//View if there is some space f the buffer to produce data
				empty.acquire();
				
				//Acquires a permit blocking until one is available, or the thread is interrupted.
				//Semaphore  for mutual exclusion,  acquires the lock to into critical section
				mutex.acquire();
				
				System.out.println("Produciendo un recurso (PRODUCTOR)");
				//Produce data in the buffer
				buffer.fill();
				System.out.println("Liberación (PRODUCTOR)");
				
				//releases the lock
				mutex.release();
				
				//Releases a permit, increasing the number of available permits by one
				full.release();

				// sleep the Consumidor to work in different time
				sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
