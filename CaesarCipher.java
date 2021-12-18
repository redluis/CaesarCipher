import java.util.Locale;

public class CaesarCipher {
    public static String encode(String input, Language language, int key) {
        String alphabet = language.alphabet;
        String result = "";
        String toEncode = input.toLowerCase(Locale.ROOT);

        int alphabetLength = alphabet.length();
        int inputLength = input.length();
        int shift = key % alphabetLength;

        for (int i = 0; i < inputLength; i++) {
            char temp = toEncode.charAt(i);

            if (Character.isAlphabetic(temp)) {
                int pos = shift + alphabet.indexOf(temp);

                if (pos < 0) {
                    pos = alphabetLength + pos;
                }

                if (pos > alphabetLength) {
                    pos = pos - alphabetLength;
                }

                temp = alphabet.charAt(pos);
            }

            result += temp;
        }

        return result;
    }

    public static String decode(String input, Language language, int key) {
        return encode(input, language, -key);
    }
}
