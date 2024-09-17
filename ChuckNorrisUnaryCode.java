package chucknorris;
import java.lang.StringBuilder;
import java.util.Scanner;

record ChuckNorrisUnaryCode(String zeroPrefix, String onePrefix) {

    static StringBuilder binary = new StringBuilder();
    static StringBuilder chuck = new StringBuilder();

    public void encode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String text = scanner.nextLine();
        binary = textToBinaryConverter(text);
        chuck = binaryToChuckConverter(binary);
        System.out.println("Encoded string:");
        System.out.println(chuck + "\n");

    }

    static StringBuilder textToBinaryConverter(String input) {
        try {
            for (int index = 0; index < input.length(); index++) {
                binary.append("%7s".formatted(Integer.toBinaryString(input.charAt(index))).replace(' ', '0'));
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return binary;
    }

    public StringBuilder binaryToChuckConverter(StringBuilder binary) {

        for (int j = 0; j < binary.length(); j++) {
            if (binary.charAt(j) == '0') {
                StringBuilder zero = new StringBuilder(zeroPrefix());
                for (int y = j; y < binary.length(); y++) {

                    if (binary.charAt(j) == '0') {
                        zero.append("0");
                        j++;
                    } else {
                        j -= 1;
                        break;
                    }
                }

                chuck.append(zero);
                if (j < binary.length()) {
                    chuck.append(" ");
                }

            } else if (binary.charAt(j) == '1') {
                StringBuilder one = new StringBuilder(onePrefix());

                for (int y = j; y < binary.length(); y++) {

                    if (binary.charAt(j) == '1') {
                        one.append("0");
                        j++;
                    } else {
                        j -= 1;
                        break;
                    }
                }
                chuck.append(one);
                if (j < binary.length()) {
                    chuck.append(" ");
                }
            }
        }
        return chuck;
    }

}
