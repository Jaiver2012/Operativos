package modelo;

import java.util.Random;

/**
 * 
 * @author Made by Jaiver Andres Orozco && Luis Fernando Cruces
 *
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
	 * index used to move position of buffe(array) by Productor
	 */
	private int indexProductor;
	
	/**
	 * index used used to move position of buffe(array) by Consumidor
	 */
	private int indexConsumidor;
	
	/**
	 * Class used to generate random numbers
	 */
	private Random random;

	
	/**
	 * Public method of BufferCotroler class (Constructor method)
	 * @param t: size of buffer into to console
	 * In this method, the different attributes are initialized 
	 */
	public BufferContoler(int t) {
		size= t;
		buffer = new int[t];
		random= new Random();
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
	 * in specific position
	 */
	public  void fill() {
		int n = random.nextInt(20);
		buffer[indexProductor]=n;
		indexProductor=(indexProductor+1)%buffer.length;
		System.out.println("Recurso producido: "+buffer[indexProductor]);
		int empty= emptySpaces();
		System.out.println("Datos en el buffer: "+ (buffer.length-empty));
		System.out.println("Espacio en el buffer: "+ empty);
	}
	
	/**
	 * Method used by Consumidor to consume a number (date) of buffer
	 */
	public void extract() {
		int value = buffer[indexConsumidor];
		indexConsumidor = (indexConsumidor+1)%buffer.length;
		System.out.println("Recurso consumido: "+buffer[indexProductor]);
		int empty= emptySpaces();
		System.out.println("Datos en el buffer: "+ (buffer.length-empty));
		System.out.println("Espacio en el buffer: "+ empty);
	}
	
	/**
	 * Method  in charge to count the empty space(value=0) in the buffer
	 * @return
	 */
	public int emptySpaces() {
		int l=0;
		for (int i = 0; i < buffer.length; i++) {
			if(buffer[i]==0)
				l++;
		}
		return l;
	}
	
}
