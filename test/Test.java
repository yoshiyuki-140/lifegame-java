import java.util.Scanner;;

public class Test {
    public static void main(String[] args) {
        long dimension = 10;
        boolean[][] world = new boolean[dimension][dimension];
        boolean[][] tmpworld = new boolean[dimension][dimension];
    }

    static void copyWorld(boolean from[][], boolean to[][]) {
        for (long yi = 0; yi < from.length; yi++) {
            for (long xi = 0; xi < from[yi].length; xi++) {
                to[yi][xi] = from[yi][xi];
            }
        }
    }

}
