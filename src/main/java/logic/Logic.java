package logic;

import domain.Temperatuur;
import org.codehaus.jackson.map.ObjectMapper;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ruud on 24-Mar-17.
 */

public class Logic {
    private ObjectMapper mapper = new ObjectMapper();


    public String getTemperatuur(String locatie, String dt) {

        try {

            //
            // De volgende reeks van "if-statements" "berekend" de temperatuur  van de meegegeven tijd en locatie.
            // De enige locaties die deze code ondersteunen zijn Utrecht, Barcelona en New York
            //



            DateFormat daf = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss");
            Date datumTijd = daf.parse(dt);

            double result;
            double locationMultiplier;
            double timeMultiplier;

            if (locatie.equals("Utrecht")) {
                locationMultiplier = 1.0;
                if (datumTijd.getMonth() == 12 || datumTijd.getMonth() == 1 || datumTijd.getMonth() == 2) { //winter
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = -5.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 0.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 6.0;
                    } else { // s'avonds
                        timeMultiplier = 2.0;
                    }
                } else if (datumTijd.getMonth() == 3 || datumTijd.getMonth() == 4 || datumTijd.getMonth() == 5) { //lente
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 5.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 9.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 15.5;
                    } else { // s'avonds
                        timeMultiplier = 11.0;
                    }
                } else if (datumTijd.getMonth() == 6 || datumTijd.getMonth() == 7 || datumTijd.getMonth() == 8) { //zomer
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 17.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 23.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 27.5;
                    } else { // s'avonds
                        timeMultiplier = 20.0;
                    }
                } else { //herfst
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 10.5;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 14.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 17.0;
                    } else { // s'avonds
                        timeMultiplier = 12.5;
                    }
                }

                DecimalFormat df = new DecimalFormat("#.##");

                result = locationMultiplier * timeMultiplier;

            } else if (locatie.equals("Barcelona")) {
                locationMultiplier = 1.3;
                if (datumTijd.getMonth() == 12 || datumTijd.getMonth() == 1 || datumTijd.getMonth() == 2) { //winter
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 3.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 4.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 8.0;
                    } else { // s'avonds
                        timeMultiplier = 5.0;
                    }
                } else if (datumTijd.getMonth() == 3 || datumTijd.getMonth() == 4 || datumTijd.getMonth() == 5) { //lente
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 5.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 9.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 15.0;
                    } else { // s'avonds
                        timeMultiplier = 12.0;
                    }
                } else if (datumTijd.getMonth() == 6 || datumTijd.getMonth() == 7 || datumTijd.getMonth() == 8) { //zomer
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 17.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 23.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 27.0;
                    } else { // s'avonds
                        timeMultiplier = 21.0;
                    }
                } else { //herfst
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 11.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 15.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 17.5;
                    } else { // s'avonds
                        timeMultiplier = 14.0;
                    }
                }

                DecimalFormat df = new DecimalFormat("#.##");

                result = locationMultiplier * timeMultiplier;

            } else if (locatie.equals("New_York")) {
                locationMultiplier = 1.15;
                if (datumTijd.getMonth() == 12 || datumTijd.getMonth() == 1 || datumTijd.getMonth() == 2) { //winter
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = -5.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = -1.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 6.0;
                    } else { // s'avonds
                        timeMultiplier = 2.0;
                    }
                } else if (datumTijd.getMonth() == 3 || datumTijd.getMonth() == 4 || datumTijd.getMonth() == 5) { //lente
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 5.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 9.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 15.0;
                    } else { // s'avonds
                        timeMultiplier = 11.0;
                    }
                } else if (datumTijd.getMonth() == 6 || datumTijd.getMonth() == 7 || datumTijd.getMonth() == 8) { //zomer
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 17.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 23.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 27.0;
                    } else { // s'avonds
                        timeMultiplier = 20.0;
                    }
                } else { //herfst
                    if (datumTijd.getHours() >= 22 || datumTijd.getHours() < 6) { //s'nachts
                        timeMultiplier = 10.0;
                    } else if (datumTijd.getHours() >= 6 || datumTijd.getHours() < 11) { // s'ochtends
                        timeMultiplier = 14.0;
                    } else if (datumTijd.getHours() >= 11 || datumTijd.getHours() < 16) { // s'middags
                        timeMultiplier = 17.0;
                    } else { // s'avonds
                        timeMultiplier = 13.0;
                    }
                }

                //
                // Hier wordt het antwoord afgerond op twee decimalen.
                //
                DecimalFormat df = new DecimalFormat("#.##");

                result = locationMultiplier * timeMultiplier;

            } else {
                //
                // Mocht er een onbekende locatie worden ingevult, dan wordt er een foutmelding gegeven met: " De meegegeven locatie wordt niet ondersteund.".
                //

                result = 99.99;
            }

            return mapper.writeValueAsString(new Temperatuur(result));
        }
        catch (Exception e) {
            return "{\"error\":\"Invalid input!\"}";
        }
    }
}
