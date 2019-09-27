package modelo;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	
	private BufferContoler buffer;
	private Semaphore mutex;
	private Semaphore empty;
	private Semaphore full;

	public Productor(BufferContoler buff, Semaphore mutex, Semaphore empty, Semaphore full) {
		this.buffer = buff;
		this.mutex = mutex;
		this.empty = empty;
		this.full = full;

	}

	public void run() {

		while (true) {
			try {
				
				empty.acquire();
				mutex.acquire();
				
				System.out.println("Produciendo un recurso");
				System.out.println("Produciendo: "+ buffer.fill());
				mutex.release();
				full.release();

				System.out.println("Esperando a producir");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
