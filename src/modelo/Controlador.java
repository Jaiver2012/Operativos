package modelo;

import java.nio.Buffer;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * @author Made by Jaiver Andres Orozco && Luis Fernando Cruces
 * Class with main method
 */
public class Controlador {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//input number of buffer
		Scanner input = new  Scanner(System.in);
		System.out.println("Escriba el tamñano del buffer:");
		int size = input.nextInt();
	
		//Init buffer with a specific size into to console
		BufferContoler buffer= new BufferContoler(size);
		
		//Init the Semaphores
		Semaphore mutex= new Semaphore(1,true);
		Semaphore empty= new Semaphore(size);
		Semaphore full= new Semaphore(0,true);	
		
		//Init Productor and Consumidor
		Productor pro1= new Productor(buffer,mutex,empty,full);
		Consumidor com1= new Consumidor(buffer,mutex,empty,full);
		pro1.start();
		com1.start();
	}
}
