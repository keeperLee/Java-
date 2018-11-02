package com.thread.lock;

/**
 * 用关键字synchronized解决多个线程同时访问临界区的问题。
 * @author ASUS
 *
 */


class Share2{
	private int a;
	//这是一个共享变量，由3个线程共享，一个做加1操作，另两个做减1操作
	
	public Share2(){
		a = 0;				//共享变量
	}
	
	public Share2(int d){
		a = d;
	}
	//临界区1，对共享变量数据加1
	public void add(){
		
		synchronized (this) {
			a = a + 1;
			System.out.println("Add:"+a);			//共享变量a所属的对象this加锁
		}
	}
	//临界区2，对共享变量数据减1
			public void dec(){
				synchronized (this) {
					if(a>0){
						a = a - 1;
						System.out.println("Dec:"+a);	//必须对同一个对象加锁
					}
				}
				
			}
}
//对共享变量做加1操作的线程
 class AddThread2 extends Thread{
	private Share2 s1;
	public AddThread2(Share2 share){
		s1 = share;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			s1.add();    			//做加1操作
			yield();
		}
	}
}

//对共享变量做减1操作的线程
class DecThread2 extends Thread{
	private Share2 s2;
	public DecThread2(Share2 s4){
		s2 = s4;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			s2.dec();    			//做减1操作
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

