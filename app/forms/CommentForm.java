package forms;

public class CommentForm {
	private Long parentId;
	private Long topicId;
	private String text;
	
	public Long getParentId() {
		return this.parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public Long getTopicId() {
		return this.topicId;
	}
	
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}