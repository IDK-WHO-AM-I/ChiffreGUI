package chiffre;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SubstitutionChiffre extends ChiffreAlgorythm<String> {

    private static List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private char[] replacements;

    public SubstitutionChiffre(String key) {
        super(key);
        buildReplacements();
    }

    public SubstitutionChiffre() {
        this(generateKey());
    }

    private static String generateKey() {
        Collections.shuffle(alphabet);
        return alphabet.stream().map(character -> character + "").collect(Collectors.joining(""));
    }

    private void buildReplacements() {
        replacements = getKey().toCharArray();
    }

    @Override
    public String encrypt() {
        startTiming();
        StringBuilder sb = new StringBuilder();
        for (char c : getText().toCharArray()) {
            if (c > 122 || c < 97) sb.append(c);
            else sb.append(replacements[c - 97]);
        }
        stopTiming();
        return sb.toString();
    }

    @Override
    public String decrypt() {
        startTiming();
        StringBuilder sb = new StringBuilder();
        for (char c : getText().toCharArray()) {
            if (c > 122 || c < 97) sb.append(c);
            else sb.append((char) (Arrays.asList(replacements).indexOf(c) + 97));
        }
        stopTiming();
        return sb.toString();
    }
}
