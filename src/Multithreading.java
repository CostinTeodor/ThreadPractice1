public class Multithreading extends Thread {
    private Player player;

    public Multithreading(Player p){
        player = p;
    }

    public void run() {
        while (LetterBag.lettersLeft != 0) {
            System.out.println(this.getName());
            player.pickLetter();
            player.generateWords();
//            System.out.println("Letters left: " + LetterBag.lettersLeft);
//            for (Letter l : letterBag.getLetters()
//            ) {
//                if (l.getCount() != 0)
//                    System.out.println(l);
//            }
        }
        if (player.letters.size() > 0) {
            String randomWord = "";
            for (String ch : player.letters) {
                randomWord += ch;
            }
            System.out.println(randomWord);
        }

    }

}
