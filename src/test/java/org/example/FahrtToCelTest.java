package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TempConverterTest {
 // initial method
    @Test
    void convertFahr() {
        int test = (TempConverter.convertFahr(32));

        assertEquals(0, test);

        }


        // Add in the class demo
    @Test
    void convertCel(){
         int test= (TempConverter.convertCel(20));
         assertEquals(68,test);
    }

    // Inclass exercise
    @Test
    void convertKel(){
        int test= (TempConverter.kelvintoCel(273));
        assertEquals(0,test);
    }

    @Test
    void convertKeltoFarTest() {
        double test =Math.round(TempConverter.kelvinToFah(300.1));
        assertEquals(59.0, test);
    }
    }
