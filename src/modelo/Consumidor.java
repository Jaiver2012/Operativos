package modelo;

import java.nio.Buffer;
import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {

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
	private Semaphore empty; // hay espacia
	
	/**
	 * Semaphore class that indicate if exist data in the buffer
	 */
	private Semaphore full; //hay datos

	/**
	 * Constructor method of Consumidor
	 * @param buff
	 * @param mutex
	 * @param empty
	 * @param full
	 */
	public Consumidor(BufferContoler buff, Semaphore mutex, Semaphore empty, Semaphore full) {
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
				//View if there is a data to consume
				full.acquire();
				
				//Acquires a permit blocking until one is available, or the thread is interrupted.
				//Semaphore  for mutual exclusion,  acquires the lock to into critical section
				mutex.acquire();
				
				
				System.out.println("Esperando a consumir (CONSUMIDOR)");
				//Extract or consume the resource in the buffer
				buffer.extract();
				System.out.println("Liberación (CONSUMIDOR)");
				
				
				//releases the lock
				mutex.release();
				
				//Releases a permit, increasing the number of available permits by one
				empty.release();
				
				// sleep the Consumidor to work in different time
				sleep(1500);

			} catch (Exception e) {
				// TODO: handle exception
				
			}

		}

	}

}
