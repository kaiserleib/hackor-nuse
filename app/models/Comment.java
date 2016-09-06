package models;

import models.Topic;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import java.util.List;

@Entity
public class Comment extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne()
	private Topic topic;
	
	@OneToMany(mappedBy = "parent")
	private List<Comment> children;
	
	@ManyToOne()
	private Comment parent;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Topic getTopic() {
		return this.topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public List<Comment> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<Comment> children) {
		this.children = children;
	}
	
	public Comment getParent() {
		return this.parent;
	}
	
	public void setParent(Comment parent) {
		this.parent = parent;
	}
	
	public String getText() {
		return this.text;
	}
	 
	public void setText(String text) {
		this.text = text;
	}
	
	public static Finder<Long, Comment> find = new Finder<Long, Comment>(Comment.class);
}
