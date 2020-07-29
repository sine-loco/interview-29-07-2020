package ru.snm.interview.lowest_unique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sine-loco
 */
public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main( String[] args ) throws IOException {
        InputStreamReader reader =
                new InputStreamReader( System.in, StandardCharsets.UTF_8 );
        BufferedReader in = new BufferedReader( reader );
        String line;
        while ( ( line = in.readLine() ) != null ) {
            System.out.println( getLowestUnique( line ) );
        }
    }

    static int getLowestUniqueSlow( String line ) {
        String[] split = line.split( "\\s+" );
        Set<String> incoming = new HashSet<>();
        TreeSet<Integer> sorted = new TreeSet<>();
        for ( String s : split ) {
            int i = Integer.parseInt( s );
            if ( incoming.add( s ) ) {
                sorted.add( i );
            } else {
                sorted.remove( i );
            }
        }
        return sorted.first();
    }

    static int getLowestUnique( String line ) {
        int[] sorted = Arrays.stream( line.split( "\\s+" ) )
                .map( Integer::valueOf )
                .mapToInt( Integer::intValue )
                .sorted()
                .toArray();

        for ( int i = 0; i < sorted.length; i += 2 ) {
            if (i + 1 == sorted.length)  {
                return sorted[i];
            }
            if ( sorted[i] != sorted[i + 1]) {
                return sorted[i];
            }
        }
        return Integer.MAX_VALUE;
    }
}
