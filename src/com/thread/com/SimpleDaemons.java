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
		daemon.setDaemon(true);				//将daemon线程设置为后台线程
		daemon.start(); 					//启动后台线程
		System.out.println(daemon.isDaemon());
		System.out.println("main end");
	}
	
}
