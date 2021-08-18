package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idThread = 2; idThread <= 3; idThread++) {
			Thread t = new ThreadCalc(idThread, semaforo);
			t.start();
		}
	}

}
