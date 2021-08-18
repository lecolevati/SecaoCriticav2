package controller;

import java.util.concurrent.Semaphore;

public class ThreadCalc extends Thread {

	private static double res;
	private int idThread;
	private Semaphore semaforo;
	
	public ThreadCalc(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
//		metodo();
//		----------------Seção Crítica----------------
		try {
			semaforo.acquire();
			op();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//Bloco que é executado apos um try ou um catch
			semaforo.release();
		}
//		------------------------------------
//		metodo2();
	}

	private void op() {
		res = 1;
		if (idThread % 2 == 0) {
			for (double i = 1.0 ; i < 10.0 ; i++) {
				res = res * i;
				System.out.println(res);
			}
		} else {
			for (double i = 1.0 ; i < 10.0 ; i++) {
				res = res / i;
				System.out.println(res);
			}
		}
	}
	
}
