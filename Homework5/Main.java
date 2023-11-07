public class Main {

    public static void main(String[] args) {
        int numPhilosophers = 5;
        DiningTable diningTable = new DiningTable();
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i + 1, diningTable);
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
