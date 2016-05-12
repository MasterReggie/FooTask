package edu.csu.etl;

import java.io.IOException;

public class App {
	
	public static void main(String[] args) throws IOException {
		
		WorkerThread w1 = new WorkerThread("Source1");
		WorkerThread w2 = new WorkerThread("Source2");
		WorkerThread w3 = new WorkerThread("Source3");
		WorkerThread w4 = new WorkerThread("Source4");
		WorkerThread w5 = new WorkerThread("Source5");
		
		w1.start();
		w2.start();
		w3.start();
		w4.start();
		w5.start();
		
		System.in.read();
	}
}
