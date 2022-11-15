/**
 * main
 */

public class Main {
    public static void main(String[] args) {
        final int delay = 1000; // mill second
        LifeGame lg = new LifeGame();
        lg.printWorld();
        lg.createGrider(5, 5);
        System.out.println("\u001b[2J");
        lg.printWorld();

        int count = 30;
        for (int i = 0; i < count; i++) {
            // System.out.println("\u001b[2J");
            System.out.println("\n");
            lg.printWorld();
            lg.update();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }
}
