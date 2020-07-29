package ru.snm.interview.lowest_unique;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sine-loco
 */
class MainTest {

    @ParameterizedTest
    @MethodSource("lowestUnique")
    void getLowestUnique(String line, int expected) {
        int actual = Main.getLowestUnique( line );

        assertEquals( expected, actual );
    }

    static Stream<Arguments> lowestUnique() {
        return Stream.of( 
                Arguments.of( "1 0", 0 ),
                Arguments.of( "1 0 0", 1 ),
                Arguments.of( "1 0 0 1 2 3 ", 2 )
        );
    }
}