package dev3;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        // 1 поток [+]
        // 2 поток [-]
        // [+][-][+][-]....

        MyThread thread1 = new MyThread("+");
        thread1.start();
        MyThread thread2 = new MyThread("-");
        thread2.start();
        Thread.sleep(3000);
        thread1.flag = false;
        thread1.join();
        printMessage("1st stopped!");

    }
    public static final Object KEY = new Object();
    public static void printMessage(String message) {
        synchronized (KEY) {
            try {
                System.out.print("[");
                Thread.sleep(300);
                System.out.print(message);
                Thread.sleep(300);
                System.out.print("]");
               // KEY.notify();
               // KEY.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } // synchronized
    }
}
class MyThread extends Thread {

    private String mess;
    public boolean flag = true;
    MyThread(String message) {
        this.mess = message;
    }

    @Override
    public void run() {
        while(flag) {
            Program.printMessage(this.mess);
        }
    }
}
