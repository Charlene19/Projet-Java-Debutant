package app;


public class Chrono implements Runnable  {

    private final int PAUSE = 3; // attente pour tour du fond d'écran
   

    @Override
    public void run() {
        while (true) {

            Main.scene.repaint();

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
  }
 }}
