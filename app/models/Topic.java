package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Topic extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String contents;
    
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
    public static Finder<Long, Topic> find = new Finder<Long, Topic>(Topic.class);
}