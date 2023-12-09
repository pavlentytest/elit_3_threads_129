package dev4;

public class Main {

    public volatile boolean flag;
    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("GUI thread stopped!");
            flag = true;
            System.out.println("Flag = "+flag);
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            System.out.println("Flag = "+flag);
            while(!flag) {
                // логика игровая
            }
            System.out.println("LOGIC thread stopped!");
        }
    };

    public void doStart() {
        new Thread(gui).start();
        System.out.println("Started GUI thread!");
        new Thread(logic).start();
        System.out.println("Started LOGIC thread!");
    }


    public static void main(String[] args) {
        new Main().doStart();

        // Игровое приложение
        // 1 поток - поток UI
        // 2 поток - поток Logic



    }
}
