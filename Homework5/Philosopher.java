import java.util.Random;

public class Philosopher extends Thread {
    private final int id;
    private DiningTable diningTable;
    private Random random = new Random();

    public Philosopher(int id, DiningTable diningTable) {
        this.id = id;
        this.diningTable = diningTable;
    }

    private void eat() throws InterruptedException {
        diningTable.startEating(id);
        System.out.println("Philosopher " + id + " is eating");
        Thread.sleep(500);
        diningTable.finishEating();
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking");
        Thread.sleep(random.nextInt(2500));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                eat();
                think();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
