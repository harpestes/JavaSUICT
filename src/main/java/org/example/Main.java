package org.example;

public class Main {
    public static void main(String[] args) {
        Decoder decoder = new Decoder();

        String encryptedFirstCase = "t2st3ng";
        String encryptedSecondCase = "vetviph";
        String encryptedNoneCase = "67890";

        System.out.println("First case: " + decoder.decode(encryptedFirstCase));
        System.out.println("Second case: " + decoder.decode(encryptedSecondCase));
        System.out.println("None case: " + decoder.decode(encryptedNoneCase));
    }
}
