package modelo;

import java.nio.Buffer;
import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {

	private BufferContoler buffer;
	private Semaphore mutex;
	private Semaphore empty; // hay espacia
	private Semaphore full; //hay datos

	public Consumidor(BufferContoler buff, Semaphore mutex, Semaphore empty, Semaphore full) {
		this.buffer = buff;
		this.mutex = mutex;
		this.empty = empty;
		this.full = full;

	}

	public void run() {

		while (true) {
			try {

				//full.wait();
				//mutex.wait();

				full.acquire();
				mutex.acquire();
				
				System.out.println("Esperando a consumir");
				System.out.println("Consumiendo: "+buffer.extract());
				System.out.println("Liberacion");
				
				mutex.release();
				empty.release();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
