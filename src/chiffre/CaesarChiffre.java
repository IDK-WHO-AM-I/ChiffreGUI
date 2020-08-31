package chiffre;

public class CaesarChiffre extends ChiffreAlgorythm<Integer> {

    public CaesarChiffre(int offset) {
        super(offset);
    }

    @Override
    public String encrypt() {
        startTiming();
        StringBuilder sb = new StringBuilder();
        for (char c : getText().toCharArray()) {
            if (c > 122 || c < 97) sb.append(c);
            else {
                char crypt = (char) (c + getKey());
                if (crypt > 122) {
                    crypt -= 26;
                }
                sb.append(crypt);
            }
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
            else {
                char crypt = (char) (c - getKey());
                if (crypt < 97) {
                    crypt += 26;
                }
                sb.append(crypt);
            }
        }
        stopTiming();
        return sb.toString();
    }
}
