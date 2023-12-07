package com.rdruzhchenko.fsjavacore.nameutils;

import com.rdruzhchenko.fsjavacore.FSNameUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FSNameUtilsTestCorrect {

    @Test
    public void correct() {
        // Given
        String name = "Іван-Василь";

        // When
        String corrected = FSNameUtils.correct(name);

        // Then
        assertEquals(name, corrected);
    }

    @Test
    public void ogly() {
        // Given
        String name = "Шаміль-огли";

        // When
        String corrected = FSNameUtils.correct(name);

        // Then
        assertEquals(name, corrected);
    }

    @Test
    public void ogly2() {
        // Given
        String name = "Шарафандін-огли";

        // When
        String corrected = FSNameUtils.correct(name);

        // Then
        assertEquals(name, corrected);
    }

    @Test
    public void daPrefix() {
        // Given
        String name = "Да Сільва";

        // When
        String corrected = FSNameUtils.correct(name);

        // Then
        assertEquals("да Сільва", corrected);
    }

    @Test
    public void daPrefix2() {
        // Given
        String name = "Да сільва";

        // When
        String corrected = FSNameUtils.correct(name);

        // Then
        assertEquals("да Сільва", corrected);
    }
}
