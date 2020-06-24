package spring.foodev.board;

public class BoardVO {

	private String division;
	private int post_id;
	private String title;
	private String writer;
	private int up_count;
	private int lookup_count;
	private String content;
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getUp_count() {
		return up_count;
	}
	public void setUp_count(int up_count) {
		this.up_count = up_count;
	}
	public int getLookup_count() {
		return lookup_count;
	}
	public void setLookup_count(int lookup_count) {
		this.lookup_count = lookup_count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
