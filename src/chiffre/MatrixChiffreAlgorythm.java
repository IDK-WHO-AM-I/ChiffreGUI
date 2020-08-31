package chiffre;

import java.util.LinkedHashMap;

public abstract class MatrixChiffreAlgorythm extends ChiffreAlgorythm<String> {

    protected LinkedHashMap<Integer, Character> chars;

    public MatrixChiffreAlgorythm(String key) {
        super(key);
        setupMatrix();
    }

    protected void setupMatrix() {
        chars = new LinkedHashMap<>();
        int check = 0;
        int row = 0, col = 0;
        for (char c : getKey().toCharArray()) {
            if (chars.containsValue(c)) continue;
            if (check == 0) {
                ++row;
                check = 4;
            } else {
                check--;
            }
            if (col >= 5) col = 0;
            chars.put(Integer.parseInt((row) + "" + (++col)), c);
        }
        for (int x = 'a'; x <= 'z'; x++) {
            if ((char) x == 'j')
                continue;
            if (chars.containsValue((char) x)) {
                continue;
            } else {
                if (check <= 0) {
                    row++;
                    check = 5;
                }
                if (col >= 5) col = 0;
                col++;
                check--;
                if (chars.containsKey(Integer.parseInt(row + "" + col)))
                    continue;
                chars.put(Integer.parseInt(row + "" + col), (char) x);

            }
        }
    }

}
