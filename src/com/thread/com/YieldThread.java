package com.thread.com;


public class YieldThread extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.println(currentThread().getName());
			yield();					//暂时放弃CPU,给其他的线程运行的机会。
		}
	}
	
	public static void main(String[] args) {
		YieldThread m1 = new YieldThread();
		YieldThread m2 = new YieldThread();
		m1.start();
		m2.start();
	}

}
