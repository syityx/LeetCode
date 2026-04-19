package 多线程交替打印;

public class Func3 {
    
    public static int num = 0;
    public static final int max = 100;
    public static final Object Lock = new Object();

    public static void main(String[] args) {

        new Thread(new Seq(0)).start(); 
        new Thread(new Seq(1)).start();
        
    }

    public static class Seq implements Runnable{
        private final int index;
        
        public Seq(int index){
            this.index = index;
        }

        @Override
        public void run(){
            while (num <= max) {
                synchronized(Lock){
                    while(num % 2 != index){
                        try{
                            Lock.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }

                    // 是当前线程打印
                    if(num > max){
                        Lock.notifyAll();
                        return;
                    }
                    System.out.println("Func3-t" + index + ", " + num);
                    // 交替打印A、B
                    // System.out.println("Func3-t" + index + ", " + (index == 0? "A": "B"));
                    num ++;
                    Lock.notifyAll();
                }
            }
        }
    }
}
