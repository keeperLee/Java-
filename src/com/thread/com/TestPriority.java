package com.thread.com;

public class TestPriority {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread3());
		Thread t2 = new Thread(new MyThread4());
		
//		MyThread3 t1 = new MyThread3();
//		MyThread4 t2 = new MyThread4();
		
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}
}

class MyThread3 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			//获取线程的优先级
			System.out.println(currentThread().getName()+":"+currentThread().getPriority());
		}
	}
}

class MyThread4 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			//获取线程的优先级
			System.out.println(currentThread().getName()+":"+currentThread().getPriority());
		}
		
	}
}
