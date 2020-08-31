package chiffre;

import java.util.Map;

public class PlayfairChiffre extends MatrixChiffreAlgorythm {

    public PlayfairChiffre(String key) {
        super(key.toLowerCase().trim());
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String encrypt() {
        StringBuilder sb = new StringBuilder();
        String cutUp = getText().replaceAll(" ", "").replaceAll("(.)(?=\\1)", "$1x").replaceAll("(.{2})", "$1 ");
        if (cutUp.replaceAll(" ", "").length() % 2 != 0)
            cutUp += "x";
        for (String cut : cutUp.split(" ")) {
            int firstKey = chars.entrySet().stream().filter(entry -> entry.getValue().equals(cut.charAt(0))).map(Map.Entry::getKey).findFirst().get();
            int secondKey = chars.entrySet().stream().filter(entry -> entry.getValue().equals(cut.charAt(1))).map(Map.Entry::getKey).findFirst().get();
            if (firstKey / 10 == secondKey / 10) {
                if (firstKey % 5 == 0) {
                    sb.append(chars.get(firstKey - 4));
                } else {
                    sb.append(chars.get(firstKey + 1));
                }
                if (secondKey % 5 == 0) {
                    sb.append(chars.get(secondKey - 4));
                } else {
                    sb.append(chars.get(secondKey + 1));
                }

            } else if (firstKey % 10 == secondKey % 10) {
                if (firstKey + 10 > 60) {
                    sb.append(chars.get(firstKey - 40));
                } else {
                    sb.append(chars.get(firstKey + 10));
                }
                if (secondKey + 10 > 60) {
                    sb.append(chars.get(secondKey - 40));
                } else {
                    sb.append(chars.get(secondKey + 10));
                }
            } else {
                sb.append(chars.get((firstKey / 10) * 10 + secondKey % 10));
                sb.append(chars.get((secondKey / 10) * 10 + firstKey % 10));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public String decrypt() {
        String cutUp = getText();
        StringBuilder sb = new StringBuilder();
        for (String cut : cutUp.split(" ")) {
            int firstKey = chars.entrySet().stream().filter(entry -> entry.getValue().equals(cut.charAt(0))).map(Map.Entry::getKey).findFirst().get();
            int secondKey = chars.entrySet().stream().filter(entry -> entry.getValue().equals(cut.charAt(1))).map(Map.Entry::getKey).findFirst().get();
            if (firstKey / 10 == secondKey / 10) {
                if (firstKey % 10 == 1) {
                    sb.append(chars.get(firstKey + 4));
                } else {
                    sb.append(chars.get(firstKey - 1));
                }
                if (secondKey % 10 == 1) {
                    sb.append(chars.get(secondKey - 4));
                } else {
                    sb.append(chars.get(secondKey - 1));
                }

            } else if (firstKey % 10 == secondKey % 10) {
                if (firstKey - 10 < 10) {
                    sb.append(chars.get(firstKey + 40));
                } else {
                    sb.append(chars.get(firstKey - 10));
                }
                if (secondKey - 10 < 10) {
                    sb.append(chars.get(secondKey + 40));
                } else {
                    sb.append(chars.get(secondKey - 10));
                }
            } else {
                sb.append(chars.get((firstKey / 10) * 10 + secondKey % 10));
                sb.append(chars.get((secondKey / 10) * 10 + firstKey % 10));
            }
        }
        return sb.toString().replaceAll("x", "");
    }

}
