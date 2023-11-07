public class DiningTable {
    private int lastEaten = -1;

    public synchronized void startEating(int philosopherId) throws InterruptedException {
        while (lastEaten == philosopherId) { // проверяем, чтобы текущий философ не ел больше 1 раза подряд
            wait(); // ждем, пока философ не сможет начать обедать
        }

        lastEaten = philosopherId;
    }

    public synchronized void finishEating() {
        notifyAll(); // уведомляем других философов, что текущий закончил обедать
    }
}
