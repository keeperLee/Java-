package com.thread.com;

public class SimpleDaemons implements Runnable{
	int i=0;
	@Override
	public void run() {
		while(i<10){
			i++;
			System.out.println(Thread.currentThread());
		}
	}
	
	public static void main(String[] args) {
		Thread daemon = new Thread(new SimpleDaemons());
		daemon.setDaemon(true);				//��daemon�߳�����Ϊ��̨�߳�
		daemon.start(); 					//������̨�߳�
		System.out.println(daemon.isDaemon());
		System.out.println("main end");
	}
	
}
