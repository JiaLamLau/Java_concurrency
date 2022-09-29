package chapter01;

class ThreadDemo extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        //（调用）
        Thread t1 = new ThreadDemo();
        t1.start();

    }
}