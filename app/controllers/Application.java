package controllers;

import java.util.List;

import models.Topic;
import play.data.Form;
import play.mvc.*;


import views.html.index;
import views.html.topic;

public class Application extends Controller {
    public Result index() {
    	List topicList = Topic.find.all();
        return ok(index.render("HACKOR NUSE", topicList, Form.form(Topic.class)));
    }
    
    public Result addTopic() {
    	Form<Topic> topicForm = Form.form(Topic.class).bindFromRequest();
    	Topic topic = topicForm.get();
    	topic.save();
    	return redirect(controllers.routes.Application.index());
    }
    
    public Result viewTopic(Long topicId) {
    	Topic t = Topic.find.byId(topicId);
    	return ok(topic.render(t));
    }
}
