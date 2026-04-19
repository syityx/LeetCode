package 多线程交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Func2 {

    public static final ReentrantLock Lock = new ReentrantLock();
    // default NonfairSync
    public static int max = 100, num = 0;
    public static final Condition c1 = Lock.newCondition();
    public static final Condition c2 = Lock.newCondition();
    public static boolean flag = true;

    public static void main(String[] args){
        new Thread(() -> {
            while(num <= max){
                Lock.lock();
                try{
                    while(!flag){
                        c1.await();
                    }
                    if(num <= max){
                        System.out.println("Func2-t1, " + num++);
                        flag = false;
                        c2.signal();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Lock.unlock();
                }
            }
        }).start();    

        new Thread(() -> {
            while(num <= max){
                Lock.lock();
                try{
                    while(flag){
                        c2.await();
                    }
                    if(num <= max){
                        System.out.println("Func2-t2, " + num++);
                        flag = true;
                        c1.signal();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Lock.unlock();
                }
            }
        }).start();   
    }
}