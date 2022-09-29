package chapter01;

public class ThreadTest {
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("I am a child thread");
        }

    }

    public static void main(String[] args) {
        MyThread thread =new MyThread();
        thread.start();
    }
}
