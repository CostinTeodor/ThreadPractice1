import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Player {
    private static final LetterBag letterBag = LetterBag.getInstance();
    private final String name;
    private final int maxLetters = 7;
    List<String> letters = new ArrayList<>();
    private int noOfLetters;


    public Player() {
        name = Generators.alphabeticGenerator((int) (Math.random() * 10) + 1);
    }

    public void pickLetter() {
        while (noOfLetters < maxLetters) {
            synchronized (this) {
                if (noOfLetters + LetterBag.lettersLeft < maxLetters) {
                    for (Letter l : letterBag.getLetters()
                    ) {
                        while (l.getCount() != 0) {
                            letters.add(String.valueOf(l.getCharacter()));
                            letterBag.useCharacter(l.getCharacter());
                            LetterBag.lettersLeft--;
                            noOfLetters++;
                        }
                    }

                } else {
                    Random r = new Random();
                    char letter = (char) (r.nextInt('z' - 'a' + 1) + 'a');
                    if (letterBag.getCountByChar(letter) != 0) {
                        letters.add(String.valueOf(letter));
                        letterBag.useCharacter(letter);
                        noOfLetters++;
                        LetterBag.lettersLeft--;
                    }
                }
                return;
            }
        }
    }

    synchronized void extractLetters() {
        while (noOfLetters < maxLetters) {
            if (noOfLetters + LetterBag.lettersLeft < maxLetters) {
                for (Letter l : letterBag.getLetters()
                ) {
                    while (l.getCount() != 0) {
                        letters.add(String.valueOf(l.getCharacter()));
                        letterBag.useCharacter(l.getCharacter());
                        LetterBag.lettersLeft--;
                        noOfLetters++;
                    }
                }
                break;

            } else {
                Random r = new Random();
                char letter = (char) (r.nextInt('z' - 'a' + 1) + 'a');
                if (letterBag.getCountByChar(letter) != 0) {
                    letters.add(String.valueOf(letter));
                    letterBag.useCharacter(letter);
                    noOfLetters++;
                    LetterBag.lettersLeft--;
                }
            }
        }
    }

    synchronized void generateWords() {
        int randomSizeWord = (int) (Math.random() * 7) + 1;
        StringBuilder randomWord = new StringBuilder();
//        System.out.println(randomSizeWord);
//        System.out.println(letters);


        for (String ch : letters) {
            randomWord.append(ch);
        }
//        System.out.println(noOfLetters);
        if (maxLetters > noOfLetters) {
            return;
        }

        randomWord = new StringBuilder(randomWord.substring(0, randomSizeWord));

        System.out.println(randomWord);

        List<String> subLetters = letters.subList(0, randomSizeWord);
        subLetters.clear();

        noOfLetters = letters.size();
//        System.out.println(letters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
