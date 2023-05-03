package org.example;

public class IvrParser {
    public static final String SOUND_FORMAT = ".wav";

    public static void main(String[] args) {
        int number = 2250;
        IvrParser parser = new IvrParser();
        System.out.println(parser.getSounds(number));
    }

    private String getSounds(int number) {
        if (number < 0 || number > 9999) {
            throw new IllegalArgumentException("Number should be between 0 and 9999");
        }

        StringBuilder sounds = new StringBuilder();

        if (number == 0) {
            return sounds.append(number).append(SOUND_FORMAT).toString();
        }

        if (number >= 1000) {
            addThousands(number, sounds);
        }

        int hundreds = (number / 100) % 10 * 100;
        if (number >= 100 && hundreds != 0) {
            addHundredsOrTens(sounds, hundreds);
        }

        int tens = (number / 10) % 10 *10;
        if (number >= 100 && tens != 0) {
            addHundredsOrTens(sounds, tens);
        }

        int ones = number % 10;
        if (ones != 0) {
            if (!sounds.isEmpty()){
                sounds.append(" + ");
            }
            sounds.append(ones)
                    .append(SOUND_FORMAT);
        }

        return sounds.toString();
    }

    private void addHundredsOrTens(StringBuilder sounds, int currentNumber) {
        if (!sounds.isEmpty()) {
            sounds.append(" + ");
        }
        sounds.append(currentNumber)
                .append(SOUND_FORMAT);
    }

    private void addThousands(int number, StringBuilder sounds) {
        int thousands = number / 1000;
        sounds.append(thousands);

        if (thousands == 1) {
            sounds.append("na");
        } else if (thousands == 2) {
            sounds.append("ve");
        }
        sounds.append(SOUND_FORMAT)
                .append(" + 1000");

        if (thousands == 2 || thousands == 3 || thousands == 4) {
            sounds.append("chi");
        } else if (thousands != 1) {
            sounds.append("ch");
        }
        sounds.append(SOUND_FORMAT);
    }
}