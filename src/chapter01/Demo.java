package chapter01;

public class Demo {
    private static volatile Object resourceA=new Object();
    private static volatile Object resourceB=new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB lock");
                        System.out.println("threadA release resourceA lock");

                        resourceA.wait();

                    }
                }
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        });

  Thread threadB =new Thread(new Runnable() {
      @Override
      public void run() {
          try {
              Thread.sleep(2);
              synchronized (resourceA) {
                  System.out.println("threadB get resourceA lock");
                  System.out.println("threadB try get resourceB lock......");
              synchronized (resourceB) {
                  System.out.println("threadB get resourceB lock");
                  System.out.println("threadB release resourceA lock");
                  resourceA.wait();
              }
          }
      }catch(InterruptedException e)
      {
          e.printStackTrace();
      }
  }
});
      threadA.start();
      threadB.start();
      threadA.join();
      threadB.join();

        System.out.println("main over");

}
}