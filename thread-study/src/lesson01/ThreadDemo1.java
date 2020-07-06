package lesson01;


public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }
}
