package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempConverterTest {

    @Test
    void convertFahr() {
        double result = TempConverter.convertFahr(32);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void convertCel() {
        double result = TempConverter.convertCel(20);
        assertEquals(68.0, result, 0.001);
    }

    @Test
    void convertKel() {
        double result = TempConverter.kelvintoCel(273);
        assertEquals(-0.15, result, 0.01); // allow small margin of error
    }


    @Test
    void convertKeltoFarTest() {
        double result = TempConverter.kelvinToFah(300.1);
        // Expected value depends on your formula; adjust if needed
        assertEquals(80.33, result, 0.5);
    }
}
