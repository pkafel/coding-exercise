import java.util.Map;

// Solution to https://leetcode.com/problems/roman-to-integer/
public class RomanToInt {

    public static final Map<Character, Integer> symbolToValue = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        if(s.length() == 1) return symbolToValue.get(s.charAt(0));

        int result = 0;
        for(int i=0;i < s.length();i++) {
            char currentLetter = s.charAt(i);

            if(i+1 == s.length()) {
                result += symbolToValue.get(currentLetter);
                break;
            }

            char nextLetter = s.charAt(i+1);
            if(symbolToValue.get(currentLetter) >= symbolToValue.get(nextLetter)) {
                result += symbolToValue.get(currentLetter);
            } else {
                result += symbolToValue.get(nextLetter) - symbolToValue.get(currentLetter);
                i++;
            }
        }

        return result;
    }
}