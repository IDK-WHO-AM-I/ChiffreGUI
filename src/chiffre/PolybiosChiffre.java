package chiffre;

public class PolybiosChiffre extends MatrixChiffreAlgorythm {

    public PolybiosChiffre(String key) {
        super(key.toLowerCase().trim());
    }

    @Override
    public String encrypt() {
        startTiming();
        StringBuilder sb = new StringBuilder();
        for (char c : getText().toCharArray()) {
            sb.append(chars.entrySet().stream().filter(entry -> entry.getValue().equals(c)).map(e -> e.getKey().toString()).findFirst().orElse("00"));
            sb.append(" ");
        }
        stopTiming();
        return sb.toString();
    }

    @Override
    public String decrypt() {
        startTiming();
        StringBuilder sb = new StringBuilder();
        for (String st : getText().split(" ")) {
            int nr = Integer.parseInt(st);
            sb.append(chars.getOrDefault(nr, ' '));
        }
        stopTiming();
        return sb.toString();
    }
}
