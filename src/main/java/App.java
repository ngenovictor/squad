import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("public");
        String layout = "templates/layout.vtl";

        get("/", (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            String title = "Home";
            model.put("title",title);
            model.put("squads",Squad.all());
            model.put("template","templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
