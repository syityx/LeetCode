package 多线程交替打印;
public class Func1 {

    public static boolean flag = true;
    public static Object Lock = new Object();
    public static int max = 100;
    public static int num = 0;
    public static void main(String[] args){
        new Thread(() -> {
            while(num <= max){
                synchronized(Lock){
                    while(!flag){
                        try{
                            Lock.wait();
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    if(num <= max){
                        System.out.println("t1, " + num);
                        num++;
                        flag = false;
                    }
                    
                    Lock.notifyAll();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while(num <= max){
                synchronized(Lock){
                    while(flag){
                        try{
                            Lock.wait();
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    if(num <= max){
                        System.out.println("t2, " + num);
                        num++;
                        flag = true;
                    }
                    
                    Lock.notifyAll();
                }
            }
        }, "t2").start();

    }
}

