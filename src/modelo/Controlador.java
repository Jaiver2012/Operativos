package modelo;

import java.nio.Buffer;
import java.util.concurrent.Semaphore;

public class Controlador {

	
	
	
	/**
	 * Por este enlace se debe subir la soluci�n en Java (debidamente documentada) al problema del buffer 
	 * limitado. La soluci�n debe emplear sem�foros. Para hacer que el productor y el consumidor trabajen a
	 *  velocidades diferentes, se puede poner a dormir al hilo respectivo por un per�odo aleatorio de 
	 *  tiempo. El n�mero de posiciones del buffer debe poder especificarse como par�metro de entrada al 
	 *  correr el programa. .La soluci�n puede presentarse en equipos de dos personas (en tal caso, 
	 *  solamente es necesario que uno de los dos integrantes del equipo suba el trabajo). 
	 *  Los nombres de los dos integrantes deben aparecer como comentarios en el c�digo.
	 * 
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Se instancia los semaforos requeridos
		Semaphore mutex;
		Semaphore empty;
		Semaphore full;
		//se instancia el buffer
		BufferContoler buffer;
		
		//Instanciar los consumidores
		Consumidor com1;
		Consumidor com2;
		
		//Instanciar los productores
		Productor pro1;
		
		//pedir por consola
		int n=4;
		
		
		//Inician los semaforos
		mutex= new Semaphore(1,true);
		empty= new Semaphore(n);
		full= new Semaphore(0,true);
		
		
		//Se inicializa el buffer
		buffer= new BufferContoler(n);
		
		//Se inicializan los productores y consumidores
		pro1= new Productor(buffer,mutex,empty,full);
		com1= new Consumidor(buffer,mutex,empty,full);
		com2= new Consumidor(buffer,mutex,empty,full);
		
		pro1.start();
		com1.start();
	
		
		
		
		

	}
	
		
	

}
