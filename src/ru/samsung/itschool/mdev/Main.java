package ru.samsung.itschool.mdev;

public class Main {

    public volatile static boolean flag;

    public static void main(String[] args) {
	    // Некое игровое приложение
        //  - поток UI
        // - поток логики игры
        new Main().doStart();
    }

    void doStart() {
        new Thread(gui).start();
        System.out.println("Start game GUI!");
        new Thread(logic).start();
        System.out.println("Logic game start!");
    }

    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stop GUI");
            flag = true;
        }
    };
    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // беск цикл
            }
            System.out.println("Stop game logic!");
        }
    };

}
