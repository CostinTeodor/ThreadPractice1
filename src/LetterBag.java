import java.util.ArrayList;
import java.util.List;

public class LetterBag {

    private static final LetterBag instance = new LetterBag();
    private static final String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";

    public static int lettersLeft = lowerCaseAlphabet.length() * 10;
    private final List<Letter> letters = new ArrayList<>();

    private LetterBag() {

        for (char allLetter : lowerCaseAlphabet.toCharArray()) {
            letters.add(new Letter(allLetter));
        }
    }

    public static LetterBag getInstance() {
        return instance;
    }

    public int getCountByChar(char character) {
        for (Letter l : letters) {
            if (l.getCharacter() == character) {
                return l.getCount();
            }
        }
        return 0;
    }

    public void useCharacter(char character) {
        for (Letter l : letters) {
            if (l.getCharacter() == character) {
                l.useLetter();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters
        ) {
            result.append(letter.toString());
        }
        return result.toString();
    }

    public List<Letter> getLetters() {
        return letters;
    }
}
