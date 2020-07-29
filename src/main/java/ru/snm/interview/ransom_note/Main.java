package ru.snm.interview.ransom_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    public static final int LEN = 256;

    /**
     * Iterate through each line of input.
     */
    public static void main( String[] args ) throws IOException {
        InputStreamReader reader =
                new InputStreamReader( System.in, StandardCharsets.UTF_8 );
        BufferedReader in = new BufferedReader( reader );

        String ransomNote = in.readLine();
        int numOfMagazines = Integer.parseInt( in.readLine() );
        StringBuilder magazines = new StringBuilder();
        for ( int i = 0; i < numOfMagazines; i++ ) {
            magazines.append( in.readLine() );
        }

        System.out.println( compare( ransomNote, magazines.toString() ) );
    }

    static boolean compare( CharSequence ransom, CharSequence dictionary ) {
        int[] ransomVoc = buildVocabulary( ransom );
        int[] dictVoc = buildVocabulary( dictionary );
        return contains( dictVoc, ransomVoc );
    }

    static int[] buildVocabulary( CharSequence source ) {
        int[] vocabulary = new int[LEN];
        for ( int i = 0; i < source.length(); i++ ) {
            char c = source.charAt( i );
            if ( Character.isLetter( c ) ) { vocabulary[c]++; }
        }
        return vocabulary;
    }

    static boolean contains(int[] firstVocabulary, int[] secondVocabulary) {
        for ( int i = 0; i < LEN; i++ ) {
            if ( secondVocabulary[i] > firstVocabulary[i] ) {
                return false;
            }
        }
        return true;
    }
}