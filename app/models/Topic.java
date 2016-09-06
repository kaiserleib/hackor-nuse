package models;

import com.avaje.ebean.Model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class Topic extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String contents;
    
    @OneToMany(mappedBy = "topic")
    private List<Comment> comments = new ArrayList<>();
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getContents() {
    	return this.contents;
    }
    
    public void setContents(String contents) {
    	this.contents = contents;
    }
    
    public List<Comment> getComments() {
    	return this.comments;
    }
    
    public void setComments(List<Comment> comments) {
    	this.comments = comments;
    }
    
    public static Finder<Long, Topic> find = new Finder<Long, Topic>(Topic.class);
}