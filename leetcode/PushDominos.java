import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/push-dominoes/description/
public class PushDominos {
    public static String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder();
        int length;
        int startIndex = 0;
        while(startIndex < dominoes.length()) {
            Character currentChar = dominoes.charAt(startIndex);
            length = getLengthOfCurrentChar(dominoes, startIndex);
            int nextCharIndex = startIndex + length;
            int previousCharIndex = startIndex - 1;
            if(currentChar.equals('.')) {
                if(previousCharIndex >= 0 && dominoes.charAt(previousCharIndex) == 'R'
                        && nextCharIndex < dominoes.length() && dominoes.charAt(nextCharIndex) == 'L') {
                    result.append(Character.toString('R').repeat(length/2));
                    if(length % 2 == 1) result.append(Character.toString('.'));
                    result.append(Character.toString('L').repeat(length/2));
                } else if (previousCharIndex >= 0 && dominoes.charAt(previousCharIndex) == 'R' ) {
                    result.append(Character.toString('R').repeat(length));
                } else if (nextCharIndex < dominoes.length() && dominoes.charAt(nextCharIndex) == 'L') {
                    result.append(Character.toString('L').repeat(length));
                } else {
                    result.append(currentChar.toString().repeat(length));
                }
            } else {
                result.append(currentChar.toString().repeat(length));
            }
            startIndex += length;
        }

        return result.toString();
    }

    private static int getLengthOfCurrentChar(String input, int startingIndex) {
        char currentChar = input.charAt(startingIndex);
        int i = startingIndex + 1;
        int length = 1;
        while(i < input.length() && input.charAt(i) == currentChar) {
            length++;
            i++;
        }
        return length;
    }

    @Test
    public void main() {
        Assertions.assertEquals("RR.L", pushDominoes("RR.L"));
        Assertions.assertEquals("LL.RR.LLRRLL..", pushDominoes(".L.R...LR..L.."));
        Assertions.assertEquals("RR", pushDominoes("R."));
    }
}
