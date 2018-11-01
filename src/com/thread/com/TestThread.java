package com.thread.com;

 class MyThread extends Thread{

	private int a = 0;
	
	public void run(){
		for(int a=0;a<10;a++){
			System.out.println(currentThread().getName()+":"+a);
			try {
				sleep(100);                    //给其他线程运行的机会
			} catch (InterruptedException e) {
//				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}

public class TestThread{
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();     //创建用户线程对象
		thread.start();                       //启动用户线程
		thread.run();                         //主线程调用用户线程对象的run()方法
		
	}
	
}
