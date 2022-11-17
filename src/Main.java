public class Main {
    public static void main(String[] args) {
        LetterBag bag = LetterBag.getInstance();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        Multithreading thread1 = new Multithreading(player1);
        thread1.setName("----First");
        Multithreading thread2 = new Multithreading(player2);
        thread2.setName("-------Second");
        Multithreading thread3 = new Multithreading(player3);
        Multithreading thread4 = new Multithreading(player4);

        thread1.start();
        thread2.start();

    }
}