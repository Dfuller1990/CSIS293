package edu.gcccd.java;
import org.junit.Test;
import static org.junit.Assert.*;

class approxPiTest {

        @Test
        public void Square() {
                double d = approxPI.Square(100000);
                assertTrue(d > 3.140 || d < 3.142);
        }
}