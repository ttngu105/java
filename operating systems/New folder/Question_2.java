import java.util.concurrent.*;
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.io.*;

public class Question_2{
  // Number of philosophers
  final static int n = 4;

  final static Philosopher[] philosophers = new Philosopher[n];

  final static Semaphore mutex = new Semaphore(1);

  public static void main(String[] args) {
    long avgwait=0;
    long avgEat=0;
    long avgThink=0;
    ExecutorService pool = Executors.newFixedThreadPool(4);
    long start = System.nanoTime();
    // Initialize threads
    philosophers[0] = new Philosopher(0);
    pool.submit(philosophers[0]);
    for (int i = 1; i < n; i++) {
      philosophers[i] = new Philosopher(i);
      pool.submit(philosophers[i]);
    }
    boolean attending = true;

    // Start the pool of threads
    while(attending){
      long end = System.nanoTime();
      long done = ((end-start)/1000000);
        if(done >= 60000){
          attending = false;
          pool.shutdown();
        }
    }
    for (int i = 0; i < 4; i++) {
    System.out.println("p"+(i+1)+" time waiting:"+philosophers[i].getWait()+" time eating:"+philosophers[i].getEating()+" time thinking:"+philosophers[i].getThinking());
      avgwait = (avgwait+philosophers[i].getWait());
      avgEat = (avgEat+philosophers[i].getEating());
      avgThink = (avgThink+philosophers[i].getThinking());     
  }
      System.out.println("average waiting:"+(avgwait/4)+" average eating:"+(avgEat/4)+" average thinking:"+(avgThink/4));
      System.exit(0);
}

  public static class Philosopher extends Thread {

    private enum State {THINKING, HUNGRY, EATING};

    private final int id;
    private State state;
    private final Semaphore self;
    private long eattime;
    private long waittime;
    private long thinktime;

    public void writeToFile(int name,long time,String state){
      try(
        FileWriter eventLog = new FileWriter("event_log2.txt", true);
        BufferedWriter bw = new BufferedWriter(eventLog);
          PrintWriter out = new PrintWriter(bw)){
        out.println("Philosopher:"+name+", time:"+(time/1000000)+" ms, entered  "+state+" state");
        }
      catch(IOException e){
          System.out.println(e);
        } 
}

    Philosopher(int id) {
      this.id = id;
      self = new Semaphore(0);
      state = State.THINKING;
    }
    
    private Philosopher left() {
      return philosophers[id == 0 ? n - 1 : id - 1];
    }

    private Philosopher right() {
      return philosophers[(id + 1) % n];
    }
    
    public void run() {
      try {
        while (true) {
          switch(state) {
          case THINKING: 
            thinkOrEat(state);
            mutex.acquire();
            state = State.HUNGRY; 
            break;
          case HUNGRY:
            // aquire both forks, i.e. only eat if no neighbor is eating
            // otherwise wait
            test(this);
            mutex.release();
            self.acquire();
            state = State.EATING;
            break;
          case EATING:
            thinkOrEat(state);
            mutex.acquire();
            state = State.THINKING;
            // if a hungry neighbor can now eat, nudge the neighbor.
            test(left());  
            test(right());
            mutex.release();
            break;          
          }
        }
      } catch(InterruptedException e) {}
    }

      private void test(Philosopher p) {
      if (p.left().state != State.EATING && p.state == State.HUNGRY &&
          p.right().state != State.EATING) {
        p.state = State.EATING;
        p.self.release();
      }
      else{
          try{
            long start = System.nanoTime();
            Random num = new Random();
            Thread.sleep(num.nextInt(50)+50);
            long end = System.nanoTime();
            this.waittime += (end - start);
            writeToFile(this.id,(end - start),"Hungry");
          }
          catch(InterruptedException e){
            System.out.println(e);
          }
      }
    }

    private void thinkOrEat(State state) {
     long start = System.nanoTime();
     long end;
      if(state == State.THINKING){
        try {
        Thread.sleep(10);
        end = System.nanoTime();
        this.thinktime += end-start;
        writeToFile(this.id,(end - start),"Thinking");
        } catch (InterruptedException e) {
          System.out.println(e);
        }
      }
       else if(state == State.EATING){
        try {
          Random num = new Random();
          Thread.sleep((num.nextInt(30)*10));
          end = System.nanoTime();
          this.eattime += end-start;
          writeToFile(this.id,(end - start),"Eating");
        } catch (InterruptedException e) {
          System.out.println(e);
        }
      }
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
}
