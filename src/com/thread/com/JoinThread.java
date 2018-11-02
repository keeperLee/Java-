package com.thread.com;

public class JoinThread {
	public static void main(String[] args) {
		MyThread5 mt = new MyThread5();
		mt.start();
		try {
			mt.join();					//�������̣߳��ȴ��ͻ��߳�ִ�н���
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
