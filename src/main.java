import chiffre.PlayfairChiffre;

public class main {

    public static void main(String[] args) {

        PlayfairChiffre chiffre = new PlayfairChiffre("CDEFG");

        chiffre.setText("aepfel sind lecker");

        String encrypt = chiffre.encrypt();

        System.out.println(encrypt);

        chiffre.setText(encrypt);

        System.out.println(chiffre.decrypt());


    }

}
