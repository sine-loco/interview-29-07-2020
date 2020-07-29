package ru.snm.interview.valid_parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * see valid-parentheses
 *
 * @author sine-loco
 */
public class Main {

    static final char ONE_OPEN = '(';
    static final char ONE_CLOSING = ')';
    static final char TWO_OPEN = '{';
    static final char TWO_CLOSING = '}';
    static final char THREE_OPEN = '[';
    static final char THREE_CLOSING = ']';


    /**
     * Iterate through each line of input.
     */
    public static void main( String[] args ) throws IOException {
        InputStreamReader reader =
                new InputStreamReader( System.in, StandardCharsets.UTF_8 );
        BufferedReader in = new BufferedReader( reader );
        String line;
        while ( ( line = in.readLine() ) != null ) {
            String print;
            if ( isValid( line ) ) {
                print = "True";
            } else {
                print = "False";
            }
            System.out.println( print );
        }
    }

    static boolean isValid( String line ) {

        if ( line == null || line.isBlank() ) {
            return false;
        }
        if ( line.length() % 2 != 0 ) {
            return false;
        }

        char[] chars = line.toCharArray();
        for ( int i = 0; i < chars.length; i += 2 ) {

            if ( !isPair( chars[i], chars[i + 1], ONE_OPEN, ONE_CLOSING ) ) {
                return false;
            }

            if ( !isPair( chars[i], chars[i + 1], TWO_OPEN, TWO_CLOSING ) ) {
                return false;
            }
            if ( !isPair( chars[i], chars[i + 1], THREE_OPEN, THREE_CLOSING ) ) {
                return false;
            }
        }
        return true;
    }

    static boolean isPair( char first, char second, char opening, char closing ) {
        return first != opening || second == closing;
    }
}

