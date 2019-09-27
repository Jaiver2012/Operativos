package modelo;

import java.util.Random;

public class BufferContoler {

	private int[] buffer;
	private int size;
	private int k=0, j=0;
	Random random;
	int pos;
	
	
	public BufferContoler(int t) {
		size= t;
		buffer = new int[t];
		random= new Random();
		init();
	}
	
	public void init() {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i]=33;
		}
	}
	
	
	public  int fill() {
		int n=0;
		n=random.nextInt(20);
		buffer[k]=n;
		System.out.println("Recurso producido: "+buffer[k]);
		k=(k+1)%buffer.length;
		return n;
	}
	
	public int extract() {
		int value=0;
		value=buffer[j];
		j = (j+1)%buffer.length;
		return value;
	}
	
}
