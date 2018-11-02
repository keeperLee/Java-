 package com.thread.lock;
/**
 * 测试对临界区不加特别考虑会产生什么样的后果。
 * @author ASUS
 *
 */
class Share{
	private int a;
	//这是一个共享变量，由3个线程共享，一个做加1操作，另两个做减1操作
	
	public Share(){
		a = 0;				//共享变量
	}
	
	public Share(int d){
		a = d;
	}
	//临界区1，对共享变量数据加1
	public void add(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		a = a + 1;
		System.out.println("Add:"+a);
	}
	//临界区2，对共享变量数据减1
		public void dec(){
			if(a>0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				a = a - 1;
				System.out.println("Dec:"+a);
			}
		}
}
 //对共享变量做加1操作的线程
class AddThread extends Thread{
	private Share s1;
	public AddThread(Share s3){
		s1 = s3;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			s1.add();    			//做加1操作
		}
	}
} 

//对共享变量做减1操作的线程
class DecThread extends Thread{
	private Share s2;
	public DecThread(Share s4){
		s2 = s4;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			s2.dec();    			//做减1操作
		}
	}
} 

//因为临界区中的add()和dec()操作都不是原子操作，运行结果出现负值，这并不是所期望的。
public class Test {
	public static void main(String[] args) {
		Share share = new Share();
		new AddThread(share).start();
		new DecThread(share).start();
		new DecThread(share).start();
	}
}
