package com.thread.com;

public class JoinThread {
	public static void main(String[] args) {
		MyThread5 mt = new MyThread5();
		mt.start();
		try {
			mt.join();					//挂起主线程，等待客户线程执行结束
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=1;i<=5;i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class MyThread5 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=5;i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}
