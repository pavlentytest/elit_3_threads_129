public class Main {
    public static void main(String[] args) {

        new MyThread().start();
        new MyThread().start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // логика потока
            }
        }).start();

    }
}
class MyThread extends Thread {
    @Override
    public void run() {
      // логика потока
    }
}
class MyThread2 implements Runnable {

    @Override
    public void run() {
        // логика потока
    }
}
