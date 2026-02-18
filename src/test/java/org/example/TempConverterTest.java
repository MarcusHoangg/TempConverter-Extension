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
        double result = TempConverter.kelvinToCelsius(273);
        assertEquals(-0.15, result, 0.001);
    }

    @Test
    void convertKel2() {
        double result = TempConverter.kelvinToCelsius(300);
        assertEquals(26.85, result, 0.001);
    }

    @Test
    void convertKeltoFarTest() {
        double result = TempConverter.kelvinToFah(300.1);
        assertEquals(80.51, result, 0.01);
    }
}
