/**
 * Created by Ruud on 24-Mar-17.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import java.util.Date;

public class test {

    @Test
    public void multiplierTest() {
        double locatiemultiplier = 1.00;
        double Timemultiplier = 21.00;
        assertEquals(21.00, locatiemultiplier * Timemultiplier, 0.00);
    }

    @Test
    public void multiplierNotTest() {
        double locatiemultiplier = 1.00;
        double Timemultiplier = 21.00;
        assertNotEquals(22.00, locatiemultiplier * Timemultiplier);
    }

    @Test
    public void uurTest() {

        Date dt = new Date("04/03/2011 20:27:05");
        int uur = dt.getHours();
        assertEquals(20.00, uur, 0.00);
    }

    @Test
    public void maandTest() {

        Date dt = new Date("04/03/2011 20:27:05");
        int maand = dt.getMonth();
        assertEquals(3.00, maand, 0.00);
    }

    @Test
    public void notDateTest() {
        Date dt = new Date("04/03/2011 20:27:05");
        int maand = dt.getMonth();
        int uur = dt.getHours();
        assertNotEquals(22.00, maand * uur);
    }
}
