package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Topic;
import models.Comment;
import forms.CommentForm;
import forms.TopicForm;

import play.data.Form;
import play.mvc.*;

import views.html.index;
import views.html.topic;
import views.html.commentReplyForm;

public class Application extends Controller {
	
    public Result index() {
    	List topicList;
    	try {
    		topicList = Topic.find.all();
    	} catch (NullPointerException e) {
    		topicList = new ArrayList<Topic>();
    	}
        return ok(index.render("HACKOR NUSE", topicList, Form.form(Topic.class)));
    }
    
    public Result addTopic() {
    	Form<TopicForm> topicForm = Form.form(TopicForm.class).bindFromRequest();
    	TopicForm furm = topicForm.get();
    	Topic topic = new Topic();
    	topic.setTitle(furm.getTitle());
    	topic.setContents(furm.getContents());
    	topic.save();
    	return redirect(controllers.routes.Application.index());
    }
    
    public Result viewTopic(Long topicId) {
    	Topic t = Topic.find.byId(topicId);
    	CommentForm comment = new CommentForm();
    	Form<CommentForm> commentForm = Form.form(CommentForm.class);
    	comment.setTopicId(topicId);
    	commentForm = commentForm.fill(comment);
    	return ok(topic.render(t, commentForm));
    }
    
    public Result replyToComment(Long parentId) {
        Comment parent = Comment.find.byId(parentId);
        Form<CommentForm> commentForm = Form.form(CommentForm.class);
        CommentForm furm = new CommentForm();
        furm.setParentId(parentId);
        commentForm = commentForm.fill(furm);
        return ok(commentReplyForm.render(parent, commentForm));
    }
    
    public Result postReply() {
    	Form<CommentForm> commentForm = Form.form(CommentForm.class).bindFromRequest();
    	CommentForm furm = commentForm.get();
    	Comment comment = new Comment();
    	if (furm.getTopicId() != null) {
    		comment.setTopic(Topic.find.byId(furm.getTopicId()));
    	}
    	if (furm.getParentId() != null) {
    	    comment.setParent(Comment.find.byId(furm.getParentId()));
    	}
    	comment.setText(furm.getText());
    	comment.save();
    	
    	if (furm.getTopicId() != null) {
    		return viewTopic(furm.getTopicId());
    	} else {
    		return replyToComment(furm.getParentId());
    	}
    }
}