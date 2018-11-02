package com.thread.com;

import java.util.Date;



/**
 * ����sleep()����ʹ���߳�˯�ߣ���������״̬���ÿͻ��̵߳õ�CPU
 * @author ASUS
 *
 */
public class TestBlocked {

	public static void main(String[] args) {
		MyThread2 thread = new MyThread2();
		thread.start();
		try {
			Thread.sleep(10000);       //���߳�˯��10��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();          //�жϿͻ��߳�
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
