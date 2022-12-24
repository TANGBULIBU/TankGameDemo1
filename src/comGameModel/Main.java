package comGameModel;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

//        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true){
            Thread.sleep(45);//Ïß³ÌÐÝÃß
            tf.repaint();

        }
    }
}
