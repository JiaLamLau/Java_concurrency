package chapter01;

public  class RunableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("I am a child thread");
    }


    public static void main(String[] args) throws InterruptedException{
        RunableTask task =new RunableTask();
        new Thread(task).start();
        new Thread(task).start();

    }
}
