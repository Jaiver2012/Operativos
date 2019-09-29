package modelo;

import java.util.Random;

/**
 * @author Made by Jaiver Andres Orozco && Luis Fernando Cruces
 * Class where implement all logic about buffer
 */
public class BufferContoler {

	/**
	 * Arrays used to store data(numbers) simulating  a real buffer
	 */
	private int[] buffer;
	
	/**
	 * Size of buffer
	 */
	private int size;
	
	/**
	 * index used to move position of buffer(array) by Productor
	 */
	private int indexProductor;
	
	/**
	 * index used used to move position of buffer(array) by Consumidor
	 */
	private int indexConsumidor;
	
	/**
	 * Public method of BufferCotroler class (Constructor method)
	 * @param t: size of buffer into to console
	 * In this method, the different attributes are initialized 
	 */
	public BufferContoler(int t) {
		size= t;
		buffer = new int[t];
		indexProductor=0;
		indexConsumidor=0;
		init();
	}

	/**
	 * Method to initialize the empty buffer
	 */
	public void init() {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i]=0;
		}
	}

	/**
	 * Method used by Productor to produce a number and to write in the buffer
	 * in a specific position
	 */
	public  void fill() {
		int n = (int) (Math.random()*10) + 1;
		buffer[indexProductor]=n;
		System.out.println("Recurso producido: "+buffer[indexProductor]+ " (PRODUCTOR)");
		int empty= emptySpaces();
		System.out.println("Datos en el buffer: "+ (buffer.length-empty)+ " (PRODUCTOR)");
		System.out.println("Espacio libre en el buffer: "+ empty + " (PRODUCTOR)");
		System.out.println("Estado del buffer: " + statusBuffer() + " (PRODUCTOR)");
		indexProductor=(indexProductor+1)%buffer.length;
	}

	/**
	 * Method used by Consumidor to consume a number (date) of buffer
	 */
	public void extract() {
		int value = buffer[indexConsumidor];
		System.out.println("Recurso consumido: "+value+ " (CONSUMIDOR)");
		buffer[indexConsumidor]=0;
		int empty= emptySpaces();
		System.out.println("Datos en el buffer: "+ (buffer.length-empty)+ " (CONSUMIDOR)");
		System.out.println("Espacio en el buffer: "+ empty+ " (CONSUMIDOR)");
		System.out.println("Estado del buffer: " + statusBuffer() + " (CONSUMIDOR)");
		indexConsumidor = (indexConsumidor+1)%buffer.length;
	}

	/**
	 * Method  in charge to count the empty space(value=0) in the buffer
	 * @return numbers of empty spaces in the buffer
	 */
	public int emptySpaces() {
		int l=0;
		for (int i = 0; i < buffer.length; i++) {
			if(buffer[i]==0)
				l++;
		}
		return l;
	}
	
	/**
	 * This method permit to print status of buffer
	 * @return data in the buffer
	 */
	public String statusBuffer() {
		String status= "";
		for (int i = 0; i < buffer.length; i++) {
			status+="["+buffer[i]+"] ";
		}
		return status;
	}
}
