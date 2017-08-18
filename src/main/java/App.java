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
            if(Squad.all().size()>0){
                model.put("squads",Squad.all());
            }
            model.put("template","templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String title = "New Squad";
            model.put("title",title);
            model.put("template","templates/new-squad-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        post("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newSquadName = request.queryParams("squad-name");
            int newSquadMaxSize = Integer.parseInt(request.queryParams("squad-size"));
            String newSquadCause = request.queryParams("squad-cause");
            Squad mySquad = new Squad(newSquadName,newSquadMaxSize,newSquadCause);
            String title = "New Squad";
            model.put("title",title);
            model.put("squad", mySquad);
            model.put("template","templates/new-squad-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad chosenSquad = Squad.find(Integer.parseInt(request.params("id")));
            model.put("title", chosenSquad.getName());
            model.put("squad",chosenSquad);
            model.put("template", "templates/squad-details.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
