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
	 * Semaphore class that indicate if exists data in the buffer
	 */
	private Semaphore full; //hay datos

	/**
	 * 
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

	public void run() {

		while (true) {
			try {
				
				full.acquire();
				mutex.acquire();
				System.out.println("Esperando a consumir");
				buffer.extract();
				System.out.println("Liberacion");
				mutex.release();
				empty.release();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
