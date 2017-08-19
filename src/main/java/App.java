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
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

    setPort(port);

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

        post("/squad/:id/addhero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String heroName = request.queryParams("hero-name");
            int heroAge = Integer.parseInt(request.queryParams("hero-age"));
            String heroPower =request.queryParams("special-power");
            String heroWeakness = request.queryParams("weakness");

            Hero myHero = new Hero(heroName,heroAge,heroPower,heroWeakness);

            Squad chosenSquad = Squad.find(Integer.parseInt(request.params("id")));
//            chosenSquad.getHeros().indexOf(myHero);
            chosenSquad.getHeros().add(myHero);
            model.put("title", chosenSquad.getName());
            model.put("squad",chosenSquad);
            model.put("template", "templates/squad-details.vtl");
            return new ModelAndView(model, layout);
        },new VelocityTemplateEngine());

        get("/hero/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Hero chosenHero = Hero.find(Integer.parseInt(request.params("id")));
            model.put("title", chosenHero.getName());
            model.put("hero", chosenHero);
            model.put("template", "templates/hero-detail.vtl");
            return new ModelAndView(model, layout);
        },new VelocityTemplateEngine());
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", Squad.all());
            model.put("template","templates/squads.vtl");
            model.put("title","Squads");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("heroes", Hero.all());
            model.put("title", "Heores");
            model.put("template", "templates/heroes.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
