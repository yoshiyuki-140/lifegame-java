
import java.util.Scanner;

class LifeGame {
    boolean[][] world;
    boolean[][] tmpworld;
    int[] world_size;
    int Dimension;

    LifeGame() {
        // default value of dimension.
        Dimension = 10;
        world_size = new int[2];
        // """ ここほかに移したほうがいいかも
        world_size[0] = 20;
        world_size[1] = Dimension;
        // """
        world = new boolean[world_size[1]][world_size[0]];
        tmpworld = new boolean[world_size[1]][world_size[0]];
        this.worldInit(world);
        this.worldInit(tmpworld);
    }

    void worldInit(boolean world[][]) {
        for (int yi = 0; yi < world_size[1]; yi++) {
            for (int xi = 0; xi < world_size[0]; xi++) {
                world[yi][xi] = false;
            }
        }
    }

    void setWorldSize(int world_size[]) {
        this.world_size[0] = world_size[0];
        this.world_size[1] = world_size[1];
    }

    int howManyAliveCells(int x, int y) {
        int counter = 0;
        int fx = x;
        int fy = y;

        // x%y==(x+n*y)%y
        // の性質を利用するためにwhileを使用
        while (fx < world_size[0]) {
            fx += world_size[0];
        }
        while (fy < world_size[1]) {
            fy += world_size[1];
        }

        if (world[(fy - 1) % this.world_size[1]][(fx - 1) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy - 1) % this.world_size[1]][(fx) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy - 1) % this.world_size[1]][(fx + 1) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy) % this.world_size[1]][(fx - 1) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy) % this.world_size[1]][(fx) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy) % this.world_size[1]][(fx + 1) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy + 1) % this.world_size[1]][(fx - 1) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy + 1) % this.world_size[1]][(fx) % this.world_size[0]]) {
            counter++;
        }
        if (world[(fy + 1) % this.world_size[1]][(fx + 1) % this.world_size[0]]) {
            counter++;
        }
        System.out.print(counter);
        return counter;
    }

    boolean isAliveCell(int x, int y) {
        int count = howManyAliveCells(x, y);
        if (world[y][x]) {
            if (count == 2 || count == 3) {

                return true;
            }
            return false;
        } else {
            if (count == 3) {
                return true;
            }
            return false;
        }
    }

    void copyWorld(boolean from[][], boolean to[][]) {
        for (int yi = 0; yi < world_size[1]; yi++) {
            for (int xi = 0; xi < world_size[0]; xi++) {
                to[yi][xi] = from[yi][xi];
            }
        }
    }

    void printWorld() {
        for (int yi = 0; yi < world_size[1]; yi++) {
            for (int xi = 0; xi < world_size[0]; xi++) {
                if (world[yi][xi]) {
                    System.out.print("x");
                } else {
                    System.out.print(".");
                }
            }
            // 改行
            System.out.println();
        }
    }

    void createGrider(int x, int y) {
        // arg x : x >= 1
        // arg y : y >= 1

        // x.x
        // .xx
        // .x.

        world[y - 1][x - 1] = true;
        world[y - 1][x] = false;
        world[y - 1][x + 1] = true;

        world[y][x - 1] = false;
        world[y][x] = true;
        world[y][x + 1] = true;

        world[y + 1][x - 1] = false;
        world[y + 1][x] = true;
        world[y + 1][x + 1] = false;
    }

    void update() {
        // this.copyWorld(world, tmpworld);

        for (int yi = 0; yi < world_size[1]; yi++) {
            for (int xi = 0; xi < world_size[0]; xi++) {
                tmpworld[yi][xi] = isAliveCell(xi, yi);
            }
        }
        copyWorld(tmpworld, world);
    }
}