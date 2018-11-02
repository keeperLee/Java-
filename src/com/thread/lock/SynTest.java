package com.thread.lock;

/**
 * �ùؼ���synchronized�������߳�ͬʱ�����ٽ��������⡣
 * @author ASUS
 *
 */


class Share2{
	private int a;
	//����һ�������������3���̹߳���һ������1����������������1����
	
	public Share2(){
		a = 0;				//�������
	}
	
	public Share2(int d){
		a = d;
	}
	//�ٽ���1���Թ���������ݼ�1
	public void add(){
		
		synchronized (this) {
			a = a + 1;
			System.out.println("Add:"+a);			//�������a�����Ķ���this����
		}
	}
	//�ٽ���2���Թ���������ݼ�1
			public void dec(){
				synchronized (this) {
					if(a>0){
						a = a - 1;
						System.out.println("Dec:"+a);	//�����ͬһ���������
					}
				}
				
			}
}
//�Թ����������1�������߳�
 class AddThread2 extends Thread{
	private Share2 s1;
	public AddThread2(Share2 share){
		s1 = share;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			s1.add();    			//����1����
			yield();
		}
	}
}

//�Թ����������1�������߳�
class DecThread2 extends Thread{
	private Share2 s2;
	public DecThread2(Share2 s4){
		s2 = s4;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			s2.dec();    			//����1����
			yield();
		}
	}
} 

public class SynTest {
	public static void main(String[] args) {
		Share2 share = new Share2();
		new AddThread2(share).start();
		new DecThread2(share).start();
		new DecThread2(share).start();
	}
}

