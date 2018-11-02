package com.thread.com;

import java.util.Date;



/**
 * 调用sleep()方法使主线程睡眠，进入阻塞状态，让客户线程得到CPU
 * @author ASUS
 *
 */
public class TestBlocked {

	public static void main(String[] args) {
		MyThread2 thread = new MyThread2();
		thread.start();
		try {
			Thread.sleep(10000);       //主线程睡眠10秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();          //中断客户线程
	}
}

class MyThread2 extends Thread{
	boolean flag = true;
	@Override
	public void run() {
		while(flag){
			System.out.println("..."+new Date()+"...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
