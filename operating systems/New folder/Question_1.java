import java.util.concurrent.*;
import java.util.Random;
import java.util.concurrent.locks.*;
import java.io.*;

class  Philosopher extends Thread{
private String name;
private Lock lFork;
private Lock rFork;
private long eattime;
private long waittime;
private long thinktime;

Philosopher(String name,Lock lFork,Lock rFork){
	this.name = name;
	this.lFork = lFork;
	this.rFork = rFork;
	this.eattime = 0;
	this.waittime = 0;
	this.thinktime = 0;
}

 public void writeToFile(String name,long time,String state){
 	try(
 		FileWriter eventLog = new FileWriter("event_log1.txt", true);
 		BufferedWriter bw = new BufferedWriter(eventLog);
    	PrintWriter out = new PrintWriter(bw)){
 		out.println("Philosopher:"+this.name+", time:"+time+" ms, entered  "+state+" state");
 		}
 	catch(IOException e){
			System.out.println(e);
		}	
}


@Override
//starts the thread with hungry method
public void run(){
	while (true){
		this.isHungry();
	}
}

private void isWaiting(){
	try{
		long start = System.nanoTime();
		Random num = new Random();
		Thread.sleep(num.nextInt(50)+50);
		long end = System.nanoTime();
		this.waittime = waittime +(end - start);
		writeToFile(this.name, (end - start) /1000000, "hungry");
	}
	catch(InterruptedException e){
		System.out.println(e);
	}
}

private void isEating(){
	try{
		long start = System.nanoTime();
		Random num = new Random();
		Thread.sleep(num.nextInt(30)+10);
		long end = System.nanoTime();
		this.eattime = eattime + (end - start);
		lFork.unlock();
		rFork.unlock();
		writeToFile(this.name,(end - start) /1000000,"eating");
		}
	catch(InterruptedException e){
		System.out.println(e);
	}
}

private void isThinking(){
	try{
		long start = System.nanoTime();
		Thread.sleep(10);
		long end = System.nanoTime();
		this.thinktime = this.thinktime +(end - start);
		writeToFile(this.name,(end - start) /1000000, "thinking");
	}
	catch(InterruptedException e){
		System.out.println(e);
	}
}

private void isHungry(){
	//is left fork present
	if (this.left()){
		//if right fork is present the philosopher then thinks
		if (this.Right()){
			this.isEating();
			this.isThinking();
		}
		else{
			//if the left fork isnt present, philosopher waits for 500-100 miliseconds then tries to grab the forks again
			//if right fork is still not there, drop left, wait then try again
			this.isWaiting();
			if(this.Right() == true){
				this.isEating();
				this.isThinking();
			}
			else{
				this.lFork.unlock();
				this.isWaiting();
				this.isHungry();
			}
		}
	}
	else{
		//ifleft fork isnt there, wait 50-100 miliseconds and try again
		this.isWaiting();
		this.isHungry();
	}
}


private boolean left(){
	return this.lFork.tryLock();
}

private boolean Right(){
	return this.rFork.tryLock();
}


public long getThinking(){
	return(this.thinktime/1000000);
}

public long getWait(){
	return(this.waittime/1000000);
}
public long getEating(){
	return(this.eattime/1000000);
	}
}
public class Question_1{

	public static void main(String[] args){
		//make each fork
		Lock fork1 = new ReentrantLock(true);
		Lock fork2 = new ReentrantLock(true);
		Lock fork3 = new ReentrantLock(true);
		Lock fork4 = new ReentrantLock(true);

		Philosopher p1 = new Philosopher("p1",fork1,fork2);
		Philosopher p2 = new Philosopher("p2",fork2,fork3);
		Philosopher p3 = new Philosopher("p3",fork3,fork4);
		Philosopher p4 = new Philosopher("p4",fork4,fork1);
		
		//create pool of thread that will run
		ExecutorService pool = Executors.newFixedThreadPool(4);
		long start = System.nanoTime();
		boolean attending = true;
		pool.submit(p1);
		pool.submit(p2);
		pool.submit(p3);
		pool.submit(p4);

		while(attending){
			long end = System.nanoTime();
			long done = ((end-start)/1000000);
				if(done >= 60000){
					attending = false;
					pool.shutdown();
				}
		}
			System.out.println("p1 time waiting:"+p1.getWait()+" time eating:"+p1.getEating()+" time thinking:"+p1.getThinking());
			System.out.println("p2 time waiting:"+p2.getWait()+" time eating:"+p2.getEating()+" time thinking:"+p2.getThinking());
			System.out.println("p3 time waiting:"+p3.getWait()+" time eating:"+p3.getEating()+" time thinking:"+p3.getThinking());
			System.out.println("p4 time waiting:"+p4.getWait()+" time eating:"+p4.getEating()+" time thinking:"+p4.getThinking());
			long avgwait = (p1.getWait()+p2.getWait()+p3.getWait()+p4.getWait())/4;
			long avgEat = (p1.getEating()+p2.getEating()+p3.getEating()+p4.getEating())/4;
			long avgThink = (p1.getThinking()+p2.getThinking()+p3.getThinking()+p4.getThinking())/4;
			System.out.println("average waiting:"+avgwait+" average eating:"+avgEat+" average thinking:"+avgThink);			
			System.exit(0);
	}
}
