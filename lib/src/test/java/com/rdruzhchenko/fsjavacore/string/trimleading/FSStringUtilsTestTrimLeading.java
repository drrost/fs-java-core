package com.rdruzhchenko.fsjavacore.string.trimleading;

import com.rdruzhchenko.fsjavacore.FSStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FSStringUtilsTestTrimLeading {

    @Test
    void testTrimEmpty() {
        // Given
        String s = "";

        // When
        var result = FSStringUtils.trimLeading(s);

        // Then
        assertEquals("", result);
    }

    @Test
    void testTrimWithoutSpaces() {
        // Given
        String s = "one two";

        // When
        var result = FSStringUtils.trimLeading(s);

        // Then
        assertEquals("one two", result);
    }

    @Test
    void testTrimOnlyTailSpaces() {
        // Given
        String s = "one  two   ";

        // When
        var result = FSStringUtils.trimLeading(s);

        // Then
        assertEquals("one  two   ", result);
    }

    @Test
    void testTrimLeadAndTailSpaces() {
        // Given
        String s = "  one  two   ";

        // When
        var result = FSStringUtils.trimLeading(s);

        // Then
        assertEquals("one  two   ", result);
    }
}
