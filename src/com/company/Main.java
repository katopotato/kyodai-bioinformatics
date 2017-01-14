package com.company;

import java.security.SecureRandom;
import java.util.*;

public class Main {

    private static final ArrayList<Character> DNA = new ArrayList<>(Arrays.asList('A', 'C', 'G', 'T'));
    private static final int DNACount = 4;
    private static final int numLevels = 2;

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        String dna = in.nextLine();
        final int inputLength = dna.length();
        StringBuilder dnaSB = new StringBuilder(dna);
        // Like doing a bfs, bfs will use a queue
        Queue<String> seqTree = new LinkedList<String>();
        // add first item to queue
        seqTree.add(dna);

        for (int i = 0; i < numLevels; i ++) {
            Queue<String> nextLevel = new LinkedList<>();
            while (!seqTree.isEmpty()) {
                String currDna = seqTree.remove();
                for (int j = 0; j < 2; j ++) {
                    StringBuilder currDnaSb = new StringBuilder(currDna);

                    int posToChange = randomPos(inputLength);
                    if (posToChange != -1) {
                        currDnaSb.setCharAt(posToChange, newLetter());
                    }
                    System.out.print(currDnaSb.toString() + "\t");
                    nextLevel.add(currDnaSb.toString());
                }
            }
            seqTree = new LinkedList<>(nextLevel);
            System.out.println();
        }
    }

    // Find position to change
    public static int randomPos(int size) {
        final SecureRandom random = new SecureRandom();
        int pos = random.nextInt(size + 1);
        if (pos == size) return -1;
        return pos;
    }
    // return random letter in range
    public static char newLetter() {
        final SecureRandom random = new SecureRandom();
        return DNA.get(random.nextInt(DNACount));
    }
}
