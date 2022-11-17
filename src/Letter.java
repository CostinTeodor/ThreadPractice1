public class Letter {
    private final char character;
    private final int points = (int) (Math.random() * 10 + 1);
    private int count;
    public Letter(char character) {
        this.character = character;
        this.count = 10;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "character=" + character +
                ", count=" + count +
                '}';
    }

    public char getCharacter() {
        return character;
    }

    public int getCount() {
        return count;
    }

    public void useLetter() {
        this.count--;
    }
}
