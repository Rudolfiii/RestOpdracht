package presentation;

import logic.Logic;
import static spark.Spark.*;

/**
 * Created by Ruud on 24-Mar-17.
 */

public class Main {
    public static void main(String[]args){
        Logic logic = new Logic();

        get("/temperatuur", "application/json", (req, res) -> {
            res.type("application/json");
            return logic.getTemperatuur(req.queryParams("locatie"), req.queryParams("datumtijd"));
        });

        notFound((req, res) -> {
            res.type("application/json");
            return "{\"error\":\"404 Not found\"}";
        });


    }
}
